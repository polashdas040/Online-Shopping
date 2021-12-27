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


@WebServlet("/Register")
public class Register extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String name = req.getParameter("username");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			
			HttpSession session = req.getSession();
			
			User us = new User();
			us.setUsername(name);
			us.setEmail(email);
			us.setPassword(password);
			
			UserDaoIm dao = new UserDaoIm(DBConnect.getCon());
			boolean f = dao.userRegister(us);
			
			if(f==true) {
				session.setAttribute("success", "Registration successful..");
				resp.sendRedirect("Login.jsp");
			}else {
				session.setAttribute("fail", "This email already exists...Please try another email");
				resp.sendRedirect("Register.jsp");
			}
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
