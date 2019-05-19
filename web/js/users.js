/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var pathArray = window.location.pathname.split('/');
var base_url = window.location.origin + '/' + window.location.pathname.split ('/') [1];
//*********************************************************************************************
$(document).ready(function () {
    $(document).on('click', '#isubmit', function (e) {
        var email = document.getElementById('email').value;
        var name = document.getElementById('name').value;
        var password = document.getElementById('password').value;
        var admin = document.getElementById('admin').value;
        alert(admin + "hi");
        $.ajax({
            data: {email: email, userName: name, password: password, admin: admin},
            type: "post",
            url: base_url+"/webresources/usermodel.users/createNewUser",
            success: function (data) {
                alert("User Created:" + name);
                loadXMLDoc();
            },
            error: function (err) {
                alert("error:" + err.toString());
            }
        });
    });
});
//*********************************************************************************************

//*********************************************************************************************
$(document).ready(function () {
    $(document).on('click', '#login-button', function (e) {
        var email = document.getElementById('email').value;
        var password = document.getElementById('password').value;
        
        $.ajax({
            data: {email: email, password: password},
            type: "post",
            url: base_url+"/webresources/usermodel.users/login",
            success: function (data) {
                var data = data.split(',');
                document.cookie = "email=" + data[0] + "; path=/;domain=localhost;";
                document.cookie = "password=" + data[1] + ";";
                document.cookie = "isadmin=" + data[2] + ";";
                window.location.replace("/" + pathArray[1] + "/jsp/view-application.jsp");
            },
            error: function (data) {
                console.log(base_url);
                alert("error");
            }
        });
    });
});
//*********************************************************************************************

//*********************************************************************************************
window.addEventListener("load", function () {
    loadXMLDoc();
});

function loadXMLDoc() {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            myFunction(this);
        }
    };
    xmlhttp.open("GET", base_url+"/webresources/usermodel.users/getAllUsers", true);
    xmlhttp.send();
}

function myFunction(xml) {
    var i;
    var xmlDoc = xml.responseXML;
    var table = '';
    var x = xmlDoc.getElementsByTagName("users");
    for (i = 0; i < x.length; i++) {
        table += "<tr>";
        var empDetails = x[i].children;
        for (j = 0; j < empDetails.length; j++) {
            switch (x[i].childNodes[j].nodeName) {
                case "email":
                    table += "<td>";
                    table += x[i].childNodes[0].firstChild.nodeValue;
                    table += "</td>";
                    break;
                case "name":
                    table += "<td>";
                    table += x[i].childNodes[3].firstChild.nodeValue;
                    table += "</td>";
                    break;
            }
        }
        table += "</tr>";
        document.getElementById("table-data").innerHTML = table;
    }
}
//*********************************************************************************************
function thisDoc(xml) {
    //alert("data1");
    var i;
    var xmlDoc = xml.responseXML;
    var table = '';
    var x = xmlDoc.getElementsByTagName('followUps');
    var y = x[0].getElementsByTagName('followUp');
    var inquiry_table = '';
    var application_table = '';
    var pathArray = window.location.pathname.split('/');
    for (i = 0; i < y.length; i++) {
            if(y[i].getElementsByTagName('leadType')[0].textContent == "A"){
                application_table += "<tr>";
                application_table += "<td>"+y[i].getElementsByTagName('inquiryId')[0].textContent+"</td>";
                application_table += "<td>"+y[i].getElementsByTagName('firstName')[0].textContent+" "+y[i].getElementsByTagName('lastName')[0].textContent+"</td>";
                application_table += "<td>"+y[i].getElementsByTagName('mobile')[0].textContent+"</td>";
                application_table += "</tr>";
            } else {
                inquiry_table += "<tr>";
                inquiry_table += "<td>"+y[i].getElementsByTagName('inquiryId')[0].textContent+"</td>";
                inquiry_table += "<td>"+y[i].getElementsByTagName('firstName')[0].textContent+" "+y[i].getElementsByTagName('lastName')[0].textContent+"</td>";
                inquiry_table += "<td>"+y[i].getElementsByTagName('mobile')[0].textContent+"</td>";
                inquiry_table += "</tr>";
            }
        
    }
    document.getElementById("inquiry-data").innerHTML = inquiry_table;
    document.getElementById("application-data").innerHTML = application_table;
}
//*********************************************************************************************
$(document).ready(function () {
    $(document).on('click', '#getFollowUps', function (e) {
        
        var date = document.getElementById('getFollowUpsDate').value;
        var parsed = parseDate(date);
        //alert(parsed);
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                //alert("data");
                thisDoc(this);
            }
        };
        xmlhttp.open("GET", base_url+"/webresources/inquiry.inquiry/todaysFollowUps/" + parsed, true);
        xmlhttp.send();
    });
});
//*********************************************************************************************
function parseDate(date) {
    var today = new Date(date);
    var dd = today.getDate();
    var mm = today.getMonth() + 1;
    var yyyy = today.getFullYear();
    var m = today.getMinutes();
    var h = today.getHours();
    var s = today.getSeconds();
    if (dd < 10) { dd = '0' + dd; }
    if (mm < 10) { mm = '0' + mm; }
    if (m < 10) { m = '0' + m; }
    if (h < 10) { h = '0' + h; }
    if (s < 10) { s = '0' + s; }
    //today = yyyy + '-' + mm + '-' + dd + ' ' + h + ':' + m;
    today = yyyy + '-' + mm + '-' + dd;
    return today;
}

//*****************************************************************************
    
    newUser.onclick = function (e) {
        var pathArray = window.location.pathname.split('/');
        window.location.replace("/" + pathArray[1] + "/jsp/new-user.jsp");
    };
//**************************************************************************************