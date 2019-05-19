<%-- 
    Document   : convertoapp
    Created on : Jan 17, 2019, 10:17:51 PM
    Author     : dashrath chauhan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Inquiry - Heer International</title>
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
                            <a class="dropdown-item" href="<%=request.getContextPath()%>/jsp/inquiry-details.jsp">Inquiry Details</a>
                            <div class="dropdown-divider"></div>
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
                            <a class="dropdown-item" href="<%=request.getContextPath()%>/jsp/documents-set.jsp">Documents Set</a>
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
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="<%=request.getContextPath()%>/jsp/detailed-Report.jsp">Detailed Report</a>
                        </div>
                    </li>
                    
                    <button class="btn btn-outline-danger my-2 my-sm-0" id="lobtn" type="button">Logout</button>
                </ul>
            </div>
        </nav>
        <div class="jumbotron vertical-center" id="jumbo-form">
            <hr class="my-5">
            <div class="row">
                <div class="col-lg-8 float-left">
                    <h3 class="display-5 mb-4">Create Inquiry/Lead</h3>
                    <form class="container col-lg-8 float-left" name="inquiry-form">
                        <div class="row">
                            <div class="form-group col-lg-6">
                                <label for="firstName">First name</label>
                                <input type="text" id="firstName" class="form-control" placeholder="First name">
                            </div>
                            <div class="form-group col-lg-6">
                                <label for="lastName">Last name</label>
                                <input type="text" id="lastName" class="form-control" placeholder="Last name">
                            </div>
                            <div class="form-group col-lg-6">
                                <label for="eMail">Email</label>
                                <input type="email" id="eMail" class="form-control" placeholder="Email">
                            </div>
                            <div class="form-group col-lg-6">
                                <label for="mobileNo">Mobile No</label>
                                <input type="text" id="mobileNo" class="form-control" placeholder="Mobile No">
                            </div>
                            <div class="form-group col-lg-6 mb-0">
                                <label for="inquirySource">Inquiry Source</label>
                                <select class="form-control" id="inquirySource">
                                    <option>Facebook</option>
                                    <option>LinkedIn</option>
                                    <option>Advertisement</option>
                                    <option>Call</option>
                                </select>
                            </div>
                            <div class="form-group col-lg-6 mb-0">
                                <label for="gender">Gender</label>
                                <select class="form-control" id="gender">
                                    <option>Male</option>
                                    <option>Female</option>
                                </select>
                            </div>
                            <div class="form-group col-lg-12 mt-3">
                                <label for="countryPreference">Country Preference</label>
                                <input type="text" id="countryPreference" class="form-control" placeholder="Enter countries seperated by comma (e.g. USA,UK,Dubai,...)">
                            </div>

                            <div class="form-group col-lg-12 mt-3">
                                <div id="success-alert" class="alert alert-success" style="display:none;">
                                    <strong></strong>
                                </div>
                            </div>

                            <hr class="my-5 container mt-0">
                            <div class="container mt-0">
                                <button id="create-inquiry" type="button" class="btn btn-primary btn-sm col-lg-4 mr-4">Create</button>
                                <button id="update-inquiry" type="button" class="btn btn-primary btn-sm col-lg-4">Update</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="vl"></div>
                <div class="col-lg-3 mt-4 ">
                    <h3 class="display-5 mb-4">Update Inquiry/Lead</h3>
                    <form class="form-inline" id="search-form">
                        <div class="form-group col-lg-8 mb-3 mr-4">
                            <input id="filter" type="search" class="form-control" placeholder="Inquiry Id" />
                        </div>
                        <div class="form-group col-lg-4 mb-3">
                            <input type="submit" class="btn btn-dark" value="Search" id="send">
                        </div>

                    </form>
                </div>
            </div>           
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/cookie.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/create-inquiry.js"></script>
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