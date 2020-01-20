package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.service.ShopService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class ContactController{
	
	@Autowired
	ShopService shopservice;

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@GetMapping(value= {"/contact"})
	public String getAPIForm() {	
		return "contact-form";
	}
}
