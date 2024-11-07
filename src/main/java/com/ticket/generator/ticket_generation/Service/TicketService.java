package com.ticket.generator.ticket_generation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ticket.generator.ticket_generation.Entity.Ticket;
import com.ticket.generator.ticket_generation.repository.TicketRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public Ticket createTicket(Ticket ticket) {
        ticket.setTicketId(generateTicketId());
        ticket.setEventDate(LocalDateTime.now()); // Set the current date/time as the event date
        return ticketRepository.save(ticket);
    }

    private String generateTicketId() {
        Random random = new Random();
        StringBuilder ticketId = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            ticketId.append(random.nextInt(10)); // Generates a digit from 0-9
        }
        return ticketId.toString();
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }
}
