<%@include file="adminheader.jsp"%>
      <h2>Product</h2>
      <f:form action="save" method="post" modelAttribute="item" enctype="multipart/form-data">
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Select Category </label>

<f:select path="category.categoryId" class="form-control" >    
       <option value="-1">Select Category</option>
       <c:forEach items="${categories}" var="category">
       <option value="${category.categoryId}"  ${item.category.categoryId == category.categoryId ? 'selected' : ''}>${category.categoryName}</option>
      	 
       </c:forEach>
      </f:select>
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Item Name</label>
    <f:input path="itemName" class="form-control" />
  </div>
   <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Item Price</label>
    <f:input path="itemPrice" class="form-control" />
  </div>
   <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Upload Image</label>
     <input type="file" name="photo" class="form-control" />
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</f:form>
<%@include file="footer.jsp"%>      
   
