package com.example.springbootdemo.controller;

import java.util.Arrays;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author D N
 * @create 2018-03-23 10:16
 **/
public class Test {
    public static void main(String[] args) {
        String result=String.format("test[%s]4", "1","2");
        System.out.println("result==>"+result);
        Map<String,Object> map=new HashMap<>();
        map.put("","");
        System.out.println(-4>>2);
        System.out.println(String.valueOf(Math.pow(2,30)));
        System.out.println(Integer.toBinaryString(-1));
        System.out.println();
    }
}
