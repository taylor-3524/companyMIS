package com.service.impl;

import com.dao.ProjectMapper;
import com.entity.Project;
import com.entity.ProjectExample;
import com.service.ImplProjectService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectService implements ImplProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public List<Project> getAllProjectInfo() {
        ProjectExample projectExample=new ProjectExample();
        List<Project> list=projectMapper.selectByExample(projectExample);
        return list;
    }    /**
     * 根据项目编号查找项目
     * @param number
     * @return
     */
    public List<Project> SelProjectByNum(Integer number){
        ProjectExample projectExample=new ProjectExample();
        projectExample.createCriteria().andNumberEqualTo(number);
        List<Project> list=projectMapper.selectByExample(projectExample);
        return list;
    }

    /**
     * 检查项目编号合法性
     * @param number
     * @return
     */
    @Override
    public JSONObject checkNum(Integer number) {
        JSONObject jsonObject = new JSONObject();
        if (number != null) {
            ProjectExample projectExample=new ProjectExample();
            projectExample.createCriteria().andNumberEqualTo(number);
            List<Project> list=projectMapper.selectByExample(projectExample);
            if (list.isEmpty()) {
                //数据库没有这个编号
                jsonObject.put("tip", "编号可以使用");
                jsonObject.put("success","success");
                jsonObject.put("code", "001");
            } else {
                jsonObject.put("tip", "编号已被分配");
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
    /**
     * 根据修改项目
     * @param project
     * @return
     */
    public void UpdProject(Project project) {
        Integer number=project.getNumber();
        ProjectExample projectExample=new ProjectExample();
        projectExample.createCriteria().andNumberEqualTo(number);
        projectMapper.updateByExampleSelective(project,projectExample);
    }
    /**
     * 根据项目名称查找项目
     * @param name
     * @return
     */
    @Override
    public List<Project> SelProjectByName(String name) {
        ProjectExample projectExample=new ProjectExample();
        projectExample.createCriteria().andNameLike("%"+name+"%");
        List<Project> list=projectMapper.selectByExample(projectExample);

        return list;
    }


    @Override
    public void AddProject(Project project) {
        System.out.println("222");
        System.out.println(project.getName());
        projectMapper.insertSelective(project);
    }


}
