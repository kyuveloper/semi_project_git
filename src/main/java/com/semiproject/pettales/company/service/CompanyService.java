package com.semiproject.pettales.company.service;

import com.semiproject.pettales.company.dto.CompanyDTO;
import com.semiproject.pettales.company.model.CompanyDAO;
import com.semiproject.pettales.company.paging.CompanyPaging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyDAO companyDAO;

    private static final int PAGE_LIMIT = 12; // 한 페이지당 보여줄 회사 갯수

    private static final int BLOCK_LIMIT = 10; // 하단에 보여줄 페이지 번호 갯수

// 메인 화면에 뿌릴 신발 리스트(페이징)

    // 모든 시설 조회
    public List<CompanyDTO> selectAllCompany(int page){
        /*

         * 1페이지에 보여줄 회사 : 12

         * 1page = 0

         * 2page = 12

         * 3page = 24

         */

        int pageStart = (page -1) * PAGE_LIMIT;

        List<CompanyDTO> companyList = companyDAO.selectAllCompany(pageStart, PAGE_LIMIT);

        return companyList;

    }

    // 지역별 건물 조회
    public List<CompanyDTO> selectAllCompanyByCtprvn(int page, String companyCtprvn){
        int pageStart = (page -1) * PAGE_LIMIT;
        List<CompanyDTO> companyListByCtprvn = companyDAO.selectAllCompanyByCtprvn(pageStart, PAGE_LIMIT, companyCtprvn);

        return companyListByCtprvn;
    }
    public CompanyPaging pagingParam(int page) {

        // 전체 글 갯수 조회

        int boardCount = companyDAO.countCompany();

        // 전체 페이지 갯수 계산(10/3=3.33333 => 4)

        int maxPage = (int) (Math.ceil((double) boardCount / PAGE_LIMIT));

        // 시작 페이지 값 계산(1, 4, 7, 10, ~~~~)

        int startPage = (((int)(Math.ceil((double) page / BLOCK_LIMIT))) - 1) * BLOCK_LIMIT + 1;

        // 끝 페이지 값 계산(3, 6, 9, 12, ~~~~)

        int endPage = startPage + BLOCK_LIMIT - 1;

        if (endPage > maxPage) {

            endPage = maxPage;

        }

        CompanyPaging paging = new CompanyPaging();

        paging.setPage(page);

        paging.setMaxPage(maxPage);

        paging.setStartPage(startPage);

        paging.setEndPage(endPage);

        return paging;
    }

    // 지역별 시설 화면에 뿌리기 페이징파람
    public CompanyPaging pagingParamByCtprvn(int page, String companyCtprvn) {

        // 지역별 시설 갯수 조회

        int boardCount = companyDAO.countCompanyByCtprvn(companyCtprvn);

        // 전체 페이지 갯수 계산(10/3=3.33333 => 4)

        int maxPage = (int) (Math.ceil((double) boardCount / PAGE_LIMIT));

        // 시작 페이지 값 계산(1, 4, 7, 10, ~~~~)

        int startPage = (((int)(Math.ceil((double) page / BLOCK_LIMIT))) - 1) * BLOCK_LIMIT + 1;

        // 끝 페이지 값 계산(3, 6, 9, 12, ~~~~)

        int endPage = startPage + BLOCK_LIMIT - 1;

        if (endPage > maxPage) {

            endPage = maxPage;

        }

        CompanyPaging paging = new CompanyPaging();

        paging.setPage(page);

        paging.setMaxPage(maxPage);

        paging.setStartPage(startPage);

        paging.setEndPage(endPage);

        return paging;

    }
}