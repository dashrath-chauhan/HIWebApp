/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//*********************************************************************************************
$(document).ready(function () {
    $(document).on('click', '#generateReport', function (e) {
        var id = document.getElementById('inquiry-id').value;
        $.ajax({
            data: { inquiryId  : id },
            type: "put",
            url: "http://localhost:46854/HIRestApp/webresources/usermodel.users/basicReport",
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


//*********************************************************************************************
$(document).ready(function () {
    $(document).on('click', '#createReport', function (e) {
        var dateFrom = parseDate(document.getElementById('dateFrom').value);
        var dateTo = parseDate(document.getElementById('dateTo').value);
        $.ajax({
            data: { dateFrom  : dateFrom, 
                    dateTo: dateTo },
            type: "put",
            url: "http://localhost:46854/HIRestApp/webresources/usermodel.users/briefReport",
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