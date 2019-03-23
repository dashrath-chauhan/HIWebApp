/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.addEventListener("load", function () {
    console.log("1");
    loadXMLDoc();
});

function loadXMLDoc() {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            console.log("2");
            myFunction(this);
            console.log("3");
        }
    };
    xmlhttp.open("GET", "http://localhost:46854/HIRestApp/webresources/followup.followup/getAllApplications", true);
    console.log("4");
    xmlhttp.send();
}
function myFunction(xml) {
    var xmlDoc = xml.responseXML;
    var y = xmlDoc.getElementsByTagName('followUp');
    var application_table = '';
    
    for (var i = 0; i < y.length; i++) {
            application_table += "<tr>";
            application_table += "<th>" + y[i].getElementsByTagName('convertedBy')[0].innerHTML + "</th>";
            application_table += "<th>" + parseDate(y[i].getElementsByTagName('convertedOn')[0].innerHTML) + "</th>";
            application_table += "<td>" + y[i].getElementsByTagName('inquiryId')[0].innerHTML + "</td>";
            application_table += "<td>" + y[i].getElementsByTagName('firstName')[0].innerHTML + " " + y[i].getElementsByTagName('lastName')[0].innerHTML + "</td>";
            application_table += "<td>" + y[i].getElementsByTagName('email')[0].innerHTML + "</td>";
            application_table += "<td>" + y[i].getElementsByTagName('mobile')[0].innerHTML + "</td>";
            application_table += "</tr>";
        }
    document.getElementById("table-data").innerHTML = application_table;
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