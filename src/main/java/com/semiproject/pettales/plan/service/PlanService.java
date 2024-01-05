package com.semiproject.pettales.plan.service;

import com.semiproject.pettales.plan.dao.PlanDAO;
import com.semiproject.pettales.plan.dto.PlanDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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
            System.out.println(planDTO.getPlanTitle());
        }
        return result;
    }

    public List<PlanDTO> selectPlanByUserCode(int userCode){
        return planDAO.selectPlanByUserCode(userCode);
    }

    public PlanDTO selectPlanByPlanCode(int planCode, int userCode){
        return planDAO.selectPlanByPlanCode(planCode, userCode);
    }
}
