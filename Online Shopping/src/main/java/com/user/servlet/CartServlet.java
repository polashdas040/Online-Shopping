package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.Dao.CartDaoIm;
import com.Dao.ProductDaoIm;
import com.entity.Cart;
import com.entity.Product;


@WebServlet("/cart")
public class CartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			
			int pid = Integer.parseInt(req.getParameter("pid"));
			int uid = Integer.parseInt(req.getParameter("uid"));
			
			ProductDaoIm dao = new ProductDaoIm(DBConnect.getCon());
			
			Product p = dao.getProductById(pid);
			
			Cart c = new Cart();
			c.setPid(pid);
			c.setUid(uid);
			c.setPname(p.getProname());
			c.setCategory(p.getCategory());
			c.setPrice(Double.parseDouble(p.getPrice()));
			c.setTotalPrice(Double.parseDouble(p.getPrice()));
			
			CartDaoIm dao2 = new CartDaoIm(DBConnect.getCon());
			boolean a = dao2.addCart(c);
			
			HttpSession session = req.getSession();
			
			if(a){
				
				session.setAttribute("success", "Product Added to Cart");
				resp.sendRedirect("Home.jsp");
			}else{
				session.setAttribute("fail", "Something wrong on server");
				resp.sendRedirect("Home.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}	
	
}
