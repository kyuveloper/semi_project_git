package com.semiproject.pettales.mypage.doglistchange.entity;

import com.semiproject.pettales.mypage.userupdate.entity.UserUpdate;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "PET_TABLE")
public class PetUpdate {

    @Id
    @Column(name = "PET_CODE")
    private int petCode;

    @Column(name = "PET_NAME")
    private String petName;

    @Column(name = "PET_STATUS")
    private String petStatus;

    @Column(name = "PET_SPECIES")
    private String petSpecies;

    @Column(name = "PET_WEIGHT")
    private Integer petWeight;

    @Column(name = "REGIST_DATE")
    private Date registDate;

    @Column(name = "UPDATE_DATE")
    private Date updateDate;

    @Column(name = "PET_IMG")
    private String petImg;
    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "user_code")
    private UserUpdate userUpdate;

    public PetUpdate() {
    }

    public PetUpdate(int petCode, String petName, String petStatus, String petSpecies, Integer petWeight, Date registDate, Date updateDate, String petImg, String imagePath) {
        this.petCode = petCode;
        this.petName = petName;
        this.petStatus = petStatus;
        this.petSpecies = petSpecies;
        this.petWeight = petWeight;
        this.registDate = registDate;
        this.updateDate = updateDate;
        this.petImg = petImg;
        this.imagePath = imagePath;
    }

    public int getPetCode() {
        return petCode;
    }

    public void setPetCode(int petCode) {
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

    public String getPetImg() {
        return petImg;
    }

    public void setPetImg(String petImg) {
        this.petImg = petImg;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "PetUpdate{" +
                "petCode=" + petCode +
                ", petName='" + petName + '\'' +
                ", petStatus='" + petStatus + '\'' +
                ", petSpecies='" + petSpecies + '\'' +
                ", petWeight=" + petWeight +
                ", registDate=" + registDate +
                ", updateDate=" + updateDate +
                ", petImg='" + petImg + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
