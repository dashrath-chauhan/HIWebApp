/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
    xmlhttp.open("GET", "http://localhost:46854/HIRestApp/webresources/inquiry.inquiry/getAllInquiries", true);
    xmlhttp.send();
}
function myFunction(xml) {
    var i;
    var xmlDoc = xml.responseXML;
    var table = '';
    var y = xmlDoc.getElementsByTagName("inquiry");
    for (i = 0; i < y.length; i++) {
        table += "<tr>";
        table += "<td>" + y[i].getElementsByTagName('id')[0].innerHTML + "</td>";
        table += "<td>" + y[i].getElementsByTagName('firstName')[0].innerHTML + " " + y[i].getElementsByTagName('lastName')[0].innerHTML +"</td>";
        table += "<td>" + y[i].getElementsByTagName('mobile')[0].innerHTML + "</td>";
        table += "<td>" + y[i].getElementsByTagName('emailId')[0].innerHTML + "</td>";
        table += "<td>" + y[i].getElementsByTagName('inquirySource')[0].innerHTML + "</td>";
        table += "<td>" + y[i].getElementsByTagName('gender')[0].innerHTML + "</td>";
        table += "<td>" + parseDate(y[i].getElementsByTagName('dateTime')[0].innerHTML) + "</td>";
        table += "</tr>";
        document.getElementById("table-data").innerHTML = table;
    }
}

//function to filter table data
var filter = document.getElementById('filter');
filter.addEventListener('keyup', filterItems);
function filterItems(e) {
    var filterText = e.target.value.toLowerCase();
    var itemsList = document.getElementsByClassName('inquiry-id');

    Array.from(itemsList).forEach(function (item) {
        var itemName = item.textContent;
        if (itemName.toLowerCase().indexOf(filterText) != -1) {
            item.parentNode.style.display = 'block';
        } else {
            item.parentNode.style.display = 'none';
        }
    });
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
