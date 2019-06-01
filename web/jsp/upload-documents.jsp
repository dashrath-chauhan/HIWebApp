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
        <title>Upload Documents - Heer International</title>
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
            <h3 class="display-5 text-center">Upload Documents:</h3>
            <form class="col-lg-6 container col-md-6 col-md-offset-6" method="post" action=base_url+"/webresources/inquiry.documents/uploadFile" enctype="multipart/form-data">
                <div class="row">
                    <hr class="my-5 container mt-0">
                    <div class="form-group col-lg-12">
                        <input type="text" id="path" class="form-control" placeholder="Inquiry Id" hidden="true" value="<%=request.getContextPath()%>/images">
                    </div>
                    <div class="form-group col-lg-8">
                        <input type="text" id="inquiryId" class="form-control" placeholder="Inquiry Id">
                    </div>
                    <div class="form-group col-lg-4">
                        <button class="btn btn-dark my-2 my-sm-0" id="getDocs" type="button">Get Documents List</button>
                    </div>
                    <div class="form-group col-lg-12 mt-3 text-primary">
                        <select class="form-control text-primary" id="documentName">
                        </select>
                    </div>
                    
                    <div class="form-group col-lg-12 mb-3 ml-3 mt-2 text-primary">
                        <input type="file" class="custom-file-input" id="file">
                        <label class="custom-file-label" for="customFile">Choose file</label>
                    </div>
                    
                    <div class="form-group col-lg-12 mt-3">
                        <div id="success-alert" class="alert alert-success" style="display:none;">
                            <strong></strong>
                        </div>
                    </div>
                    <div class="form-group col-lg-12 mt-3">
                        <div id="danger-alert" class="alert alert-danger" style="display:none;">
                            <strong></strong>
                        </div>
                    </div>
                    <div class="container mt-0">
                        <button type="button" name="btnSend" id="btnSend" onclick="send()" class="btn btn-dark btn-sm col-lg-12">Upload</button>
                    </div>
                    <hr class="my-5 container mt-0">
                    
                </div>
            </form>

        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/cookie.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/documents.js"></script>
        <script>
            var pathArray = window.location.pathname.split('/');
var base_url = window.location.origin + '/' + window.location.pathname.split ('/') [1];
//--------------------------------------------------------------------------------------
                            function send() {
                                var xhttp = new XMLHttpRequest();
                                xhttp.open("POST", base_url+"/webresources/inquiry.documents/uploadFile", false)
                                var input = document.querySelector('#file').files[0];
                                var fData = new FormData();
                                fData.append("file", input);
                                fData.append("inquiryId", document.getElementById("inquiryId").value);
                                fData.append("documentName", document.getElementById("documentName").value);
                                xhttp.send(fData);
                                document.getElementById('success-alert').textContent = document.getElementById("documentName").value + " uploaded";
                                document.getElementById('success-alert').style = "block";
                            }
                            
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