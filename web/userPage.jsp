<%-- 
    Document   : userPage
    Created on : Oct 12, 2017, 9:09:08 PM
    Author     : Edric
--%>

<%@ include file = "header.jsp" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<h1><s:property value="#session.itemowner[0].userName"/>'s user page</h1>
<img src="img/user.png" class="img-thumbnail" alt="" style="border:1">
<h2>Email: <a href="#"><s:property value="#session.itemowner[0].email"/></a></h2>
<center>
    <h3>Items being sold by <s:property value="#session.itemowner[0].userName"/></h3>
    <%@ include file = "listItems.jsp" %>
</center>
    
<%@ include file = "footer.jsp" %>
