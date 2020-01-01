package com.service;

import com.dto.projectAndTeam;

import java.util.List;

public interface ImplProjectAndTeamService {
    public void AddProjectAndTeam(projectAndTeam projectAndTeam);
    public List<projectAndTeam> getProjectAndTeam();
    public List<projectAndTeam> selProjectAndTeam(String name);
}
