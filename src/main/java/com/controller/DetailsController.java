package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Cart;
import com.model.Item;
import com.model.Product;
import com.service.ShopService;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class DetailsController{
	
	@Autowired
	ShopService shopservice;

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@GetMapping(value= {"/details"})
	public String Details(@RequestParam int id, @RequestParam int qty, Model model, HttpSession session) {
		logger.debug("qty: {}",qty);
		Cart cart = new Cart();
		
		@SuppressWarnings("unchecked")
		List<Item> items = (List<Item>) session.getAttribute("items");
		
		if(items!=null) {cart.setItems(items);}
		Product product_new = shopservice.getDetails(id);
		model.addAttribute("product", product_new);
		List<Item> item_list = cart.getItems();
		if(qty>0) {
			Boolean new_item=true;
			for(Item item:item_list) {
				if(item.getProduct().getId()==product_new.getId()) {
					item.setQuantity(item.getQuantity()+qty);
					new_item=false;
					break;
				}
			}
			if(new_item) {
				cart.addItem(new Item(product_new,qty));
			}
		}
		session.setAttribute("cartQty",cart.getCartQty());
		session.setAttribute("total",cart.getTotal());
		session.setAttribute("items", cart.getItems());
		return "details-form";
	}
}
