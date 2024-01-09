package com.semiproject.pettales.mypage.userupdate.service;

import com.semiproject.pettales.mypage.model.dto.UserTableDTO;
import com.semiproject.pettales.mypage.userupdate.entity.UserUpdate;
import com.semiproject.pettales.mypage.userupdate.repository.UserUpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserUpdateService {

    private final UserUpdateRepository userUpdateRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserUpdateService(UserUpdateRepository userUpdateRepository, PasswordEncoder passwordEncoder) {
        this.userUpdateRepository = userUpdateRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserUpdate getUserUpdate(Integer userCode) {
        return userUpdateRepository.findById(userCode)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 사용자 코드:" + userCode));
    }

    public UserTableDTO updateUserInfo(int userCode, UserTableDTO userTableDTO) {
        UserUpdate userUpdate = getUserUpdate(userCode);

        // DTO의 데이터로 엔터티를 업데이트합니다
        userUpdate.setUserNickname(userTableDTO.getUserNickname());
        userUpdate.setUserEmail(userTableDTO.getUserEmail());
        userUpdate.setUserPassword(passwordEncoder.encode(userTableDTO.getUserPassword())); // 비밀번호 암호화 적용
        userUpdate.setUserStatus(userTableDTO.getUserStatus());
        userUpdate.setUserAuth(userTableDTO.getUserAuth());
        userUpdate.setPetCodeList(userTableDTO.getPetCodeList());
        userUpdate.setCompanyCodeList(userTableDTO.getCompanyCodeList());
        userUpdate.setUpdateDate(new Date());

        UserUpdate updatedUserUpdate = userUpdateRepository.save(userUpdate);
        return convertToDto(updatedUserUpdate);
    }

    // 엔터티를 DTO로 변환하는 메소드
    private UserTableDTO convertToDto(UserUpdate userUpdate) {
        // 엔터티의 데이터로 새로운 DTO를 생성합니다
        UserTableDTO dto = new UserTableDTO();
        dto.setUserCode(userUpdate.getUserCode());
        dto.setUserNickname(userUpdate.getUserNickname());
        dto.setUserEmail(userUpdate.getUserEmail());
        dto.setUserPassword(userUpdate.getUserPassword());
        dto.setUserStatus(userUpdate.getUserStatus());
        dto.setUserAuth(userUpdate.getUserAuth());
        dto.setPetCodeList(userUpdate.getPetCodeList());
        dto.setCompanyCodeList(userUpdate.getCompanyCodeList());
        dto.setRegistDate(userUpdate.getRegistDate());
        dto.setUpdateDate(userUpdate.getUpdateDate());
        return dto;
    }

    public void saveUserUpdate(UserUpdate userUpdate) {
        userUpdateRepository.save(userUpdate);
    }

    public void deleteById(int userCode) {
        userUpdateRepository.deleteById(userCode);
    }
}