package com.example.springbootdemo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author D N
 * @create 2018-03-22 15:46
 **/
@ApiModel(value = "投资人测试")
public class TestInvest {
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("年龄")
    private String age;
    @ApiModelProperty("班级")
    private String className;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
