package com.example.bootifuljaxrs.repo;

import com.example.bootifuljaxrs.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PersonneRepository extends JpaRepository<Personne,Long> {
    Optional<Personne> findById(Long id);
    List<Personne> findAllBy();

    @Query("update Personne p set p.nom = ?1 where p.id = ?2")
    void updatePersonne(String nom,Long id);

}
