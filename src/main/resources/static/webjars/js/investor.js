$.views.settings.allowCode(true);
$.views.converters("getResponseModelName", function(val) {
  return getResponseModelName(val);
});

var tempBody = $.templates('#temp_body');
var tempBodyResponseModel = $.templates('#temp_body_response_model');

//获取context path
var contextPath = getContextPath();
function getContextPath() {
  // var pathName = document.location.pathname;
  // var index = pathName.substr(1).indexOf("/");
  // var result = pathName.substr(0,index+1);
  // return result;
    return "";
}

$(function(){
    $.ajax({
        url : "/v2/api-docs?group=investor",
// 	        url : "http://petstore.swagger.io/v2/swagger.json",
        dataType : "json",
        type : "get",
        async : false,
        success : function(data) {
            //layui init
            layui.use([ 'layer','jquery', 'element' ], function() {
	            var $ = layui.jquery, layer = layui.layer, element = layui.element;
	        });
            var jsonData = eval(data);
            
            $("#title").html(jsonData.info.title);
            $("body").html($("#template").render(jsonData));
            
            $("[name='a_path']").click(function(){
	            var path = $(this).attr("path");
	            var method = $(this).attr("method");
	            var operationId = $(this).attr("operationId");
	            $.each(jsonData.paths[path],function(i,d){
	              if(d.operationId == operationId){
                      d.path = path;
                      d.method = method;
		              $("#path-body").html(tempBody.render(d));
                      var modelName = getResponseModelName(d.responses["200"]["schema"]["$ref"]);
                      if(modelName && jsonData.definitions[modelName] && jsonData.definitions[modelName].properties){
                        var properties = jsonData.definitions[modelName].properties;
                        formatResponseDef(properties, jsonData);
                        var options = {
                            withQuotes: true
                        };
                        $("#responseData").jsonViewer(properties, options);
                        $("#path-body-response-model").html(tempBodyResponseModel.render(jsonData.definitions[modelName]));
                      }
	              }
	            });
	        });
	        
	       //提交测试按钮
	       $("[name='btn_submit']").click(function(){
                var operationId = $(this).attr("operationId");
                var parameterJson = {};
                $("input[operationId='"+operationId+"']").each(function(index, domEle){
                    var k = $(domEle).attr("name");
                    var v = $(domEle).val();
                    parameterJson.push({k:v});
                });
            });
        }
    });
    
});


function getResponseModelName(val){
  if(!val){
    return null;
  }
  return val.substring(val.lastIndexOf("/")+1,val.length);
}

//测试按钮，获取数据
function getData(operationId){
   var path = contextPath + $("[m_operationId='"+operationId+"']").attr("path");
   //path 参数
   $("[p_operationId='"+operationId+"'][in='path']").each(function(index, domEle){
       var k = $(domEle).attr("name");
       var v = $(domEle).val();
       if(v){
           path = path.replace("{"+k+"}",v);
       }
   });
   
   //请求方式
   var parameterType = $("#content_type_"+operationId).val();
   
   //query 参数
   var parameterJson = {};
   if("form" == parameterType){
       $("[p_operationId='"+operationId+"'][in='formData']").each(function(index, domEle){
           var k = $(domEle).attr("name");
           var v = $(domEle).val();
           if(v){
               parameterJson[k] = v;
           }
       });
   }else if("json" == parameterType){
       var str = $("#text_tp_"+operationId).val();
       try{
           parameterJson = JSON.parse(str); 
       }catch(error){
           layer.msg(""+error,{icon:5});
           return false;
       }
   }
   
   //发送请求
   $.ajax({
	   type: $("[m_operationId='"+operationId+"']").attr("method"),
	   url: path,
	   data: parameterJson,
	   dataType: 'json',
	   success: function(data){
	     var options = {
          withQuotes: true
         };
	     $("#json-response").jsonViewer(data, options);
	   }
   });
}


//请求类型
function changeParameterType(el){
    var operationId = $(el).attr("operationId");
    var type = $(el).attr("type");
    $("#content_type_"+operationId).val(type);
    $(el).addClass("layui-btn-normal").removeClass("layui-btn-primary");
    if("form" == type){
        $("#text_tp_"+operationId).hide();
        $("#table_tp_"+operationId).show();
        $("#pt_json_"+operationId).addClass("layui-btn-primary").removeClass("layui-btn-normal");
    }else if("json" == type){
       $("#text_tp_"+operationId).show();
       $("#table_tp_"+operationId).hide();
       $("#pt_form_"+operationId).addClass("layui-btn-primary").removeClass("layui-btn-normal");
    }
}

// 格式化接口返回数据定义，主要处理$ref
function formatResponseDef(data, jsonData) {
    if (data) {
        if (data.data && data.data.type == "object") { // 删除BaseResult中未定义的data，即接口返回只有code、text，无需data数据
            delete data.data;
        }
        for (var d in data) {
            if (data[d].type == "integer" && data[d].format) { // 删除format: "int32"属性
                delete data[d].format;
            } else if (data[d].$ref) {   // 处理$ref
                var refData = jsonData.definitions[getResponseModelName(data[d].$ref)].properties;
                // 递归处理
                formatResponseDef(refData, jsonData);
                data[d] = refData;
            } else if (data[d].type == "array" && data[d].items && data[d].items.$ref) {   // 处理$ref数组
                var refData = jsonData.definitions[getResponseModelName(data[d].items.$ref)].properties;
                // 递归处理
                formatResponseDef(refData, jsonData);
                data[d] = new Array(refData);
            }
        }
    }
}