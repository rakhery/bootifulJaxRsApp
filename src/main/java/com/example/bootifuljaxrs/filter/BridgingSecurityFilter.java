package com.example.bootifuljaxrs.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.security.Principal;

//Ajout de filtre
public class BridgingSecurityFilter implements ContainerRequestFilter {
    @Context
    UriInfo uriInfo;

    private static class BridgingSecurityContext implements SecurityContext{

        private final org.springframework.security.core.context.SecurityContext spring;
        private final UriInfo uriInfo;

        private BridgingSecurityContext(org.springframework.security.core.context.SecurityContext spring, UriInfo uriInfo) {
            this.spring = spring;
            this.uriInfo = uriInfo;
        }

        @Override
        public Principal getUserPrincipal() {
            return spring.getAuthentication();
        }

        @Override
        public boolean isUserInRole(String s) {
            return spring.getAuthentication().getAuthorities()
                    .stream()
                    .anyMatch(ga->ga.getAuthority().contains(s));
        }

        @Override
        public boolean isSecure() {
            return uriInfo.getAbsolutePath().toString().toLowerCase().startsWith("http");
        }

        @Override
        public String getAuthenticationScheme() {
            return "spring-security-authentication";
        }


    }

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        containerRequestContext.setSecurityContext(new BridgingSecurityContext(org.springframework.security.core.context.SecurityContextHolder.getContext(),this.uriInfo));
    }
}
