package com.service.impl;

import com.dao.TeamMapper;
import com.entity.Team;
import com.entity.TeamExample;
import com.service.ImplTeamService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.dao.TeamMapper;
import com.entity.Team;
import com.entity.TeamExample;
import com.service.ImplTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeamService implements ImplTeamService {

    @Autowired
    private TeamMapper teamMapper;

    /**
     * 返回现有小组的名字和编号
     * @return
     */
    @Override
    public List<Team> getAllTeamIs0() {
        TeamExample teamExample=new TeamExample();
        teamExample.createCriteria().andOfporjectEqualTo(0);
        List<Team> list=teamMapper.selectByExample(teamExample);
        return list;
    }
    /**
     * 返回现有小组的名字和编号
     * @return
     */
    @Override
    public List<Team> getAllTeamInfo() {
        TeamExample teamExample=new TeamExample();
        List<Team> list=teamMapper.selectByExample(teamExample);
        return list;
    }

    @Override
    public JSONObject checkNum(Integer number) {
        JSONObject jsonObject = new JSONObject();
        if(number!=null){
            TeamExample teamExample=new TeamExample();
            teamExample.createCriteria().andNumberEqualTo(number);
            List<Team> list=teamMapper.selectByExample(teamExample);
            if (list.isEmpty()) {
                //数据库没有这个编号
                jsonObject.put("tip", "工号可以使用");
                jsonObject.put("success","success");
                jsonObject.put("code", "001");
            } else {
                jsonObject.put("tip", "工号已被分配");
                jsonObject.put("success","error");
                jsonObject.put("code", "002");
            }
        } else {
            //没有工号
            jsonObject.put("tip", "");
            jsonObject.put("success","error");
            jsonObject.put("code", "003");
        }
        return jsonObject;
    }


    @Override
    public void addAction(Team Team) {

        teamMapper.insertSelective(Team);
    }

    @Override
    public List<Team> selectByName(String name) {
        TeamExample teamExample=new TeamExample();
        teamExample.createCriteria().andNameLike("%"+name+"%");
        List<Team> list=teamMapper.selectByExample(teamExample);
        return list;
    }
    /**
     * 根据项目找小组*/
    @Override
    public List<Team> selectByTeam(Integer ofTeam) {
        TeamExample teamExample=new TeamExample();
        teamExample.createCriteria().andOfporjectEqualTo(ofTeam);
        List<Team> list=teamMapper.selectByExample(teamExample);
        return list;
    }


    @Override
    public List<Team> selectByNumber(Integer number){
        TeamExample teamExample=new TeamExample();
        teamExample.createCriteria().andNumberEqualTo(number);
        List<Team> list=teamMapper.selectByExample(teamExample);
        return list;
    }

    @Override
    public void updateTeamInfo(Team Team) {
        Integer number=Team.getNumber();
        TeamExample teamExample=new TeamExample();
        teamExample.createCriteria().andNumberEqualTo(number);
        teamMapper.updateByExampleSelective(Team,teamExample);
    }

    @Override
    /**
     *根据项目编号查找小组
     * @return
     */
    public List<Team> selByNumber(Integer number) {
        TeamExample teamExample=new TeamExample();
        teamExample.createCriteria().andNumberEqualTo(number);
        List<Team> list=teamMapper.selectByExample(teamExample);
        return list;
    }

}
