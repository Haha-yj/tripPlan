package com.teamProject.tripPlan.controller;

import com.teamProject.tripPlan.dto.UsersDTO;
import com.teamProject.tripPlan.service.UsersService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @Autowired
    UsersService usersService;

    @GetMapping("/login")
    public String showLogin() {
        return "/member/login";
    }


//    @PostMapping("/login")
//    public String login(@Valid @ModelAttribute("dto") UsersDTO dto,
//                        BindingResult bindingResult, HttpSession session, Model model) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("loginError", "Invalid login details");
//            return "/member/login";
//        }
//        UsersDTO users = usersService.findByMemberId(dto);
//        // 아이디 확인
//        if (ObjectUtils.isEmpty(users)) {
//            model.addAttribute("loginError", "아이디가 올바른지 확인해주세요");
//            return "/member/login";
//        }
//        // 비밀번호 확인
//        if (users.getUserPassword() == null) {
//            model.addAttribute("loginError", "비밀번호가 일치하지 않습니다");
//            return "/member/login";
//        } else {
//            if (users.getUserId().equals("admin")) {
//                // 로그인 아이디가 관리자인지 체크
//                session.setAttribute("loginId", users.getUserId());
//                session.setMaxInactiveInterval(60 * 30);
//                return "redirect:/main";
//            } else {
//                // 로그인 성공
//                session.setAttribute("loginId", users.getUserId());
//                session.setMaxInactiveInterval(60 * 30);
//                return "redirect:/main";
//
//            }
//        }
//    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response,
                         HttpSession session) {
        session.invalidate();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!ObjectUtils.isEmpty(authentication)) {
            new SecurityContextLogoutHandler()
                    .logout(request, response, authentication);
        }
        return "redirect:/login";
    }
}