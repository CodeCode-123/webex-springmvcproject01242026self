<%@include file="adminheader.jsp"%>
	<h2>Manage Users</h2>
	<p align="right">
		<a href="registration">
			<button class="primary">Add new Users</button>
		</a>
	</p>
	<div class="table-responsive">
		<table class="table table-striped table-sm">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">image</th>
					<th scope="col">Name</th>
					<th scope="col">Gender</th>
					<th scope="col">Country</th>
					<th scope="col">Language</th>
					<th scope="col">Email Id</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="users" items="${lstusers}">
					<tr>
						<td>&nbsp;</td>
						<td><img src="image/${users.getId()}" width="50px" height="50px"/></td>
						<td>${users.getFirstName()} ${users.getLastName()}</td>
						<td>${users.getGender()}</td>
						<td>${users.getCountry()}</td>
						<td><c:forEach var="lang" items="${users.getLanguages()}">
                                     ${lang} &nbsp;
                                     </c:forEach></td>
						<td>${users.getEmailId()}</td>
						<td><a href="edit/${users.getId()}">Edit</a> | <a
							href="delete/${users.getId()}"
							onclick='return confirm("Are you sure you want to delete this Record???")'>Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
<%@include file="footer.jsp"%>