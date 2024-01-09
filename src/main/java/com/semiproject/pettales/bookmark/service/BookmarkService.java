package com.semiproject.pettales.bookmark.service;

import com.semiproject.pettales.bookmark.dto.BookmarkDTO;
import com.semiproject.pettales.bookmark.model.BookmarkDAO;
import com.semiproject.pettales.company.dto.CompanyPaging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookmarkService {
    @Autowired
    private BookmarkDAO bookmarkDAO;

    private static final int PAGE_LIMIT = 6; // 한 페이지당 보여줄 회사 갯수

    private static final int BLOCK_LIMIT = 10; // 하단에 보여줄 페이지 번호 갯수

    // 시설을 찜 목록에 추가하는 메소드
    public void insertBookmarkByComCode(int companyCode, int userCode){
        bookmarkDAO.insertBookmarkByComCode(companyCode, userCode);
    }

    // 유저의 찜 목록을 가져오는 메소드
    public List<BookmarkDTO> selectBookmarkByUserCode(int userCode){
        return bookmarkDAO.selectBookmarkByUserCode(userCode);
    }

    // 유저가 찜한 시설을 삭제(안 보이게 한다)
    public void deleteBookmark(int companyCode, int userCode){
       bookmarkDAO.deleteBookmark(companyCode, userCode);
    }

    // 로그인 한 사용자가 해당 시설을 찜 목록에 추가했는지 보기 위한 메소드
    public BookmarkDTO selectBookmarkByComCode(int userCode, int companyCode){
        return bookmarkDAO.selectBookmarkByComCode(userCode, companyCode);
    }

    // 찜 목록 토글
    public void bookmarkToggle(int companyCode, int userCode){
        // 로그인 한 사용자의 해당 시설의 찜 목록 개수
        int bookmarkCount = bookmarkDAO.BookmarkCountByUserCode(userCode, companyCode);
        if(bookmarkCount > 0){
            // 해당 시설이 찜 목록에 추가되어 있다면 삭제
            deleteBookmark(companyCode, userCode);
        }else{
            // 찜 목록에 추가되어 있지 않다면 추가
            insertBookmarkByComCode(companyCode, userCode);
        }
    }

    // 찜 목록 삭제
    public int deleteBookmarkByBookCode(int userCode, int bookmarkCode){
        int result = bookmarkDAO.deleteBookmarkByBookCode(userCode, bookmarkCode);
        if(result < 0){
            System.out.println("실패했습니다");
        }else{
            System.out.println("성공");
        }
        return result;
    }

    public CompanyPaging pagingParam(int page, int userCode) {

        // 유저의 북마크 갯수 조회

        int boardCount = bookmarkDAO.countBookmarkByUserCode(userCode);

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
