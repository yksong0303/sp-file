package com.file.sp.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.file.sp.service.MemberService;
import com.file.sp.vo.MemberVO;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Slf4j //로그대신 쓸수있음. ex) log.info("test=>{}",test); 롬복때문에 가능함
public class MemberController {
	
	
	@Autowired //@resource어노테이션도 써도 됨, 단 조금 다름. 나중에 찾아보기
	private MemberService ms;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@PostMapping("/upload")
	public @ResponseBody Integer upload(@ModelAttribute MemberVO member) {
		log.info("member=>{}",member);
		return ms.insertMember(member);
	}
	
}
