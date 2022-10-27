package com.iu.home.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	@GetMapping("login")
	public String getLogin() throws Exception{
		return "member/login";
	}
	
	@PostMapping("login")
	public String getLogin(HttpServletRequest request,MemberVO memberVO) throws Exception{
		log.info("pw:{}",memberVO.getPw());
		HttpSession session = request.getSession();
		memberVO = memberService.getLogin(memberVO);
		if(memberVO != null) {
			log.info("로그인 성공");
			session.setAttribute("member", memberVO);
			return "redirect:/";
		}
		else {
			log.info("로그인 실패");
			return "";
		}
	}
	
	@GetMapping("logOut")
	public String getLogOut(HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("join")
	public String getJoin() throws Exception{
		return "member/join";
	}
	
	@PostMapping("join")
	public String setJoin(MemberVO memberVO) throws Exception{
		int result = memberService.setJoin(memberVO);
		if(result == 1) {
			return "member/login";
		}
		return "member/login";
	}
	
	@PostMapping("idCheck")
	@ResponseBody
	public int getIdCheck(MemberVO memberVO) throws Exception{
		memberVO = memberService.getIdCheck(memberVO);
		if(memberVO == null) {
			return 0;
		}
		else {
			return 1;
		}
	}

}
