<%-- 
    Document   : index
    Created on : 29-Aug-2017, 15:00:13
    Author     : lzy
--%>

<%@ include file = "header.jsp" %>


<center>
    <h1>cart of <s:property value="#session.user.userName"/></h1>
</center>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<div class="container">

    <form action="action" method="GET">

        <table id="cart" class="table table-hover table-condensed">
            <thead>
                <tr>
                    <th style="width:50%">Product</th>
                    <th style="width:10%">Price</th>
                    <th style="width:8%">Quantity</th>
                    <th style="width:22%" class="text-center">Subtotal</th>
                    <th style="width:10%"></th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="#session.itemlist">
                    <tr>
                        <td data-th="Product">
                            <div class="row">
                                <div class="col-sm-2 hidden-xs"><img src="img/<s:property value='itemImage' />" alt="..." class="img-responsive"/></div>
                                <div class="col-sm-10">
                                    <h4 class="nomargin"><s:property value="itemName"/></h4>
                                    <p><s:property value="itemDescription"/></p>
                                </div>
                            </div>
                        </td>
                        <td data-th="Price" id="price"><ins>$<s:property value="price"/></ins></td>
                        <td data-th="Quantity">
                            <input type="number" name="qty" class="form-control text-center" id="qty_input" value="1">
                        </td>
                        <td data-th="Subtotal" class="text-center">$<s:property value="price"/></td>
<!--<script>
$('input[name=\'qty\']').on('change keyup click', function(){
    var price = $('#price').text().substr(1);
    var qty = $('#qty_input').val();
    
})
</script>-->
                        <td class="actions" data-th="">
                            <button class="btn btn-info btn-sm"><i class="fa fa-refresh"></i></button>
                            <s:url action="removecartitem" var="removefromcartURL">
                                <s:param name="selectedUserId" value="#session.user.userId"/>
                                <s:param name="removeitemid" value="itemId"/>
                            </s:url>
                            <s:a href="%{removefromcartURL}">
                                <i class="fa fa-trash-o"><input class="btn btn-danger btn-sm" type="button"/></i>
                            </s:a>
                        </td>
                    </tr>
                </s:iterator>
            </tbody>
            <tfoot>
                <tr class="visible-xs">
                    <td class="text-center"><strong>$</strong></td>
                </tr>
                <tr>
                    <td><s:a href="search" class="btn btn-warning"><i class="fa fa-angle-left"></i> Continue Shopping</s:a></td>
                        <td colspan="2" class="hidden-xs"></td>
                        <td class="hidden-xs text-center"><strong>Total $</strong></td>
                        <td>
<!--                            <a href="checkout.jsp" class="btn btn-success btn-block">Checkout <i class="fa fa-angle-right"></i></a>-->
                        <s:url action="checkout" var="checkoutURL">
                            <s:param name="selectedUserId" value="#session.user.userId"/>
                            <s:param name="removeitemid" value="itemId"/>
                        </s:url>
                        <s:a href="%{checkoutURL}">Checkout <i class="fa fa-angle-right"></i></s:a>
                        </td>                       
                    </tr>
                </tfoot>
            </table>

        </form>

    </div>
<%@ include file = "footer.jsp" %>