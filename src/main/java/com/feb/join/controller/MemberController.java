package com.feb.join.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.feb.join.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	/**
	 * 회원가입 페이지 이동
	 * @return ModelAndView login.jsp
	 */
	@GetMapping("/join-page.do")
	public ModelAndView joinPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	/**
	 * ID 중복 검사
	 * @param memberId 사용자가 입력한 가입하려는 ID
	 * @return ResponseEntity<String> 가입 가능한 ID면 "0"
	 */
	@PostMapping(value = "/confirmId.do", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> confirmId(String memberId) {
		int cnt = memberService.confirmId(memberId);
		
		return new ResponseEntity<>(cnt+"", HttpStatus.OK);
	}
}
