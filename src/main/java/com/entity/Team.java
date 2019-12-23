package com.entity;

public class Team {
    private Integer id;

    private String name;

    private Integer number;

    private Integer ofporject;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getOfporject() {
        return ofporject;
    }

    public void setOfporject(Integer ofporject) {
        this.ofporject = ofporject;
    }
}