package com.lucassants.voteapi.controller;

import com.lucassants.voteapi.model.Associate;
import com.lucassants.voteapi.repository.AssociateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/associates")
public class AssociateController {
    @Autowired
    private AssociateRepository associateRepository;

    @GetMapping
    public List<Associate> List(){ return associateRepository.findAll(); }

    @PostMapping
    public Associate Create(@RequestBody Associate associate){
        return associateRepository.save(associate);
    }

    @GetMapping
    public Optional<Associate> GetById(Long id){
        return associateRepository.findById(id);
    }
}
