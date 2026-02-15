<%@include file="adminheader.jsp"%>
   <h2>Manage Product</h2>
   <p align="right"> <a href="add"> <button class="btn btn-primary">Add new Product</button></a></p>
   <div class="table-responsive">
     <table class="table table-striped table-sm">
       <thead>
         <tr>
          <th>Item Id</th><th>Image</th><th>Item Name</th><th>Category Name</th><th>Item Price</th><th></th>
         </tr>
       </thead>
       <tbody>
         <c:forEach var="item" items="${items}">
<tr>

<td>${item.itemId}
<td><img class="img-rounded"  height="50" width="50" src="image/${item.itemId}"  width="50px" height="50px"/></td>
<td>${item.itemName}</td>
<td>${item.category.categoryName}</td>
<td>${item.itemPrice}
<td>
  <a href="edit/${item.itemId}">
  <img src="../../resources/svg/pencil-fill.svg" alt="edit"/></a>&nbsp;||&nbsp;
  <a href="delete/${item.itemId}" onclick="return confirm('Are you sure you want to delete this record?')">
  <img src="../../resources/svg/trash-fill.svg" alt="delete"/></a>
</tr>
</c:forEach>
          </tbody>
        </table>
      </div>
<%@include file="footer.jsp"%>  