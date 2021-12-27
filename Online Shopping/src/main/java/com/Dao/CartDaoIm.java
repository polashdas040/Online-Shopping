package com.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Cart;
import com.entity.Product;

import java.sql.Connection;

public class CartDaoIm implements CartDao {

	private Connection con;

	public CartDaoIm(Connection con) {
		super();
		this.con = con;
	}

	@Override
	public boolean addCart(Cart c) {
		boolean f = false;
		try {

			String sql = "insert into cart(pid, uid, pname, category, price, totalPrice) VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, c.getPid());
			ps.setInt(2, c.getUid());
			ps.setString(3, c.getPname());
			ps.setString(4, c.getCategory());
			ps.setDouble(5, c.getPrice());
			ps.setDouble(6, c.getTotalPrice());

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
	public List<Cart> getProductByUser(int userId) {

		List<Cart> list = new ArrayList<Cart>();
		Cart c = null;
		Double totalPrice = 0.0;
		try {
			String sql = "select * from cart where uid=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				c = new Cart();
				c.setCid(rs.getInt(1));
				c.setPid(rs.getInt(2));
				c.setUid(rs.getInt(3));
				c.setPname(rs.getString(4));
				c.setCategory(rs.getString(5));
				c.setPrice(rs.getDouble(6));

				totalPrice = totalPrice + rs.getDouble(7);
				c.setTotalPrice(totalPrice);
				list.add(c);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean removeProduct(int pid,int uid) {
		boolean f = false;
		try {
			String sql = "delete from cart where pid = ? and uid = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, pid);
			ps.setInt(2, uid);

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

}
