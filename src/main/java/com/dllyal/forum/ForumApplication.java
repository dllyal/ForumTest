package com.dllyal.forum;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.dllyal.forum.mapper")//将项目中对应的mapper类的路径加进来就可以了,这个注解非常的关键，这个对应了项目中mapper（dao）所对应的包路径
public class ForumApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ForumApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ForumApplication.class, args);
	}

}

