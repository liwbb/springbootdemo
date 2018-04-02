package com.example.springbootdemo.controller.investController;

import com.example.springbootdemo.pojo.TestInvest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author D N
 * @create 2018-03-22 15:32
 **/
@RestController("testinvest")
@RequestMapping(value = "test",method = RequestMethod.POST)
@Api(value = "testinvest",tags = "testinvest")
public class TestController {
    @RequestMapping("test")
    @ApiOperation(value = "testInvest",notes = "投资人测试")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType="form",name = "id",value = "id",required = true,dataType = "String"),
        @ApiImplicitParam(paramType="form",name = "name",value = "姓名",required = true,dataType = "String"),
    })
    public TestInvest test(String id,String name){
        TestInvest invest=new TestInvest();
        invest.setId("1");
        invest.setName("李经纬");
        invest.setAge("12");
        invest.setClassName("12年级");
        return invest;
    }
}
