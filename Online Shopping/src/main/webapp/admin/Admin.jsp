<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: Home</title>
<%@include file="allCss.jsp"%>
<style type="text/css">
a {
	text-decoration: none;
	color: black;
}

a:hover {
	text-decoration: none;
	color: black;
}
</style>


</head>
<body style="background-color: #f7f7f7;">
	<%@include file="navbar.jsp"%>
	
	<c:if test="${empty userobj}">
	<c:redirect url="../Login.jsp" />
	</c:if>
	
	
	<div class="container">

		<div class="row p-5">
			<div class="col-md-3">
				<a href="AddProduct.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fas fa-plus-square fa-3x"></i><br>
							<h4>Add Product</h4>
						</div>

					</div>
				</a>
			</div>
			<div class="col-md-3">
				<a href="AllProducts.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fas fa-folder fa-3x"></i><br>
							<h4>All Products</h4>
						</div>

					</div>
				</a>
			</div>

		</div>
	</div><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<%@include file="Footer.jsp"%>
</body>
</html>