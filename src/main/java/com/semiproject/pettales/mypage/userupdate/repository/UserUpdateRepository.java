/*
레포지토리(Repository) 클래스
데이터베이스와의 연동을 담당하며,
쿼리를 실행하고 결과를 반환합니다.
 */

package com.semiproject.pettales.mypage.userupdate.repository;

import com.semiproject.pettales.mypage.userupdate.entity.UserUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserUpdateRepository extends JpaRepository<UserUpdate, Integer> {
}