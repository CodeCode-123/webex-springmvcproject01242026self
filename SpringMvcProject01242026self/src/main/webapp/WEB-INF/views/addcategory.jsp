<%@include file="adminheader.jsp"%>
	<h2>Category</h2>
	<f:form action="savecategory" method="post"
		modelAttribute="category">
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
