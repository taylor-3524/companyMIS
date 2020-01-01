package com.dao;

import com.dto.projectAndTeam;

import java.util.List;

public interface ProjectAndTeamMapper {
    List<projectAndTeam> getProjectAndTeam();
    List<projectAndTeam> selByName(String name);
}
