package com.pi.kitchenservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pi.kitchenservice.model.Ticket;
import com.pi.kitchenservice.repository.TicketRepository;

@RestController
@RequestMapping("/kitchen")
public class KitchenController {

    @Autowired
    private TicketRepository ticketRepository;

    @PostMapping("/tickets")
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        Ticket savedTicket = ticketRepository.save(ticket);
        return ResponseEntity.ok(savedTicket);
    }

    @PutMapping("/tickets/{id}/accept")
    public ResponseEntity<Ticket> acceptTicket(@PathVariable Long id) {
        Ticket ticket = ticketRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Ticket not found with id " + id));
        ticket.setState("accepted");
        Ticket updatedTicket = ticketRepository.save(ticket);
        return ResponseEntity.ok(updatedTicket);
    }

    @PutMapping("/tickets/{id}/ready")
    public ResponseEntity<Ticket> readyForPickUp(@PathVariable Long id) {
        Ticket ticket = ticketRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Ticket not found with id " + id));
        ticket.setState("ready");
        Ticket updatedTicket = ticketRepository.save(ticket);
        return ResponseEntity.ok(updatedTicket);
    }
}
