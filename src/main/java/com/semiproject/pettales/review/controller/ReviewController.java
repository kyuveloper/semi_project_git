package com.semiproject.pettales.review.controller;

import com.semiproject.pettales.review.dto.ReviewDTO;
import com.semiproject.pettales.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviewPage")
    public void reviewPage(){

    }

    @PostMapping("/reviewPage")
    public ModelAndView reviewPage(@ModelAttribute ReviewDTO reviewDTO, ModelAndView mv){
        System.out.println("컨트롤러"+reviewDTO);
        int result = reviewService.regist(reviewDTO);

        String message;
        if(result>0){
            message = "리뷰작성 완료";
            mv.setViewName("review/reviewPage");
        }else {
            message = "리뷰작성 실패";
            mv.setViewName("review/failReview");
        }
        System.out.println(result);
        mv.addObject("message",message);

        return mv;
    }
}
