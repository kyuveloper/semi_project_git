package com.semiproject.pettales.review.service;

import com.semiproject.pettales.review.dao.ReviewDAO;
import com.semiproject.pettales.review.dto.ReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ReviewService {
    @Autowired
    private ReviewDAO reviewDAO;
    public int regist(ReviewDTO reviewDTO) {
        System.out.println("서비스" + reviewDTO);
        int result = reviewDAO.insertReview(reviewDTO);

        return result;
    }

    public List<ReviewDTO> viewReview() {
        List<ReviewDTO> reviews = reviewDAO.viewReview();

        if(Objects.isNull(reviews)){
            System.out.println("리뷰가 없음");
        }
        return reviews;
    }
}
