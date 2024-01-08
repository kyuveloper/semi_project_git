/*
레포지토리(Repository) 클래스
데이터베이스와의 연동을 담당하며,
쿼리를 실행하고 결과를 반환합니다.
 */

package com.semiproject.pettales.adminpage.inquirystatus.repository;

import com.semiproject.pettales.adminpage.inquirystatus.entity.AdminInquiryStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminInquiryStatusRepository extends JpaRepository<AdminInquiryStatus, Integer> {
    // 여기에 필요한 JPA 쿼리 메소드를 추가할 수 있습니다.
    // 예를 들어, 사용자 코드나 답변 코드에 따른 검색 기능이 필요할 경우 아래와 같이 메소드를 선언할 수 있습니다.

    // 사용자 코드에 따른 문의사항 검색
    List<AdminInquiryStatus> findByUserCode(int userCode);

    // 답변 여부에 따른 문의사항 검색
    List<AdminInquiryStatus> findByAnswerCodeNotNull(); // 답변이 있는 문의사항 검색

    List<AdminInquiryStatus> findByAnswerCodeNull(); // 답변이 없는 문의사항 검색
}

