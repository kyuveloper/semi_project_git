package com.semiproject.pettales.plan.dao;

import com.semiproject.pettales.plan.dto.PlanDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

@Mapper
public interface PlanDAO {
    int insertPlan(PlanDTO planDTO);
}
