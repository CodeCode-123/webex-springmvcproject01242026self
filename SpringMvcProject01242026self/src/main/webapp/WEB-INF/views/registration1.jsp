<%@include file="adminheader.jsp"%>
	<h2>Admin User Registration</h2>
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
<%@include file="footer.jsp"%>	
			