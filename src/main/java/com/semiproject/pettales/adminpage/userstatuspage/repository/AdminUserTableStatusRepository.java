/*
레포지토리(Repository) 클래스
데이터베이스와의 연동을 담당하며,
쿼리를 실행하고 결과를 반환합니다.
 */

package com.semiproject.pettales.adminpage.userstatuspage.repository;

import com.semiproject.pettales.adminpage.userstatuspage.entity.AdminUserTableStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AdminUserTableStatusRepository extends JpaRepository<AdminUserTableStatus, Integer> {
    // 검색 기능을 위한 메소드
    List<AdminUserTableStatus> findByUserNicknameContaining(String keyword);
}
