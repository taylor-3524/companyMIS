package com.controller.team;

import com.dto.TeamAndProject;
import com.entity.Project;
import com.entity.Team;
import com.service.ImplProjectService;
import com.service.ImplTAPService;
import com.service.ImplTeamService;
import com.service.impl.TAPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/teamSU")
public class TeamSelectAndUpdateController {
    @Autowired
    private ImplTeamService teamService;
    @Autowired
    private ImplProjectService projectService;
    @Autowired
    private ImplTAPService tapService;

    @RequestMapping("/index")
    public ModelAndView modelAndView(){
        ModelAndView modelAndView=new ModelAndView("/team/select");
        List<Project> list=projectService.getAllProjectInfo();
        modelAndView.addObject("team",list);
        return modelAndView;
    }

    @RequestMapping("/selectByName")
    public ModelAndView selectByName(@RequestParam(value = "name")String name){
        ModelAndView modelAndView=new ModelAndView("team/selectRes");
        List<Team> list=teamService.selectByName(name);
        modelAndView.addObject("data",list);
        List<Project> list1=projectService.getAllProjectInfo();
        modelAndView.addObject("team",list1);
        return modelAndView;
    }

    @RequestMapping("/getTeam")
    public ModelAndView getStaff(@RequestParam(value = "number") Integer number){
        ModelAndView modelAndView=new ModelAndView("team/updateRes");
        List<Team> list=teamService.selectByNumber(number);
        modelAndView.addObject("data",list);
        List<TeamAndProject> list1=tapService.gerTAndP();
        modelAndView.addObject("data1",list1);
        return modelAndView;
    }

    @RequestMapping("/update")
    public ModelAndView update(Team team){
        ModelAndView modelAndView=new ModelAndView("/team/updateRes");
        teamService.updateTeamInfo(team);
        List<TeamAndProject> list1=tapService.gerTAndP();
        modelAndView.addObject("data1",list1);
        List<Team> list=teamService.selectByNumber(team.getNumber());
        modelAndView.addObject("data",list);
        return modelAndView;

    }
    @RequestMapping("/selectByTeam")
    public ModelAndView selectByTeam(@RequestParam(value = "ofTeam")Integer ofTeam){
        ModelAndView modelAndView=new ModelAndView("/team/selectRes");
        List<Team> list=teamService.selectByTeam(ofTeam);
        modelAndView.addObject("data",list);

        List<Project> list1=projectService.getAllProjectInfo();
        modelAndView.addObject("team",list1);

        return modelAndView;
    }
}
