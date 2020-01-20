package com.repository;

import java.util.List;

import com.model.Product;

public interface ShopRepositoty {

	List<Product> getProducts();

	List<Product> searchProductsInDB(String search);

	Product getProductDetails(int id);

	List<Product> getProductsByPrice(String search);

	List<Product> getProductsByBrand(String search);
}
