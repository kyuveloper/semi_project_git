package com.semiproject.pettales.bookmark.model;

import com.semiproject.pettales.bookmark.dto.BookmarkDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookmarkDAO {
    // 찜 추가
    void insertBookmarkByComCode(
            @Param("companyCode")int companyCode,
            @Param("userCode")int userCode);

    // 유저의 찜 목록
    List<BookmarkDTO> selectBookmarkByUserCode(int userCode);

    // 찜 목록 토글에 사용하는 삭제
    void deleteBookmark(
            @Param("companyCode")int companyCode,
            @Param("userCode")int userCode
    );

    // 유저의 북마크 숫자 카운트
    int BookmarkCountByUserCode (
            @Param("userCode")int userCode,
            @Param("companyCode")int companyCode
    );

    // CompanyCardDTO에 들어갈 북마크
    BookmarkDTO selectBookmarkByComCode(
            @Param("userCode")int userCode,
            @Param("companyCode")int companyCode
    );

    // 찜 목록 삭제
    int deleteBookmarkByBookCode(
            @Param("userCode")int userCode,
            @Param("bookmarkCode")int bookmarkCode
    );
}
