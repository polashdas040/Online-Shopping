package com.Dao;

import java.util.List;

import com.entity.Cart;

public interface CartDao {
	
	public boolean addCart(Cart c);

	public List <Cart> getProductByUser(int userId);
	
	public boolean removeProduct(int pid, int uid);
}
