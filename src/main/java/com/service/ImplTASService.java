package com.service;

import com.dto.TeamAndStaff;

import java.util.List;

public interface ImplTASService {
    public List<TeamAndStaff> getTAndS();
    public void devide(TeamAndStaff teamAndStaff);
}
