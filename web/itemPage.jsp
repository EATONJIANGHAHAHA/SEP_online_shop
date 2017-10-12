<%@ include file = "header.jsp" %>
<center>
    
    <p>User with ID:<s:property value="#session.user.userId"/> is logged in</p>
    <p>Owner of the item:</p>
    <s:property value="#session.itemowner[0].userId"/><br>
    <s:property value="#session.itemowner[0].userName"/><br>
    <%@ include file = "listItems.jsp" %>
</center>
<%@ include file = "footer.jsp" %>