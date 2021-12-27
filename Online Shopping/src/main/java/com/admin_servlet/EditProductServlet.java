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

@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			
			int id = Integer.parseInt(req.getParameter("id"));
			String pname = req.getParameter("proname");
			String category = req.getParameter("category");
			String price = req.getParameter("price");
			String status = req.getParameter("status");	
			
			Product p = new Product();
			p.setId(id);
			p.setProname(pname);
			p.setCategory(category);
			p.setPrice(price);
			p.setStatus(status);
			
			
			ProductDaoIm dao = new ProductDaoIm(DBConnect.getCon());
			boolean f = dao.updateEditProduct(p);
			
			HttpSession session = req.getSession();
			
			if(f) {
				session.setAttribute("success", "Product Update Successfully");
				resp.sendRedirect("admin/AllProducts.jsp");
			}else {
				session.setAttribute("fail", "Something wrong on Server");
				resp.sendRedirect("admin/AllProducts.jsp");
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
