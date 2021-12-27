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

@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			int id = Integer.parseInt(req.getParameter("id"));
			
			ProductDaoIm dao = new ProductDaoIm(DBConnect.getCon());
			boolean f = dao.deleteProduct(id);
			
			HttpSession session = req.getSession();
			
			if(f) {
				session.setAttribute("success", "Product Delete Successfully");
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
