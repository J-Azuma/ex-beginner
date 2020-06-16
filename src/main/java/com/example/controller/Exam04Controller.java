package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.UserForm;

@Controller
@RequestMapping("/ex04")
public class Exam04Controller {
	@ModelAttribute
	public UserForm setUpForm() {
		return new UserForm();
	}
	
	@RequestMapping("")
	public String index(Model model) {
		return "exam04/exam04";
	}
	
	//とりあえずジェネリクスだけ生成
	@RequestMapping("/input-values")
	public String inputValues(@Validated UserForm userForm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return index(model);
		}
		model.addAttribute("name", userForm.getName());
		model.addAttribute("age", userForm.getAge());
		model.addAttribute("comment", userForm.getComment());
		//まだ
		return "exam04/exam04-result.html";
	}
}
