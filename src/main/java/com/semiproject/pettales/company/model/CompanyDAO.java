package com.semiproject.pettales.company.model;


import com.semiproject.pettales.company.dto.CompanyDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CompanyDAO {
    // 전체 건물 조회 페이징
    List<CompanyDTO> selectAllCompany(@Param("pageStart") int pageStart, @Param("pageLimit") int pageLimit);

    // 지역, 카테고리 별 건물 조회
    List<CompanyDTO> selectAllCompanyByCtprvn(
            @Param("pageStart") int pageStart,
            @Param("pageLimit") int pageLimit,
            @Param("companyCtprvn") String companyCtprvn,
            @Param("companyClassi") String companyClassi);
    // 전체 시설의 수
    int countCompany();

    // 지역별 시설의 수
    int countCompanyByCtprvn(
            @Param("companyCtprvn") String companyCtprvn,
            @Param("companyClassi") String companyClassi);
}