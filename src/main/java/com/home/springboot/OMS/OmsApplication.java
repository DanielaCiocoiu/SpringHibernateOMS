package com.home.springboot.OMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan(basePackages={"com.home.springboot.OMS"})
//@EnableJpaRepositories("\"com.home.springboot.OMS.repository")
//@EntityScan("com.home.springboot.OMS.entity")
public class OmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmsApplication.class, args);
		
		
	}

}
