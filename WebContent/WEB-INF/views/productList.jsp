<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>



<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>All Books</h1>

            <p class="lead">Checkout all the books available now!</p>
        </div>

        <table style="width:96%" border="1" cellspacing="10" cellpadding="10">
            <thead>
                <tr>
                    <th>Photo Thumb</th>
                    <th>Product Name</th>
                    <th>Category</th>
                    <th>Condition</th>
                    <th>Price</th>
                    <th>view</th>
                </tr>
            </thead>
             
            <c:forEach items="${products}" var="product">
            <tbody>
               <tr>
                    <td width="16%"><img src="<spring:url value="/resources/images/${product.productId}.jpg"/>" alt="image" /></td>
                    <td width="16%">${product.productName}</td>
                    <td width="16%">${product.productCategory}</td>
                    <td width="16%">${product.productCondition}</td>
                    <td width="16%">${product.productPrice} USD </td>
                    <td width="16%"><a href="<spring:url value="/product/viewProduct/${product.productId}" />"><span class="glyphicon glyphicon-info-sign"></span></a></td>
                 </tr>
                 </tbody>
            </c:forEach>
            
           
        </table>

<%@ include file="/WEB-INF/views/template/footer.jsp" %>