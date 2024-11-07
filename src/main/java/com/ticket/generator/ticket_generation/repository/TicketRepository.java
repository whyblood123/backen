package com.ticket.generator.ticket_generation.repository;

import com.ticket.generator.ticket_generation.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
