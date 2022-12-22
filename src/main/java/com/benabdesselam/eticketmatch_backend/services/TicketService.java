package com.benabdesselam.eticketmatch_backend.services;

import com.benabdesselam.eticketmatch_backend.dtos.TicketDTORequest;
import com.benabdesselam.eticketmatch_backend.dtos.TicketDTOResponse;
import com.benabdesselam.eticketmatch_backend.entities.Ticket;

import java.util.List;

public interface TicketService {
    List<TicketDTOResponse> findAll();
    TicketDTOResponse addTicket(Long id,TicketDTORequest ticketDTORequest);
    TicketDTOResponse findById(Long id);
    TicketDTOResponse updateTicket(Long id, TicketDTORequest ticketDTORequest);
    void deleteTicket(Long id);
}
