<%-- 
    Document   : application-followup
    Created on : Jan 28, 2019, 7:37:52 AM
    Author     : dashrath chauhan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Application FollowUp - Heer International</title>
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
            <h3 class="display-5 container">Applications FollowUp</h3>
            <hr class="my-5 container" id="form-header" style="display:none;">
            <form class="form container" id="follow-form" name="follow-form" style="display:none;">
                <div class="form-row">
                    <div class="form-group col-md-3">
                        <input type="text" id="inquiryId" class="form-control" placeholder="Inquiry Id">
                    </div>
                    <div class="form-group col-md-3">
                        <select id="followup-type" class="form-control text-primary">
                            <option selected disabled class="text-success">FollowUp Type</option>
                            <option>Incoming Call</option>
                            <option>Outgoing Call</option>
                            <option>CC Walk-In</option>
                            <option>Direct Walk-In</option>
                            <option>Old Walk-In</option>
                        </select>
                    </div>
                    <div class="form-group col-md-3">
                        <select id="followup-status" class="form-control text-primary">
                            <option selected disabled class="text-success">Status</option>
                            <option>Appointment</option>
                            <option>Followup</option>
                            <option>Drop</option>
                            <option>Visited</option>
                            <option>No Response</option>
                        </select>
                    </div>
                    <div class="form-group col-md-3">
                        <select id="strength" class="form-control text-primary">
                            <option selected disabled class="text-success">Lead Strength</option>
                            <option>Strong</option>
                            <option>Average</option>
                            <option>Weak</option>
                        </select>
                    </div>
                    <div class="form-group col-md-3">
                        <input type="text" id="getFollowUpsDate" class="form-control" placeholder="Next Follow-Up Date">
                    </div>
                    <div class="form-group col-md-7">
                        <input type="text" class="form-control col-lg-12" id="description" placeholder="Description"></textarea>
                    </div>
                    <div class="form-group col-md-2">
                        <button class="btn btn-dark btn-block" type="button" id="followup-button">Update</button>
                    </div>
                </div>
                <div class="form-group col-lg-12 mt-3">
                    <div id="success-alert" class="alert alert-success" style="display:none;">
                        <strong></strong>
                    </div>
                </div>
            </form>
            <hr class="my-5 container">
            <div class="row container" style="margin:0 auto;">
                <div class="col-lg-5">
                    <table id="inquiries_table" class="table table-striped table-bordered">
                        <thead class="thead-dark">
                            <tr>                                    
                                <th>Application Id</th>
                                <th>Name</th>
                                <th>Mobile no</th>
                            </tr>
                        </thead>
                        <tbody id="table-data">
                        </tbody>
                    </table>
                    <button class="btn btn-outline-success my-2 my-sm-0" id="followUpReport" type="button">Download Followup Report</button>
                    <div class="form-group col-lg-12 mt-3">
                        <div id="success-alert" class="alert alert-success" style="display:none;">
                            <strong></strong>
                        </div>
                    </div>
                </div>
                
                <div class="col-lg-7">
                    <div class="card alert alert-info" style="display:none;">
                        <div class="card-body" id="followups-details">
                          
                        </div>
                    </div> 
                </div>             
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/cookie.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/application-followup.js"></script>
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

