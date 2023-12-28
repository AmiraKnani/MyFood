package com.pi.courtierservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pi.courtierservice.model.Courier;


@Repository
public interface CourierRepository extends JpaRepository<Courier, String> {
}
