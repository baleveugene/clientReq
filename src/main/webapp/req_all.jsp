<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="en">   
    <head>
        <!-- Meta -->
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
        <title> All requests</title>
        <!-- Bootstrap Core CSS -->
        <link rel="stylesheet" href="../resources/css/bootstrap.min.css">       
        <!-- Customizable CSS -->
        <link rel="stylesheet" href="../resources/css/main.css">
        <link rel="stylesheet" href="../resources/css/green.css">
        <link rel="stylesheet" href="../resources/css/owl.carousel.css">
        <link rel="stylesheet" href="../resources/css/owl.transitions.css">
        <link rel="stylesheet" href="../resources/css/animate.min.css">
        <!-- Fonts -->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800' rel='stylesheet' type='text/css'>       
        <!-- Icons/Glyphs -->
        <link rel="stylesheet" href="../resources/css/font-awesome.min.css">       
        <!-- Favicon -->
        <link rel="shortcut icon" href="../resources/images/favicon.ico"> 
    </head>   
    <body>   
        <div class="wrapper">
<!-- ============================================================= HEADER ============================================================= -->
        <%@include file="/WEB-INF/pages/header.jsp" %>
<!-- ============================================================= HEADER : END ============================================================= -->           
                <section id="category-grid">
                    <div class="container">       
<!-- ========================================= SIDEBAR ========================================= -->
                        <div class="col-xs-12 col-sm-3 no-margin sidebar narrow">
<!-- ========================================= PRODUCT FILTER ========================================= -->
                            <div class="widget">
                                <h1>Filters</h1>
                                <div class="body bordered"> <!-- body -->                  
                                        <form:form id="filterForm" action="/request" method="GET">                   
                                        <!--Requests -->      
                                        <c:if test="${!empty listReqStatus}" >               
                                            <div class="category-filter">
                                            <h2> Request's status</h2>
                                            <!--<hr>--> 
                                            <div id="item-count" class="le-select">
                                                <select name="status">  
                                                    <option value='' >Status not selected</option> 
                                                    <!--<option disabled>Select axes</option>-->  
                                                    <c:forEach items="${listReqStatus}" var="aa">
                                                        <option value="${aa.name}"
                                                        <c:if test="${aa.name == name}">selected</c:if>                 
                                                        > ${aa.name} </option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>         
                                    </c:if><br>                                      
                                    <button class="le-button small">Filter Requests</button>                    
                                    </form:form>
                                </div><!-- /.body -->                 
                                <form:form id="addForm" action="/request/add" method="GET">    
                                    <button class="le-button small">Add new Request</button>             
                                </form:form>                        
                            </div><!-- /.widget -->
<!-- ========================================= PRODUCT FILTER : END ========================================= -->
                        </div>
<!-- ========================================= SIDEBAR : END ========================================= -->
<!-- ========================================= CONTENT ========================================= -->
                        <div class="col-xs-12 col-sm-9 no-margin wide sidebar">   
                            <section id="gaming">
                                <div class="grid-list-products">                                                               
                                    <div class="tab-content">
                                        <div id="grid-view" class="products-grid fade tab-pane in active">               
                                            <div class="product-grid-holder">
                                                <div class="row no-margin">                    
                                                    <c:forEach items="${listRequests}" var="req"> 
                                                        <div class="col-xs-12 col-sm-4 no-margin product-item-holder hover">
                                                            <div class="product-item">                                                                            
                                                                <div class="body">                                   
                                                                    <div class="title">
                                                                        <a href="/request-${req.url}">${req.text}</a> 
                                                                    </div>
                                                                    <div class="brand">Author: ${req.getUser().username}</div>                                                                   
                                                                </div>                      
                                                            </div><!-- /.product-item -->
                                                        </div><!-- /.product-item-holder -->
                                                    </c:forEach>
                       
                                                    <c:if test="${empty listRequests}">
                                                        <div class="container-fluid">
                                                            <div class="col-lg-10 center-block items-holder">
                                                                <div class="inner-xs">
                                                                    <div class="page-header">
                                                                        <h2 class="page-title">There are no Requests with such parameters<br/>
                                                                                            Please, change the filter parameters.
                                                                        </h2>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </c:if>         
                                                </div><!-- /.row -->
                                            </div><!-- /.product-grid-holder -->         
                                        </div><!-- /.products-grid #grid-view -->                                           
                                    </div><!-- /.grid-list-products -->
                                </div>
                            </section><!-- /#gaming -->            
                        </div><!-- /.col -->
<!-- ========================================= CONTENT : END ========================================= -->    
                    </div><!-- /.container -->
                </section><!-- /#category-grid -->    
<!-- ============================================================= FOOTER ============================================================= -->
                <%@include file="/WEB-INF/pages/footer.jsp" %>
<!-- ============================================================= FOOTER : END ============================================================= -->   
        </div><!-- /.wrapper -->
        <!-- JavaScripts placed at the end of the document so the pages load faster -->
        <script src="../resources/js/jquery-1.10.2.min.js"></script>
        <script src="../resources/js/jquery-migrate-1.2.1.js"></script>
        <script src="../resources/js/bootstrap.min.js"></script>       
        <script src="../resources/js/bootstrap-hover-dropdown.min.js"></script>
        <script src="../resources/js/owl.carousel.min.js"></script>
        <script src="../resources/js/css_browser_selector.min.js"></script>
        <script src="../resources/js/echo.min.js"></script>
        <script src="../resources/js/jquery.easing-1.3.min.js"></script>
        <script src="../resources/js/bootstrap-slider.min.js"></script>      
        <script src="../resources/js/jquery.prettyPhoto.min.js"></script>
        <script src="../resources/js/jquery.customSelect.min.js"></script>
        <script src="../resources/js/wow.min.js"></script>
        <script src="../resources/js/scripts.js"></script>
        <script src="http://w.sharethis.com/button/buttons.js"></script>
    </body>
</html>