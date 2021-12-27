<%@page import="com.Dao.ProductDaoIm"%>
<%@page import="com.entity.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Products</title>
<%@include file="allCss.jsp"%>
</head>
<body style="background-color: #f7f7f7;">
	<%@include file="navbar.jsp"%>

	<c:if test="${empty userobj}">
		<c:redirect url="../Login.jsp" />
	</c:if>


	<div align="center">
		<h4>All Products</h4><hr>
		<br>
		<c:if test="${not empty success}">
			<p class="text-center text-black">${success}</p>
			<c:remove var="success" scope="session" />
		</c:if>

		<c:if test="${not empty fail}">
			<p class="text-center text-black">${fail}</p>
			<c:remove var="fail" scope="session" />
		</c:if>

		<div class="table">
			<table border="2" cellspacing="0" align="center"
				style="background-color: white;">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Product Name</th>
					<th scope="col">Category</th>
					<th scope="col">Price</th>
					<th scope="col">Status</th>
					<th scope="col">Manage</th>
				</tr>
				<%
				ProductDaoIm dao = new ProductDaoIm(DBConnect.getCon());
				List<Product> list = dao.getAllProduct();

				for (Product p : list) {
				%>

				<tr>
					<td><%=p.getId()%></td>
					<td><%=p.getProname()%></td>
					<td><%=p.getCategory()%></td>
					<td><%=p.getPrice()%></td>
					<td><%=p.getStatus()%></td>
					<td><a href="EditProduct.jsp?id=<%=p.getId()%>"
						class="btn-sm btn-secondary"><i class="fas fa-edit"></i>Edit</a> <a
						href="../delete?id=<%=p.getId()%>" class="btn-sm btn-secondary"><i
							class="fas fa-trash-alt"></i>Delete</a></td>
				</tr>

				<%
				}
				%>
			</table>

		</div>
	</div>
	<div style="margin-top:30px;"><%@include file="Footer.jsp"%></div>
</body>
</html>