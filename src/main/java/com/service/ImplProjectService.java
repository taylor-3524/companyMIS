package com.service;

import com.entity.Project;
import net.sf.json.JSONObject;

import java.util.List;

public interface ImplProjectService {
    public List<Project> getAllProjectInfo();
    public void UpdProject(Project project);
    public List<Project> SelProjectByName(String name);
    public List<Project> SelProjectByNum(Integer number);
    public JSONObject checkNum(Integer number);
    public void AddProject(Project project);
}
