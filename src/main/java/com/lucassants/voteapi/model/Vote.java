package com.lucassants.voteapi.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.lucassants.voteapi.views.ScheduleView;

import javax.persistence.*;

@Entity
@Table(name = "vote", indexes = {@Index(name="ASSOCIATE_SCHEDULE",columnList = "schedule_id,associate_id")})
public class Vote {
    @JsonView(ScheduleView.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonView(ScheduleView.class)
    @ManyToOne
    @JoinColumn(name = "associate_id")
    Associate associate;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    Schedule schedule;

    @JsonView(ScheduleView.class)
    @Column
    private Boolean positive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Associate getAssociate() {
        return associate;
    }

    public void setAssociate(Associate associate) {
        this.associate = associate;
    }

    public Boolean getPositive() {
        return positive;
    }

    public void setPositive(Boolean positive) {
        this.positive = positive;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
