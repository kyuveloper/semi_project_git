package com.semiproject.pettales.plan.service;

import com.semiproject.pettales.plan.dao.ReviewDAO;
import com.semiproject.pettales.plan.dto.ReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewDAO reviewDAO;

    public List<ReviewDTO> selectReviewByCompanyCode(int companyCode) {
        return reviewDAO.selectReviewByCompanyCode(companyCode);
    }
}
