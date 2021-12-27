<%@page import="java.util.List"%>
<%@page import="com.entity.Cart"%>
<%@page import="com.entity.User"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.Dao.CartDaoIm"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
<%@include file="allComponent/allCss.jsp"%>
</head>
<body style="background-color: #f7f7f7;">

	<%@include file="allComponent/navbar.jsp"%>

	<c:if test="${empty userobj }">
		<c:redirect url="Login.jsp"></c:redirect>
	</c:if>

	<div class="text-center text-black">
		<h2>Shopping Cart</h2>
	</div>
	<hr>
	<c:if test="${ not empty success}">
		<div class="alert alert-black text-center" role="alert">${success}</div>
		<c:remove var="success" scope="session" />
	</c:if>

	<c:if test="${ not empty fail}">
		<div class="alert alert-black text-center" role="alert">${fail}</div>
		<c:remove var="fail" scope="session" />
	</c:if>
	<div class="container">
		<div class="row p-2">
			<div class="col-md-6">
				<div class="cart">
					<div class="table">
						<h3 class="text-center text-black">Your Selected Products</h3>

						<div align="center"></div>
						<table border="2" cellspacing="0" align="center"
							style="background-color: white;">
							<tr>
								<th scope="col">Product Name</th>
								<th scope="col">Category</th>
								<th scope="col">Price</th>
								<th scope="col">Action</th>
							</tr>
							<%
							User user = (User) session.getAttribute("userobj");
							CartDaoIm dao = new CartDaoIm(DBConnect.getCon());
							List<Cart> cart = dao.getProductByUser(user.getId());
							Double totalPrice = 0.00;
							for (Cart c : cart) {
								totalPrice = c.getTotalPrice();
							%>
							<tr>
								<td><%=c.getPname()%></td>
								<td><%=c.getCategory()%></td>
								<td><%=c.getPrice()%></td>
								<td><a
									href="RemoveProduct?pid=<%=c.getPid()%>&&uid=<%=c.getUid()%>"
									class="btn btn-sm btn-secondary"><i
										class="far fa-trash-alt"></i> Remove</a></td>

							</tr>

							<%
							}
							%>
							<tr>
								<th>Total Price ($)</th>
								<td></td>
								<th><%=totalPrice%></th>
								<td></td>
							</tr>
						</table>
					</div>
				</div>
			</div>

			<div class="col-md-6" align="center">
				<div class="cart">
					<div class="cart-body">
						<h3 class="text-center text-black">Your Details for Order</h3>
						<form action="order" method="post">
							<input type="hidden" value="${userobj.id}" name="id">
							<table>

								<tr>
									<td>Name:</td>
									<td><input type="text" name="username" required="required"
										value="<%=user.getUsername()%>" readonly="readonly"></td>
								</tr>
								<tr>
									<td>Email:</td>
									<td><input type="text" name="email" required="required"
										value="<%=user.getEmail()%>" readonly="readonly"></td>
								</tr>
								<tr>
									<td>Phone Number:</td>
									<td><input type="number" name="phoneNumber"
										required="required"></td>
								</tr>
								<tr>
									<td>Address:</td>
									<td><input type="text" name="address" required="required"
										value=""></td>
								</tr>

								<tr>
									<td>Payment Mode:</td>
									<td><select class="form-control" name="paymentMode">
											<option value="noselect">Payment Select</option>
											<option value="COD">Cash On Delivery</option>
											<option value="PP">PayPal</option>
									</select></td>
								</tr>
							</table>
							<div>
								<button class="btn btn-dark mr-4">Order Now</button>
								<a href="Home.jsp" class="btn btn-secondary ml-4">Continue
									Shopping</a>
							</div>

						</form>
					</div>
				</div>

			</div>

		</div>
	</div>

</body>
<br>
<br>
<br>
	<div style="margin-top:45px;"><%@include file="allComponent/Footer.jsp"%></div>
</html>