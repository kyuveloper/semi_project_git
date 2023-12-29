package com.semiproject.pettales.bookmark.service;

import com.semiproject.pettales.bookmark.dto.BookmarkDTO;
import com.semiproject.pettales.bookmark.model.BookmarkDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookmarkService {
    @Autowired
    private BookmarkDAO bookmarkDAO;

    public int insertBookmarkByComCode(int companyCode, int userCode){
        int result = bookmarkDAO.insertBookmarkByComCode(companyCode, userCode);
        if(result < 0){
            System.out.println("실패");
        }else{
            System.out.println("성공");
        }
        return result;
    }

    public List<BookmarkDTO> selectBookmarkByUserCode(int userCode){
        return bookmarkDAO.selectBookmarkByUserCode(userCode);
    }

    public int deleteBookmark(int bookmarkCode, int userCode){
        int result = bookmarkDAO.deleteBookmark(bookmarkCode, userCode);
        if(result < 0){
            System.out.println("실패");
        }else{
            System.out.println("성공");
        }
        return result;
    }

}
