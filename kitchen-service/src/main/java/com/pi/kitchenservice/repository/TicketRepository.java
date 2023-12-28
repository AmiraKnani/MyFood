package com.pi.kitchenservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pi.kitchenservice.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}