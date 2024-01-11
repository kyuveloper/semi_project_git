package com.semiproject.pettales.plan.dao;

import com.semiproject.pettales.plan.dto.BookmarkMappingDTO;
import com.semiproject.pettales.plan.dto.DetailPlanDTO;
import com.semiproject.pettales.plan.dto.PlanDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Mapper
public interface PlanDAO {
    int insertPlan(PlanDTO planDTO);

    List<PlanDTO> selectPlanByUserCode(int userCode);

    PlanDTO selectPlanByPlanCode(
            @Param("planCode")int planCode,
            @Param("userCode")int userCode);

    LocalDate getStartDateByPlanCodeAndUserCode(
            @Param("planCode")int planCode,
            @Param("userCode")int userCode
    );

    LocalDate getEndDateByPlanCodeAndUserCode(
            @Param("planCode")int planCode,
            @Param("userCode")int userCode
    );

    int insertDetailPlan(DetailPlanDTO detailPlanDTO);

    int insertBookmarkMapping(BookmarkMappingDTO bookmarkMappingDTO);

    DetailPlanDTO selectPlanBookmark(
            @Param("travelDate") Date travelDate,
            @Param("planDetailCode") int planDetailCode,
            @Param("userCode")int userCode
    );

    PlanDTO selectRegionByPlan(int planDetailCode);

    void hidePlanByPlanCode(
            @Param("planCode")int planCode,
            @Param("userCode")int userCode
    );


}
