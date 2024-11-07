package com.ticket.generator.ticket_generation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ticket.generator.ticket_generation.Entity.Ticket;
import com.ticket.generator.ticket_generation.Service.TicketService;
import java.util.List;
import java.util.Collections; // Make sure this import is included

@RestController
@CrossOrigin
@RequestMapping("/api/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        Ticket createdTicket = ticketService.createTicket(ticket);
        return ResponseEntity.ok(createdTicket); // Return the created ticket with ticketId
    }

    @GetMapping("/clients")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> tickets = ticketService.getAllTickets();
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/verify/{ticketId}")
    public ResponseEntity<?> verifyTicket(@PathVariable String ticketId) {
        List<Ticket> tickets = ticketService.getAllTickets(); // Retrieve all tickets
        boolean isValid = tickets.stream().anyMatch(ticket -> ticket.getTicketId().equals(ticketId));

        return ResponseEntity.ok(Collections.singletonMap("isValid", isValid));
    }
}
