package com.semiproject.pettales.mypage.mypage.service;

import com.semiproject.pettales.mypage.bookmarklistchange.entity.BookmarkUpdate;
import com.semiproject.pettales.mypage.doglistchange.entity.PetUpdate;
import com.semiproject.pettales.mypage.mypage.repository.BookmarkRepository;
import com.semiproject.pettales.mypage.mypage.repository.MypageRepository;
import com.semiproject.pettales.mypage.mypage.repository.PetRepository;
import com.semiproject.pettales.mypage.passwordchange.service.UserNotFoundException;
import com.semiproject.pettales.mypage.userupdate.entity.UserUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MypageService {

    @Autowired
    private MypageRepository mypageRepository;

    @Autowired
    private BookmarkRepository bookmarkRepository;

    @Autowired
    private PetRepository petRepository;

    public UserUpdate getUserById(int userId) {
        return mypageRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
    }

    public List<BookmarkUpdate> getBookmarksByUserId(int userId) {
        return bookmarkRepository.findByUserUpdate_UserCode(userId);
    }

    public List<PetUpdate> getPetsByUserId(int userId) {
        return petRepository.findByUserUpdate_UserCode(userId);
    }

    public UserUpdate getUserByEmail(String currentPrincipalName) {
        return mypageRepository.findByUserEmail(currentPrincipalName)
                .orElseThrow(() -> new UserNotFoundException("User not found with email: " + currentPrincipalName));
    }
}