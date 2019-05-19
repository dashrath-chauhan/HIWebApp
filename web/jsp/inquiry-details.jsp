<%-- 
    Document   : inquiry-details1.jsp
    Created on : Jan 3, 2019, 3:12:25 PM
    Author     : dashrath chauhan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Inquiry Details - Heer International</title>
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
            <h3 class="display-5">Process Application</h3>
            <hr class="my-5">
            <form class="container" id="frm" name="frm">
                <div class="row">
                    <div class="col-sm-3">
                        <div class="text-center">
                            <img id="profilePic" src="" class="square" height="300" width="200" />
                        </div>
                    </div><!--/col-3-->
                    <div class="col-sm-9">
                        <div class="row">
                            
                            <div class="form-group col-lg-12 mb-3 mr-4">
                                <input id="filter" type="search" class="form-control" placeholder="Inquiry Id" />
                            </div>
                            <div class="form-group col-lg-12 mb-3">
                                <button class="btn btn-dark my-4 btn-block" type="button" id="send">Search</button>
                            </div>
                            <h3 class="display-5 col-lg-10 text-primary">Basic details:</h3>
                            <div class="form-group col-lg-4">
                                <label for="firstName">First name</label>
                                <input type="text" id="firstName" class="form-control" placeholder="First name">
                            </div>
                            <div class="form-group col-lg-4">
                                <label for="lastName">Last name</label>
                                <input type="text" id="lastName" class="form-control" placeholder="Last name">
                            </div>
                            <div class="form-group col-lg-4">
                                <label for="eMail">Email</label>
                                <input type="email" id="eMail" class="form-control" placeholder="Email">
                            </div>
                            <div class="form-group col-lg-4">
                                <label for="mobileNo">Mobile No</label>
                                <input type="text" id="mobileNo" class="form-control" placeholder="Mobile No">
                            </div>
                            <div class="form-group col-lg-4 mb-0">
                                <label for="inquirySource">Inquiry Source</label>
                                <select class="form-control" id="inquirySource">
                                    <option>Facebook</option>
                                    <option>LinkedIn</option>
                                    <option>Advertisement</option>
                                    <option>Call</option>
                                </select>
                            </div>
                            <div class="form-group col-lg-4 mb-0">
                                <label for="inputEmail4">Gender</label>
                                <select class="form-control" id="gender">
                                    <option>Male</option>
                                    <option>Female</option>
                                </select>
                            </div>
                            <div class="form-group col-lg-4 mb-0 text-primary">
                                <label for="inputEmail4">Process form as</label>
                                <select class="form-control text-primary" id="formType">
                                    <option>Student Visa</option>
                                    <option>Visitor Visa</option>
                                    <option>Work Permit</option>
                                </select>
                            </div>

                            <div class="form-group col-lg-4 mb-0 text-primary">
                                <label for="inputEmail4">Assigned</label>
                                <select class="form-control text-primary" id="assigned">
                                    <option>Heer International</option>
                                    <option>Associate</option>
                                </select>
                            </div>
                            <div class="form-group col-lg-4 text-primary">
                                <label for="inputEmail4">Assigned To</label>
                                <input type="text" id="assignedTo" class="form-control text-primary" placeholder="Assigned To">
                            </div>
                            <div class="form-group col-lg-12">
                                <label for="inputEmail4">Country Preferences</label>
                                <input type="text" id="countryPreference" class="form-control" placeholder="Country Preferences">
                            </div>
                        </div>
                    </div>
                    <hr class="my-5 container mt-0">
                    <div class="col-sm-12">
                        <div class="row">
                            <h3 class="display-5 col-lg-10 text-primary">General</h3>
                            <div class="form-group col-lg-4">
                                <label for="inputEmail4">Address Line 1</label>
                                <input type="text" id="add1" class="form-control" placeholder="Address Line 1">
                            </div>
                            <div class="form-group col-lg-4">
                                <label for="inputEmail4">Address Line 2</label>
                                <input type="text" id="add2" class="form-control" placeholder="Address Line 2">
                            </div>
                            <div class="form-group col-lg-4">
                                <label for="inputEmail4">City/Town</label>
                                <input type="text" id="cityTown" class="form-control" placeholder="City/Town">
                            </div>
                            <div class="form-group col-lg-4">
                                <label for="inputEmail4">State</label>
                                <input type="text" id="state" class="form-control" placeholder="State">
                            </div>
                            <div class="form-group col-lg-4 mb-0">
                                <label for="inputEmail4">Pincode</label>
                                <input type="text" id="pin" class="form-control" placeholder="Pincode">
                            </div>
                            <div class="form-group col-lg-4">
                                <label for="inputEmail4">Passport</label>
                                <input type="text" id="passport" class="form-control" placeholder="Passport No">
                            </div>
                            <div class="form-group col-lg-4">
                                <label for="inputEmail4">Additional Passport #1</label>
                                <input type="text" id="passport1" class="form-control" placeholder="Additional Passport #1">
                            </div>
                            <div class="form-group col-lg-4 mb-0">
                                <label for="inputEmail4">Additional Passpor #2</label>
                                <input type="text" id="passport2" class="form-control" placeholder="Additional Passport #2">
                            </div>
                        </div>
                    </div>
                    <hr class="my-5 container mt-0">
                    <div class="col-sm-12">
                        <div class="row">
                            <h3 class="display-5 col-lg-10 text-primary">Acedemic details:</h3>
                            <h5 class="display-5 col-lg-12 text-primary">10th Grade / O Levels</h5>
                            <div class="form-group col-lg-2">
                                <input type="text" id="per10" class="form-control" placeholder="Grade / %">
                            </div>
                            <div class="form-group col-lg-2">
                                <input type="text" id="passYear10" class="form-control" placeholder="Passing Year">
                            </div>  

                            <h5 class="display-5 col-lg-12 text-primary">12th Grade / A Level</h5>
                            <div class="form-group col-lg-2">
                                <input type="text" id="per12" class="form-control" placeholder="Grade / %">
                            </div>
                            <div class="form-group col-lg-2">
                                <input type="text" id="passYear12" class="form-control" placeholder="Passing Year">
                            </div>
                            <div class="form-group col-lg-2">
                                <input type="text" id="stream12" class="form-control" placeholder="Stream">
                            </div>  

                            <h5 class="display-5 col-lg-12 text-primary">Diploma </h5>
                            <div class="form-group col-lg-2">
                                <input type="text" id="perDiploma" class="form-control" placeholder="Grade / %">
                            </div>
                            <div class="form-group col-lg-2">
                                <input type="text" id="passYearDiploma" class="form-control" placeholder="Passing Year">
                            </div>
                            <div class="form-group col-lg-3">
                                <input type="text" id="nameDiploma" class="form-control" placeholder="Diploma Name">
                            </div>
                            <div class="form-group col-lg-3">
                                <input type="text" id="awardingBodyDiploma" class="form-control" placeholder="Awarding Body">
                            </div>
                            <div class="form-group col-lg-2">
                                <input type="text" id="durationDiploma" class="form-control" placeholder="Duration In Years">
                            </div>   

                            <h5 class="display-5 col-lg-12 text-primary">Bachelors Degree </h5>
                            <div class="form-group col-lg-2">
                                <input type="text" id="perBachelor" class="form-control" placeholder="Grade / %">
                            </div>
                            <div class="form-group col-lg-2">
                                <input type="text" id="passYearBachelor" class="form-control" placeholder="Passing Year">
                            </div>
                            <div class="form-group col-lg-3">
                                <input type="text" id="degreeNameBachelor" class="form-control" placeholder="Degree Name">
                            </div>
                            <div class="form-group col-lg-3">
                                <input type="text" id="collegeBachelor" class="form-control" placeholder="College & Univeristy">
                            </div>
                            <div class="form-group col-lg-2">
                                <input type="text" id="durationBachelor" class="form-control" placeholder="Duration In Years">
                            </div>     

                            <h5 class="display-5 col-lg-12 text-primary">Bachelors Backlogs/Failures</h5>
                            <div class="form-group col-lg-4">
                                <input type="text" id="backlogsBachelor" class="form-control" placeholder="# of Backlogs/Failures">
                            </div>   

                            <h5 class="display-5 col-lg-12 text-primary">PG Diploma </h5>
                            <div class="form-group col-lg-2">
                                <input type="text" id="perPG" class="form-control" placeholder="Grade / %">
                            </div>
                            <div class="form-group col-lg-2">
                                <input type="text" id="passYearPG" class="form-control" placeholder="Passing Year">
                            </div>
                            <div class="form-group col-lg-3">
                                <input type="text" id="namePG" class="form-control" placeholder="PG Diploma Name">
                            </div>
                            <div class="form-group col-lg-3">
                                <input type="text" id="awardingBodyPG" class="form-control" placeholder="Awarding Body">
                            </div>
                            <div class="form-group col-lg-2">
                                <input type="text" id="durationPG" class="form-control" placeholder="Duration In Years">
                            </div>    

                            <h5 class="display-5 col-lg-12 text-primary">Masters Degree </h5>
                            <div class="form-group col-lg-2">
                                <input type="text" id="perMasters" class="form-control" placeholder="Grade / %">
                            </div>
                            <div class="form-group col-lg-2">
                                <input type="text" id="passYearMasters" class="form-control" placeholder="Passing Year">
                            </div>
                            <div class="form-group col-lg-3">
                                <input type="text" id="degreeNameMasters" class="form-control" placeholder="Degree Name">
                            </div>
                            <div class="form-group col-lg-3">
                                <input type="text" id="collegeMasters" class="form-control" placeholder="College & Univeristy">
                            </div>
                            <div class="form-group col-lg-2">
                                <input type="text" id="durationMasters" class="form-control" placeholder="Duration In Years">
                            </div>   

                            <h5 class="display-5 col-lg-12 text-primary">Masters Backlogs/Failures</h5>
                            <div class="form-group col-lg-4">
                                <input type="text" id="backlogsMasters" class="form-control" placeholder="# of Backlogs/Failures">
                            </div>


                            <h5 class="display-5 col-lg-12 text-primary">Test Details</h5>
                            <div class="form-group col-lg-3">
                                <input type="text" id="scoreTOEFL" class="form-control" placeholder="TOEFL Score">
                            </div>
                            <div class="form-group col-lg-3">
                                <input type="text" id="mockTOEFL" class="form-control" placeholder="Mock Score">
                            </div>
                            <div class="form-group col-lg-3">
                                <input type="text" id="dateTOEFL" class="form-control" name="dateTOEFL" placeholder="Test Date">
                            </div>
                            <div class="form-group col-lg-3"></div>

                            <div class="form-group col-lg-3">
                                <input type="text" id="scoreIELTS" class="form-control" placeholder="IELTS Score">
                            </div>
                            <div class="form-group col-lg-3">
                                <input type="text" id="mockIELTS" class="form-control" placeholder="Mock Score">
                            </div>
                            <div class="form-group col-lg-3">
                                <input type="text" id="dateIELTS" class="form-control" name="dateIELTS" placeholder="Test Date">
                            </div>
                            <div class="form-group col-lg-3"></div>

                            <div class="form-group col-lg-3">
                                <input type="text" id="scoreGRE" class="form-control" placeholder="GRE Score">
                            </div>
                            <div class="form-group col-lg-3">
                                <input type="text" id="mockGRE" class="form-control" placeholder="Mock Score">
                            </div>
                            <div class="form-group col-lg-3">
                                <input type="text" id="dateGRE" class="form-control" name="dateGRE" placeholder="Test Date">
                            </div>
                            <div class="form-group col-lg-3"></div>

                            <div class="form-group col-lg-3">
                                <input type="text" id="scoreGMAT" class="form-control" placeholder="GMAT Score">
                            </div>
                            <div class="form-group col-lg-3">
                                <input type="text" id="mockGMAT" class="form-control" placeholder="Mock Score">
                            </div>
                            <div class="form-group col-lg-3">
                                <input type="text" id="dateGMAT" class="form-control" name="dateGMAT" placeholder="Test Date">
                            </div>
                            <div class="form-group col-lg-3"></div>

                            <div class="form-group col-lg-3">
                                <input type="text" id="scoreSAT" class="form-control" placeholder="SAT Score">
                            </div>
                            <div class="form-group col-lg-3">
                                <input type="text" id="mockSAT" class="form-control" placeholder="Mock Score">
                            </div>
                            <div class="form-group col-lg-3">
                                <input type="text" id="dateSAT" class="form-control" name="dateSAT" placeholder="Test Date">
                            </div>                             
                        </div>
                    </div>
                    <hr class="my-5 container mt-0">
                    <h3 class="display-5 col-lg-12 text-primary">Special Note:</h3>
                    <div class="form-group col-lg-9">
                        <textarea class="form-control col-lg-12" id="specialNote" rows="3" cols="9"></textarea>
                    </div>
                    <div class="form-group col-lg-9 mt-3">
                        <div id="success-alert" class="alert alert-success" style="display:none;">
                            <strong></strong>
                        </div>
                    </div>
                    <hr class="my-5 container mt-0">
                    <div class="container mt-0">
                        <button id="update-inquiry" type="button" class="btn btn-primary btn-sm col-lg-2">Update Inquiry</button>
                    </div>

                </div></form>
        </div>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" ></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cookie.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/inquiry-details.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dateTimePicker/jquery.datetimepicker.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dateTimePicker/jquery.datetimepicker.full.min.js"></script>
<script>
    $('#dateIELTS').datetimepicker();
    $('#dateTOEFL').datetimepicker();
    $('#dateGRE').datetimepicker();
    $('#dateSAT').datetimepicker();
    $('#dateGMAT').datetimepicker();
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