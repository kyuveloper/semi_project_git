package com.semiproject.pettales.AAmypage.userupdate.service;

import com.semiproject.pettales.AAmypage.userupdate.entity.UserUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semiproject.pettales.AAmypage.userupdate.repository.UserUpdateRepository;
import java.util.Optional;

@Service
public class UserUpdateServiceImpl implements UserUpdateService {

    // 사용자 정보를 저장하고 검색하기 위한 PasswordChangeRepository 객체를 주입합니다.
    @Autowired
    private UserUpdateRepository userUpdateRepository;

    /**
     * 사용자의 ID를 이용하여 사용자 정보를 찾습니다.
     * @param id 사용자의 ID
     * @return ID에 해당하는 사용자 정보를 담은 Optional 객체입니다. 해당 ID의 사용자가 없을 경우, 비어있는 Optional 객체를 반환합니다.
     */
    @Override
    public Optional<UserUpdate> findById(int id) {
        return userUpdateRepository.findById(id);
    }

    /**
     * 사용자 정보를 저장하거나 업데이트합니다.
     * @param userUpdate 저장하거나 업데이트할 사용자 정보 객체
     * @return 저장하거나 업데이트된 사용자 정보 객체를 반환합니다.
     */
    @Override
    public UserUpdate save(UserUpdate userUpdate) {
        return userUpdateRepository.save(userUpdate);
    }

    /**
     * 사용자의 ID를 이용하여 사용자 정보를 삭제합니다.
     * @param id 삭제할 사용자의 ID
     */
    @Override
    public void deleteById(int id) {
        userUpdateRepository.deleteById(id);
    }
}