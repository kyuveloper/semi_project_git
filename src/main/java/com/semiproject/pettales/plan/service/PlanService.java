package com.semiproject.pettales.plan.service;

import com.semiproject.pettales.bookmark.dto.BookmarkDTO;
import com.semiproject.pettales.plan.dao.PlanDAO;
import com.semiproject.pettales.plan.dto.BookmarkMappingDTO;
import com.semiproject.pettales.plan.dto.DetailPlanDTO;
import com.semiproject.pettales.plan.dto.GroupedPlanDTO;
import com.semiproject.pettales.plan.dto.PlanDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
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
            System.out.println("service: " + planDTO.getPlanCode());
        }
        return result;
    }

    public List<PlanDTO> selectPlanByUserCode(int userCode){
        return planDAO.selectPlanByUserCode(userCode);
    }

    public PlanDTO selectPlanByPlanCode(int planCode, int userCode){
        return planDAO.selectPlanByPlanCode(planCode, userCode);
    }

    public LocalDate getStartDateByPlanCodeAndUserCode(int planCode, int userCode) {
        // PlanMapper를 통해 시작일을 가져온다.
        return planDAO.getStartDateByPlanCodeAndUserCode(planCode, userCode);
    }

    public LocalDate getEndDateByPlanCodeAndUserCode(int planCode, int userCode) {
        // PlanMapper를 통해 종료일을 가져온다.
        return planDAO.getEndDateByPlanCodeAndUserCode(planCode, userCode);
    }

    public int insertDetailPlan(DetailPlanDTO detailPlanDTO){
        return planDAO.insertDetailPlan(detailPlanDTO);
    }

    public int insertBookmarkMapping(BookmarkMappingDTO bookmarkMappingDTO){
        return planDAO.insertBookmarkMapping(bookmarkMappingDTO);
    }

    public List<DetailPlanDTO> selectPlanBookmark(Date travelDate, int planCode, int userCode){
        return planDAO.selectPlanBookmark(travelDate, planCode, userCode);
    }

    public PlanDTO selectRegionByPlan(int planCode,int userCode,Date travelDate){
        return planDAO.selectRegionByPlan(planCode, userCode, travelDate);
    }

    public void hidePlanByPlanCode(int planCode, int userCode){
        planDAO.hidePlanByPlanCode(planCode, userCode);
    }

    public DetailPlanDTO selectPlanDetailByPlanCodeAndTravelDate(int planCode, Date travelDate, int userCode){
        return planDAO.selectPlanDetailByPlanCodeAndTravelDate(planCode, travelDate, userCode);
    }

    public void deleteMappingById(int bookmarkCode, int userCode){
        planDAO.deleteMappingById(bookmarkCode, userCode);
    }

    public List<GroupedPlanDTO> selectDetailPlanList(int userCode, int planCode){
        return planDAO.selectDetailPlanList(userCode, planCode);
    }

}
