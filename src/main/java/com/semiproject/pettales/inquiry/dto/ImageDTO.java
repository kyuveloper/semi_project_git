package com.semiproject.pettales.inquiry.dto;

import java.util.Date;

public class ImageDTO {
    private int inquiryImgCode;
    private String ImgOrgName;
    private String ImgUpdName;
    private Date registDate;
    private int InqCode;

    public ImageDTO() {
    }

    public ImageDTO(int inquiryImgCode, String imgOrgName, String imgUpdName, Date registDate, int inqCode) {
        this.inquiryImgCode = inquiryImgCode;
        ImgOrgName = imgOrgName;
        ImgUpdName = imgUpdName;
        this.registDate = registDate;
        InqCode = inqCode;
    }

    public int getInquiryImgCode() {
        return inquiryImgCode;
    }

    public void setInquiryImgCode(int inquiryImgCode) {
        this.inquiryImgCode = inquiryImgCode;
    }

    public String getImgOrgName() {
        return ImgOrgName;
    }

    public void setImgOrgName(String imgOrgName) {
        ImgOrgName = imgOrgName;
    }

    public String getImgUpdName() {
        return ImgUpdName;
    }

    public void setImgUpdName(String imgUpdName) {
        ImgUpdName = imgUpdName;
    }

    public Date getRegistDate() {
        return registDate;
    }

    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }

    public int getInqCode() {
        return InqCode;
    }

    public void setInqCode(int inqCode) {
        InqCode = inqCode;
    }

    @Override
    public String toString() {
        return "ImageDTO{" +
                "inquiryImgCode=" + inquiryImgCode +
                ", ImgOrgName='" + ImgOrgName + '\'' +
                ", ImgUpdName='" + ImgUpdName + '\'' +
                ", registDate=" + registDate +
                ", InqCode=" + InqCode +
                '}';
    }
}
