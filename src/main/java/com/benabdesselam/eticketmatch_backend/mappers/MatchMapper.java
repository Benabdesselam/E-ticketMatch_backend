package com.benabdesselam.eticketmatch_backend.mappers;

import com.benabdesselam.eticketmatch_backend.dtos.MatchDTORequest;
import com.benabdesselam.eticketmatch_backend.dtos.MatchDTOResponse;
import com.benabdesselam.eticketmatch_backend.entities.Match;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MatchMapper {
    @Autowired
    static TicketMapper ticketMapper;


    public Match fromMatchDTORequestToMatch(MatchDTORequest matchDTORequest){
        Match match=new Match();
        BeanUtils.copyProperties(matchDTORequest,match);
        return match;
    }

    public MatchDTOResponse fromMatchtoMatchDTOResponse(Match match){
        MatchDTOResponse matchDTOResponse=new MatchDTOResponse();
        BeanUtils.copyProperties(match,matchDTOResponse);
        matchDTOResponse.setTicketList(match.getTicketList().stream().map(ticket ->
                ticketMapper.fromTicketToTicketDTOResponse(ticket)).collect(Collectors.toList())
        );
        return  matchDTOResponse;
    }
}
