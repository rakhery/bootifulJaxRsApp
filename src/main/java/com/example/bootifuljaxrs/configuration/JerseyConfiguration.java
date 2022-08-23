package com.example.bootifuljaxrs.configuration;

import com.example.bootifuljaxrs.api.BookContentResource;
import com.example.bootifuljaxrs.api.CustomerResource;
import com.example.bootifuljaxrs.exceptions.GenericExceptionMapper;
import com.example.bootifuljaxrs.repo.BookRepository;
import com.example.bootifuljaxrs.repo.CustomerRepository;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/")
class JerseyConfiguration {
    @Bean
    CustomerResource customerResource(CustomerRepository repository) {
        return new CustomerResource(repository);
    }
    @Bean
    BookContentResource bookResource(BookRepository repo) {
        return new BookContentResource(repo);
    }
    //Injection de endpoint
    @Bean
    ResourceConfig config(CustomerRepository cr, GenericExceptionMapper exceptionMapper) {
        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(CustomerResource.class);
        return resourceConfig;
    }

}
