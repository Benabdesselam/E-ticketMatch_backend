package com.benabdesselam.eticketmatch_backend;

import com.benabdesselam.eticketmatch_backend.dtos.MatchDTORequest;
import com.benabdesselam.eticketmatch_backend.dtos.TicketDTORequest;
import com.benabdesselam.eticketmatch_backend.services.MatchServiceImp;
import com.benabdesselam.eticketmatch_backend.services.TicketServiceImp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class ETicketMatchBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ETicketMatchBackendApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(MatchServiceImp matchService, TicketServiceImp ticketService) {
        return args -> {
            MatchDTORequest matchDTORequest = new MatchDTORequest(new Date(), "Settat", "ANSS", "RSS");
           matchService.addMatch(matchDTORequest);
            for (int i = 0; i < 10; i++) {
                TicketDTORequest ticketRequestDto = new TicketDTORequest((double) (Math.random()*100));
                ticketService.addTicket(1L,ticketRequestDto);
            }


        };

    }
}
