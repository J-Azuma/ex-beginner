package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex03")
public class Exam03Controller {
	@Autowired
	private ServletContext application;
	
	@RequestMapping("")
	public String index() {
		return "exam03/exam03";
	}
	
	@RequestMapping("/input-values")
	public String inputValues(String item1, String item2, String item3) {
		Integer sumOfItemPrice = 0;
		List<String> itemList = new ArrayList<String>();
		itemList.add(item1);
		itemList.add(item2);
		itemList.add(item3);
		for (String item : itemList) {
			sumOfItemPrice += Integer.parseInt(item);
		}
		Integer priceIncludingTax = (int)(sumOfItemPrice * 1.1);
		application.setAttribute("sumOfItemPrice", sumOfItemPrice);
		application.setAttribute("priceIncludingTax", priceIncludingTax);
		return "exam03/exam03-result";
	}
	
	
}
