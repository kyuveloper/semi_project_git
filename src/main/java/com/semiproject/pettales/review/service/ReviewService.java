package com.semiproject.pettales.review.service;

import com.semiproject.pettales.review.dao.ReviewDAO;
import com.semiproject.pettales.review.dto.ReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewDAO reviewDAO;
    public int regist(ReviewDTO reviewDTO) {
        System.out.println("서비스" + reviewDTO);
        int result = reviewDAO.insertReview(reviewDTO);

        return result;
    }
}
