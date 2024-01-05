package com.semiproject.pettales.plan.dao;

import com.semiproject.pettales.plan.dto.PlanDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PlanDAO {
    int insertPlan(PlanDTO planDTO);

    List<PlanDTO> selectPlanByUserCode(int userCode);

    PlanDTO selectPlanByPlanCode(
            @Param("planCode")int planCode,
            @Param("userCode")int userCode);
}
