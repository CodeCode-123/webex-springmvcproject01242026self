<%@include file="adminheader.jsp"%>
	<h2>Edit User Registration</h2>
	<f:form action="${contextPath}/admin/users/editsave" method="POST" modelAttribute="users" enctype="multipart/form-data">
	    <p><f:hidden path="id"/></p>
		<p>First Name:<f:input path="firstName" placeholder="Enter First Name" required="true"/></p>
		<p>Last Name:<f:input path="lastName" placeholder="Enter Last Name" required="true"/></p>
		<p>Country: <f:select path="country" required="true">
				<f:option value="">Select Country</f:option>
				<f:option value="IND">India</f:option>
				<f:option value="USA">United States</f:option>
				<f:option value="UK">United Kingdom</f:option>
			</f:select></p>
		<p>Gender: <f:radiobutton path="gender" value="Male" />Male
			<f:radiobutton path="gender" value="Female" />Female</p>
		<p>Languages: <f:checkbox path="languages" value="C"/>C
			<f:checkbox path="languages" value="C#"/>C#
			<f:checkbox path="languages" value="Java"/>Java</p>
		<p>Upload Photo: <input type="file" id="imagefile" name="imagefile"/></p>
		<p><button type="submit">Submit</button></p>
	</f:form>
<%@include file="footer.jsp"%> 