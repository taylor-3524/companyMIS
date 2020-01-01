package com.dto;

public class TeamAndProject {
    private String pname;
    private Integer pnumber;

    private String tname;
    private Integer tnumber;
    private Integer ofporject;

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getPnumber() {
        return pnumber;
    }

    public void setPnumber(Integer pnumber) {
        this.pnumber = pnumber;
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


}
