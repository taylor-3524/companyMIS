package com.controller.project;

import com.dto.projectAndTeam;
import com.entity.Project;
import com.entity.Team;
import com.service.ImplProjectAndTeamService;
import com.service.ImplProjectService;
import com.service.ImplTeamService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectSelContorller {
    @Autowired
    private ImplProjectService projectService;
    @Autowired
    private ImplTeamService teamService;
    @Autowired
    private ImplProjectAndTeamService projectAndTeamService;

    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView=new ModelAndView("project/SelPorject");
        return modelAndView;
    }
    @RequestMapping("/selByName")
    public ModelAndView SelByName(@RequestParam(value = "name")String name){
        ModelAndView modelAndView=new ModelAndView("project/selProjectRes");
        List<Project> plist=projectService.SelProjectByName(name);
        modelAndView.addObject("data",plist);

        return modelAndView;
    }
    @RequestMapping("/selByName1")
    public ModelAndView SelByName1(@RequestParam(value = "name")String name){
        ModelAndView modelAndView=new ModelAndView("project/selProjectRes");
        List<projectAndTeam> list=projectAndTeamService.selProjectAndTeam(name);
        modelAndView.addObject("data",list);

        return modelAndView;
    }

}
