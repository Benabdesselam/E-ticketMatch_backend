package com.benabdesselam.eticketmatch_backend.repositories;

import com.benabdesselam.eticketmatch_backend.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

}
