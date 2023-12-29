package com.pi.restaurantservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pi.restaurantservice.model.Adresse;

public interface AdresseRepository extends JpaRepository<Adresse, Long> {

    List<Adresse> findByVille(String ville);

}
