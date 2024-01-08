package com.semiproject.pettales.review.dao;

import com.semiproject.pettales.review.dto.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewDAO {
    int insertReview(ReviewDTO reviewDTO);

    List<ReviewDTO> viewReview();
}
