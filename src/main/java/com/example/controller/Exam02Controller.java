package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex02")
public class Exam02Controller {
	@Autowired
	private HttpSession session;
	
	@RequestMapping("")
	public String index() {
		return "exam02/exam02";
	}
	
	@RequestMapping("/input-value")
	public String inputValue(String num1, String num2) {
		int answer = Integer.parseInt(num1) + Integer.parseInt(num2);
		session.setAttribute("num1", num1);
		session.setAttribute("num2", num2);
		session.setAttribute("answer", answer);
		return "exam02/exam02-result";
	}
	
	@RequestMapping("/to-page2")
	public String toPage2() {
		return "exam02/exam02-result2";
	}
}
