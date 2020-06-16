package com.example.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.UserForm;
import com.example.domain.*;


@Controller
@RequestMapping("/ex04")
public class Exam04Controller {
	@ModelAttribute
	public UserForm setUpForm() {
		return new UserForm();
	}
	
	@RequestMapping("")
	public String index() {
		return "exam04/exam04";
	}
	
	@RequestMapping("/input-values")
	public String inputValues(@Validated UserForm userForm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return index();
		}
		
		User user = new User();
		BeanUtils.copyProperties(userForm, user);
		model.addAttribute("user", user);
		//まだ
		return "exam04/exam04-result.html";
	}
}
