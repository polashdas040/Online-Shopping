<%@page import="com.entity.Product"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.Dao.ProductDaoIm"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Product</title>
<%@include file="allCss.jsp"%>
</head>
<body style="background-color: #f7f7f7;">
	<%@include file="navbar.jsp"%>

	<c:if test="${empty userobj}">
		<c:redirect url="../Login.jsp" />
	</c:if>

	<div align="center">
		<h4>Add Product</h4>
		<br>
		<hr>

		<%
		int id = Integer.parseInt(request.getParameter("id"));
		ProductDaoIm dao = new ProductDaoIm(DBConnect.getCon());
		Product p = dao.getProductById(id);
		%>

		<form action="../EditProductServlet" method="post">
			<table>
				<tr>
					<td><input type="hidden" name="id" value="<%=p.getId()%>"></td>
				</tr>
				<tr>
					<td>Product Name</td>
					<td><input type="text" name="proname" required="required"
						value="<%=p.getProname()%>"></td>
				</tr>
				<tr>
					<td>Category</td>
					<td><input type="text" name="category" required="required"
						value="<%=p.getCategory()%>"></td>
				</tr>
				<tr>
					<td>Price</td>
					<td><input type="number" name="price" required="required"
						value="<%=p.getPrice()%>"></td>
				</tr>

				<tr>
					<td>Product Status</td>
					<td><select id="inputState" name="status">
							<%
							if ("Active".equals(p.getStatus())) {
							%>
							<option value="Active">Active</option>
							<option value="Inactive">Inactive</option>
							<%
							} else {
							%>
							<option value="Inactive">Inactive</option>
							<option value="Active">Active</option>
							<%
							}
							%>

					</select></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" value="Add"></td>
				</tr>
			</table>

		</form>
	</div>
	<div style="margin-top: 330px;"><%@include file="Footer.jsp"%></div>
</body>
</html>