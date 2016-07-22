<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Cart</h1>
                    <p>All the selected products in your shopping cart</p>
                </div>
            </div>
        </section>

        <section class="container" ng-app="cartApp">

            <div ng-controller = "cartCtrl" ng-init="initCartId('${cartId}')">

                <div>
                    <a href="<spring:url value="/rest/cart/clearCart/${cartId}" />" class="btn btn-danger pull-left"  ><span class="glyphicon glyphicon-remove-sign"></span> Clear Cart</a>
                   <c:if test="${not empty cartItemList}">
                    <a href="<spring:url value="/order/${cartId}" />" class="btn btn-success pull-right"><span class="glyphicon glyphicon-shopping-cart"></span> Check out</a>
                </c:if>
                </div>

                <br/><br/><br/>


           <table style="width:100%" border="1" cellpadding="10" cellspacing="10">
          
                <tr>
                   <tr>
                        <th>Product</th>
                        <th>Unit Price</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                </tr>
            
             
            <c:forEach items="${cartItemList}" var="cartItem">
           
               <tr>
                   
                    <td width="16%">${cartItem.getProduct().getProductName()}</td>
                    <td width="16%">${cartItem.getProduct().getProductPrice()}</td>
                    <td width="16%">${cartItem.quantity}</td>
                    <td width="16%">${cartItem.totalPrice} USD </td>
                    <td><a href="<spring:url value="/customer/cart/removeFromCart/${cartItem.getCartItemId()}" />"><span class="glyphicon glyphicon-remove"></span>remove</a></td>
                 </tr>
                
                
            </c:forEach>
            
            <tr>
                        <th></th>
                        <th></th>
                        <th>Grand Total</th>
                        <th>${grandTotal}</th>
                        <th></th>
                    </tr>
        </table>




                <a href="<spring:url value="/product/productList" />" class="btn btn-primary">Continue Shopping</a>
            </div>
        </section>

<!-- My -->
<script src="<c:url value="/resources/js/controller.js?v3" /> "></script>

<%@ include file="/WEB-INF/views/template/footer.jsp" %>