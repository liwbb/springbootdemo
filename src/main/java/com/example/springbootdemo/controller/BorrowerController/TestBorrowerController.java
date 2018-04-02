package com.example.springbootdemo.controller.BorrowerController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author D N
 * @create 2018-03-22 15:32
 **/
@RestController
@RequestMapping("testBorrower")
public class TestBorrowerController {
    @RequestMapping("testBorrower")
    public String test(){
        return "sss";
    }
}
