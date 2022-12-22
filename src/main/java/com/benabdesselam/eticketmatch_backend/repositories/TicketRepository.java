package com.benabdesselam.eticketmatch_backend.repositories;

import com.benabdesselam.eticketmatch_backend.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {
}
