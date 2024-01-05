package com.semiproject.pettales.plan.dto;

import java.util.Date;

public class DetailPlanDTO {
    private int planDetailCode;
    private int planCode;
    private int userCode;
    private Date travelDate;

    public DetailPlanDTO() {
    }

    public DetailPlanDTO(int planDetailCode, int planCode, int userCode, Date travelDate) {
        this.planDetailCode = planDetailCode;
        this.planCode = planCode;
        this.userCode = userCode;
        this.travelDate = travelDate;
    }

    public int getPlanDetailCode() {
        return planDetailCode;
    }

    public void setPlanDetailCode(int planDetailCode) {
        this.planDetailCode = planDetailCode;
    }

    public int getPlanCode() {
        return planCode;
    }

    public void setPlanCode(int planCode) {
        this.planCode = planCode;
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public Date getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
    }

    @Override
    public String toString() {
        return "DetailPlanDTO{" +
                "planDetailCode=" + planDetailCode +
                ", planCode=" + planCode +
                ", userCode=" + userCode +
                ", travelDate=" + travelDate +
                '}';
    }
}
