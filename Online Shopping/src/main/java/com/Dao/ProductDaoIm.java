package com.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Product;
import java.sql.Connection;

public class ProductDaoIm implements ProductDao {

	private Connection con;

	public ProductDaoIm(Connection con) {
		super();
		this.con = con;
	}

	@Override
	public boolean addProducts(Product p) {
		boolean f = false;

		try {
			String sql = "insert into product (proname,category,price,status) values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getProname());
			ps.setString(2, p.getCategory());
			ps.setString(3, p.getPrice());
			ps.setString(4, p.getStatus());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> list = new ArrayList<Product>();
		Product product = null;
		try {

			String sel = "select * from product";
			PreparedStatement ps = con.prepareStatement(sel);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				product = new Product();
				product.setId(rs.getInt(1));
				product.setProname(rs.getString(2));
				product.setCategory(rs.getString(3));
				product.setPrice(rs.getString(4));
				product.setStatus(rs.getString(5));
				list.add(product);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	
	public List<Product> getnewProduct() {

		List<Product> list = new ArrayList<Product>();
		Product product = null;
		try {

			String sqlString = "select * from product where  status=?  order by id DESC";
			PreparedStatement ps = con.prepareStatement(sqlString);

			ps.setString(1, "Active");

			ResultSet rs = ps.executeQuery();

			int i = 1;
			while (rs.next() && i <= 12) {

				product = new Product();

				product.setId(rs.getInt(1));
				product.setProname(rs.getString(2));
				product.setCategory(rs.getString(3));
				product.setPrice(rs.getString(4));
				product.setStatus(rs.getString(5));
				list.add(product);
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Product getProductById(int id) {

		Product product = null;

		try {

			String sql = "select * from product where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			int i = 1;
			while (rs.next()) {

				product = new Product();

				product.setId(rs.getInt(1));
				product.setProname(rs.getString(2));
				product.setCategory(rs.getString(3));
				product.setPrice(rs.getString(4));
				product.setStatus(rs.getString(5));
			
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return product;
	}


	@Override
	public boolean updateEditProduct(Product p) {
		
		boolean f = false;
		try {
			String sql = "update product set proname =?, category = ?, price =?, status = ? where id = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getProname());
			ps.setString(2, p.getCategory());
			ps.setString(3, p.getPrice());
			ps.setString(4, p.getStatus());
			ps.setInt(5, p.getId());	
			
			int i = ps.executeUpdate();
			if(i == 1) {
				f= true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	@Override
	public boolean deleteProduct(int id) {
		boolean f = false;
		try {
			String sql = "delete from product where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				f = true;
			}
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		
		return f;
	}

}
