package com.example.bootifuljaxrs.api;

import com.example.bootifuljaxrs.entities.Customer;
import com.example.bootifuljaxrs.repo.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.util.Collection;

@Component
@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {
    private final CustomerRepository customerRepository;
    //Ajout de log pour verifier la securité
    Logger logger = (Logger) LoggerFactory.getLogger(CustomerResource.class);

    public CustomerResource(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GET
    public Collection<Customer> customers(){
        return this.customerRepository.findAll();
    }


    //récuperer le context de securité context
    @GET
    @Path("/{id}")
    public Customer byId(@PathParam("id") Long id, @Context SecurityContext context){
        logger.info(context.getUserPrincipal().getName()+" est ici.");
        return customerRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Non trouvé #"+ id +"!"));
    }


}
