package com.controller.staff;

import com.dao.StaffMapper;
import com.entity.Staff;
import com.entity.Team;
import com.service.ImplStaffService;
import com.service.ImplTeamService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/staffSU")
public class StaffSelectAndUpdateController {
    @Autowired
    private ImplTeamService teamService;
    @Autowired
    private ImplStaffService staffService;
    @RequestMapping("/index")
    public ModelAndView modelAndView(){
        ModelAndView modelAndView=new ModelAndView("/staff/select");
        List<Team> list=teamService.getAllTeamInfo();
        modelAndView.addObject("team",list);
        return modelAndView;
    }

    /**
     * 根据名字查员工
     * @param name
     * @return
     */
    @RequestMapping("/selectByName")
    public ModelAndView selectByName(@RequestParam(value = "name")String name){
        ModelAndView modelAndView=new ModelAndView("staff/selectRes");
        List<Staff> list=staffService.selectByName(name);
        modelAndView.addObject("data",list);

        List<Team> list1=teamService.getAllTeamInfo();
        modelAndView.addObject("team",list1);

        return modelAndView;
    }

    /**
     * 根据小组查员工
     * @param ofTeam
     * @return
     */
    @RequestMapping("/selectByTeam")
    public ModelAndView selectByTeam(@RequestParam(value = "ofTeam")Integer ofTeam){
        ModelAndView modelAndView=new ModelAndView("staff/selectRes");
        List<Staff> list=staffService.selectByTeam(ofTeam);
        modelAndView.addObject("data",list);

        List<Team> list1=teamService.getAllTeamInfo();
        modelAndView.addObject("team",list1);

        return modelAndView;
    }

    /**
     * 向修改页面返回staff信息
     * @param number
     * @return
     */
    @RequestMapping("/getStaff")
    public ModelAndView getStaff(@RequestParam(value = "number") Integer number){
        ModelAndView modelAndView=new ModelAndView("staff/updateRes");
        List<Staff> list=staffService.selectByNumber(number);
        modelAndView.addObject("data",list);

        return modelAndView;
    }

    @RequestMapping("/update")
    public ModelAndView update(Staff staff){
        ModelAndView modelAndView=new ModelAndView("/staff/updateRes");
        staffService.updateStaffInfo(staff);

        List<Staff> list=staffService.selectByNumber(staff.getNumber());
        modelAndView.addObject("data",list);
        return modelAndView;

    }

}
