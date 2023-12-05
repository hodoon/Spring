package hello.hello.spring.controller;

import hello.hello.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired //의존 관계 주입
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
}
