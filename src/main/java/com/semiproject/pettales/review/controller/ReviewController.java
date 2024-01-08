package com.semiproject.pettales.review.controller;

import com.semiproject.pettales.review.dto.ReviewDTO;
import com.semiproject.pettales.review.service.ReviewService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;


    @GetMapping("/reviewPage")
    public ModelAndView viewReview(ModelAndView mv) {
        List<ReviewDTO> reviews = reviewService.viewReview();

        if (Objects.isNull(reviews)) {
            System.out.println("exception으로 대처한다");
        }
        mv.addObject("reviews", reviews);
        mv.setViewName("review/reviewPage");
        return mv;
    }

    @PostMapping("/reviewPage")
    public ModelAndView reviewPage(@ModelAttribute ReviewDTO reviewDTO, ModelAndView mv) {
        System.out.println("컨트롤러" + reviewDTO);
        int result = reviewService.regist(reviewDTO);

        String message;
        if (result > 0) {
            message = "리뷰작성 완료";
        } else {
            message = "리뷰작성 실패";
        }
        System.out.println(result);
        mv.addObject("message", message);
        mv.setViewName("redirect:/review/reviewPage");

        return mv;
    }

//    @PostMapping("/comDetail")
//    public ModelAndView reviewPage(@ModelAttribute ReviewDTO reviewDTO, ModelAndView mv, HttpSession session, RedirectAttributes redirectAttributes) {
//        System.out.println("컨트롤러" + reviewDTO);
//        int result = reviewService.regist(reviewDTO);
//
//        String message;
//        if (result > 0) {
//            message = "리뷰작성 완료";
//
//            // 리뷰 작성한 회사의 companyCode를 세션에 저장
//            session.setAttribute("currentCompanyCode", reviewDTO.getCompanyCode());
//
//            // 리다이렉션할 때 파라미터를 전달하지 않고, 세션에서 값을 가져와서 사용
//            mv.setViewName("redirect:/plan/comDetail");
//        } else {
//            message = "리뷰작성 실패";
//            mv.setViewName("review/failReview");
//        }
//        System.out.println(result);
//        mv.addObject("message", message);
//
//        return mv;
//    }
}
