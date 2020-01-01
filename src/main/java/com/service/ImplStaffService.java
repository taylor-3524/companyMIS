package com.service;

import com.entity.Staff;
import net.sf.json.JSONObject;

import java.util.List;

public interface ImplStaffService {
    public JSONObject checkNum(Integer number);
    public void addAction(Staff staff);
    public List<Staff> selectByName(String name);
    public List<Staff> selectByTeam(Integer ofTeam);
    public List<Staff> selectByNumber(Integer number);
    public void updateStaffInfo(Staff staff);

}
