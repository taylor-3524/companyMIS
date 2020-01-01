package com.service.impl;


import com.dao.UserMapper;

import com.entity.User;
import com.entity.UserExample;
import com.service.ImplLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class LoginService implements ImplLoginService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean checkuser(User user, HttpSession session) {
        UserExample userExample=new UserExample();
        userExample.createCriteria().andUsernameEqualTo(user.getUsername());
        List<User> list=userMapper.selectByExample(userExample);

        if(!list.isEmpty()){
            //有这个用户名
            if(list.get(0).getPassword().equals(user.getPassword())){
                session.setAttribute("user",user);
                return true;
            }
        }

        return false;
    }
}
