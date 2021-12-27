<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<nav class="navbar navbar-expand-lg navbar-light bg-custom">
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link btn btn-secondary" href="Home.jsp"> Home
					<span class="sr-only">(current)</span>
			</a></li>
		</ul>
		
		<c:if test="${not empty userobj}">
		
		<a href="Cart.jsp"><i class="fas fa-cart-plus btn-light"> Cart</i> </a>
		<a class="btn-dark ml-4 p-2 text-white"><i class="fas fa-user-plus"></i>  ${userobj.username}</a>
		<a href="Logout" class="btn-dark ml-2 p-2 "><i class="fas fa-sign-out-alt"></i> Logout</a>
		</c:if>
		
		<c:if test="${empty userobj}">
		
		<a href="Login.jsp" class="btn-dark ml-4 p-2 "><i class="fas fa-sign-in-alt"></i> Login</a>
			<a href="Register.jsp" class="btn-dark ml-2 p-2 "><i class="fas fa-user-plus"></i>  Register</a>
		</c:if>
		
	</div>
</nav>