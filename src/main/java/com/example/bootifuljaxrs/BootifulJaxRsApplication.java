package com.example.bootifuljaxrs;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.stream.Stream;


@SpringBootApplication
public class BootifulJaxRsApplication {

	//Données d'initialisation
	@Bean
	ApplicationRunner data(CustomerRepository cr){
		return args-> Stream.of("A","B","C").forEach(x->cr.save(new Customer(null,x)));
	}

	public static void main(String[] args) {
		SpringApplication.run(BootifulJaxRsApplication.class, args);
	}


}
//Activation de Jax-Rx

