/*
레포지토리(Repository) 클래스
데이터베이스와의 연동을 담당하며,
쿼리를 실행하고 결과를 반환합니다.
 */

package com.semiproject.pettales.adminpage.companystatus.repository;

import com.semiproject.pettales.adminpage.companystatus.entity.AdminCompanyTableStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AdminCompanyTableStatusRepository extends JpaRepository<AdminCompanyTableStatus, Integer> {

    // 회사 이름을 포함하여 검색하는 메서드
    List<AdminCompanyTableStatus> findByCompanyNameContaining(String keyword);

}