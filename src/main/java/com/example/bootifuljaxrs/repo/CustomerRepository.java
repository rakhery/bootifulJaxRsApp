package com.example.bootifuljaxrs.repo;

import com.example.bootifuljaxrs.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
