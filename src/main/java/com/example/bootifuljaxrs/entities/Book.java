package com.example.bootifuljaxrs.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@XmlRootElement(name = "book")
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String isbn;
}
