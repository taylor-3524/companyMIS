package com.controller.staff;

import com.entity.Staff;
import com.entity.Team;
import com.service.ImplStaffService;
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
@RequestMapping("/staffAdd")
public class StaffAddController {
    @Autowired
    private ImplTeamService teamService;
    @Autowired
    private ImplStaffService staffService;
    /**
     * 输入需要新增的信息
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView=new ModelAndView("/staff/add");
        List<Team> list=teamService.getAllTeamInfo();
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
        JSONObject msg=staffService.checkNum(number);
        return msg;
    }

    @RequestMapping("/addAction")
    public ModelAndView addAction(Staff staff){
        ModelAndView modelAndView=new ModelAndView("staff/add");
        List<Team> list=teamService.getAllTeamInfo();
        modelAndView.addObject("data",list);
        staffService.addAction(staff);
        return modelAndView;
    }

}
