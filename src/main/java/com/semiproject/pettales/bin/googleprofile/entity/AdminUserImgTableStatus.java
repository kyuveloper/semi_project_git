//package com.semiproject.pettales.Aadminpage.googleprofile.entity;
//
//
//import com.semiproject.pettales.Aadminpage.userstatuspage.entity.myPage;
//import jakarta.persistence.*;
//// jdk 17
//// java -> jakarta
//// @javax.persistence.Entity
//
//@Entity
//@Table(name = "USER_IMG_TABLE")
//public class AdminUserImgTableStatus {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "IMG_ID")
//    private Long imgId;
//
//    @Column(name = "IMG_ORG_NAME")
//    private String image;
//
//    @Column(name = "IMG_UPD_NAME")
//    private String userImageUrl;
//
//    @ManyToOne
//    @JoinColumn(name = "USER_CODE")
//    private myPage adminUserTableStatus;
//
//    public AdminUserImgTableStatus() {
//    }
//
//    public AdminUserImgTableStatus(Long imgId, String image, String userImageUrl, myPage adminUserTableStatus) {
//        this.imgId = imgId;
//        this.image = image;
//        this.userImageUrl = userImageUrl;
//        this.adminUserTableStatus = adminUserTableStatus;
//    }
//
//    public Long getImgId() {
//        return imgId;
//    }
//
//    public void setImgId(Long imgId) {
//        this.imgId = imgId;
//    }
//
//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }
//
//    public String getUserImageUrl() {
//        return userImageUrl;
//    }
//
//    public void setUserImageUrl(String userImageUrl) {
//        this.userImageUrl = userImageUrl;
//    }
//
//    public myPage getAdminUserTableStatus() {
//        return adminUserTableStatus;
//    }
//
//    public void setAdminUserTableStatus(myPage adminUserTableStatus) {
//        this.adminUserTableStatus = adminUserTableStatus;
//    }
//
//    @Override
//    public String toString() {
//        return "AdminUserImgTableStatus{" +
//                "imgId=" + imgId +
//                ", image='" + image + '\'' +
//                ", userImageUrl='" + userImageUrl + '\'' +
//                ", adminUserTableStatus=" + adminUserTableStatus +
//                '}';
//    }
//}
