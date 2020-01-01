package com.dto;

import org.springframework.stereotype.Repository;


public class projectAndTeam {

    private String pname;
    private Integer pnumber;
    private String status;
    private String remark;
    private String tname;
    private Integer tnumber;
    private Integer ofPorject;
    private Integer[] tnumbers;

    public Integer[] getTnumbers() {
        return tnumbers;
    }

    public void setTnumbers(Integer[] tnumbers) {
        this.tnumbers = tnumbers;
    }

    public Integer getTnumber() {
        return tnumber;
    }

    public void setTnumber(Integer tnumber) {
        this.tnumber = tnumber;
    }

    public Integer getOfPorject() {
        return ofPorject;
    }

    public void setOfPorject(Integer ofPorject) {
        this.ofPorject = ofPorject;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
}
