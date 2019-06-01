<%-- 
    Document   : dashboard
    Created on : Jan 13, 2019, 7:21:25 PM
    Author     : dashrath chauhan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>

    <head>
        <title>Dashboard - Heer International</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/dateTimePicker/jquery.datetimepicker.css">
        <% System.setProperty("java.awt.headless", "false");%>
    </head>

    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <button type="button" class="btn btn-outline-success my-2 my-sm-0 mr-2" id="newUser" style="display:none;">Create New User</button>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item dropdown mr-4 ml-4">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Inquiry
                        </a>
                        <div class="dropdown-menu mt-2" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="<%=request.getContextPath()%>/jsp/create-inquiry.jsp">Create Inquiry</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="<%=request.getContextPath()%>/jsp/view-inquiry.jsp">View Inquiry</a>
                            <div class="dropdown-divider"></div>
<!--                            <a class="dropdown-item" href="<%=request.getContextPath()%>/jsp/inquiry-details.jsp">Inquiry Details</a>
                            <div class="dropdown-divider"></div>-->
                            <a class="dropdown-item" href="<%=request.getContextPath()%>/jsp/hold-inquiries.jsp">OnHold Inquiries</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown mr-4 ml-4">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Application
                        </a>
                        <div class="dropdown-menu mt-2" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="<%=request.getContextPath()%>/jsp/convertoapp.jsp">Convert To Application</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="<%=request.getContextPath()%>/jsp/upload-documents.jsp">Upload Documents</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="<%=request.getContextPath()%>/jsp/document-status.jsp">Documents Status</a>
                        </div>
                    </li>
                    
                    <li class="nav-item dropdown mr-4 ml-4">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Follow Up
                        </a>
                        <div class="dropdown-menu mt-2" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="<%=request.getContextPath()%>/jsp/view-application.jsp">View Applications</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="<%=request.getContextPath()%>/jsp/inquiry-followup.jsp">Inquiry Follow-Up</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="<%=request.getContextPath()%>/jsp/application-followup.jsp">Application Follow-Up</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown mr-4 ml-4">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Reports
                        </a>
                        <div class="dropdown-menu mt-2" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="<%=request.getContextPath()%>/jsp/invoice.jsp">Invoice</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="<%=request.getContextPath()%>/jsp/basic-Report.jsp">Basic Report</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="<%=request.getContextPath()%>/jsp/brief-Report.jsp">Brief Report</a>
                        </div>
                    </li>
                    
                    <button class="btn btn-outline-danger my-2 my-sm-0" id="lobtn" type="button">Logout</button>
                </ul>
            </div>
        </nav>

        <div class="jumbotron vertical-center">
            <h2 class="display-5 container">Dashboard - Today's Follow-Ups</h2>


            <hr class="my-5 container">
            <div class="container col-lg-10">
                <div class="form-row mb-4">
                    <div class="col-lg-3"> 
                        <input type="text" id="getFollowUpsDate" class="form-control" placeholder="Get Follow-Ups of">
                    </div>
                    <button class="btn btn-dark col-lg-2 btn-block" type="button" id="getFollowUps">Get FollowUps of</button>
                </div>
                <hr class="my-5 container">
                <div class="row">

                    <div class="col-md-5">
                        <h3 class="mb-4">Inquries Follow-Ups</h3>
                        <div class="card alert alert-info" role="alert" id="followups-inquiry">
                            <table id="todays-inquiries-followups" class="table table-striped table-bordered" style="width:100%">
                                <thead class="thead-dark">
                                    <tr>
                                        <th>Inquiry Id</th>
                                        <th>Name</th>
                                        <th>Mobile</th>
                                        <th>Update FollowUp</th>
                                    </tr>
                                </thead>
                                <tbody id="inquiry-data">

                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="col-md-2"></div>
                    <div class="col-md-5">
                        <h3 class="mb-4">Application Follow-Ups</h3>
                        <div class="card alert alert-info" role="alert">
                            <table id="todays-applications-followups" class="table table-striped table-bordered" style="width:100%">
                                <thead class="thead-dark">
                                    <tr>
                                        <th>Inquiry Id</th>
                                        <th>Name</th>
                                        <th>Mobile</th>
                                    </tr>
                                </thead>
                                <tbody id="application-data">

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/cookie.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/follow-up.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/users.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/dateTimePicker/jquery.datetimepicker.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/dateTimePicker/jquery.datetimepicker.full.min.js"></script>
        <script>
            $('#getFollowUpsDate').datetimepicker();

            function getCookieValue(a) {
                var b = document.cookie.match('(^|;)\\s*' + a + '\\s*=\\s*([^;]+)');
                return b ? b.pop() : '';
            }
            window.onload = function () {
                var is_Admin = getCookieValue("isadmin");
                //alert(is_Admin);
                if (is_Admin == 1) {
                    document.getElementById('newUser').style.display = "block";
                } else {
                    document.getElementById('newUser').style.display = "none";
                }
            }

        </script>
    </body>

</html>