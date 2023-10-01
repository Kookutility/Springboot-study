package com.example.logyexample.controller;

import com.example.logyexample.domain.Member;
import com.example.logyexample.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logy")
public class LogyController {

    private final MemberService memberService;

    @Autowired
    public LogyController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/signup")
    public String signup(@RequestBody Member member) {
        memberService.join(member);
        return "signupSuccess";  // 회원가입 성공 페이지로 리다이렉트. 해당 페이지를 작성해야 합니다.
    }
}