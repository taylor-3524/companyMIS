package com.controller.team;

import com.dto.TeamAndProject;
import com.dto.TeamAndStaff;
import com.entity.Staff;
import com.entity.Team;
import com.service.ImplStaffService;
import com.service.ImplTAPService;
import com.service.ImplTASService;
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
@RequestMapping("/teamAdd")
public class TeamAddControlled {
    @Autowired
    private ImplTeamService teamService;
    @Autowired
    private ImplStaffService staffService;
    @Autowired
    private ImplTASService tasService;
    @Autowired
    private TeamAndStaff teamAndStaff;
    @Autowired
    private ImplTAPService tapService;
    /**
     * 输入需要新增的信息
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView=new ModelAndView("/team/add");
        List<TeamAndProject> list=tapService.gerTAndP();
        modelAndView.addObject("data",list);
       List<TeamAndStaff> list1=tasService.getTAndS();
       modelAndView.addObject("data1",list1);
        return modelAndView;
    }

    /**
     * 检查工号合法性（确保工号唯一）
     * @param number
     * @return
     */

    @RequestMapping("/checkNum")
    @ResponseBody
    public JSONObject check(@RequestParam(value = "number")Integer number){
        JSONObject msg=teamService.checkNum(number);
        return msg;
    }

    @RequestMapping("/addAction")
    public ModelAndView addAction(TeamAndStaff teamAndStaff){
        ModelAndView modelAndView=new ModelAndView("team/add");
        tasService.devide(teamAndStaff);
        List<TeamAndProject> list=tapService.gerTAndP();
        modelAndView.addObject("data",list);
        List<TeamAndStaff> list1=tasService.getTAndS();
        modelAndView.addObject("data1",list1);
        return modelAndView;
    }
}
