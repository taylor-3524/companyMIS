package com.service.impl;

import com.dao.ProjectAndTeamMapper;
import com.dto.projectAndTeam;
import com.entity.Project;
import com.entity.Team;
import com.service.ImplProjectAndTeamService;
import com.service.ImplProjectService;
import com.service.ImplTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.PriorityQueue;

@Service
public class ProjectAndTeamService implements ImplProjectAndTeamService {
    @Autowired
    private ProjectAndTeamMapper projectAndTeamMapper;
    @Autowired
    private ImplProjectService projectService;
    @Autowired
    private ImplTeamService teamService;

    @Override
    public void AddProjectAndTeam(projectAndTeam projectAndTeam) {
        Project project=new Project();
        project.setName(projectAndTeam.getPname());
        project.setNumber(projectAndTeam.getPnumber());
        project.setRemark(projectAndTeam.getRemark());
        project.setStatus(projectAndTeam.getStatus());
        projectService.AddProject(project);

        Team team=new Team();
        for(int i:projectAndTeam.getTnumbers()){
            team.setNumber(i);
            System.out.println(i);
            team.setOfporject(projectAndTeam.getPnumber());
            System.out.println(projectAndTeam.getPnumber());
            teamService.updateTeamInfo(team);
        }


    }

    @Override
    public List<projectAndTeam> getProjectAndTeam() {
   //     System.out.println("到了service");
        List<projectAndTeam> list=projectAndTeamMapper.getProjectAndTeam();

        return list;
    }

    @Override
    public List<projectAndTeam> selProjectAndTeam(String name) {
        List<projectAndTeam> list=projectAndTeamMapper.selByName(name);
        return list;
    }


}
