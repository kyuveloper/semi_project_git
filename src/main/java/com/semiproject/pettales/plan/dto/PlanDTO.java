package com.semiproject.pettales.plan.dto;

import java.util.Date;

public class PlanDTO {
    private int planCode;
    private int userCode;
    private Date startDate;
    private Date endDate;
    private char planStatus;
    private String planTitle;

    public PlanDTO() {
    }

    public PlanDTO(int planCode, int userCode, Date startDate, Date endDate, char planStatus, String planTitle) {
        this.planCode = planCode;
        this.userCode = userCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.planStatus = planStatus;
        this.planTitle = planTitle;
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

    public String getPlanTitle() {
        return planTitle;
    }

    public void setPlanTitle(String planTitle) {
        this.planTitle = planTitle;
    }

    @Override
    public String toString() {
        return "PlanDTO{" +
                "planCode=" + planCode +
                ", userCode=" + userCode +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", planStatus=" + planStatus +
                ", planTitle='" + planTitle + '\'' +
                '}';
    }
}
