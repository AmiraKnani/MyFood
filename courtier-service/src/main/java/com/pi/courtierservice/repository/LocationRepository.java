package com.pi.courtierservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pi.courtierservice.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}