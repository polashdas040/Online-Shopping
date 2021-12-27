package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.Dao.UserDaoIm;
import com.entity.User;

@WebServlet("/Login")
public class Login extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			UserDaoIm dao = new UserDaoIm(DBConnect.getCon());
			
			HttpSession session = req.getSession();
			
			String name = req.getParameter("username");
			String password = req.getParameter("password");
			
			if("admin".equals(name) && "admin".equals(password)) {
				User user = new User();
				user.setUsername("admin");
				session.setAttribute("userobj", user);
				resp.sendRedirect("admin/Admin.jsp");
			}else {
				
				
				User us = dao.login(name, password);
				if(us!=null) {
					session.setAttribute("userobj", us);
					resp.sendRedirect("Home.jsp");
				}else {
					session.setAttribute("fail", "Username and Password Invalid");
					resp.sendRedirect("Login.jsp");
				}
				
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
}
