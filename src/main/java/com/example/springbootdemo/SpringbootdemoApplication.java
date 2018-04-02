package com.example.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class SpringbootdemoApplication{
	/**
	 * 如果要发布到自己的Tomcat中的时候，需要继承SpringBootServletInitializer类，并且增加如下的configure方法。
	 * 如果不发布到自己的Tomcat中的时候，就无需上述的步骤
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}
	@RequestMapping("/rest")
	public Map<String,Object> rest(){
		Map<String,Object> objectMap=new HashMap<>();
		objectMap.put("1","test");
		objectMap.put("2","job");
		return objectMap;
	}
 }
