package com.example.bootifuljaxrs;

import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

//Création de Exception generique
@Component
class GenericExceptionMapper implements ExceptionMapper<IllegalArgumentException> {

    @Override
    public Response toResponse(IllegalArgumentException e) {
        return Response.serverError().entity(e.getMessage()).build();

    }
}
