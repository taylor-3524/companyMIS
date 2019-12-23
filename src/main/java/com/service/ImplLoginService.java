package com.service;


import com.entity.User;

import javax.servlet.http.HttpSession;

public interface ImplLoginService {
    public void checkuser(User user, HttpSession session);
}
