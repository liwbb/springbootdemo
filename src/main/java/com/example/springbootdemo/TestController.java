package com.example.springbootdemo;

import com.example.springbootdemo.pojo.Greeting;
import org.springframework.web.bind.annotation.*;

/**
 * @author D N
 * @create 2018-03-23 13:27
 **/
@RestController
public class TestController {

    private  final static String sName="hello,%s!";
    @RequestMapping("greeting")
    @ResponseBody
    public Greeting greeting(@RequestParam(value = "name1",defaultValue = "world") String name){
        return new Greeting(1,String.format(sName,name));

    }
}
