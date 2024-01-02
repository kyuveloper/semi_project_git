package com.semiproject.pettales.bookmark.model;

import com.semiproject.pettales.bookmark.dto.BookmarkDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookmarkDAO {
    void insertBookmarkByComCode(
            @Param("companyCode")int companyCode,
            @Param("userCode")int userCode);

    List<BookmarkDTO> selectBookmarkByUserCode(int userCode);

    void deleteBookmark(
            @Param("companyCode")int companyCode,
            @Param("userCode")int userCode
    );

    int BookmarkCountByUserCode (
            @Param("userCode")int userCode,
            @Param("companyCode")int companyCode
    );

    BookmarkDTO selectBookmarkByComCode(
            @Param("userCode")int userCode,
            @Param("companyCode")int companyCode
    );
}
