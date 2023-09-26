package com.example.studentmanagement.model;

public class Student {
    private int id;
    private String name;
    private double score;
    private int clazzId;

    public Student() {
    }

    public Student(int id, String name, double score, int clazzId) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.clazzId = clazzId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getClazzId() {
        return clazzId;
    }

    public void setClazzId(int clazzId) {
        this.clazzId = clazzId;
    }
}
