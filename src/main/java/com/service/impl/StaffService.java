package com.service.impl;

import com.dao.StaffMapper;
import com.entity.Staff;
import com.entity.StaffExample;
import com.service.ImplStaffService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StaffService implements ImplStaffService {
    @Autowired
    private StaffMapper staffMapper;
    /**
     * 检查工号合法性
     * @param number
     * @return
     */
    @Override
    public JSONObject checkNum(Integer number) {
        JSONObject jsonObject = new JSONObject();
        if (number != null) {
            StaffExample staffExample=new StaffExample();
            staffExample.createCriteria().andNumberEqualTo(number);
            List<Staff> list=staffMapper.selectByExample(staffExample);
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

    /**
     * 保存数据
     * @param staff
     */
    @Override
    public void addAction(Staff staff) {
        staffMapper.insertSelective(staff);
    }

    /**
     * 根据名字查找员工
     * @param name
     * @return
     */
    @Override
    public List<Staff> selectByName(String name) {
        StaffExample staffExample=new StaffExample();
        staffExample.createCriteria().andNameLike("%"+name+"%");
        List<Staff> list=staffMapper.selectByExample(staffExample);
        return list;
    }

    /**
     * 根据小组查找员工
     * @param ofTeam
     * @return
     */
    @Override
    public List<Staff> selectByTeam(Integer ofTeam){
        StaffExample staffExample=new StaffExample();
        staffExample.createCriteria().andOfteamEqualTo(ofTeam);
        List<Staff> list=staffMapper.selectByExample(staffExample);
        return list;

    }

    /**
     * 根据工号查员工
     * @param number
     * @return
     */
    @Override
    public List<Staff> selectByNumber(Integer number) {
        StaffExample staffExample=new StaffExample();
        staffExample.createCriteria().andNumberEqualTo(number);
        List<Staff> list=staffMapper.selectByExample(staffExample);
        return list;
    }

    /**
     * 部分更新员工表
     * @param staff
     */
    @Override
    public void updateStaffInfo(Staff staff){
        Integer number=staff.getNumber();
        StaffExample staffExample=new StaffExample();
        staffExample.createCriteria().andNumberEqualTo(number);
        staffMapper.updateByExampleSelective(staff,staffExample);
    }


}
