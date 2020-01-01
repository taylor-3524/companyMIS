package com.service.impl;

import com.dao.TAPMapper;
import com.dto.TeamAndProject;
import com.service.ImplTAPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TAPService implements ImplTAPService {
    @Autowired
    TAPMapper tapMapper;
    @Override
    public List<TeamAndProject> gerTAndP() {
        List<TeamAndProject> list=tapMapper.getTAndP();
        for(int i=0;i<list.size();i++)
        {
            list.get(i).setOfporject(list.get(i).getPnumber());
        }
        return list;
    }
}
