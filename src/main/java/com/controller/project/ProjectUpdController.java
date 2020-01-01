package com.controller.project;

import com.entity.Project;
import com.service.impl.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/projectUpd")
public class ProjectUpdController {
    @Autowired
    private ProjectService projectService;

    @RequestMapping("/getProjectNum")
    public ModelAndView getProjectNum(@RequestParam("number") Integer number){
        ModelAndView modelAndView=new ModelAndView("project/UpdProject");
        List<Project> list=projectService.SelProjectByNum(number);
        modelAndView.addObject("data",list);
        return  modelAndView;
    }
    @RequestMapping("/updateProject")
    public ModelAndView updateProject(Project project){
        ModelAndView modelAndView=new ModelAndView("project/UpdProject");
        projectService.UpdProject(project);
        return  modelAndView;
    }
}
