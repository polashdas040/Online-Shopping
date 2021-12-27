<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
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
		<c:if test="${not empty success}">
			<p class="text-center text-black">${success}</p>
			<c:remove var="success" scope="session" />
		</c:if>

		<c:if test="${not empty fail}">
			<p class="text-center text-black">${fail}</p>
			<c:remove var="fail" scope="session" />
		</c:if>
		<form action="../AddProduct" method="post">
			<table>
				<tr>
					<td>Product Name</td>
					<td><input type="text" name="proname" required="required"></td>
				</tr>
				<tr>
					<td>Category</td>
					<td><input type="text" name="category" required="required"></td>
				</tr>
				<tr>
					<td>Price</td>
					<td><input type="number" name="price" required="required"></td>
				</tr>

				<tr>
				<td>Product Status</td>
					<td><select id="inputState" name="status">
					<option selected>Select Status</option>
					<option value="Active">Active</option>
					<option value="Inactive">Inactive</option>	
					</select></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" value="Add"></td>
				</tr>
			</table>

		</form>
	</div>
	<div style="margin-top:330px;"><%@include file="Footer.jsp"%></div>
</body>
</html>