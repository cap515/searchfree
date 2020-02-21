<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="zxx">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>mypage - order </title>
    
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- <link rel="manifest" href="site.webmanifest"> -->
    <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">
    <!-- Place favicon.ico in the root directory -->

    <!-- CSS here -->
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css">

    <link rel="stylesheet" href="css/style.css">
    <!-- <link rel="stylesheet" href="css/responsive.css"> -->
    
    <link rel="stylesheet" href="http://localhost:8080/searchfree/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://localhost:8080/searchfree/resources/css/owl.carousel.min.css">
    <link rel="stylesheet" href="http://localhost:8080/searchfree/resources/css/magnific-popup.css">
    <link rel="stylesheet" href="http://localhost:8080/searchfree/resources/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://localhost:8080/searchfree/resources/css/themify-icons.css">
    <link rel="stylesheet" href="http://localhost:8080/searchfree/resources/css/nice-select.css">
    <link rel="stylesheet" href="http://localhost:8080/searchfree/resources/css/flaticon.css">
    <link rel="stylesheet" href="http://localhost:8080/searchfree/resources/css/gijgo.css">
    <link rel="stylesheet" href="http://localhost:8080/searchfree/resources/css/animate.css">
    <link rel="stylesheet" href="http://localhost:8080/searchfree/resources/css/slicknav.css">
    <link rel="stylesheet" href="http://localhost:8080/searchfree/resources/css/style.css">
    <link rel="stylesheet" href="http://localhost:8080/searchfree/resources/css/kim.css">
    <!-- <link rel="stylesheet" href="css/responsive.css"> -->

    <style>
        #left_side {
            position: relative;
        }

        #left_side>img {
            position: absolute;
            height: 280px;
            left: 0;
            right: 0;
            margin: auto;
        }
    </style>
</head>

<body>
    <!--[if lte IE 9]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
        <![endif]-->

    <!-- header-start -->
    <header>
        <div class="header-area ">
            <div id="sticky-header" class="main-header-area">
                <div class="container-fluid ">
                    <div class="header_bottom_border">
                        <div class="row align-items-center">
                            <div class="col-xl-3 col-lg-2">
                                <div class="logo">
                                    <a href="index.html">
                                        <img src="img/logo.png" alt="">
                                    </a>
                                </div>
                            </div>
                            <div class="col-xl-6 col-lg-7">
                                <div class="main-menu  d-none d-lg-block">
                                    <nav>
                                        <ul id="navigation">
                                            <li><a href="index.html">home</a></li>
                                            <li><a href="Listings.html">Listings</a></li>
                                            <li><a href="#">pages <i class="ti-angle-down"></i></a>
                                                <ul class="submenu">

                                                    <li><a href="elements.html">elements</a></li>
                                                    <li><a href="single_listings.html">Single listing</a></li>
                                                </ul>
                                            </li>
                                            <li><a href="about.html">about</a></li>
                                            <li><a href="#">blog <i class="ti-angle-down"></i></a>
                                                <ul class="submenu">
                                                    <li><a href="blog.html">blog</a></li>
                                                    <li><a href="single-blog.html">single-blog</a></li>
                                                </ul>
                                            </li>
                                            <li><a href="contact.html">Contact</a></li>
                                        </ul>
                                    </nav>
                                </div>
                            </div>
                            <div class="col-xl-3 col-lg-3 d-none d-lg-block">
                                <div class="Appointment">
                                    <div class="book_btn d-none d-lg-block">
                                        <a href="#">Sign In</a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="mobile_menu d-block d-lg-none"></div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </header>
    <!-- header-end -->
    <!-- bradcam_area  -->
    <div class="bradcam_area bradcam_bg_2">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="bradcam_text text-center">
                        <h3>OrderList</h3>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--/ bradcam_area  -->
    <div class="listing_details">
        <div class="explorer_europe">
            <div class="container">
                <div class="explorer_wrap">
                    <div class="row align-items-center">
                        <div class="col-xl-6 col-md-4 single_details">
                            <h3>OrderList</h3>
                        </div>
                        <div class="col-xl-6 col-md-8">
                            <div class="explorer_tab">
                                <nav>
                                    <div class="nav" id="nav-tab" role="tablist">
                                        <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab"
                                            href="#nav-home" role="tab" aria-controls="nav-home"
                                            aria-selected="true">판매한 프로젝트</a>
                                        <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab"
                                            href="#nav-profile" role="tab" aria-controls="nav-profile"
                                            aria-selected="false">구매한 프로젝트</a>
                                    </div>
                                </nav>

                            </div>
                        </div>
                    </div>
                </div>
                <div class="tab-content" id="nav-tabContent">
                    <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                        <div class="row">
                            <div class="col-xl-4 col-lg-4 col-md-6">
                                <div class="single_explorer">
                                    <div class="thumb">
                                        <img src="img/explorer/1.png" alt="">
                                    </div>
                                    <div class="explorer_bottom d-flex">
                                        <div class="explorer_info">
                                            <h3><a href="single_listings.html">쇼핑몰 제작</a></h3>
                                            <ul>
                                                <li> <i class="fa fa-dollar"></i>
                                                    840,000원
                                                </li>
                                                <li> <i class="fa fa-user"></i>
                                                    Freelancer Name</li>
                                                    <li> <i class="fa fa-star"></i>
                                                        5.00</li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-4 col-lg-4 col-md-6">
                                <div class="single_explorer">
                                    <div class="thumb">
                                        <img src="img/explorer/2.png" alt="">
                                    </div>
                                    <div class="explorer_bottom d-flex">
                                        <div class="explorer_info">
                                            <h3><a href="single_listings.html">숙박 예약 사이트 제작</a></h3>
                                            <ul>
                                                <li> <i class="fa fa-dollar"></i>
                                                   125,000원
                                                </li>
                                                <li> <i class="fa fa-user"></i>
                                                    Freelancer Name</li>
                                                    <li> <i class="fa fa-star"></i>
                                                        4.80</li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-4 col-lg-4 col-md-6">
                                <div class="single_explorer">
                                    <div class="thumb">
                                        <img src="img/explorer/2.png" alt="">
                                    </div>
                                    <div class="explorer_bottom d-flex">
                                        <div class="explorer_info">
                                            <h3><a href="single_listings.html">맞춤형 홈페이지 제작</a></h3>
                                            <ul>
                                                <li> <i class="fa fa-dollar"></i>
                                                   440,000원
                                                </li>
                                                <li> <i class="fa fa-user"></i>
                                                    Freelancer Name</li>
                                                    <li> <i class="fa fa-star"></i>
                                                        4.80</li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                          
                        </div>
                    </div>
                    <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
                        <div class="row">
                            <div class="col-xl-4 col-lg-4 col-md-6">
                                <div class="single_explorer">
                                    <div class="thumb">
                                        <img src="img/explorer/2.png" alt="">
                                    </div>
                                    <div class="explorer_bottom d-flex">
                                        <div class="icon">
                                            <i class="flaticon-food"></i>
                                        </div>
                                        <div class="explorer_info">
                                            <h3><a href="single_listings.html">쇼핑몰 제작</a></h3>
                                            <ul>
                                                <li> <i class="fa fa-dollar"></i>
                                                    840,000원
                                                </li>
                                                <li> <i class="fa fa-user"></i>
                                                    Freelancer Name</li>
                                                    <li> <i class="fa fa-star"></i>
                                                        5.00</li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-4 col-lg-4 col-md-6">
                                <div class="single_explorer">
                                    <div class="thumb">
                                        <img src="img/explorer/1.png" alt="">
                                    </div>
                                    <div class="explorer_bottom d-flex">
                                        <div class="icon">
                                            <i class="flaticon-beach"></i>
                                        </div>
                                        <div class="explorer_info">
                                            <h3><a href="single_listings.html">쇼핑몰 제작</a></h3>
                                            <ul>
                                                <li> <i class="fa fa-dollar"></i>
                                                    840,000원
                                                </li>
                                                <li> <i class="fa fa-user"></i>
                                                    Freelancer Name</li>
                                                    <li> <i class="fa fa-star"></i>
                                                        5.00</li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-4 col-lg-4 col-md-6">
                                <div class="single_explorer">
                                    <div class="thumb">
                                        <img src="img/explorer/3.png" alt="">
                                    </div>
                                    <div class="explorer_bottom d-flex">
                                        <div class="icon">
                                            <i class="flaticon-food-1"></i>
                                        </div>
                                        <div class="explorer_info">
                                            <h3><a href="single_listings.html">쇼핑몰 제작</a></h3>
                                            <ul>
                                                <li> <i class="fa fa-dollar"></i>
                                                    840,000원
                                                </li>
                                                <li> <i class="fa fa-user"></i>
                                                    Freelancer Name</li>
                                                    <li> <i class="fa fa-star"></i>
                                                        5.00</li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-4 col-lg-4 col-md-6">
                                <div class="single_explorer">
                                    <div class="thumb">
                                        <img src="img/explorer/4.png" alt="">
                                    </div>
                                    <div class="explorer_bottom d-flex">
                                        <div class="icon">
                                            <i class="flaticon-barbershop"></i>
                                        </div>
                                        <div class="explorer_info">
                                            <h3><a href="single_listings.html">쇼핑몰 제작1</a></h3>
                                            <ul>
                                                <li> <i class="fa fa-dollar"></i>
                                                    840,000원
                                                </li>
                                                <li> <i class="fa fa-user"></i>
                                                    Freelancer Name</li>
                                                    <li> <i class="fa fa-star"></i>
                                                        5.00</li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-4 col-lg-4 col-md-6">
                                <div class="single_explorer">
                                    <div class="thumb">
                                        <img src="img/explorer/5.png" alt="">
                                    </div>
                                    <div class="explorer_bottom d-flex">
                                        <div class="icon">
                                            <i class="flaticon-cabin"></i>
                                        </div>
                                        <div class="explorer_info">
                                            <h3><a href="single_listings.html">쇼핑몰 제작2</a></h3>
                                            <ul>
                                                <li> <i class="fa fa-dollar"></i>
                                                    840,000원
                                                </li>
                                                <li> <i class="fa fa-user"></i>
                                                    Freelancer Name</li>
                                                    <li> <i class="fa fa-star"></i>
                                                        5.00</li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-4 col-lg-4 col-md-6">
                                <div class="single_explorer">
                                    <div class="thumb">
                                        <img src="img/explorer/6.png" alt="">
                                    </div>
                                    <div class="explorer_bottom d-flex">
                                        <div class="icon">
                                            <i class="flaticon-shop"></i>
                                        </div>
                                        <div class="explorer_info">
                                            <h3><a href="single_listings.html">쇼핑몰 제작3</a></h3>
                                            <ul>
                                                <li> <i class="fa fa-dollar"></i>
                                                    840,000원
                                                </li>
                                                <li> <i class="fa fa-user"></i>
                                                    Freelancer Name</li>
                                                    <li> <i class="fa fa-star"></i>
                                                        5.00</li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
            </div>
        </div>
    </div>
    <!-- footer start -->
    <footer class="footer">
        <div class="footer_top">
            <div class="container">
                <div class="row">
                    <div class="col-xl-4 col-md-6 col-lg-3">
                        <div class="footer_widget">
                            <div class="footer_logo">
                                <a href="#">
                                    <img src="img/footer_logo.png" alt="">
                                </a>
                            </div>
                            <p>
                                Esteem spirit temper too say adieus who <br> direct esteem. It esteems luckily or
                                <br>
                                picture placing drawing.
                            </p>
                            <div class="socail_links">
                                <ul>
                                    <li>
                                        <a href="#">
                                            <i class="ti-facebook"></i>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <i class="fa fa-google-plus"></i>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <i class="fa fa-twitter"></i>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <i class="fa fa-instagram"></i>
                                        </a>
                                    </li>
                                </ul>
                            </div>

                        </div>
                    </div>
                    <div class="col-xl-2 col-md-6 col-lg-3">
                        <div class="footer_widget">
                            <h3 class="footer_title">
                                Services
                            </h3>
                            <ul>
                                <li><a href="#">SEO/SEM </a></li>
                                <li><a href="#">Web design </a></li>
                                <li><a href="#">Ecommerce</a></li>
                                <li><a href="#">Digital marketing</a></li>
                            </ul>

                        </div>
                    </div>
                    <div class="col-xl-2 col-md-6 col-lg-2">
                        <div class="footer_widget">
                            <h3 class="footer_title">
                                Useful Links
                            </h3>
                            <ul>
                                <li><a href="#">About</a></li>
                                <li><a href="#">Blog</a></li>
                                <li><a href="#"> Contact</a></li>
                                <li><a href="#">Support</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-xl-4 col-md-6 col-lg-4">
                        <div class="footer_widget">
                            <h3 class="footer_title">
                                Subscribe
                            </h3>
                            <form action="#" class="newsletter_form">
                                <input type="text" placeholder="Enter your mail">
                                <button type="submit">Subscribe</button>
                            </form>
                            <p class="newsletter_text">Esteem spirit temper too say adieus who direct esteem esteems
                                luckily.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="copy-right_text">
            <div class="container">
                <div class="footer_border"></div>
                <div class="row">
                    <div class="col-xl-12">
                        <p class="copy_right text-center">
                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                            Copyright &copy;
                            <script>document.write(new Date().getFullYear());</script> All rights reserved | This
                            template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a
                                href="https://colorlib.com" target="_blank">Colorlib</a>
                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!--/ footer end  -->

    <!-- link that opens popup -->
    <script src=" https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"> </script>
    <!-- JS here -->
    <script src="js/vendor/modernizr-3.5.0.min.js"></script>
    <script src="js/vendor/jquery-1.12.4.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/isotope.pkgd.min.js"></script>
    <script src="js/ajax-form.js"></script>
    <script src="js/waypoints.min.js"></script>
    <script src="js/jquery.counterup.min.js"></script>
    <script src="js/imagesloaded.pkgd.min.js"></script>
    <script src="js/scrollIt.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
    <script src="js/wow.min.js"></script>
    <script src="js/nice-select.min.js"></script>
    <script src="js/jquery.slicknav.min.js"></script>
    <script src="js/jquery.magnific-popup.min.js"></script>
    <script src="js/plugins.js"></script>
    <!-- <script src="js/gijgo.min.js"></script> -->
    <script src="js/slick.min.js"></script>



    <!--contact js-->
    <script src="js/contact.js"></script>
    <script src="js/jquery.ajaxchimp.min.js"></script>
    <script src="js/jquery.form.js"></script>
    <script src="js/jquery.validate.min.js"></script>
    <script src="js/mail-script.js"></script>


    <script src="js/main.js"></script>
</body>

</html>