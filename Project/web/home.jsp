<%-- 
    Document   : home
    Created on : Jan 25, 2024, 12:51:49 PM
    Author     : Quang
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- basic -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- mobile metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">
        <!-- site metas -->
        <title>Eflyer</title>
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">
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
        <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <!--  -->
        <!-- owl stylesheets -->
        <link href="https://fonts.googleapis.com/css?family=Great+Vibes|Poppins:400,700&display=swap&subset=latin-ext" rel="stylesheet">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesoeet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
    </head>
    <body>
        <!-- banner bg main start -->
        <div class="banner_bg_main">
            <!-- header top section start -->
            <!-- logo section start -->
            <div class="logo_section">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="logo"><a href="home"><img src="images/logo.png"></a></div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- logo section end -->
            <!-- header section start -->
            <div class="header_section">
                <div class="container">
                    <div class="containt_main">
                        <div class="dropdown">
                            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">All Category 
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                <c:forEach items="${ListC}" var="c">
                                    <a class="dropdown-item" href="category?cid=${c.category_id}">${c.category_name}</a>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="main">
                            <!-- Another variation with a button -->
                            <form action="search" method="post">
                                <div class="input-group">
                                    <input name="txt" type="text" class="form-control" placeholder="Search this blog">
                                    <div class="input-group-append">
                                        <button class="btn btn-secondary" type="submit" style="background-color: #f26522; border-color:#f26522 ">
                                            <i class="fa fa-search"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="header_box">
                            <div class="lang_box ">
                                <div class="dropdown-menu ">
                                    <a href="#" class="dropdown-item">
                                        <img src="images/flag-france.png" class="mr-2" alt="flag">
                                        French
                                    </a>
                                </div>
                            </div>
                            <div class="login_menu">
                                <ul>
                                    <li><a href="cart">
                                            <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                            <span class="padding_10">Cart(${totalQuantity})
                                            </span></a>
                                    </li>

                                    <li><a href="statuscart">
                                            <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                            <span class="padding_10">Status Cart</span></a>
                                    </li>

                                    <c:if test="${sessionScope.acc.isAdmin == 1}">
                                        <li class="nav-item">
                                            <a href="#">
                                                <i class="fa fa-user" aria-hidden="true"></i>
                                                <span class="padding_10">Manager Account</span>
                                            </a>
                                        </li>
                                    </c:if>

                                    <c:if test="${sessionScope.acc.isUser == 1}">
                                        <li class="nav-item">
                                            <a href="index.html">
                                                <i class="fa fa-user" aria-hidden="true"></i>
                                                <span class="padding_10">Manager Product</span>
                                            </a>
                                        </li>
                                    </c:if>

                                    <c:if test="${sessionScope.acc == null}">
                                        <li>
                                            <a href="login.jsp">
                                                <i class="fa fa-user" aria-hidden="true"></i>
                                                <span class="padding_10">Login</span>
                                            </a>
                                        </li>
                                    </c:if>

                                    <c:if test="${sessionScope.acc != null}">
                                        <li class="nav-item">
                                            <a href="#">
                                                <i class="fa fa-user" aria-hidden="true"></i>
                                                <span class="padding_10">Hello ${sessionScope.acc.username}</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="logout">
                                                <i class="fa fa-user" aria-hidden="true"></i>
                                                <span class="padding_10">Logout</span>
                                            </a>
                                        </li>
                                    </c:if>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- header section end -->
            <!-- banner section start -->
            <div class="banner_section layout_padding">
                <div class="container">
                    <div id="my_slider" class="carousel slide" data-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <div class="row">
                                    <div class="col-sm-12">
                                        <h1 class="banner_taital">Get Start <br>Your favriot shoping</h1>
                                        <div class="buynow_bt"><a href="#">Buy Now</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- banner section end -->
        </div>
        <!-- banner bg main end -->
        <!-- fashion section start -->
        <div class="fashion_section">
            <div id="main_slider" class="carousel slide" data-ride="carousel">
                <div class="carousel-inner">
                    <div class="active">
                        <div class="container">
                            <h1 class="fashion_taital">Man & Woman Fashion</h1>
                            <div class="fashion_section_2">
                                <div class="row">
                                    <c:forEach items="${ListP}" var="o">
                                        <div class="col-lg-4 col-sm-4">
                                            <div class="box_main">
                                                <h4 class="shirt_text">${o.product_name}</h4>
                                                <p class="price_text">Price  <span style="color: #262626;">$ ${o.price}</span></p>
                                                <div class="tshirt_img"><img src="${o.img}"></div>
                                                <div class="btn_main">
                                                    <div class="buy_bt"><a href="detail?pid=${o.product_id}">Buy Now</a></div>
                                                    <div class="seemore_bt"><a href="detail?pid=${o.product_id}">See More</a></div>
                                                    <div class="seemore_bt"><a href="cart?pid=${o.product_id}&quantity=1">Add to cart</a></div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- fashion section end -->

        <!-- footer section start -->
        <div class="footer_section layout_padding">
            <div class="container">
                <div class="footer_logo"><a href="index.html"><img src="images/footer-logo.png"></a></div>
                <div class="input_bt">
                    <input type="text" class="mail_bt" placeholder="Your Email" name="Your Email">
                    <span class="subscribe_bt" id="basic-addon2"><a href="#">Subscribe</a></span>
                </div>
                <div class="footer_menu">
                    <ul>
                        <li><a href="#">Best Sellers</a></li>
                        <li><a href="#">Gift Ideas</a></li>
                        <li><a href="#">New Releases</a></li>
                        <li><a href="#">Today's Deals</a></li>
                        <li><a href="#">Customer Service</a></li>
                    </ul>
                </div>
                <div class="location_main">Help Line  Number : <a href="#">0968836096</a></div>
            </div>
        </div>
        <!-- footer section end -->
        <!-- Javascript files-->
        <script src="js/jquery.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="js/jquery-3.0.0.min.js"></script>
        <script src="js/plugin.js"></script>
        <!-- sidebar -->
        <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
        <script src="js/custom.js"></script>
        <script>
            function openNav() {
                document.getElementById("mySidenav").style.width = "250px";
            }

            function closeNav() {
                document.getElementById("mySidenav").style.width = "0";
            }
        </script>
    </body>
</html>