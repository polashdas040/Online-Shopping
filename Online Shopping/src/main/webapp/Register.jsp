 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<%@include file="allComponent/allCss.jsp"%>
</head>
<body style="background-color:#f7f7f7;">
	<%@include file="allComponent/navbar.jsp"%>
	<div >
		<h2 class="text-center text-black">Online Shopping</h2>
	</div>
	<hr>
	<div align="center" >
		<h4>New User Register</h4>
		<br>
		<c:if test="${not empty success}">
		<p class="text-center text-black">${success}</p>
		<c:remove var="success" scope="session"/>
		</c:if>
		
		<c:if test="${not empty fail}">
		<p class="text-center text-black">${fail}</p>
		<c:remove var="fail" scope="session"/>
		</c:if>
		
		<form action="Register" method="post">
		<table>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" required="required"></td>
			</tr>
			<tr>
				<td>E-mail</td>
				<td><input type="email" name="email" required="required"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" required="required"></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>

		</form>

	</div>
	<div style="margin-top:330px;"><%@include file="allComponent/Footer.jsp"%></div>
</body>
</html>