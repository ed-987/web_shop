package com.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.model.Product;
import com.repository.ShopRepositoty;

@Repository
public class ShopRepositoryImpl implements ShopRepositoty {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final RowMapper<Product> mapper = new RowMapper<Product>() {
		
		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException{
			Product n = new Product();
			n.setId(rs.getInt("id"));
			n.setName(rs.getString("name"));
			n.setBrand(rs.getString("brand"));
			n.setDescription(rs.getString("description"));
			n.setPrice(rs.getInt("price"));
			return n;
		}
	};

	@Override
	public List<Product> getProducts() {
		final String sql = "SELECT id,name,brand,description,price FROM products";
		return jdbcTemplate.query(sql,mapper);
	}

	@Override
	public List<Product> searchProductsInDB(String search) {
		final String sql = "SELECT id,name,brand,description,price FROM products WHERE LOWER (name) LIKE ? "
				+ "OR LOWER (brand) LIKE ?";
		search=("%"+search+"%").toLowerCase();
		return jdbcTemplate.query(sql,mapper,search,search);
	}

	@Override
	public Product getProductDetails(int id) {
		final String sql = "SELECT id,name,brand,description,price FROM products WHERE id=?";
		return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
        new Product(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("brand"),
                rs.getString("description"),
                rs.getInt("price")                
        ));
	}

	@Override
	public List<Product> getProductsByPrice(String search) {
		final String sql = "SELECT id,name,brand,description,price FROM products WHERE LOWER (name) LIKE ? "
				+ "OR LOWER (brand) LIKE ? ORDER BY price";
		search=("%"+search+"%").toLowerCase();
		return jdbcTemplate.query(sql,mapper,search,search);
	}

	@Override
	public List<Product> getProductsByBrand(String search) {
		final String sql = "SELECT id,name,brand,description,price FROM products WHERE LOWER (name) LIKE ? "
				+ "OR LOWER (brand) LIKE ? ORDER BY brand";
		search=("%"+search+"%").toLowerCase();
		return jdbcTemplate.query(sql,mapper,search,search);
	}

}
