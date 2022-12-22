package com.benabdesselam.eticketmatch_backend.dtos;

import com.benabdesselam.eticketmatch_backend.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class TicketDTOResponse {
    private Long id;
    private String reference;
    private double prix;
    private Status status;

}
