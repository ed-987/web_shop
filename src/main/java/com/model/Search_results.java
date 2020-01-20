package com.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Search_results {
	
	private static List<Product> products =new ArrayList<>();
	
	public Search_results() {
	}
	
	public static List<Product> getProducts() {
		return products;
	}

	public static void setProducts(List<Product> products) {
		Search_results.products = products;
	}
	
	public static void sortByBrand() {
		Collections.sort(products,Product.ProductBrandComparator);
	}
	
	public static void sortByPrice() {
		Collections.sort(products,Product.ProductPriceComparator);
	}

}
