/*
서비스(Service) 클래스
비즈니스 로직을 수행하며, 필요한 경우
레포지토리를 호출하여 데이터를 가져오거나 저장합니다.
 */

package com.semiproject.pettales.adminpage.companystatus.service;

import com.semiproject.pettales.adminpage.companystatus.entity.AdminCompanyTableStatus;
import com.semiproject.pettales.adminpage.companystatus.repository.AdminCompanyTableStatusRepository;
import com.semiproject.pettales.adminpage.model.dto.CompanyTableDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminCompanyTableStatusService {

    private final AdminCompanyTableStatusRepository adminCompanyTableStatusRepository;

    @Autowired
    public AdminCompanyTableStatusService(AdminCompanyTableStatusRepository adminCompanyTableStatusRepository) {
        this.adminCompanyTableStatusRepository = adminCompanyTableStatusRepository;
    }

    // 회사 정보 조회 메서드
    public CompanyTableDTO getCompanyInfo(int companyCode) {
        AdminCompanyTableStatus company = adminCompanyTableStatusRepository.findById(companyCode)
                .orElseThrow(() -> new IllegalArgumentException("Invalid company code: " + companyCode));
        return convertToDto(company);
    }

    // 회사 정보 업데이트 메서드
    public void updateCompanyInfo(int companyCode, CompanyTableDTO companyDto) {
        AdminCompanyTableStatus company = adminCompanyTableStatusRepository.findById(companyDto.getCompanyCode())
                .orElseThrow(() -> new IllegalArgumentException("Invalid company code: " + companyDto.getCompanyCode()));
        updateEntityWithDto(company, companyDto);
        company.setUpdateDate(new Date());
        adminCompanyTableStatusRepository.save(company);
    }

    // 회사 삭제 메서드
    public boolean deleteCompany(int companyCode) {
        AdminCompanyTableStatus company = adminCompanyTableStatusRepository.findById(companyCode)
                .orElseThrow(() -> new IllegalArgumentException("Invalid company code: " + companyCode));
        adminCompanyTableStatusRepository.delete(company);
        return true;
    }

    // 회사 검색 메서드
    public List<CompanyTableDTO> searchCompanies(String keyword) {
        List<AdminCompanyTableStatus> companies = adminCompanyTableStatusRepository.findByCompanyNameContaining(keyword);
        return companies.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // 새로운 회사 추가 메서드
    public CompanyTableDTO addCompany(CompanyTableDTO companyDto) {
        AdminCompanyTableStatus company = convertToEntity(companyDto);
        company.setRegistDate(new Date());
        AdminCompanyTableStatus savedCompany = adminCompanyTableStatusRepository.save(company);
        return convertToDto(savedCompany);
    }

    // 엔터티를 DTO로 변환하는 메서드
    private CompanyTableDTO convertToDto(AdminCompanyTableStatus company) {
        CompanyTableDTO companyDto = new CompanyTableDTO();
        companyDto.setCompanyCode(company.getCompanyCode());
        companyDto.setCompanyName(company.getCompanyName());
        companyDto.setCompanyClassi(company.getCompanyClassi());
        companyDto.setCompanyStatus(company.getCompanyStatus());
        companyDto.setCompanyAddress(company.getCompanyAddress());
        companyDto.setCompanyLat(company.getCompanyLat());
        companyDto.setCompanyHar(company.getCompanyHar());
        companyDto.setCompanyPhoneNumber(company.getCompanyPhoneNumber());
        companyDto.setCompanyTime(company.getCompanyTime());
        companyDto.setRegistDate(company.getRegistDate());
        companyDto.setUpdateDate(company.getUpdateDate());
        companyDto.setCompanyPetPosbl(company.getCompanyPetPosbl());
        companyDto.setCompanyCtprvn(company.getCompanyCtprvn());
        companyDto.setCompanySigngu(company.getCompanySigngu());
        companyDto.setCompanyZipNum(company.getCompanyZipNum());
        companyDto.setCompanyInfo(company.getCompanyInfo());
        companyDto.setCompanyUrl(company.getCompanyUrl());
        companyDto.setCompanyCertified(company.getCompanyCertified());
        return companyDto;
    }

    // DTO를 엔터티로 변환하는 메서드
    private AdminCompanyTableStatus convertToEntity(CompanyTableDTO companyDto) {
        AdminCompanyTableStatus company = new AdminCompanyTableStatus();
        company.setCompanyCode(companyDto.getCompanyCode());
        company.setCompanyName(companyDto.getCompanyName());
        company.setCompanyClassi(companyDto.getCompanyClassi());
        company.setCompanyStatus(companyDto.getCompanyStatus());
        company.setCompanyAddress(companyDto.getCompanyAddress());
        company.setCompanyLat(companyDto.getCompanyLat());
        company.setCompanyHar(companyDto.getCompanyHar());
        company.setCompanyPhoneNumber(companyDto.getCompanyPhoneNumber());
        company.setCompanyTime(companyDto.getCompanyTime());
        company.setRegistDate(companyDto.getRegistDate());
        company.setUpdateDate(companyDto.getUpdateDate());
        company.setCompanyPetPosbl(companyDto.getCompanyPetPosbl());
        company.setCompanyCtprvn(companyDto.getCompanyCtprvn());
        company.setCompanySigngu(companyDto.getCompanySigngu());
        company.setCompanyZipNum(companyDto.getCompanyZipNum());
        company.setCompanyInfo(companyDto.getCompanyInfo());
        company.setCompanyUrl(companyDto.getCompanyUrl());
        company.setCompanyCertified(companyDto.getCompanyCertified());
        return company;
    }

    // DTO의 데이터로 엔터티를 업데이트하는 메서드
    private void updateEntityWithDto(AdminCompanyTableStatus company, CompanyTableDTO companyDto) {
        company.setCompanyCode(companyDto.getCompanyCode());
        company.setCompanyName(companyDto.getCompanyName());
        company.setCompanyClassi(companyDto.getCompanyClassi());
        company.setCompanyStatus(companyDto.getCompanyStatus());
        company.setCompanyAddress(companyDto.getCompanyAddress());
        company.setCompanyLat(companyDto.getCompanyLat());
        company.setCompanyHar(companyDto.getCompanyHar());
        company.setCompanyPhoneNumber(companyDto.getCompanyPhoneNumber());
        company.setCompanyTime(companyDto.getCompanyTime());
        company.setRegistDate(companyDto.getRegistDate());
        company.setUpdateDate(companyDto.getUpdateDate());
        company.setCompanyPetPosbl(companyDto.getCompanyPetPosbl());
        company.setCompanyCtprvn(companyDto.getCompanyCtprvn());
        company.setCompanySigngu(companyDto.getCompanySigngu());
        company.setCompanyZipNum(companyDto.getCompanyZipNum());
        company.setCompanyInfo(companyDto.getCompanyInfo());
        company.setCompanyUrl(companyDto.getCompanyUrl());
        company.setCompanyCertified(companyDto.getCompanyCertified());
    }

    // 회사 목록을 페이지별로 표시하는 메서드
    public List<CompanyTableDTO> getCompaniesPerPage(int page, int size) {
        // 페이지 번호는 1부터 시작하지만, 리스트 인덱스는 0부터 시작하므로 1을 빼줍니다.
        int currentPage = page - 1;
        // 페이지당 표시할 항목 수에 따른 전체 리스트의 서브셋을 계산합니다.
        List<AdminCompanyTableStatus> allCompanies = adminCompanyTableStatusRepository.findAll();
        int total = allCompanies.size();
        int start = Math.max(0, currentPage * size);
        int end = Math.min(start + size, total);
        // 서브리스트를 생성합니다.
        List<AdminCompanyTableStatus> companiesPage = allCompanies.subList(start, end);
        // DTO 리스트로 변환하여 반환합니다.
        return companiesPage.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }


    public int getCompanyCount() {
        return (int) adminCompanyTableStatusRepository.count();
    }
}