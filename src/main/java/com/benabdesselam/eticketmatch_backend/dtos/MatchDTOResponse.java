package com.benabdesselam.eticketmatch_backend.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchDTOResponse {
    private Long id;
    private String reference;
    private Date date;
    private String lieu;
    private String equipe1;
    private String equipe2;
    private List<TicketDTOResponse> ticketList;
}
