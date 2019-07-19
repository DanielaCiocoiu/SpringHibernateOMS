package com.home.springboot.OMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages={"com.home.springboot.OMS"})
//@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class OmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmsApplication.class, args);
		
		
	}

}
