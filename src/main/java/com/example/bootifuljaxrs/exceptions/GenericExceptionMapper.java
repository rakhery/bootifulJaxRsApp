package com.example.bootifuljaxrs.exceptions;

import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

//Création de Exception generique
@Component
public
class GenericExceptionMapper implements ExceptionMapper<IllegalArgumentException> {

    @Override
    public Response toResponse(IllegalArgumentException e) {
        return Response.serverError().entity(e.getMessage()).build();

    }
}
