package com.benabdesselam.eticketmatch_backend.services;

import com.benabdesselam.eticketmatch_backend.dtos.TicketDTORequest;
import com.benabdesselam.eticketmatch_backend.dtos.TicketDTOResponse;
import com.benabdesselam.eticketmatch_backend.entities.Match;
import com.benabdesselam.eticketmatch_backend.entities.Ticket;
import com.benabdesselam.eticketmatch_backend.enums.Status;
import com.benabdesselam.eticketmatch_backend.mappers.TicketMapper;
import com.benabdesselam.eticketmatch_backend.repositories.MatchRepository;
import com.benabdesselam.eticketmatch_backend.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TicketServiceImp implements TicketService{
    @Autowired
    TicketRepository ticketRepository;
    TicketMapper ticketMapper;
    MatchRepository matchRepository;

    @Override
    public List<TicketDTOResponse> findAll() {
        return ticketRepository.findAll().stream().map(ticket -> ticketMapper.fromTicketToTicketDTOResponse(ticket)).collect(Collectors.toList());

    }

    @Override
    public TicketDTOResponse addTicket(Long id, TicketDTORequest ticketDTORequest) {
        Match match = matchRepository.findById(id).orElseThrow(()->new RuntimeException("Match not Fount"));
        Ticket ticket =ticketMapper.fromTicketDTORequestToTicket(ticketDTORequest);
        ticket.setReference(UUID.randomUUID().toString());
        ticket.setStatus(Status.ACTIVATED);
        ticket.setMatch(match);
        ticketRepository.save(ticket);

        return ticketMapper.fromTicketToTicketDTOResponse(ticket);
    }

    @Override
    public TicketDTOResponse findById(Long id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(()->new RuntimeException("Ticket not found"));
        return ticketMapper.fromTicketToTicketDTOResponse(ticket);
    }

    @Override
    public TicketDTOResponse updateTicket(Long id, TicketDTORequest ticketDTORequest) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(()->new RuntimeException("Ticket Not found"));
        ticket.setPrix(ticketDTORequest.getPrix());
        ticketRepository.save(ticket);
        return ticketMapper.fromTicketToTicketDTOResponse(ticket);
    }

    @Override
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);


    }
}
