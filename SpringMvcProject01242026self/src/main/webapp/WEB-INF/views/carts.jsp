<%@include file="homeheader.jsp" %>
<div class="container-fluid top-header" style="background-color:#b80818">
  <div class="banner-section"></div>
</div>
<div class="container-fluid main-section">
	<div class="container">
		<div class="row">
			<div class="col-12">
				<div class="heading-section">
					<h3>Carts</h3>
					<h2>Items</h2>
					<div class="heading-borders">
						<span class="selected"></span>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
		<div class="table-responsive">
		    <table class="table table-striped table-sm">
		      <thead>
		        <tr>
		          <th scope="col">#</th>
		          <th scope="col">Item Name</th>
		          <th scope="col">Price</th>
		          <th scope="col">Qty</th>
		          <th scope="col">value</th>
		          <th scope="col">Action</th>
		        </tr>
		      </thead>
		      <c:forEach var="item" items="${carts}">
		      <form action="${contextPath}/item/cart/update" method="POST">
		        <tr>
		          <td><img src="${contextPath}/image/${item.getItemId()}" width="50px" height="50px"/></td>
		          <td>${item.getItemName()}</td>
		          <td>$ ${item.getPrice()}</td>
		          <td><input type="number" name="qty[]" id="qty" value="${item.getQty()}"/></td>
		          <td>$ ${item.getAmount()}</td>
		          <td>
		          <input type="hidden" value="${item.getItemId()}" name="itemId" id="itemId"/>
		          <button type="submit" class="primary"><i class="fa fa-pencil"></i></button>
		          &nbsp; <a href="item/cart/delete/${item.getItemId()}"><i class="fa fa-remove"></i></a>
		          </td>
		        </tr>
		      </form>
		      </c:forEach>
		      <tr>
			      <td colspan="4"><h3>Total Amount</h3></td>
			      <td align="left"><h3>$ ${totalAmount}</h3></td>
			      <td>&nbsp;</td>
		      </tr>
		      <tr>
		        <td colspan="6" align="right">
		          <a href="${pageContext.request.contextPath}/checkout">Checkout</a>
		        </td>
		      </tr>
		    </table>
		</div>
		</div>
	</div>
</div>
<%@include file="homefooter.jsp"%>
