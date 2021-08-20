package com.lucassants.voteapi.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.lucassants.voteapi.views.ScheduleView;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Schedule {
    @JsonView(ScheduleView.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonView(ScheduleView.class)
    @Column
    private String name;

    @JsonView(ScheduleView.class)
    @Column
    private Date date;

    @JsonView(ScheduleView.class)
    @Column
    private Boolean active = true;

    @JsonView(ScheduleView.class)
    @OneToMany(mappedBy = "schedule")
    Set<Vote> votes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<Vote> getVotes() {
        return votes;
    }

    public void setVotes(Set<Vote> votes) {
        this.votes = votes;
    }
}
