package com.example.bootifuljaxrs.api;

import com.example.bootifuljaxrs.entities.Book;
import com.example.bootifuljaxrs.repo.BookRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/content-books")
public class BookContentResource {

    private final BookRepository bookRepository;

    public BookContentResource(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @GET
        @Path("/xml")
        @Produces(MediaType.APPLICATION_XML)
        public Book getContentBookXML() {
            System.out.println("Endpoint : getContentBookXML");

            Book book = new Book();
            book.setName("Harry Potter");
            book.setIsbn("1-111111-11");

            return book;
        }

        @PUT
        @Path("/xml")
        @Consumes(MediaType.APPLICATION_XML)
        public void updateContentBookXML(Book book) {
            System.out.println("Endpoint : updateContentBookXML");
            System.out.println("Les modifications apportées - name : " +
                    book.getName() + ", isbn : " + book.getIsbn());
        }

        @GET
        @Path("/json")
        @Produces(MediaType.APPLICATION_JSON)
        public Book getContentBookJSON() {
            System.out.println("Endpoint : getContentBookJSON");

            Book book = new Book();
            book.setName("JSON Potter");
            book.setIsbn("9-999999-99");

            return book;
        }

        // URI : content-books/json
        @PUT
        @Path("/json")
        @Consumes(MediaType.APPLICATION_JSON)
        public void updateContentBookJSON(Book book) {
            System.out.println("Endpoint : updateContentBookJSON");
            System.out.println("Les modifications apportées - name : " +
                    book.getName() + ", isbn : " + book.getIsbn());
        }
    }

