package com.yunsheng.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// 扫描注入
// 注入service和controller
@ComponentScan({"com.yunsheng"})
// 注入mapper。放在service里，web不要直接使用mapper
//@MapperScan("com.yunsheng.mapper")
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}
}
