package com.controller.staff;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/staff")
public class StaffIndexController {

    /**
     * 主页导航
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView=new ModelAndView("/staff/index");
        return modelAndView;
    }


}
