<%@include file="adminheader.jsp"%>
	<h2>Category</h2>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<f:form action="${contextPath}/admin/category/editcategory" method="POST" modelAttribute="category">
		<div><f:hidden path="categoryId"/></div>
		<div class="mb-3">
			<label for="exampleInputEmail1" class="form-label">Category
				Name</label>
			<f:input path="categoryName" class="form-control" />
	
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Category
				Description</label>
			<f:input path="categoryDesc" class="form-control" />
		</div>
	
		<button type="submit" class="btn btn-primary">Submit</button>
	</f:form>
<%@include file="footer.jsp"%>