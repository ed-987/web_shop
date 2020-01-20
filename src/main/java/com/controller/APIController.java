package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.ShopService;

import javax.servlet.ServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class APIController{
	
	@Autowired
	ShopService shopservice;

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@GetMapping(value= {"/api"})
	public String getAPIForm(Model model) {	
		return "api-form";
	}
	
	
	@PostMapping(value= {"/api"})
	@ResponseBody
	public String postAPIForm(ServletRequest request) {	
		String data=request.getParameter("data");
		logger.debug("data: {}",data);
		if(data!=null) {
			if(data.equals("hello")) {
				return "hi";
			}
		}
		return "";
	}
}
