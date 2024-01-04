package com.semiproject.pettales.plan.dto;

import java.util.Date;

public class PlanDTO {
    private int planCode;
    private int userCode;
    private Date startDate;
    private Date endDate;
    private char planStatus;

    public PlanDTO() {
    }

    public PlanDTO(int planCode, int userCode, Date startDate, Date endDate, char planStatus) {
        this.planCode = planCode;
        this.userCode = userCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.planStatus = planStatus;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public char getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(char planStatus) {
        this.planStatus = planStatus;
    }


}
