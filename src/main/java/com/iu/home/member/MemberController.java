package com.iu.home.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	public String getJoin(@ModelAttribute MemberVO memberVO) throws Exception{
		return "member/join";
	}
	
	@PostMapping("join")
	public String setJoin(@Valid MemberVO memberVO,BindingResult bindingResult,ModelAndView mv) throws Exception{
		//int result = memberService.setJoin(memberVO);
		//if(result == 1) {
			//return "member/login";
		//}
		boolean check = memberService.getMemberError(memberVO, bindingResult);
		if(check) {
			List<FieldError> errors = bindingResult.getFieldErrors();
			for(FieldError fieldError:errors) {
				log.info("FieldError => {} ", fieldError);
				log.info("Field => {} ", fieldError.getField());
				log.info("Message => {}",fieldError.getRejectedValue());
				log.info("Default => {}",fieldError.getDefaultMessage());
				log.info("Code => {}",fieldError.getCode());
				mv.addObject(fieldError.getField(), fieldError.getDefaultMessage());
				log.info("===========================================");
			}
			return "member/login";
		}
		return "redirect:../";
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
