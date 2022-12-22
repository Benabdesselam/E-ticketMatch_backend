package com.benabdesselam.eticketmatch_backend.controllers;

import com.benabdesselam.eticketmatch_backend.dtos.MatchDTORequest;
import com.benabdesselam.eticketmatch_backend.dtos.MatchDTOResponse;
import com.benabdesselam.eticketmatch_backend.services.MatchServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "/api/json/match/",produces = "application/json")
public class MatchController {
    @Autowired
    MatchServiceImp matchService;

    @PostMapping("add")
    public MatchDTOResponse addMatch(@RequestBody MatchDTORequest matchDTORequest){
        return matchService.addMatch(matchDTORequest);
    }

    @GetMapping("all")
    public List<MatchDTOResponse> listMatch(){
        return matchService.allMatch();
    }

    @GetMapping("findById/{id}")
    public MatchDTOResponse findById(@RequestParam Long id){
        return matchService.findById(id);
    }

    @DeleteMapping("deleteById/{id}")
    public  void  deleteById(@RequestParam Long id){
        matchService.deleteMatch(id);
    }
}
