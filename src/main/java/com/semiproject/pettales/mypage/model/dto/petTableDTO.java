package com.semiproject.pettales.mypage.model.dto;

import java.util.Date;

public class petTableDTO {

    private Integer petCode;
    private String petName;
    private String petStatus;
    private String petSpecies;
    private Integer petWeight;
    private Date registDate;
    private Date updateDate;

    public petTableDTO() {
    }

    public petTableDTO(Integer petCode, String petName, String petStatus, String petSpecies, Integer petWeight, Date registDate, Date updateDate) {
        this.petCode = petCode;
        this.petName = petName;
        this.petStatus = petStatus;
        this.petSpecies = petSpecies;
        this.petWeight = petWeight;
        this.registDate = registDate;
        this.updateDate = updateDate;
    }

    public Integer getPetCode() {
        return petCode;
    }

    public void setPetCode(Integer petCode) {
        this.petCode = petCode;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetStatus() {
        return petStatus;
    }

    public void setPetStatus(String petStatus) {
        this.petStatus = petStatus;
    }

    public String getPetSpecies() {
        return petSpecies;
    }

    public void setPetSpecies(String petSpecies) {
        this.petSpecies = petSpecies;
    }

    public Integer getPetWeight() {
        return petWeight;
    }

    public void setPetWeight(Integer petWeight) {
        this.petWeight = petWeight;
    }

    public Date getRegistDate() {
        return registDate;
    }

    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "petTableDTO{" +
                "petCode=" + petCode +
                ", petName='" + petName + '\'' +
                ", petStatus='" + petStatus + '\'' +
                ", petSpecies='" + petSpecies + '\'' +
                ", petWeight=" + petWeight +
                ", registDate=" + registDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
