package com.user.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.DB.DBConnect;
import com.Dao.CartDaoIm;
import com.Dao.OrderDaoIm;
import com.entity.Cart;
import com.entity.ProductOrder;

@WebServlet("/order")
public class Order extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			HttpSession session = req.getSession();

			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("username");
			String email = req.getParameter("email");
			String phone = req.getParameter("phoneNumber");
			String address = req.getParameter("address");
			String paymentMode = req.getParameter("paymentMode");
		
			CartDaoIm daoIm = new CartDaoIm(DBConnect.getCon());
			
			List<Cart> cart = daoIm.getProductByUser(id);
			OrderDaoIm daoIm1 = new OrderDaoIm(DBConnect.getCon());
			
			
			ProductOrder order = null;
			
			Random random = new Random();
		
			ArrayList <	ProductOrder> list = new ArrayList<	ProductOrder>();
			for (Cart c:cart) {
				
				order = new ProductOrder();
				
				order.setOrderId(random.nextInt(1000));
				order.setUsername(name);
				order.setProName(c.getPname());
				order.setEmail(email);
				order.setPhone(phone);
				order.setAddress(address);
				order.setPrice(c.getPrice()+"");
				order.setPaymentMode(paymentMode);
				list.add(order);
			}
			

			if ("noselect".equals(paymentMode)) {
				session.setAttribute("fail","Please Choose Payment Mode");
				resp.sendRedirect("Cart.jsp");
			} else {
				
                boolean f = daoIm1.saveProduct(list);
                
                if(f) {
                	session.setAttribute("success","Your order has been successful");
                	resp.sendRedirect("Cart.jsp");
                }else {
                	session.setAttribute("fail","Something wrong on server");
                	resp.sendRedirect("Cart.jsp");
                }
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
