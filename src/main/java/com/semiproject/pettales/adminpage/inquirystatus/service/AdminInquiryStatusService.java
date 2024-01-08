/*
서비스(Service) 클래스
비즈니스 로직을 수행하며, 필요한 경우
레포지토리를 호출하여 데이터를 가져오거나 저장합니다.
 */

package com.semiproject.pettales.adminpage.inquirystatus.service;

import com.semiproject.pettales.adminpage.inquirystatus.entity.AdminInquiryStatus;
import com.semiproject.pettales.adminpage.inquirystatus.repository.AdminInquiryStatusRepository;
import com.semiproject.pettales.adminpage.model.dto.InquiryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminInquiryStatusService {

    private final AdminInquiryStatusRepository adminInquiryStatusRepository;

    @Autowired
    public AdminInquiryStatusService(AdminInquiryStatusRepository adminInquiryStatusRepository) {
        this.adminInquiryStatusRepository = adminInquiryStatusRepository;
    }

    // 문의사항 목록을 페이지별로 가져오는 메서드
    public List<InquiryDTO> getInquiriesPerPage(int page, int size) {
        int startIndex = (page - 1) * size;
        List<AdminInquiryStatus> inquiries = adminInquiryStatusRepository.findAll();
        return inquiries.stream()
                .skip(startIndex)
                .limit(size)
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // 문의사항 상세 정보를 가져오는 메서드
    public InquiryDTO getInquiryInfo(int inqCode) {
        AdminInquiryStatus inquiry = adminInquiryStatusRepository.findById(inqCode)
                .orElseThrow(() -> new IllegalArgumentException("Invalid inquiry code: " + inqCode));
        return convertToDto(inquiry);
    }

    // 문의사항 답변을 업데이트하는 메서드
    public void updateInquiryAnswer(InquiryDTO inquiryDto) {
        AdminInquiryStatus inquiry = adminInquiryStatusRepository.findById(inquiryDto.getInqCode())
                .orElseThrow(() -> new IllegalArgumentException("Invalid inquiry code: " + inquiryDto.getInqCode()));
        inquiry.setAnswerContents(inquiryDto.getAnswerContents());
        inquiry.setAnswerRegistDate(new Date()); // 답변 등록 날짜는 현재 날짜로 설정
        adminInquiryStatusRepository.save(inquiry);
    }

    // 문의사항을 삭제하는 메서드
    public void deleteInquiry(int inqCode) {
        adminInquiryStatusRepository.deleteById(inqCode);
    }

    // AdminInquiryStatus 엔터티를 InquiryDTO로 변환하는 메서드
    private InquiryDTO convertToDto(AdminInquiryStatus inquiry) {
        InquiryDTO inquiryDto = new InquiryDTO();
        inquiryDto.setInqCode(inquiry.getInqCode());
        inquiryDto.setInqTitle(inquiry.getInqTitle());
        inquiryDto.setInqClassi(inquiry.getInqClassi());
        inquiryDto.setInqContents(inquiry.getInqContents());
        inquiryDto.setRegistDate(inquiry.getRegistDate());
        inquiryDto.setUpdateDate(inquiry.getUpdateDate());
        inquiryDto.setUserCode(inquiry.getUserCode());
        inquiryDto.setAnswerCode(inquiry.getAnswerCode());
        inquiryDto.setAnswerContents(inquiry.getAnswerContents());
        inquiryDto.setAnswerRegistDate(inquiry.getAnswerRegistDate());
        inquiryDto.setAnswerUpdateDate(inquiry.getAnswerUpdateDate());
        return inquiryDto;
    }

    // 사용자 코드에 따른 문의사항 목록을 조회하는 메소드
    public List<InquiryDTO> getInquiriesByUser(int userCode) {
        List<AdminInquiryStatus> inquiries = adminInquiryStatusRepository.findByUserCode(userCode);
        return inquiries.stream().map(this::convertToDto).collect(Collectors.toList());
    }
    // 답변이 있는 문의사항 목록을 조회하는 메소드
    public List<InquiryDTO> getAnsweredInquiries() {
        List<AdminInquiryStatus> inquiries = adminInquiryStatusRepository.findByAnswerCodeNotNull();
        return inquiries.stream().map(this::convertToDto).collect(Collectors.toList());
    }
    // 답변이 없는 문의사항 목록을 조회하는 메소드
    public List<InquiryDTO> getUnansweredInquiries() {
        List<AdminInquiryStatus> inquiries = adminInquiryStatusRepository.findByAnswerCodeNull();
        return inquiries.stream().map(this::convertToDto).collect(Collectors.toList());
    }
}