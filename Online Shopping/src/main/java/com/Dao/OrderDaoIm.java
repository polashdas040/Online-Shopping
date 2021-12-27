package com.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import com.entity.ProductOrder;
import java.sql.Connection;

public class OrderDaoIm implements OrderDao {

	private Connection con;

	public OrderDaoIm(Connection con) {
		super();
		this.con = con;
	}

	@Override
	public boolean saveProduct(List <ProductOrder> plist) {
		boolean f = false;
		try {
			String sql = "INSERT INTO order_details(order_id, user_name, product_name, email, phone, address, price, payment_mode) VALUES (?,?,?,?,?,?,?,?)";
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(sql);
			
			for(ProductOrder p:plist) {
				ps.setInt(1, p.getOrderId());
				ps.setString(2, p.getUsername());
				ps.setString(3, p.getProName());
				ps.setString(4, p.getEmail());
				ps.setString(5, p.getPhone());
				ps.setString(6, p.getAddress());
				ps.setString(7, p.getPrice());
				ps.setString(8, p.getPaymentMode());
				ps.addBatch();
			}
			int[] count= ps.executeBatch();
			con.commit();
			f= true;
			con.setAutoCommit(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
}
