package com.dto;

import org.springframework.stereotype.Repository;

@Repository
public class TeamAndStaff {
    private String sname;

    private Integer snumber;

    private Integer ofteam;

    private String stenure;

    private String tname;

    private Integer tnumber;

    private Integer ofporject;

    private Integer[] snumbers;

    public Integer[] getSnumbers() {
        return snumbers;
    }

    public void setSnumbers(Integer[] snumbers) {
        this.snumbers = snumbers;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getSnumber() {
        return snumber;
    }

    public void setSnumber(Integer snumber) {
        this.snumber = snumber;
    }

    public String getStenure() {
        return stenure;
    }

    public void setStenure(String stenure) {
        this.stenure = stenure;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Integer getTnumber() {
        return tnumber;
    }

    public void setTnumber(Integer tnumber) {
        this.tnumber = tnumber;
    }

    public Integer getOfporject() {
        return ofporject;
    }

    public void setOfporject(Integer ofporject) {
        this.ofporject = ofporject;
    }




    public Integer getOfteam() {
        return ofteam;
    }

    public void setOfteam(Integer ofteam) {
        this.ofteam = ofteam;
    }


}
