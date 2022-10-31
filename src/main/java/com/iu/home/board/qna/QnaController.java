package com.iu.home.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.home.member.MemberVO;
import com.iu.home.util.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private QnaService qnaService;
	
	@PostMapping("add")
	public String setAdd(QnaVO qnaVO, RedirectAttributes redirectAttributes)throws Exception{
		
		int result = qnaService.setAdd(qnaVO);
		redirectAttributes.addAttribute("result", result);
		
		return "redirect:./list";
	}
	
	@GetMapping("add")
	public String setAdd(MemberVO memberVO)throws Exception{
		return "board/write";
	}
	
	@GetMapping("list")
	public ModelAndView getList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		List<QnaVO> ar = qnaService.getList(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/list");
		return mv;
	}
	
	@GetMapping("detail")
	public ModelAndView getDetail(QnaVO qnaVO) throws Exception{
		qnaVO = qnaService.getDetail(qnaVO);
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", qnaVO);
		mv.setViewName("board/detail");
		return mv;
	}
	
	@GetMapping("update")
	public ModelAndView getUpdate(QnaVO qnaVO) throws Exception{
		qnaVO = qnaService.getUpdate(qnaVO);
		ModelAndView mv = new  ModelAndView();
		mv.addObject("vo", qnaVO);
		mv.setViewName("board/update");
		return mv;
	}
	
	@PostMapping("fileDelete")
	@ResponseBody
	public void fileDelete(QnaFileVO qnaFileVO) throws Exception{
		log.info("FileNum : {}",qnaFileVO.getFileNum());
		qnaService.fileDelete(qnaFileVO);
	}

	
}
