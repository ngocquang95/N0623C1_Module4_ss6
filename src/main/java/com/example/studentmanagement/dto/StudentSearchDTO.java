package com.example.studentmanagement.dto;

public class StudentSearchDTO {
    private String name;
    private String fromScore;
    private String toScore;
    private String clazzId;

    public StudentSearchDTO() {
    }

    public StudentSearchDTO(String name, String fromScore, String toScore, String clazzId) {
        this.name = name;
        this.fromScore = fromScore;
        this.toScore = toScore;
        this.clazzId = clazzId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFromScore() {
        return fromScore;
    }

    public void setFromScore(String fromScore) {
        this.fromScore = fromScore;
    }

    public String getToScore() {
        return toScore;
    }

    public void setToScore(String toScore) {
        this.toScore = toScore;
    }

    public String getClazzId() {
        return clazzId;
    }

    public void setClazzId(String clazzId) {
        this.clazzId = clazzId;
    }
}
