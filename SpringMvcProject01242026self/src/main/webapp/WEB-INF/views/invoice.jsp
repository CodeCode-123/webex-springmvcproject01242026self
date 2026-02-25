<%@include file="homeheader.jsp"%>
<div class="container-fluid  main-section">
	<div class="container">
		<div class="row">
			<div class="col-12">
				<div class="heading-section">
					<h2>Invoice</h2>
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
						<th scope="col">Invoice Number</th>
						<td>${orders.orderId}</td>
						<th scope="col">Invoice Date</th>
						<td>${orders.orderDate}</td>
						<th scope="col">Invoice Amount</th>
						<td>${orders.totalAmount}</td>
					</tr>
				</thead>
			</table>
			<table class="table table-striped table-sm">
				<thead>
					<tr>
						<th scope="col">Item Name</th>
						<th scope="col">Price</th>
						<th scope="col">Qty</th>
						<th scope="col">value</th>
					</tr>
				</thead>
				<c:forEach var="item" items="${itemOrderDetailsList}">
					<tr>
						<td>${item.getProductName()}</td>
						<td>$ ${item.getPrice()}</td>
						<td>${item.getQty()}</td>
						<td>$ ${item.getItemValue()}</td>
						<td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="4"><h3>Total Amount</h3></td>
					<td align="right"><h3>$ ${orders.totalAmount}</h3></td>
					<td>&nbsp;</td>
				</tr>
			</table>
		</div>
      </div>
    </div>
</div>
<%@include file="homefooter.jsp"%>
