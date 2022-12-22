package com.benabdesselam.eticketmatch_backend.controllers;

import com.benabdesselam.eticketmatch_backend.dtos.MatchDTORequest;
import com.benabdesselam.eticketmatch_backend.dtos.MatchDTOResponse;
import com.benabdesselam.eticketmatch_backend.services.MatchServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MatchControllerGraphQl {
    @Autowired
    MatchServiceImp matchService;

    @QueryMapping
    public List<MatchDTOResponse> getMatchs(){
        return matchService.allMatch();
    }

    @QueryMapping
    public MatchDTOResponse getMatchById(@Argument Long id){
        return  matchService.findById(id);
    }

    @MutationMapping
    public  MatchDTOResponse addMatch( @Argument MatchDTORequest matchDTORequest){
        return  matchService.addMatch(matchDTORequest);
    }

    @MutationMapping
    public  MatchDTOResponse updateMatch(@Argument Long id, @Argument MatchDTORequest matchDTORequest){
        return  matchService.updateMatch(id,matchDTORequest);
    }


    @MutationMapping
    public void deleteMatch( @Argument Long id){
        matchService.deleteMatch(id);
    }
}
