/*
서비스(Service) 클래스
비즈니스 로직을 수행하며, 필요한 경우
레포지토리를 호출하여 데이터를 가져오거나 저장합니다.
 */

package com.semiproject.pettales.adminpage.userstatuspage.service;

import com.semiproject.pettales.adminpage.model.dto.UserTableDTO;
import com.semiproject.pettales.adminpage.userstatuspage.entity.AdminUserTableStatus;
import com.semiproject.pettales.adminpage.userstatuspage.repository.AdminUserTableStatusRepository;
import com.semiproject.pettales.mypage.userupdate.entity.UserUpdate;
import com.semiproject.pettales.mypage.userupdate.repository.UserUpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminUserTableStatusService {

    private final AdminUserTableStatusRepository adminUserTableStatusRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AdminUserTableStatusService(AdminUserTableStatusRepository adminUserTableStatusRepository, PasswordEncoder passwordEncoder) {
        this.adminUserTableStatusRepository = adminUserTableStatusRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserTableDTO updateUserInfo(int userCode, UserTableDTO userTableDTO) {
        AdminUserTableStatus adminUserTableStatus = adminUserTableStatusRepository.findById(userCode)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 사용자 코드:" + userCode));

        // DTO의 데이터로 엔터티를 업데이트합니다

        adminUserTableStatus.setUpdateDate(new Date());

        AdminUserTableStatus updatedAdminUserTableStatus = adminUserTableStatusRepository.save(adminUserTableStatus);
        return convertToDto(updatedAdminUserTableStatus);
    }

    // 엔터티를 DTO로 변환하는 메소드
    private UserTableDTO convertToDto(AdminUserTableStatus adminUserTableStatus) {
        // 엔터티의 데이터로 새로운 DTO를 생성합니다
        UserTableDTO dto = new UserTableDTO();
        dto.setUserCode(adminUserTableStatus.getUserCode());
        dto.setUserNickname(adminUserTableStatus.getUserNickname());
        dto.setUserEmail(adminUserTableStatus.getUserEmail());
        dto.setUserPassword(adminUserTableStatus.getUserPassword());
        dto.setUserStatus(adminUserTableStatus.getUserStatus());
        dto.setUserAuth(adminUserTableStatus.getUserAuth());
        dto.setPetCodeList(adminUserTableStatus.getPetCodeList());
        dto.setCompanyCodeList(adminUserTableStatus.getCompanyCodeList());
        dto.setRegistDate(adminUserTableStatus.getRegistDate());
        dto.setUpdateDate(adminUserTableStatus.getUpdateDate());
        return dto;
    }

    // 사용자를 삭제하는 메소드
    public void deleteUser(int userCode) {
        AdminUserTableStatus user = adminUserTableStatusRepository.findById(userCode)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 사용자 코드:" + userCode));
        adminUserTableStatusRepository.deleteById(userCode);
    }

    // 전체 사용자 수를 반환하는 메소드
    public int getUserCount() {
        return (int) adminUserTableStatusRepository.count();
    }

    // 페이지별로 사용자 목록을 반환하는 메소드
    public List<UserTableDTO> getUsersPerPage(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size); // 페이지는 0부터 시작하므로 page - 1을 해줍니다.
        Page<AdminUserTableStatus> pageResult = adminUserTableStatusRepository.findAll(pageRequest);
        return pageResult.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // 키워드로 사용자를 검색하는 메소드
    public List<UserTableDTO> searchUsers(String keyword) {
        List<AdminUserTableStatus> entities = adminUserTableStatusRepository.findByUserNicknameContaining(keyword);
        return entities.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // 사용자 정보를 가져오는 메소드
    public UserTableDTO getUserInfo(int userCode) {
        AdminUserTableStatus adminUserTableStatus = adminUserTableStatusRepository.findById(userCode)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 사용자 코드:" + userCode));
        return convertToDto(adminUserTableStatus);
    }

    public UserTableDTO updateUserInfo(UserTableDTO userDto) {
        AdminUserTableStatus adminUserTableStatus = adminUserTableStatusRepository.findById(userDto.getUserCode())
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 사용자 코드:" + userDto.getUserCode()));

        // DTO의 데이터로 엔터티를 업데이트합니다
        adminUserTableStatus.setUserNickname(userDto.getUserNickname());
        adminUserTableStatus.setUserEmail(userDto.getUserEmail());
        adminUserTableStatus.setUserPassword(userDto.getUserPassword());
        adminUserTableStatus.setUserStatus(userDto.getUserStatus());
        adminUserTableStatus.setUserAuth(userDto.getUserAuth());
        adminUserTableStatus.setPetCodeList(userDto.getPetCodeList());
        adminUserTableStatus.setCompanyCodeList(userDto.getCompanyCodeList());
        adminUserTableStatus.setUpdateDate(new Date());

        AdminUserTableStatus updatedAdminUserTableStatus = adminUserTableStatusRepository.save(adminUserTableStatus);
        return convertToDto(updatedAdminUserTableStatus);
    }


    // 사용자를 등록하는 메소드 (비밀번호 암호화 포함)
    public UserTableDTO addUser(UserTableDTO userDto) {
        AdminUserTableStatus adminUserTableStatus = new AdminUserTableStatus();

        // DTO의 데이터로 엔터티를 설정합니다
        adminUserTableStatus.setUserNickname(userDto.getUserNickname());
        adminUserTableStatus.setUserEmail(userDto.getUserEmail());

        // 비밀번호 암호화
        String rawPassword = userDto.getUserPassword();
        String encodedPassword = passwordEncoder.encode(rawPassword);
        adminUserTableStatus.setUserPassword(encodedPassword);

        adminUserTableStatus.setUserStatus(userDto.getUserStatus());
        adminUserTableStatus.setUserAuth(userDto.getUserAuth());
        adminUserTableStatus.setPetCodeList(userDto.getPetCodeList());
        adminUserTableStatus.setCompanyCodeList(userDto.getCompanyCodeList());
        adminUserTableStatus.setRegistDate(new Date());

        AdminUserTableStatus newAdminUserTableStatus = adminUserTableStatusRepository.save(adminUserTableStatus);
        return convertToDto(newAdminUserTableStatus);
    }

    @Autowired
    UserUpdateRepository userUpdateRepository;

    public UserUpdate saveUserUpdate(UserUpdate userUpdate) {
        userUpdate.setUpdateDate(new Date()); // 업데이트 날짜를 현재 날짜로 설정
        return userUpdateRepository.save(userUpdate); // 사용자 정보를 업데이트
    }

}