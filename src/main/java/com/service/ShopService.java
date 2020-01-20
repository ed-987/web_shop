package com.service;

import java.util.List;

import com.model.Product;

public interface ShopService {
	
	List<Product> getAllProducts();

	List<Product> searchProducts(String search);
	
	Product getDetails(int id);

	List<Product> sortByPrice(String search);

	List<Product> sortByBrand(String search);

}
