package com.example.bootifuljaxrs;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {
    private final CustomerRepository customerRepository;

    public CustomerResource(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GET
    public Collection<Customer> customers(){
        return this.customerRepository.findAll();
    }

    @GET
    @Path("/{id}")
    public Customer byId(@PathParam("id") Long id){
        return customerRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Non trouvé #"+ id +"!"));
    }


}
