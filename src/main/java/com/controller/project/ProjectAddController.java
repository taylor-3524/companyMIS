package com.controller.project;

import com.dto.projectAndTeam;
import com.entity.Project;
import com.entity.Team;
import com.service.ImplProjectAndTeamService;
import com.service.ImplProjectService;
import com.service.ImplTeamService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/projectAdd")
public class ProjectAddController {
    @Autowired
    private ImplProjectService projectService;
    @Autowired
    private ImplProjectAndTeamService projectAndTeamService;
    @Autowired
    private ImplTeamService teamService;

//    @RequestMapping("/addAction")
//    public ModelAndView addProjectInfo(Project project){
//        System.out.println("111");
//        ModelAndView modelAndView=new ModelAndView("project/add");
//        projectService.AddProject(project);
//
//        return modelAndView;
//    }

    @RequestMapping("/addAction1")
    public ModelAndView addProjectTeam(projectAndTeam projectAndTeam){
        ModelAndView modelAndView=new ModelAndView("project/add");
        projectAndTeamService.AddProjectAndTeam(projectAndTeam);
        List<projectAndTeam> list=projectAndTeamService.getProjectAndTeam();
        List<Team> list1=teamService.getAllTeamIs0();
        modelAndView.addObject("data1",list1);
        modelAndView.addObject("data",list);
        return modelAndView;
    }
    /**
     * 检查工号合法性（确保工号唯一）
     * @param number
     * @return
     */

    @RequestMapping("/checkNum")
    @ResponseBody
    public JSONObject check(@RequestParam("number")Integer number){
        JSONObject msg=projectService.checkNum(number);
        return msg;
    }
    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView=new ModelAndView("project/add");
        List<projectAndTeam> list=projectAndTeamService.getProjectAndTeam();
        List<Team> list1=teamService.getAllTeamIs0();
        modelAndView.addObject("data",list);
        modelAndView.addObject("data1",list1);
        return modelAndView;

    }
}
