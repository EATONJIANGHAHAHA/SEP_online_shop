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
                        <td data-th="Price"><ins>$<s:property value="price"/></ins></td>
                        <td data-th="Quantity">
                            <input type="number" class="form-control text-center" value="1">
                        </td>
                        <td data-th="Subtotal" class="text-center">1.99</td>
                        <td class="actions" data-th="">
                            <button class="btn btn-info btn-sm"><i class="fa fa-refresh"></i></button>
                            <button class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></button>								
                        </td>
                    </tr>
                </s:iterator>
            </tbody>
            <tfoot>
                <tr class="visible-xs">
                    <td class="text-center"><strong>Total 1.99</strong></td>
                </tr>
                <tr>
                    <td><s:a href="#" class="btn btn-warning"><i class="fa fa-angle-left"></i> Continue Shopping</s:a></td>
                        <td colspan="2" class="hidden-xs"></td>
                        <td class="hidden-xs text-center"><strong>Total $1.99</strong></td>
                        <td><a href="#" class="btn btn-success btn-block">Checkout <i class="fa fa-angle-right"></i></a></td>
                    </tr>
                </tfoot>
            </table>

        </form>

    </div>
<%@ include file = "footer.jsp" %>