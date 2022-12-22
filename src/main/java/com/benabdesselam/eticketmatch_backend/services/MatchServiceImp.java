package com.benabdesselam.eticketmatch_backend.services;

import com.benabdesselam.eticketmatch_backend.dtos.MatchDTORequest;
import com.benabdesselam.eticketmatch_backend.dtos.MatchDTOResponse;
import com.benabdesselam.eticketmatch_backend.entities.Match;
import com.benabdesselam.eticketmatch_backend.mappers.MatchMapper;
import com.benabdesselam.eticketmatch_backend.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MatchServiceImp implements MatchService{
    @Autowired
    MatchRepository matchRepository;
    MatchMapper matchMapper;


    @Override
    public List<MatchDTOResponse> allMatch() {
        List<MatchDTOResponse> matchResponseDtoList =
                matchRepository.findAll().stream().map(t-> matchMapper.fromMatchtoMatchDTOResponse(t)).collect(Collectors.toList());
        return matchResponseDtoList;
    }

    @Override
    public MatchDTOResponse findById(Long id) {
        Match match =  matchRepository.findById(id).orElse(null);
        return matchMapper.fromMatchtoMatchDTOResponse(match);
    }

    @Override
    public MatchDTOResponse addMatch(MatchDTORequest matchDTORequest) {
        Match match = matchMapper.fromMatchDTORequestToMatch(matchDTORequest);
        match.setReference(UUID.randomUUID().toString());
        matchRepository.save(match);
        return matchMapper.fromMatchtoMatchDTOResponse(match);
    }

    @Override
    public MatchDTOResponse updateMatch(Long id, MatchDTORequest matchDTORequest) {
        Match match = matchRepository.findById(id).orElseThrow(()-> new RuntimeException("Match Not Found"));
        match.setDate(matchDTORequest.getDate());
        match.setEquipe1(matchDTORequest.getEquipe1());
        match.setEquipe2(matchDTORequest.getEquipe2());
        matchRepository.save(match);
        return matchMapper.fromMatchtoMatchDTOResponse(match);
    }

    @Override
    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }
}
