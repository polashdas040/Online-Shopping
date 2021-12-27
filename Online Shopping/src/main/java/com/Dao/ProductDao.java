package com.Dao;

import java.util.List;

import com.entity.Product;

public interface ProductDao {

	public boolean addProducts(Product p);
	
	public List <Product> getAllProduct();
	
	public List<Product> getnewProduct();
	
	public Product getProductById(int id);
	
	public boolean updateEditProduct(Product p);
	
	public boolean deleteProduct(int id);
	
}
