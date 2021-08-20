package com.lucassants.voteapi.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private Date date;
    @Column
    private Boolean active = true;
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
