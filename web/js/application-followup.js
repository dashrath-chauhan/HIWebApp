/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var pathArray = window.location.pathname.split('/');
var base_url = window.location.origin + '/' + window.location.pathname.split ('/') [1];
//--------------------------------------------------------------------------------------
window.addEventListener("load", function () {
    loadXMLDoc();
});
function loadXMLDoc() {
        
        var today = new Date();
        var parsed = parseDate(today);
        //alert("v" + parsed);
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                //alert("data");
                thisDoc(this);
            }
        };
        xmlhttp.open("GET", base_url+"/webresources/inquiry.inquiry/todaysApplicationsFollowUps", true);
        xmlhttp.send();
}
//*********************************************************************************************
function thisDoc(xml) {
    //alert("data1");
    var today = new Date();
    var parsed = parseDate(today);
    var i;
    var xmlDoc = xml.responseXML;
    var table = '';
    var x = xmlDoc.getElementsByTagName('followUps');
    var y = x[0].getElementsByTagName('followUp');
    var inquiry_table = '';
    for (i = 0; i < y.length; i++) {
        if(parseDate(y[i].getElementsByTagName('nextFollowupDate')[0].textContent) == parsed){
            inquiry_table += "<tr class='bg-success'>";
        } else {
            inquiry_table += "<tr>";
        }
        inquiry_table += "<td>" + y[i].getElementsByTagName('inquiryId')[0].textContent + "</td>";
        inquiry_table += "<td>" + y[i].getElementsByTagName('firstName')[0].textContent + " " + y[i].getElementsByTagName('lastName')[0].textContent + "</td>";
        inquiry_table += "<td>" + y[i].getElementsByTagName('mobile')[0].textContent + "</td>";
        inquiry_table += "</tr>"; 
    }
    document.getElementById("table-data").innerHTML = inquiry_table;
}
//*********************************************************************************************

//*********************************************************************************************
function parseDate(date) {
    var today = new Date(date);
    var dd = today.getDate();
    var mm = today.getMonth() + 1;
    var yyyy = today.getFullYear();
    var m = today.getMinutes();
    var h = today.getHours();
    var s = today.getSeconds();
    if (dd < 10) {
        dd = '0' + dd;
    }
    if (mm < 10) {
        mm = '0' + mm;
    }
    if (m < 10) {
        m = '0' + m;
    }
    if (h < 10) {
        h = '0' + h;
    }
    if (s < 10) {
        s = '0' + s;
    }
    //today = yyyy + '-' + mm + '-' + dd + ' ' + h + ':' + m;
    today = yyyy + '-' + mm + '-' + dd;
    return today;
}

//*****************************************************************************

$(document).ready(function () {
    $('#table-data').on("click", "tr", function(e) {
        var inquiryId = this.cells[0].innerHTML;
        document.getElementById("inquiryId").value = inquiryId;
        document.getElementById("form-header").style.display = "block";
        document.getElementById("follow-form").style.display = "block";
        document.getElementById("followups-details").style.display = "block";
        displayFollowUpDetails(inquiryId);
        loadXMLDoc(); 
    });
});
//-------------------------------------------------------------------------------
function displayFollowUpDetails(id) {
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                var xmlDoc = xmlhttp.responseXML;
                var i;
                var y = xmlDoc.getElementsByTagName("followupDetails");
                var data = '<h5 class="card-title text-center" id="inquiry-Id"><strong>Application Id: '+ y[0].getElementsByTagName('inquiryId')[0].innerHTML +'</strong></h5>';
                data += '<hr class="my-5 container"> ';
                for (i = 0; i < y.length; i++) {
                    data += '<p class="card-text" id="Followup-date"><strong>FollowUp Date: </strong>'+ parseDate(y[i].getElementsByTagName('lastFollowupDate')[0].innerHTML) +'</p>';
                    data += '<p class="card-text" id="Followup-by"><strong>FollowUp By: </strong>'+ y[i].getElementsByTagName('email')[0].innerHTML +'</p>';
                    data += '<p class="card-text" id="Followup-description"><strong>Description: </strong>'+ y[i].getElementsByTagName('description')[0].innerHTML +'</p>';
                    data += '<hr class="my-5 container"> ';
                }
                document.getElementById("followups-details").innerHTML = data;
                document.getElementsByClassName('card alert alert-info')[0].style.display = "block";
            }
        };
        xmlhttp.open("GET", base_url+"/webresources/followup.followupdetails/getAllInquiriesById/" + id, true);
        xmlhttp.send();
}
//-------------------------------------------------------------------------------
function getCookieValue(a) {
    var b = document.cookie.match('(^|;)\\s*' + a + '\\s*=\\s*([^;]+)');
    return b ? b.pop() : '';
}

    
//*********************************************************************************************
$(document).ready(function () {
    $(document).on('click', '#followup-button', function (e) {
        var id = document.getElementById('inquiryId').value;
        var email = getCookieValue("email");
        var type = document.getElementById('followup-type').value;
        var status = document.getElementById('followup-status').value;
        var strength = document.getElementById('strength').value;
        var description = document.getElementById('description').value;
        var nextDate = document.getElementById('getFollowUpsDate').value;

        $.ajax({
            data: {id: id,
                type: type, email: email,
                status: status, strength: strength,
                description: description, nextDate: nextDate
            },
            type: "post",
            url: base_url+"/webresources/followup.followup/createFollowUp",
            success: function (data) {
                //alert(data);
                document.getElementById('success-alert').textContent = "Inquiry Id: "+data;
                document.getElementById('success-alert').style.display = "block";
                var frm = document.getElementsByName('follow-form')[0];
                frm.reset();
            },
            error: function (err) {
                alert(err);
            }
        });
    });
});
//*********************************************************************************************
$(document).ready(function () {
    $(document).on('click', '#todayFollowUpReport', function (e) {
        var today = new Date();
        var date = parseDate(today);

        $.ajax({
            data: { date  : date },
            type: "put",
            url: base_url+"/webresources/usermodel.users/AfolowUpReport",
            success: function (data) {
                //alert("success");
                document.getElementById('success-report').textContent = data;
                document.getElementById('success-report').style.display = "block";
                var frm = document.getElementsByName('inquiry-form')[0];
                frm.reset();
            },
            error: function (err) {
                //alert(err);
                document.getElementById('success-alert').style.display = "none";
            }
        });
    });
});
//*********************************************************************************************
//*********************************************************************************************
$(document).ready(function () {
    $(document).on('click', '#completeFollowUpReport', function (e) {
        var today = new Date();
        var date = parseDate(today);

        $.ajax({
            data: { },
            type: "put",
            url: base_url+"/webresources/usermodel.users/completeAfolowUpReport",
            success: function (data) {
                //alert("success");
                document.getElementById('success-alert').textContent = data;
                document.getElementById('success-alert').style.display = "block";
                var frm = document.getElementsByName('inquiry-form')[0];
                frm.reset();
            },
            error: function (err) {
                //alert(err);
                document.getElementById('success-alert').style.display = "none";
            }
        });
    });
});
//*********************************************************************************************
