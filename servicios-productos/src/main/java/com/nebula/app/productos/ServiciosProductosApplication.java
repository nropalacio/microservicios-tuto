package com.nebula.app.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class ServiciosProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiciosProductosApplication.class, args);
	}

}
