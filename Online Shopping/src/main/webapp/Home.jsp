<%@page import="com.entity.User"%>
<%@page import="com.entity.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.Dao.ProductDaoIm"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.DB.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Home</title>
<%@ include file="allComponent/allCss.jsp"%>
<head>
<body style="background-color: #f7f7f7;">

	<%
	User u = (User) session.getAttribute("userobj");
	%>
	<%@include file="allComponent/navbar.jsp"%>

	<div>
		<h2 class="text-center text-black">Online Shopping</h2>
	</div>
	<hr>

	<div class="container">
		<h3 class="text-center">Recent Products</h3>

		<c:if test="${not empty fail}">
			<p class="text-center text-black">${fail}</p>
			<c:remove var="fail" scope="session" />
		</c:if>

		<c:if test="${not empty success}">
			<p class="text-center text-black">${success}</p>
			<c:remove var="success" scope="session" />
		</c:if>

		<div class="row">
			<%
			ProductDaoIm dao = new ProductDaoIm(DBConnect.getCon());

			List<Product> list = dao.getnewProduct();

			for (Product p : list) {
			%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<p><%=p.getProname()%></p>
						<p>
							Category:
							<%=p.getCategory()%></p>
						<p>
							Status:
							<%=p.getStatus()%></p>
						<div class="row">
							<%
							if (u == null) {
							%>
							<a href="Login.jsp" class="btn btn-secondary btn-sm ml-4 p-1"><i
								class="fas fa-cart-plus"></i> Add Cart</a>
							<%
							} else {
							%>
							<a href="cart?pid=<%=p.getId()%>&&uid=<%=u.getId()%>"
								class="btn btn-light btn-sm ml-4 p-1"><i
								class="fas fa-cart-plus"></i>Add Cart</a>
							<%
							}
							%>

							<a class="btn btn-dark btn-sm ml-4 p-1 text-white">Price= $<%=p.getPrice()%></a>
						</div>
					</div>
				</div>
				<br>
			</div>
			<%
			}
			%>

		</div>
	</div>

	<div style="margin-top: 20px;"><%@include
			file="allComponent/Footer.jsp"%></div>
</body>
</html>


