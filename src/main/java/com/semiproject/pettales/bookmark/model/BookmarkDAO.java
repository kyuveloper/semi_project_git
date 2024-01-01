package com.semiproject.pettales.bookmark.model;

import com.semiproject.pettales.bookmark.dto.BookmarkDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookmarkDAO {
    int insertBookmarkByComCode(
            @Param("companyCode")int companyCode,
            @Param("userCode")int userCode);

    List<BookmarkDTO> selectBookmarkByUserCode(int userCode);

    int deleteBookmark(
            @Param("bookmarkCode")int bookmarkCode,
            @Param("userCode")int userCode
    );

    BookmarkDTO selectBookmarkByComCode(
            @Param("userCode")int userCode,
            @Param("companyCode")int companyCode
    );
}
