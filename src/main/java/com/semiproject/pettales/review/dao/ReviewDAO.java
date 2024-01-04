package com.semiproject.pettales.review.dao;

import com.semiproject.pettales.review.dto.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewDAO {
    int insertReview(ReviewDTO reviewDTO);
}
