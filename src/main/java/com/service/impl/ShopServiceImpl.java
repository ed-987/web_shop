package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Product;
import com.repository.ShopRepositoty;
import com.service.ShopService;

@Service
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	ShopRepositoty shopRepository;

	@Override
	public List<Product> getAllProducts() {
		return shopRepository.getProducts();
	}

	@Override
	public List<Product> searchProducts(String search) {
		return shopRepository.searchProductsInDB(search);
	}

	@Override
	public Product getDetails(int id) {
		return shopRepository.getProductDetails(id);
	}

	@Override
	public List<Product> sortByPrice(String search) {
		return shopRepository.getProductsByPrice(search);
	}

	@Override
	public List<Product> sortByBrand(String search) {
		return shopRepository.getProductsByBrand(search);
	}

}
