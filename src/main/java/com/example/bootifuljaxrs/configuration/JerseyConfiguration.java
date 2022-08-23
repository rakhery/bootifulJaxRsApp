package com.example.bootifuljaxrs.configuration;

import com.example.bootifuljaxrs.api.BookContentResource;
import com.example.bootifuljaxrs.api.CustomerResource;
import com.example.bootifuljaxrs.exceptions.GenericExceptionMapper;
import com.example.bootifuljaxrs.repo.BookRepository;
import com.example.bootifuljaxrs.repo.CustomerRepository;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/")
class JerseyConfiguration extends ResourceConfig {
    public JerseyConfiguration(){

    }
   @PostConstruct
    public void setUp(){
        register(BookContentResource.class);
        register(GenericExceptionMapper.class);
        register(CustomerResource.class);

   }

}
