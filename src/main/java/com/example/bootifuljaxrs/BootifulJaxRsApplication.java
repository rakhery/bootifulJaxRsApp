package com.example.bootifuljaxrs;
import com.example.bootifuljaxrs.entities.Customer;
import com.example.bootifuljaxrs.repo.CustomerRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

