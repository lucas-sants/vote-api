package com.lucassants.voteapi.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorDTO {
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;

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
