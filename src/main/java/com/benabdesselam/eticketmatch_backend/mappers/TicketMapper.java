package com.benabdesselam.eticketmatch_backend.mappers;

import com.benabdesselam.eticketmatch_backend.dtos.TicketDTORequest;
import com.benabdesselam.eticketmatch_backend.dtos.TicketDTOResponse;
import com.benabdesselam.eticketmatch_backend.entities.Ticket;
import org.springframework.beans.BeanUtils;

public class TicketMapper {

    public Ticket fromTicketDTORequestToTicket(TicketDTORequest ticketDTORequest){
         Ticket ticket=new Ticket();
        BeanUtils.copyProperties(ticketDTORequest,ticket);
        return ticket;
    }

    public TicketDTOResponse fromTicketToTicketDTOResponse(Ticket ticket){
        TicketDTOResponse ticketDTOResponse=new TicketDTOResponse();
        BeanUtils.copyProperties(ticket,ticketDTOResponse);
        return ticketDTOResponse;
    }
}
