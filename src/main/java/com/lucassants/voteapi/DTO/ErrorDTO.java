package com.lucassants.voteapi.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lucassants.voteapi.views.ScheduleView;

@JsonSerialize
public class ErrorDTO {
    @JsonView(ScheduleView.class)
    @JsonProperty("name")
    private String name;
    @JsonView(ScheduleView.class)
    @JsonProperty("description")
    private String description;

    public ErrorDTO() {
    }

    public ErrorDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
