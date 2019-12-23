package com.entity;

public class Staff {
    private Integer id;

    private String name;

    private Integer number;

    private Integer ofteam;

    private String phone;

    private String tenure;

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

    public Integer getOfteam() {
        return ofteam;
    }

    public void setOfteam(Integer ofteam) {
        this.ofteam = ofteam;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getTenure() {
        return tenure;
    }

    public void setTenure(String tenure) {
        this.tenure = tenure == null ? null : tenure.trim();
    }
}