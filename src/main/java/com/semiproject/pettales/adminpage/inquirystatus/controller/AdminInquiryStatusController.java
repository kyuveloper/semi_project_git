/*
컨트롤러(Controller) 클래스
사용자의 HTTP 요청을 받아 적절한 서비스 메소드를 호출하고,
그 결과를 사용자에게 반환합니다.
 */

package com.semiproject.pettales.adminpage.inquirystatus.controller;

import com.semiproject.pettales.adminpage.inquirystatus.service.AdminInquiryStatusService;
import com.semiproject.pettales.adminpage.model.dto.InquiryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admins")
public class AdminInquiryStatusController {

    private AdminInquiryStatusService adminInquiryStatusService;

    @Autowired
    public AdminInquiryStatusController(AdminInquiryStatusService adminInquiryStatusService) {
        this.adminInquiryStatusService = adminInquiryStatusService;
    }

    // 전체 문의사항 목록을 표시하는 메소드
    @GetMapping("/inquirystatus")
    public ModelAndView listInquiries(@RequestParam(value = "page", defaultValue = "1") int page) {
        ModelAndView mv = new ModelAndView();
        List<InquiryDTO> inquiries = adminInquiryStatusService.getInquiriesPerPage(page, 15);
        int totalInquiryCount = adminInquiryStatusService.getInquiryCount();

        mv.addObject("inquiries", inquiries);
        mv.addObject("totalInquiryCount", totalInquiryCount);
        mv.addObject("currentPage", page);
        mv.addObject("inquiriesCountOnPage", inquiries.size());
        mv.addObject("isEmpty", inquiries.isEmpty());
        mv.setViewName("/admins/inquirystatus");
        return mv;
    }


    // 사용자별 문의사항 목록을 표시하는 메소드
    @GetMapping("/inquirystatus/user/{userCode}")
    public ModelAndView listInquiriesByUser(@PathVariable("userCode") int userCode) {
        ModelAndView mv = new ModelAndView();
        List<InquiryDTO> inquiries = adminInquiryStatusService.getInquiriesByUser(userCode);

        for (InquiryDTO inquiry : inquiries) {
            if (inquiry.getAnswerCode() == null) {
                inquiry.setAnswerCode(0);
            }
        }

        mv.addObject("inquiries", inquiries);
        mv.setViewName("/admins/inquirystatus");
        return mv;
    }

    // 답변된 문의사항 목록을 표시하는 메소드
    @GetMapping("/inquirystatus/answered")
    public ModelAndView listAnsweredInquiries() {
        ModelAndView mv = new ModelAndView();
        List<InquiryDTO> inquiries = adminInquiryStatusService.getAnsweredInquiries();

        for (InquiryDTO inquiry : inquiries) {
            if (inquiry.getAnswerCode() == null) {
                inquiry.setAnswerCode(0);
            }
        }

        mv.addObject("inquiries", inquiries);
        mv.setViewName("/admins/inquirystatus");
        return mv;
    }

    // 미답변 문의사항 목록을 표시하는 메소드
    @GetMapping("/inquirystatus/unanswered")
    public ModelAndView listUnansweredInquiries() {
        ModelAndView mv = new ModelAndView();
        List<InquiryDTO> inquiries = adminInquiryStatusService.getUnansweredInquiries();

        for (InquiryDTO inquiry : inquiries) {
            if (inquiry.getAnswerCode() == null) {
                inquiry.setAnswerCode(0);
            }
        }

        mv.addObject("inquiries", inquiries);
        mv.setViewName("/admins/inquirystatus");
        return mv;
    }


    // 문의사항 답변 등록 및 수정 페이지를 표시하는 메소드
    @GetMapping("/inquirystatus/answer/{inqCode}")
    public ModelAndView showAnswerInquiryPage(@PathVariable int inqCode) {
        ModelAndView mv = new ModelAndView();
        InquiryDTO inquiryDto = adminInquiryStatusService.getInquiryInfo(inqCode);
        mv.addObject("inquiry", inquiryDto);
        mv.setViewName("/admins/inquirystatus/answer");
        return mv;
    }

    // 문의사항 답변을 등록 및 수정하는 메소드
    @PostMapping("/inquirystatus/answer/{inqCode}")
    public ModelAndView answerInquiry(@PathVariable int inqCode, @ModelAttribute InquiryDTO inquiryDto, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        inquiryDto.setInqCode(inqCode);

        // answerCode가 null인 경우 디폴트 값을 설정
        if (inquiryDto.getAnswerCode() == null) {
            inquiryDto.setAnswerCode(0);  // 혹은 적절한 다른 값
        }

        adminInquiryStatusService.updateInquiryAnswer(inquiryDto);

        HttpSession session = request.getSession();
        session.setAttribute("message", "답변이 등록되었습니다.");

        mv.setViewName("redirect:/admins/inquirystatus/" + inqCode);
        return mv;
    }

    // 문의사항 삭제 메소드
    @PostMapping("/inquirystatus/delete/{inqCode}")
    public ModelAndView deleteInquiry(@PathVariable int inqCode, RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();
        adminInquiryStatusService.deleteInquiry(inqCode);
        redirectAttributes.addFlashAttribute("successMessage", "문의사항이 삭제되었습니다.");
        mv.setViewName("redirect:/admins/inquirystatus");
        return mv;
    }



}
