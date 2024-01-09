package com.semiproject.pettales.inquiry.dao;

import com.semiproject.pettales.inquiry.dto.InquiryDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InquiryDAO {
    int insertInquiry(InquiryDTO inquiryDTO);

//    int updateInqAns(InquiryDTO inquiryDTO);
}
