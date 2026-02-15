<%@include file="adminheader.jsp"%>
  <h2>Manage Category</h2>
  <p align="right"> <a href="add"> <button class="primary">Add new Category</button></a></p>
  <div class="table-responsive">
    <table class="table table-striped table-sm">
      <thead>
        <tr>
         <th scope="col">#</th>
          <th scope="col">Name</th>
          <th scope="col">Description</th>
          <th scope="col">Action</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="category" items="${categories}">
        <tr>
         <td>${category.getCategoryId()}</td>
         <td>${category.getCategoryName()}</td>
         <td>${category.getCategoryDesc()} </td>
         <td>
           <a href="edit/${category.getCategoryId()}">
           <img src="../../resources/svg/pencil-fill.svg" alt="edit"/></a>&nbsp;|&nbsp;
           <a href="delete/${category.getCategoryId()}" 
             onclick="return confirm('are you sure you want to delete thgis record')">
           <img src="../../resources/svg/trash-fill.svg" alt="delete"/></a>
           <!-- 
           <td><a href="edit/${category.getCategoryId()}"><i class="bi bi-pencil-fill"></i></a> | <a href="delete/${category.getCategoryId()}" onclick="return confirm('are you sure you want to delete thgis record')"><i class="bi bi-trash-fill"></i></a>-->
         </td>
        </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
<%@include file="footer.jsp"%>   