package com.semiproject.pettales.plan.service;

import com.semiproject.pettales.plan.dao.PlanDAO;
import com.semiproject.pettales.plan.dto.PlanDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PlanService {
    @Autowired
    private PlanDAO planDAO;

    public int insertPlan(PlanDTO planDTO){
        int result = planDAO.insertPlan(planDTO);
        if(result < 0){
            System.out.println("실패");
        }else{
            System.out.println("성공");
        }
        return result;
    }
}
