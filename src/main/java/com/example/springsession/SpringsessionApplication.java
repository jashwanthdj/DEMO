package com.example.springsession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringsessionApplication {

	public static void main(String[] args) {

     System.out.println("hello");
		SpringApplication.run(SpringsessionApplication.class, args);
	}

}
