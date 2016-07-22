<%@ include file="/WEB-INF/views/template/header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container-wrapper">
    <div class="container">
        <div id="login-box">
            <h2>Login with Username and Password</h2>

         


          <%--   <form name="loginForm" action="product/productList" method="post" commandName="Users">--%>

                <form:form action="loginCheck"
                   method="post" commandName="user" onsubmit="loginValidation()">

                <div class="form-group">
                    <label for="username">User: </label>
                   
                    <form:errors path="username" cssStyle="color: #ff0000" />
                   <form:input path="username" id="username" class="form-Control" />
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <form:errors path="password" cssStyle="color: #ff0000" />
                   <form:input path="password" id="password" class="form-Control" />
                </div>
                <input type="submit" value="Submit" class="btn btn-primary">
                <span style="color: #ff0000">${logincheckMsg}</span>
             </form:form>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/views/template/footer.jsp" %>
