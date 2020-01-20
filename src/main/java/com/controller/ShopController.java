package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.service.ShopService;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class ShopController{
	
	@Autowired
	ShopService shopservice;

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@GetMapping(value= {"/shop","/"})
	public String getShopForm(ServletRequest request, Model model, HttpSession session) {
		
		String funct=request.getParameter("funct");
		String p=request.getParameter("p");
		logger.debug("funct: {} p: {}", funct, p);
		if(funct!=null) {
		  switch(funct) {
			  case "prod":
				  session.setAttribute("search",p);
				  model.addAttribute("shopProducts",shopservice.searchProducts(p));
				  break;		
			  case "search":
				  model.addAttribute("Search", p);
				  session.setAttribute("search",p);
				  model.addAttribute("shopProducts",shopservice.searchProducts(p));
				  break;
			  case "sort":
				  String search = "";
				  if (session.getAttribute("search")!=null) {
					  search=(String) session.getAttribute("search");
				  };
				  switch(p) {
				    case "price":
				    	model.addAttribute("shopProducts",shopservice.sortByPrice(search));
				    	break;
				    case "brand":
				    	model.addAttribute("shopProducts",shopservice.sortByBrand(search));
				  }		          
		  }
		}
		else {
			model.addAttribute("shopProducts",shopservice.getAllProducts());
		}
		int qty=0;
		if (session.getAttribute("cartQty")!=null) {
			qty = (int) session.getAttribute("cartQty");
		}
		session.setAttribute("cartQty",qty);
		return "shop-form";
	}
}
