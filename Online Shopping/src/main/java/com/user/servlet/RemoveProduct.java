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

@WebServlet("/RemoveProduct")
public class RemoveProduct extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		try {
			
			int pid = Integer.parseInt(req.getParameter("pid"));
			int uid = Integer.parseInt(req.getParameter("uid"));
			
			CartDaoIm dao = new CartDaoIm(DBConnect.getCon());
			boolean f =  dao.removeProduct(pid,uid);
			
			HttpSession session = req.getSession();
			
			if(f) {
				session.setAttribute("success", "Product Removed");
				resp.sendRedirect("Cart.jsp");
			}else {
				session.setAttribute("fail", "Something wrong on Server");
				resp.sendRedirect("Cart.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
