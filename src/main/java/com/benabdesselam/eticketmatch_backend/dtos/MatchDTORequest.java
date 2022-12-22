package com.benabdesselam.eticketmatch_backend.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class MatchDTORequest {
    private Date date;
    private String lieu;
    private String equipe1;
    private String equipe2;
}
