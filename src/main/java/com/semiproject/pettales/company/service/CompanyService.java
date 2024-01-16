package com.semiproject.pettales.company.service;

import com.semiproject.pettales.auth.service.MemberService;
import com.semiproject.pettales.bookmark.dto.BookmarkDTO;
import com.semiproject.pettales.bookmark.service.BookmarkService;
import com.semiproject.pettales.company.dto.CompanyCardDTO;
import com.semiproject.pettales.company.dto.CompanyDTO;
import com.semiproject.pettales.company.dto.CompanyDetailDTO;
import com.semiproject.pettales.company.model.CompanyDAO;
import com.semiproject.pettales.company.dto.CompanyPaging;
import com.semiproject.pettales.user.model.dto.LoginUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyDAO companyDAO;

    @Autowired
    private MemberService memberService;

    @Autowired
    private BookmarkService bookmarkService;

    private static final int PAGE_LIMIT = 12; // 한 페이지당 보여줄 회사 갯수

    private static final int BLOCK_LIMIT = 10; // 하단에 보여줄 페이지 번호 갯수

// 메인 화면에 뿌릴 신발 리스트(페이징)

    // 모든 시설 조회
    public List<CompanyCardDTO> selectAllCompanyCard(int page, int userCode){
        int pageStart = (page -1) * PAGE_LIMIT;
        List<CompanyCardDTO> companyCard = new ArrayList<>();
        List<CompanyDTO> companyList = companyDAO.selectAllCompany(pageStart, PAGE_LIMIT);

        // 시설 리스트 수 만큼 CompanyCard에 회사 정보, 유저 정보, 북마크 정보 삽입
        for(CompanyDTO companyDTO : companyList){
            CompanyCardDTO card = new CompanyCardDTO();
            // 회사 정보
            card.setCompanyDTO(companyDTO);

            // 로그인 한 유저의 정보
            LoginUserDTO user = memberService.selectUserByUserCode(userCode);
            card.setUser(user);

            // 유저 북마크 정보
            BookmarkDTO bookmarked = bookmarkService.selectBookmarkByComCode(userCode, companyDTO.getCompanyCode());
            card.setBookmarkDTO(bookmarked);
            companyCard.add(card);
        }
        return companyCard;
    }

    //지역별 건물 조회
    public List<CompanyDTO> selectAllCompanyByCtprvn(int page, String companyCtprvn, String companyClassi){
        int pageStart = (page -1) * PAGE_LIMIT;
        List<CompanyDTO> companyListByCtprvn = companyDAO.selectAllCompanyByCtprvn(pageStart, PAGE_LIMIT, companyCtprvn, companyClassi);

        return companyListByCtprvn;
    }

    public List<CompanyCardDTO> selectCompanyCardByCtprvn(int page, String companyCtprvn, String companyClassi, int userCode){
        int pageStart = (page -1) * PAGE_LIMIT;
        List<CompanyCardDTO> companyCard = new ArrayList<>();
        List<CompanyDTO> companyListByCtprvn = companyDAO.selectAllCompanyByCtprvn(pageStart, PAGE_LIMIT, companyCtprvn, companyClassi);

        // 시설 리스트 수 만큼 CompanyCard에 회사 정보, 유저 정보, 북마크 정보 삽입
        for(CompanyDTO companyDTO : companyListByCtprvn){
            CompanyCardDTO card = new CompanyCardDTO();
            // 회사 정보
            card.setCompanyDTO(companyDTO);

            // 로그인 한 유저의 정보
            LoginUserDTO user = memberService.selectUserByUserCode(userCode);
            card.setUser(user);

            // 유저 북마크 정보
            BookmarkDTO bookmarked = bookmarkService.selectBookmarkByComCode(userCode, companyDTO.getCompanyCode());
            card.setBookmarkDTO(bookmarked);
            companyCard.add(card);
        }
        return companyCard;
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

    // 지역별 시설 화면에 뿌리기 페이징 파람
    public CompanyPaging pagingParamByCtprvn(int page, String companyCtprvn, String companyClassi) {

        // 지역별 시설 갯수 조회

        int boardCount = companyDAO.countCompanyByCtprvn(companyCtprvn, companyClassi);

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

    public List<String> getAllRegion(){
        return companyDAO.getAllRegion();
    }

    public List<String> getAllCategory(){
        return companyDAO.getAllCategory();
    }

    public int companyInfoByCode(CompanyDTO companyDTO) {
        int result = companyDAO.companyInfoByCode(companyDTO);
        if (result <= 0) {
            System.out.println("Select Error");
        } else {
            System.out.println("Select Success");
        }
        return result;
    }

    public List<CompanyDetailDTO> comDetailInfo(int companyCode) {
        return companyDAO.comDetailInfo(companyCode);
    }
}