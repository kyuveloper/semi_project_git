package com.semiproject.pettales.plan.dto;


import java.util.Date;
import java.util.List;

public class GroupedPlanDTO {
    private String planTitle;
    private Date travelDate;
    private List<String> companyNames;
    private List<String> companyCtprvns;
    private List<String> companyClassis;

    public GroupedPlanDTO(){

    }

    public GroupedPlanDTO(String planTitle, Date travelDate, List<String> companyNames, List<String> companyCtprvns, List<String> companyClassis) {
        this.planTitle = planTitle;
        this.travelDate = travelDate;
        this.companyNames = companyNames;
        this.companyCtprvns = companyCtprvns;
        this.companyClassis = companyClassis;
    }

    public String getPlanTitle() {
        return planTitle;
    }

    public void setPlanTitle(String planTitle) {
        this.planTitle = planTitle;
    }

    public Date getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
    }

    public List<String> getCompanyNames() {
        return companyNames;
    }

    public void setCompanyNames(List<String> companyNames) {
        this.companyNames = companyNames;
    }

    public List<String> getCompanyCtprvns() {
        return companyCtprvns;
    }

    public void setCompanyCtprvns(List<String> companyCtprvns) {
        this.companyCtprvns = companyCtprvns;
    }

    public List<String> getCompanyClassis() {
        return companyClassis;
    }

    public void setCompanyClassis(List<String> companyClassis) {
        this.companyClassis = companyClassis;
    }

    @Override
    public String toString() {
        return "GroupedPlanDTO{" +
                "planTitle='" + planTitle + '\'' +
                ", travelDate=" + travelDate +
                ", companyNames=" + companyNames +
                ", companyCtprvns=" + companyCtprvns +
                ", companyClassis=" + companyClassis +
                '}';
    }
}
