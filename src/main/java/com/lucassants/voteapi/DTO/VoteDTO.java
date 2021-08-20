package com.lucassants.voteapi.DTO;

public class VoteDTO {
    private Long associate;
    private Boolean positive;

    public Long getAssociate() {
        return associate;
    }

    public void setAssociate(Long associate) {
        this.associate = associate;
    }

    public Boolean getPositive() {
        return positive;
    }

    public void setPositive(Boolean positive) {
        this.positive = positive;
    }
}
