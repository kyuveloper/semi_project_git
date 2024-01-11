package com.semiproject.pettales.plan.dao;

import com.semiproject.pettales.plan.dto.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewDAO {

    List<ReviewDTO> selectReviewByCompanyCode(int companyCode);
}
