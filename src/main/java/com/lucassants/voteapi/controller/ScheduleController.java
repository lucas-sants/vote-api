package com.lucassants.voteapi.controller;

import com.lucassants.voteapi.DTO.VoteDTO;
import com.lucassants.voteapi.model.Associate;
import com.lucassants.voteapi.model.Schedule;
import com.lucassants.voteapi.model.Vote;
import com.lucassants.voteapi.repository.AssociateRepository;
import com.lucassants.voteapi.repository.ScheduleRepository;
import com.lucassants.voteapi.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private AssociateRepository associateRepository;

    @Autowired
    private VoteRepository voteRepository;

    @GetMapping
    public List<Schedule> List(){
        return scheduleRepository.findAll();
    }

    @PostMapping
    public Schedule Create(@RequestBody Schedule schedule){
        Schedule newSchedule = scheduleRepository.save(schedule);

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        executorService.schedule(() -> {
            newSchedule.setActive(false);
            scheduleRepository.save(newSchedule);
        }, 1, TimeUnit.MINUTES);
        return newSchedule;
    }

    @PostMapping("/{id}/votes")
    public ResponseEntity<Vote> CreateVote(@PathVariable Long id, @RequestBody VoteDTO voteDTO){

        Optional<Schedule> schedule = scheduleRepository.findById(id);
        Optional<Associate> associate = associateRepository.findById(voteDTO.getAssociate());
        if(associate.isEmpty() || schedule.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        if(!schedule.get().getActive()){
            return ResponseEntity.badRequest().build();
        }

        Vote vote = new Vote();
        vote.setPositive(voteDTO.getPositive());

        vote.setSchedule(schedule.get());
        vote.setAssociate(associate.get());

        return ResponseEntity.ok().body(voteRepository.save(vote));
    }

    @GetMapping("/{id}")
    public Optional<Schedule> GetById(@PathVariable Long id){
        return scheduleRepository.findById(id);
    }
}
