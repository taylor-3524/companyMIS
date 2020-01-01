package com.service;


import com.entity.User;

import javax.servlet.http.HttpSession;

public interface ImplLoginService {
    public boolean checkuser(User user, HttpSession session);
}
