<%-- Document : cart Created on : Jan 25, 2024, 1:20:11 PM Author : Quang --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
        <link rel="stylesheet" href="css/cart.css">
        <!-- bootstrap css -->
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <!-- style css -->
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <!-- Responsive-->
        <link rel="stylesheet" href="css/responsive.css">
        <!-- fevicon -->
        <link rel="icon" href="images/fevicon.png" type="image/gif" />
        <!-- Scrollbar Custom CSS -->
        <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
        <!-- Tweaks for older IEs-->
        <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
        <!-- fonts -->
        <link href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap" rel="stylesheet">
        <!-- font awesome -->
        <link rel="stylesheet" type="text/css"
              href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <!--  -->
        <!-- owl stylesheets -->
        <link
            href="https://fonts.googleapis.com/css?family=Great+Vibes|Poppins:400,700&display=swap&subset=latin-ext"
            rel="stylesheet">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesoeet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css"
              media="screen">
    </head>

    <body>

        <c:set var="cookie" value="${pageContext.request.cookies}"/>

        <div class="card">
            <div class="row">
                <div class="col-md-8 cart">
                    <div class="title">
                        <div class="row">
                            <div class="col">
                                <h4><b>Shopping Cart</b></h4>
                            </div>
                            <div class="col align-self-center text-right text-muted">${totalProducts} items</div>
                        </div>
                    </div>
                    <c:forEach items="${requestScope.vector}" var="i">
                        <div class="row border-top border-bottom">
                            <div class="row main align-items-center">
                                <c:forEach items="${requestScope.vectorP}" var="item">
                                    <c:if test="${i.product_id == item.product_id}">
                                        <div class="col-2"><img src="${item.img}" class="img-fluid"></div>
                                        <div class="col">
                                            <div class="row text-muted">${item.product_name}</div>
                                            <div class="row">${item.description}</div>
                                        </div>
                                    </c:if>
                                </c:forEach>
                                <div class="col">
                                    <!-- Hiển thị số lượng của sản phẩm -->
                                    <td class="align-middle p-4"><input type="number" class="form-control text-center" value="${i.quantity}"  min="1" name="quantity" ></td>
                                </div>
                                <div class="col">&dollar; ${i.total} <a href="remove?pid=${i.product_id}&quantity=0"><span class="close">&#10005;</span></a></div>
                            </div>
                        </div>
                    </c:forEach>

                    <div class="row" style="border-top: 1px solid rgba(0,0,0,.1); padding: 2vh 0;">
                        <div class="col">TOTAL PRICE</div>
                        <!-- Hiển thị tổng giá trị giỏ hàng -->
                        <div class="col text-right">&dollar; ${total}</div>
                    </div>

                    <div class="back-to-shop"><a href="home">&leftarrow;</a><span class="text-ádfasdf">Back to
                            shop</span></div>
                </div>
                <div class="col-md-4 summary">
                    <div>
                        <h5><b>Summary</b></h5>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col" style="padding: left 50px;;">ITEMS ${totalProducts}</div>
                        <div class="col text-right">&dollar; ${total}</div>
                    </div>
                    <div class="row" style="border-top: 1px solid rgba(0,0,0,.1); padding: 2vh 0;">
                        <div class="col">TOTAL PRICE</div>
                        <div class="col text-right">&dollar; ${total}</div>
                    </div>
                    <a href="checkout"><button class="btn">CHECKOUT</button></a>
                </div>
            </div>
        </div>
    </body>
</html>