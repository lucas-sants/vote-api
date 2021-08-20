package com.lucassants.voteapi.repository;

import com.lucassants.voteapi.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
