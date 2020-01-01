package com.service;

import com.entity.Team;
import net.sf.json.JSONObject;

import java.util.List;

public interface ImplTeamService {
    public List<Team> getAllTeamInfo();
    public JSONObject checkNum(Integer number);
    public void addAction(Team Team);
    public List<Team> selectByName(String name);
    public List<Team> selectByTeam(Integer ofTeam);
    public List<Team> selectByNumber(Integer number);
    public void updateTeamInfo(Team Team);
    public List<Team> getAllTeamIs0();
    public List<Team> selByNumber(Integer number);
}
