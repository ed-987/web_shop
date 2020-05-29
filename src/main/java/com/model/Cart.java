package com.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<Item> items =new ArrayList<>();
	
	public Cart() {
	}
	
	public Cart(List<Item> items) {
		super();
		this.items = items;
	}

	public List<Item> getItems() {
		return items;
	}
	
	public void setItems(List<Item> items) {
		this.items = items;
	}

	public void addItem(Item item) {
		items.add(item);
	}
	
	public int getCartQty() {
		int qty=0;
		List<Item> item_list = getItems();
		for(Item item:item_list) {
			qty+=item.getQuantity();
		}
		return qty;
	}
	
	public int getTotal() {
		int total=0;
		List<Item> item_list = getItems();
		for(Item item:item_list) {
			total+=item.getQuantity()*item.getProduct().getPrice();
		}
		return total;
	}
	
}
