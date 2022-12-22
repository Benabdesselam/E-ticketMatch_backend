package com.benabdesselam.eticketmatch_backend.entities;

import com.benabdesselam.eticketmatch_backend.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false,updatable = false)
    private String reference;
    private double prix;
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    Match match;
}
