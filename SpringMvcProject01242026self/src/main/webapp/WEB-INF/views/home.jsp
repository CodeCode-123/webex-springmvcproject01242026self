<%@include file="homeheader.jsp" %>
<div class="container-fluid top-header" style="background-color:#b80818">
  <div class="banner-section">
    <div class="row">
      <div class="col-lg-1 col-12"></div>
      <div class="col-lg-5 col-md-7 col-12">
        <div class="banner-detail">
          <h5>Best Choice</h5>
          <h1>ITALIAN PIZZA</h1>
          <div class="col-md-12">
            <button class="btn button-1">Order Now</button>
            <button class="btn button-2">Full Menu</button>
          </div>
        </div>
      </div>
      <div class="col-lg-6 col-md-5 col-12">
        <div class="banner-img">
          <img src="resources/images/banner.png">
        </div>
      </div>
    </div>
  </div>
</div>
<!------- ADV Section ADV Section-------->
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
<div class="col-lg-3 col-md-6">
	<div class="famous-product">
		<h2>${item.getCategory().getCategoryName()}</h2>
		<h3>${item.getItemName()}</h3>
		<img src="image/${item.itemId}" />
		<div class="price">
			<h4>$ ${item.getItemPrice()}</h4>
			<p>&nbsp;</p>
			<span> <a href="item/cart/${item.getItemId()}"><i
					class="fa fa-plus"></i></a>
			</span>
		</div>
	</div>
</div>
</c:forEach>
</div>
<!------FOOTER Section FOOTER Section------>
<%@include file="homefooter.jsp"%>
