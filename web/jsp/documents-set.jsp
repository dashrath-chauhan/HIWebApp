<%-- 
    Document   : documents-set
    Created on : Jan 30, 2019, 6:51:21 PM
    Author     : dashrath chauhan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Document Set - Heer International</title>
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
            <h3 class="display-5 container">Documents Set</h3>
            <h5 class="display-5 container text-primary">Instructions**</h5>
            <p class="container text-primary">- Select documents to assign for specific lead.</p>
            <p class="container text-primary">- Later, when uploading documents, you can upload documents which has been selected from here for specific lead.</p>
            <hr class="my-5 container">
            
            <form class="container" id="frm" name="frm">
                <div class="form-group col-lg-4 mb-5">
                    <input type="text" id="inquiryId" class="form-control" placeholder="Inquiry Id">
                </div>
                <h5 class="display-5 container text-success">Personal Documents</h5>
                <div class="row container ml-5 col-lg-12">
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="addProof" value="Address Proof">
                        <label class="form-check-label" for="addProof">Address Proof</label>
                    </div>
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="psPhoto" value="Passport size photograph">
                        <label class="form-check-label" for="psPhoto">Passport size photograph</label>
                    </div>
                </div>
                <h5 class="display-5 container text-success">Academic Documents</h5>
                <div class="row container ml-5 col-lg-12">
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="appForm" value="Application Form">
                        <label class="form-check-label" for="appForm">Application Form</label>
                    </div>
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="marksheet10" value="10TH Marksheet">
                        <label class="form-check-label" for="marksheet10">10TH Marksheet</label>
                    </div>
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="marksheet12" value="12TH Marksheet">
                        <label class="form-check-label" for="marksheet12">12TH Marksheet</label>
                    </div>
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="marksheetUG" value="UG Marksheet">
                        <label class="form-check-label" for="marksheetUG">UG Marksheet</label>
                    </div>
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="degreeUG" value="UG Degree">
                        <label class="form-check-label" for="degreeUG">UG Degree</label>
                    </div>
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="marksheetPG" value="PG Marksheet">
                        <label class="form-check-label" for="marksheetPG">PG Marksheet</label>
                    </div>
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="degreePG" value="PG Degree">
                        <label class="form-check-label" for="degreePG">PG Degree</label>
                    </div>
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="resume" value="Resume">
                        <label class="form-check-label" for="resume">Resume</label>
                    </div>
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="expCerti" value="Work Experience Certificate">
                        <label class="form-check-label" for="expCerti">Work Experience Certificate</label>
                    </div>
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="extCerti" value="Extra Certification">
                        <label class="form-check-label" for="extCerti">Extra Certification</label>
                    </div>
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="sop" value="SOP">
                        <label class="form-check-label" for="sop">SOP</label>
                    </div>
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="lor" value="LOR">
                        <label class="form-check-label" for="lor">LOR</label>
                    </div>
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="itg" value="IELTS or TOEFL or GRE">
                        <label class="form-check-label" for="itg">IELTS or TOEFL or GRE</label>
                    </div>
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="passport" value="Passport">
                        <label class="form-check-label" for="passport">Passport</label>
                    </div>
                </div>
                <h5 class="display-5 container text-success">Experience Documents</h5>
                <div class="row container ml-5 col-lg-12">
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="birthCerti" value="Birth Certificate">
                        <label class="form-check-label" for="birthCerti">Birth Certificate</label>
                    </div>
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="financialDoc" value="Financial Documents">
                        <label class="form-check-label" for="financialDoc">Financial Documents</label>
                    </div>
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="rspos" value="Relationship Proof of Sponsor">
                        <label class="form-check-label" for="rspos">Relationship Proof of Sponsor</label>
                    </div>
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="feeR" value="Fee Receipt or Fee Draft or Telegraphic Transfer">
                        <label class="form-check-label" for="feeR">Fee Receipt or Fee Draft or Telegraphic Transfer</label>
                    </div>
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="coe" value="120 or COE">
                        <label class="form-check-label" for="coe">120 or COE</label>
                    </div>
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="aip" value="PVA or AIP">
                        <label class="form-check-label" for="aip">PVA or AIP</label>
                    </div>
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="degreePG" value="Marriage Certificate">
                        <label class="form-check-label" for="degreePG">Marriage Certificate</label>
                    </div>
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="refForm" value="Refund Form">
                        <label class="form-check-label" for="refForm">Refund Form</label>
                    </div>
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="accForm" value="Acceptance Form">
                        <label class="form-check-label" for="accForm">Acceptance Form</label>
                    </div>
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="ohsc" value="OHSC">
                        <label class="form-check-label" for="ohsc">OHSC</label>
                    </div>
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="defForm" value="Defferal Form Sent to University">
                        <label class="form-check-label" for="defForm">Defferal Form Sent to University</label>
                    </div>
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="prefForm" value="Change of Preference Form">
                        <label class="form-check-label" for="prefForm">Change of Preference Form</label>
                    </div>
                </div>
                <h5 class="display-5 container text-success">Offer Letter</h5>
                <div class="row container ml-5 col-lg-12">
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="visaFile" value="Visa File">
                        <label class="form-check-label" for="visaFile">Visa File</label>
                    </div>
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="visaCopy" value="Visa Copy">
                        <label class="form-check-label" for="visaCopy">Visa Copy</label>
                    </div>
                </div>
                <h5 class="display-5 container text-success">Visa Documents</h5>
                <div class="row container ml-5 col-lg-12">
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="offerLetter" value="Offer Letter">
                        <label class="form-check-label" for="offerLetter">Offer Letter</label>
                    </div>
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="defOfferLetter" value="Defer Offer Letter">
                        <label class="form-check-label" for="defOfferLetter">Defer Offer Letter</label>
                    </div>
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="rejLetter" value="Rejection Letter">
                        <label class="form-check-label" for="rejLetter">Rejection Letter</label>
                    </div>
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="withdrawlLetter" value="Withdrawl Letter">
                        <label class="form-check-label" for="withdrawlLetter">Withdrawl Letter</label>
                    </div>
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="agentLetter" value="Agent Authorisation Letter">
                        <label class="form-check-label" for="agentLetter">Agent Authorisation Letter</label>
                    </div>
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="ackLetter" value="Acknowledgement Letter">
                        <label class="form-check-label" for="ackLetter">Acknowledgement Letter</label>
                    </div>
                    <div class="form-group col-lg-3">
                        <input class="form-check-input" type="checkbox" id="lateLetter" value="Late Arrival Letter">
                        <label class="form-check-label" for="lateLetter">Late Arrival Letter</label>
                    </div>
                    <div class="form-group col-lg-12 mt-3">
                        <div id="success-alert" class="alert alert-success" style="display:none;">
                            <strong></strong>
                        </div>
                    </div>
                </div>
                <div class="container mt-4">
                    <button type="button" name="btnSend" id="btnSend" class="btn btn-dark btn-sm col-lg-12">Save Documents</button>
                </div>
            </form>
        </div>              
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/cookie.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/documents-set.js"></script>
        <script>
var pathArray = window.location.pathname.split('/');
var base_url = window.location.origin + '/' + window.location.pathname.split ('/') [1];
//--------------------------------------------------------------------------------------
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
            
            newUser.onclick = function (e) {
                
                window.location.replace("/" + pathArray[1] + "/jsp/new-user.jsp");
            };

        </script>                
    </body>
</html>
