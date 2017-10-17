<%-- 
    Document   : userCart
    Created on : Oct 17, 2017, 9:34:56 AM
    Author     : Edric
--%>

<%@ include file = "header.jsp" %>
    <body>
        <h1><s:property value="#session.itemowner[0].userName"/>'s cart</h1>
    <center>
        <%@ include file = "listItems.jsp" %>
        <s:url action="checkout" var="checkoutURL">
            <s:param name="selectedUserId" value="#session.user.userId"/>
        </s:url>
        <s:a href="%{checkoutURL}">Checkout items</s:a>
    </center>
    </body>
<%@ include file = "footer.jsp" %>
