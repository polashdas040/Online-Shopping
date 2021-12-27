package com.admin_servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.Dao.ProductDaoIm;
import com.entity.Product;

@WebServlet("/AddProduct")
public class AddProducts extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String pname = req.getParameter("proname");
			String category = req.getParameter("category");
			String price = req.getParameter("price");
			String status = req.getParameter("status");		

			Product p = new Product(pname,category, price, status);
 
			ProductDaoIm dao = new ProductDaoIm(DBConnect.getCon());

			boolean f = dao.addProducts(p);
			
			HttpSession session = req.getSession();
			
			if(f) {
								
				session.setAttribute("success", "Product Add Successfully");
				resp.sendRedirect("admin/AddProduct.jsp");
			}else {
				session.setAttribute("fail", "Something wrong on Server");
				resp.sendRedirect("admin/AddProduct.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
