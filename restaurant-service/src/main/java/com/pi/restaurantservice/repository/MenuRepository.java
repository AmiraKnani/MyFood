package com.pi.restaurantservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pi.restaurantservice.model.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {

}
