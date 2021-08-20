package com.lucassants.voteapi.repository;

import com.lucassants.voteapi.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}
