package com.benabdesselam.eticketmatch_backend.services;

import com.benabdesselam.eticketmatch_backend.dtos.MatchDTORequest;
import com.benabdesselam.eticketmatch_backend.dtos.MatchDTOResponse;
import com.benabdesselam.eticketmatch_backend.entities.Match;

import java.util.List;

public interface MatchService {


    List<MatchDTOResponse> allMatch();
    MatchDTOResponse findById(Long id);
    MatchDTOResponse addMatch(MatchDTORequest matchDTORequest);
    MatchDTOResponse updateMatch(Long id, MatchDTORequest matchDTORequest);
    void deleteMatch(Long id);
}
