<%@include file="homeheader.jsp" %>
<link href="${contextPath}/resources/admincss/css/bootstrap.min.css"
	rel="stylesheet">

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
<div class="container-fluid top-header" style="background-color:#b80818">
  <div class="banner-section">
  </div>
</div>
	<h2>Customer User Registration</h2>
	<f:form action="save1" method="POST" modelAttribute="users"
		enctype="multipart/form-data">
		<div class="mb-3">
			<label for="exampleInputEmail" class="form-label">First
				Name: </label>
			<f:input path="firstName" placeholder="Enter First Name"
				required="true" />
		</div>
		<div class="mb-3">
			<label for="exampleInputEmail" class="form-label">Last
				Name: </label>
			<f:input path="lastName" placeholder="Enter Last Name"
				required="true" />
		</div>
		<div class="mb-3">
			<label for="exampleInputEmail" class="form-label">Country:
			</label>
			<f:select path="country" required="true">
				<f:option value="">Select Country</f:option>
				<f:option value="IND">India</f:option>
				<f:option value="USA">United States</f:option>
				<f:option value="UK">United Kingdom</f:option>
			</f:select>
		</div>
		<div class="mb-3">
			<label for="exampleInputEmail" class="form-label">Gender:
			</label>
			<f:radiobutton path="gender" value="Male" />
			Male
			<f:radiobutton path="gender" value="Female" />
			Female
		</div>
		<div class="mb-3">
			<label for="exampleInputEmail" class="form-label">Languages:
			</label>
			<f:checkbox path="languages" value="C" />
			C
			<f:checkbox path="languages" value="C#" />
			C#
			<f:checkbox path="languages" value="Java" />
			Java
		</div>
		<div class="mb-3">
			<label for="exampleInputEmail" class="form-label">Email: </label>
			<f:input type="email" path="emailId" required="true" />
		</div>
		<div class="mb-3">
			<label for="exampleInputEmail" class="form-label">Password:
			</label>
			<f:input type="password" path="password" required="true" />
		</div>
		<div class="mb-3">
			<label for="exampleInputEmail" class="form-label">Image: </label>
			<input type="file" id="imagefile" name="imagefile" />
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</f:form>
<%@include file="homefooter.jsp"%>
			