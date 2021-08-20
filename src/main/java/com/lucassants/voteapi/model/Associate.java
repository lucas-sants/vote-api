package com.lucassants.voteapi.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Associate {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @OneToMany(mappedBy = "associate")
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

    public Set<Vote> getVotes() {
        return votes;
    }

    public void setVotes(Set<Vote> votes) {
        this.votes = votes;
    }
}
