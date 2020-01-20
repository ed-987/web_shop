package com.model;

import java.util.Comparator;

//public class Product implements Comparable<Product> {
public class Product{
	private int id;
	private String name;
	private String brand;
	private String description;
	private int price;

	public Product() {
	}

	public Product(int id, String name, String brand, String description, int price) {
		super();
		this.id=id;
		this.name = name;
		this.brand = brand;
		this.description = description;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//@Override
	//public int compareTo(Product compareprod) {
	//	int compareprice =((Product)compareprod).getPrice();
	//	return this.price-compareprice;
	//}
	
	public static Comparator<Product> ProductBrandComparator = new Comparator<Product>() {

		@Override
		public int compare(Product p1, Product p2) {
			String ProductBrand1 = p1.getBrand().toUpperCase();
			String ProductBrand2 = p2.getBrand().toUpperCase();
			return ProductBrand1.compareTo(ProductBrand2);
		}
	};
	
	public static Comparator<Product> ProductPriceComparator = new Comparator<Product>() {

		@Override
		public int compare(Product p1, Product p2) {
			int ProductPrice1 = p1.getPrice();
			int ProductPrice2 = p2.getPrice();
			return ProductPrice1-ProductPrice2;
		}
	};

}
