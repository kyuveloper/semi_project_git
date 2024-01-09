package com.semiproject.pettales.inquiry.service;

import com.semiproject.pettales.inquiry.dao.InquiryDAO;
import com.semiproject.pettales.inquiry.dto.InquiryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InquiryService {
    @Autowired
    private InquiryDAO inquiryDAO;

    public int insertInquiry(InquiryDTO inquiryDTO) {
        int result = inquiryDAO.insertInquiry(inquiryDTO);
        if (result <= 0) {
            System.out.println("Insert Error");
        } else {
            System.out.println("Insert Success");
        }
        return result;
    }

//    public int updateInqAns(InquiryDTO inquiryDTO) {
//         int result = inquiryDAO.updateInqAns(inquiryDTO);
//        if (result <= 0) {
//            System.out.println("Update Error");
//        } else {
//            System.out.println("Update Success");
//        }
//        return result;
//    }
}
