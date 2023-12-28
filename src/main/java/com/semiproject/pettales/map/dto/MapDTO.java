package com.semiproject.pettales.map.dto;

public class MapDTO {

    private int companyCode;
    private String companyName;
    private String companyLat;
    private String companyHar;

    public MapDTO() {
    }

    public MapDTO(int companyCode, String companyName, String companyLat, String companyHar) {
        this.companyCode = companyCode;
        this.companyName = companyName;
        this.companyLat = companyLat;
        this.companyHar = companyHar;
    }

    public int getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(int companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyLat() {
        return companyLat;
    }

    public void setCompanyLat(String companyLat) {
        this.companyLat = companyLat;
    }

    public String getCompanyHar() {
        return companyHar;
    }

    public void setCompanyHar(String companyHar) {
        this.companyHar = companyHar;
    }

    @Override
    public String toString() {
        return "MapDTO{" +
                "companyCode=" + companyCode +
                ", companyName='" + companyName + '\'' +
                ", companyLat='" + companyLat + '\'' +
                ", companyHar='" + companyHar + '\'' +
                '}';
    }
}