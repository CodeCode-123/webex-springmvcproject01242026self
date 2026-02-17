<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home</title>
</head>

<body>
<h1>Hello World!</h1>
<p>This is the homepage!</p>
<a href="admin/login">Login</a>
<div class="container-fluid main-section">
	<div class="container">
		<div class="row">
			<c:forEach var="category" items="${categories}">
				<div class="col-lg-4 col-md-6">
					<div class="top-banner">
						<div class="row">
							<div class="col-md-7">
							    <h2>SAVE 30%</h2>
								<h3>${category.categoryName}</h3>
								<p>${category.categoryDesc}</p>
							</div>
							<div class="col-md-5">
								<div>
									<img src="resources/images/banner-1.png">
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>
<div class="container-fluid main-section">
	<div class="container">
		<div class="row">
			<div class="col-12">
				<div class="heading-section">
					<h3>Our Top Sell</h3>
					<h2>Checkout Our Top Sell Items</h2>
					<div class="heading-borders">
						<span class="selected"></span>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="row">
<c:forEach var="item" items="${items}">
	<div class="famous-product">
		<h2>${item.getCategory().getCategoryName()}</h2>
		<h3>${item.getItemName()}</h3>
		<img src="image/${item.itemId}" />
		<div class="price">
			<h4>${item.getItemPrice()}</h4>
			<p>&nbsp;</p>
			<span> <a href="item/cart/${item.getItemId()}"><i
					class="fa fa-plus"></i></a>
			</span>
		</div>
	</div>
</c:forEach>
</div>
</body>
</html>
