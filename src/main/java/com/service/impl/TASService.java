package com.service.impl;

import com.dao.TASMapper;
import com.dto.TeamAndStaff;
import com.entity.Staff;
import com.entity.Team;
import com.service.ImplTASService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TASService implements ImplTASService {

    @Autowired
    private TASMapper tasMapper;
    @Autowired
    private TeamService teamService;
    @Autowired
    private StaffService staffService;
    @Override
    public List<TeamAndStaff> getTAndS() {
        List<TeamAndStaff> list=tasMapper.getTAndS();
        return list;
    }

    @Override
    public void devide(TeamAndStaff teamAndStaff) {
        Team team=new Team();
        team.setName(teamAndStaff.getTname());
        team.setOfporject(teamAndStaff.getOfporject());
        team.setNumber(teamAndStaff.getTnumber());
        teamService.addAction(team);

        Staff staff=new Staff();

        for (int i:teamAndStaff.getSnumbers())
        {
            staff.setNumber(i);
            staff.setOfteam(teamAndStaff.getTnumber());
            staffService.updateStaffInfo(staff);
        }
    }
}
