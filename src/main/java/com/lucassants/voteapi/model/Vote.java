package com.lucassants.voteapi.model;

import javax.persistence.*;

@Entity
@Table(name = "vote", indexes = {@Index(name="ASSOCIATE_SCHEDULE",columnList = "schedule_id,associate_id")})
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "associate_id")
    Associate associate;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    Schedule schedule;

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
