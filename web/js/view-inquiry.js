/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var pathArray = window.location.pathname.split('/');
var base_url = window.location.origin + '/' + window.location.pathname.split ('/') [1];
//------------------------------------------------------------------------------------
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
    xmlhttp.open("GET", base_url+"/webresources/inquiry.inquiry/getAllInquiries", true);
    xmlhttp.send();
}
function myFunction(xml) {
    var i;
    var xmlDoc = xml.responseXML;
    var application_table = '';
    var y = xmlDoc.getElementsByTagName("inquiry");
    for (i = 0; i < y.length; i++) {
        application_table += "<tr>";
        application_table += '<td class="id"><button type="button" name="hold" class="btn btn-outline-success my-2 my-sm-0" id="' + y[i].getElementsByTagName('id')[0].innerHTML+ '">' + y[i].getElementsByTagName('id')[0].innerHTML+ '</button></td>';
        application_table += "<td>" + y[i].getElementsByTagName('firstName')[0].innerHTML + " " + y[i].getElementsByTagName('lastName')[0].innerHTML +"</td>";
        application_table += "<td>" + y[i].getElementsByTagName('mobile')[0].innerHTML + "</td>";
        application_table += "<td>" + y[i].getElementsByTagName('emailId')[0].innerHTML + "</td>";
        application_table += "<td>" + y[i].getElementsByTagName('inquirySource')[0].innerHTML + "</td>";
        application_table += "<td>" + y[i].getElementsByTagName('gender')[0].innerHTML + "</td>";
        application_table += "<td>" + parseDate(y[i].getElementsByTagName('dateTime')[0].innerHTML) + "</td>";
        application_table += '<td class="hold"><button type="button" name="hold" class="btn btn-dark my-2 my-sm-0" id="'+y[i].getElementsByTagName("id")[0].innerHTML+'">Hold</button></td>';
        application_table += "</tr>";
        document.getElementById("table-data").innerHTML = application_table;
    }
}

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
//*****************************************************************************

$(document).ready(function () {
    $('#table-data').on("click", "td.hold", function(e) {
        var inquiryId = this.firstChild.getAttribute('id');
        var email = getCookieValue("email");
        $.ajax({
            data: { inquiryId  : inquiryId, email: email  },
            type: "put",
            url: base_url+"/webresources/inquiry.inquiry/putOnHold",
            success: function (data) {
                alert(data);
                loadXMLDoc();
            },
            error: function (err) {
                alert("Failed to hold application.");
            }
        });
    });
});
//-------------------------------------------------------------------------------

//*****************************************************************************
//*****************************************************************************

$(document).ready(function () {
    $('#table-data').on("click", "td.id", function(e) {
        var inquiryId = this.innerText;
        document.cookie = "inquiryId=" + inquiryId + ";";
        sessionStorage.setItem("inquiryId", inquiryId);
        window.location.replace("/" + pathArray[1] + "/jsp/inquiry-details.jsp");
    });
});
//-------------------------------------------------------------------------------
//*****************************************************************************