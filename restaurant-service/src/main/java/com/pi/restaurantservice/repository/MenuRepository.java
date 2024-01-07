package com.pi.restaurantservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pi.restaurantservice.model.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    List<Menu> findByNom(String nom);

}
