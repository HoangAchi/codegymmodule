<%--
  Created by IntelliJ IDEA.
  User: PLH
  Date: 7/16/2019
  Time: 8:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sneaky Restaurant - Chef</title>
    <link rel="icon" href="img/Fevicon.png" type="image/png">

    <link rel="stylesheet" href="vendors/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="vendors/themify-icons/themify-icons.css">
    <link rel="stylesheet" href="vendors/owl-carousel/owl.theme.default.min.css">
    <link rel="stylesheet" href="vendors/owl-carousel/owl.carousel.min.css">
    <link rel="stylesheet" href="vendors/Magnific-Popup/magnific-popup.css">

    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<!--================ Header Menu Area start =================-->
<header class="header_area">
    <div class="main_menu">
        <nav class="navbar navbar-expand-lg navbar-light">
            <div class="container box_1620">
                <a class="navbar-brand logo_h" href="index.html"><img src="img/logo.png" alt=""></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>

                <div class="collapse navbar-collapse offset" id="navbarSupportedContent">
                    <ul class="nav navbar-nav menu_nav justify-content-end">
                        <li class="nav-item"><a class="nav-link" href="index.html">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="about.html">About</a></li>
                        <li class="nav-item"><a class="nav-link" href="menu.html">Menu</a>
                        <li class="nav-item active"><a class="nav-link" href="chef.html">Chef</a>

                        <li class="nav-item submenu dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                               aria-expanded="false">Blog</a>
                            <ul class="dropdown-menu">
                                <li class="nav-item"><a class="nav-link" href="blog.html">Blog Single</a></li>
                                <li class="nav-item"><a class="nav-link" href="blog-details.html">Blog Details</a></li>
                            </ul>
                        </li>
                        <li class="nav-item"><a class="nav-link" href="contact.html">Contact</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</header>
<!--================Header Menu Area =================-->

<!--================Hero Banner Section start =================-->
<section class="hero-banner hero-banner-sm">
    <div class="hero-wrapper">
        <div class="hero-left">
            <h1 class="hero-title">Talent Chefs</h1>
            <p>From  set together our divided own saw divided the form god <br class="d-none d-xl-block"> seas moveth you will fifth under replenish end</p>
            <ul class="hero-info d-none d-lg-block">
                <li>
                    <img src="img/banner/fas-service-icon.png" alt="">
                    <h4>Fast Service</h4>
                </li>
                <li>
                    <img src="img/banner/fresh-food-icon.png" alt="">
                    <h4>Fresh Food</h4>
                </li>
                <li>
                    <img src="img/banner/support-icon.png" alt="">
                    <h4>24/7 Support</h4>
                </li>
            </ul>
        </div>
        <div class="hero-right">
            <div class="owl-carousel owl-theme w-100 hero-carousel">
                <div class="hero-carousel-item">
                    <img class="img-fluid" src="img/banner/hero-banner-sm.png" alt="">
                </div>
                <!-- <div class="hero-carousel-item">
                  <img class="img-fluid" src="img/banner/hero-banner2.png" alt="">
                </div>
                <div class="hero-carousel-item">
                  <img class="img-fluid" src="img/banner/hero-banner1.png" alt="">
                </div>
                <div class="hero-carousel-item">
                  <img class="img-fluid" src="img/banner/hero-banner2.png" alt="">
                </div> -->
            </div>
        </div>
        <ul class="social-icons d-none d-lg-block">
            <li><a href="#"><i class="ti-facebook"></i></a></li>
            <li><a href="#"><i class="ti-twitter"></i></a></li>
            <li><a href="#"><i class="ti-instagram"></i></a></li>
        </ul>
    </div>
</section>
<!--================Hero Banner Section end =================-->


<!--================Chef section start =================-->
<section class="section-margin">
    <div class="container">
        <div class="section-intro mb-75px">
            <h4 class="intro-title">Our Chef</h4>
            <h2>Talent & experience member</h2>
        </div>

        <div class="row">
            <div class="col-sm-6 col-lg-4 mb-4 mb-lg-0">
                <div class="chef-card">
                    <img class="card-img rounded-0" src="img/home/chef-1.png" alt="">
                    <div class="chef-footer">
                        <h4>Daniesl Laran</h4>
                        <p>Executive Chef</p>
                    </div>

                    <div class="chef-overlay">
                        <ul class="social-icons">
                            <li><a href="#"><i class="ti-facebook"></i></a></li>
                            <li><a href="#"><i class="ti-twitter-alt"></i></a></li>
                            <li><a href="#"><i class="ti-skype"></i></a></li>
                            <li><a href="#"><i class="ti-vimeo-alt"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="col-sm-6 col-lg-4 mb-4 mb-lg-0">
                <div class="chef-card">
                    <img class="card-img rounded-0" src="img/home/chef-2.png" alt="">
                    <div class="chef-footer">
                        <h4>Daniesl Laran</h4>
                        <p>Executive Chef</p>
                    </div>

                    <div class="chef-overlay">
                        <ul class="social-icons">
                            <li><a href="#"><i class="ti-facebook"></i></a></li>
                            <li><a href="#"><i class="ti-twitter-alt"></i></a></li>
                            <li><a href="#"><i class="ti-skype"></i></a></li>
                            <li><a href="#"><i class="ti-vimeo-alt"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="col-sm-6 col-lg-4 mb-4 mb-lg-0">
                <div class="chef-card">
                    <img class="card-img rounded-0" src="img/home/chef-3.png" alt="">
                    <div class="chef-footer">
                        <h4>Daniesl Laran</h4>
                        <p>Executive Chef</p>
                    </div>

                    <div class="chef-overlay">
                        <ul class="social-icons">
                            <li><a href="#"><i class="ti-facebook"></i></a></li>
                            <li><a href="#"><i class="ti-twitter-alt"></i></a></li>
                            <li><a href="#"><i class="ti-skype"></i></a></li>
                            <li><a href="#"><i class="ti-vimeo-alt"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!--================Chef section end =================-->

<!--================CTA section start =================-->
<section class="cta-area text-center">
    <div class="container">
        <p>Some Trendy And Popular Courses Offerd</p>
        <h2>Under replenish give saying thing</h2>
        <a class="button" href="#">Reservation</a>
    </div>
</section>
<!--================CTA section end =================-->


<!-- ================ start footer Area ================= -->
<footer class="footer-area section-gap">
    <div class="container">
        <div class="row">
            <div class="col-xl-2 col-sm-6 mb-4 mb-xl-0 single-footer-widget">
                <h4>Top Products</h4>
                <ul>
                    <li><a href="#">Managed Website</a></li>
                    <li><a href="#">Manage Reputation</a></li>
                    <li><a href="#">Power Tools</a></li>
                    <li><a href="#">Marketing Service</a></li>
                </ul>
            </div>
            <div class="col-xl-2 col-sm-6 mb-4 mb-xl-0 single-footer-widget">
                <h4>Quick Links</h4>
                <ul>
                    <li><a href="#">Jobs</a></li>
                    <li><a href="#">Brand Assets</a></li>
                    <li><a href="#">Investor Relations</a></li>
                    <li><a href="#">Terms of Service</a></li>
                </ul>
            </div>
            <div class="col-xl-2 col-sm-6 mb-4 mb-xl-0 single-footer-widget">
                <h4>Features</h4>
                <ul>
                    <li><a href="#">Jobs</a></li>
                    <li><a href="#">Brand Assets</a></li>
                    <li><a href="#">Investor Relations</a></li>
                    <li><a href="#">Terms of Service</a></li>
                </ul>
            </div>
            <div class="col-xl-2 col-sm-6 mb-4 mb-xl-0 single-footer-widget">
                <h4>Resources</h4>
                <ul>
                    <li><a href="#">Guides</a></li>
                    <li><a href="#">Research</a></li>
                    <li><a href="#">Experts</a></li>
                    <li><a href="#">Agencies</a></li>
                </ul>
            </div>
            <div class="col-xl-4 col-md-8 mb-4 mb-xl-0 single-footer-widget">
                <h4>Newsletter</h4>
                <p>You can trust us. we only send promo offers,</p>

                <div class="form-wrap" id="mc_embed_signup">
                    <form target="_blank" action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01"
                          method="get">
                        <div class="input-group">
                            <input type="email" class="form-control" name="EMAIL" placeholder="Your Email Address" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Your Email Address '">
                            <div class="input-group-append">
                                <button class="btn click-btn" type="submit">
                                    <i class="ti-arrow-right"></i>
                                </button>
                            </div>
                        </div>
                        <div style="position: absolute; left: -5000px;">
                            <input name="b_36c4fd991d266f23781ded980_aefe40901a" tabindex="-1" value="" type="text">
                        </div>

                        <div class="info"></div>
                    </form>
                </div>

            </div>
        </div>
        <div class="footer-bottom row align-items-center text-center text-lg-left">
            <p class="footer-text m-0 col-lg-8 col-md-12"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="ti-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
            <div class="col-lg-4 col-md-12 text-center text-lg-right footer-social">
                <a href="#"><i class="ti-facebook"></i></a>
                <a href="#"><i class="ti-twitter-alt"></i></a>
                <a href="#"><i class="ti-dribbble"></i></a>
                <a href="#"><i class="ti-linkedin"></i></a>
            </div>
        </div>
    </div>
</footer>
<!-- ================ End footer Area ================= -->




<script src="vendors/jquery/jquery-3.2.1.min.js"></script>
<script src="vendors/bootstrap/bootstrap.bundle.min.js"></script>
<script src="vendors/owl-carousel/owl.carousel.min.js"></script>
<script src="vendors/nice-select/jquery.nice-select.min.js"></script>
<script src="vendors/Magnific-Popup/jquery.magnific-popup.min.js"></script>
<script src="js/jquery.ajaxchimp.min.js"></script>
<script src="js/mail-script.js"></script>
<script src="js/main.js"></script>
</body>
</html>
