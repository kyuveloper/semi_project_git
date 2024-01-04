//package com.semiproject.pettales.Aadminpage.googleprofile.service;
//
//import com.semiproject.pettales.Aadminpage.googleprofile.entity.AdminUserImgTableStatus;
//import com.semiproject.pettales.Aadminpage.model.dto.UserImgTableDTO;
//import com.semiproject.pettales.Aadminpage.userstatuspage.repository.myPageRepository;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserImgAssembler {
//
//    private myPageRepository adminUserTableStatusRepository;
//
//    public UserImgAssembler(myPageRepository adminUserTableStatusRepository) {
//        this.adminUserTableStatusRepository = adminUserTableStatusRepository;
//    }
//
//    public UserImgTableDTO toDTO(AdminUserImgTableStatus entity) {
//        UserImgTableDTO dto = new UserImgTableDTO();
//        dto.setUserImgCode(entity.getUserImgCode());
//        dto.setUserCode(entity.getAdminUserTableStatus().getUserCode()); // AdminUserTableStatus의 기본 키 값
//        dto.setImgOrgName(entity.getImgOrgName());
//        dto.setImgUpdName(entity.getImgUpdName());
//        dto.setImgStatus(entity.getImgStatus());
//        return dto;
//    }
//
//    public AdminUserImgTableStatus toEntity(UserImgTableDTO dto) {
//        AdminUserImgTableStatus entity = new AdminUserImgTableStatus();
//        entity.setUserImgCode(dto.getUserImgCode());
//        entity.setAdminUserTableStatus(adminUserTableStatusRepository.findById(dto.getUserCode()).orElse(null)); // AdminUserTableStatus의 기본 키 값으로 엔티티를 가져옴
//        entity.setImgOrgName(dto.getImgOrgName());
//        entity.setImgUpdName(dto.getImgUpdName());
//        entity.setImgStatus(dto.getImgStatus());
//        return entity;
//    }
//}