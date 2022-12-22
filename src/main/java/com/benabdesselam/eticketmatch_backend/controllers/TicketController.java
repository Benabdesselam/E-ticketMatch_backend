package com.benabdesselam.eticketmatch_backend.controllers;

import com.benabdesselam.eticketmatch_backend.dtos.MatchDTORequest;
import com.benabdesselam.eticketmatch_backend.dtos.MatchDTOResponse;
import com.benabdesselam.eticketmatch_backend.dtos.TicketDTORequest;
import com.benabdesselam.eticketmatch_backend.dtos.TicketDTOResponse;
import com.benabdesselam.eticketmatch_backend.services.MatchServiceImp;
import com.benabdesselam.eticketmatch_backend.services.TicketServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/json/ticket/",produces = "application/json")
public class TicketController {
    @Autowired
    TicketServiceImp ticketService;

    @PostMapping("addTiket/{id}")
    public TicketDTOResponse addTiket(@PathVariable Long id, @RequestBody TicketDTORequest ticketDTORequest){
        return ticketService.addTicket(id,ticketDTORequest);
    }

    @GetMapping("allTicket")
    public List<TicketDTOResponse> getAll(){
        return ticketService.findAll();
    }

    @GetMapping("ticketById/{id}")
    public TicketDTOResponse ticketById(@PathVariable Long id){
        return ticketService.findById(id);
    }

    @PutMapping("update/{id}")
    public TicketDTOResponse updateTicket(@PathVariable Long id,@RequestBody TicketDTORequest ticketDTORequest){
        return  ticketService.updateTicket(id, ticketDTORequest);
    }

    @DeleteMapping("delete/{id}")
    public  void deleteTicket(@PathVariable Long id){
        ticketService.deleteTicket(id);
    }



}
