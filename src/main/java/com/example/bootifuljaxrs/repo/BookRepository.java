package com.example.bootifuljaxrs.repo;

import com.example.bootifuljaxrs.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
