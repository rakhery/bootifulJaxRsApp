package com.example.bootifuljaxrs;
import com.example.bootifuljaxrs.entities.Book;
import com.example.bootifuljaxrs.entities.Customer;
import com.example.bootifuljaxrs.entities.Personne;
import com.example.bootifuljaxrs.repo.BookRepository;
import com.example.bootifuljaxrs.repo.CustomerRepository;
import com.example.bootifuljaxrs.repo.PersonneRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;


@SpringBootApplication
public class BootifulJaxRsApplication {

	//Données d'initialisation
	@Bean
	ApplicationRunner customer(CustomerRepository cr){
		return args-> Stream.of("A","B","C").forEach(x->cr.save(new Customer(null,x)));
	}
	@Bean
	ApplicationRunner book(BookRepository br){
		return args-> Stream.of("Harry Potter","Java EE","Angular")
				.forEach(x->br.save(new Book(null,x,"1-111111-11")));
	}
	@Bean
	ApplicationRunner annuaire( PersonneRepository personne){
		return args-> Stream.of("Bob Marley","Jimmy Hendrix","Rolling Stones")
				.forEach(nom->{
					Personne p=new Personne(null,nom);
					personne.save(p);
				});
	}

	public static void main(String[] args) {
		SpringApplication.run(BootifulJaxRsApplication.class, args);
	}


}

