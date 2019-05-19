/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var pathArray = window.location.pathname.split('/');
var base_url = window.location.origin + '/' + window.location.pathname.split ('/') [1];
//--------------------------------------------------------------------------------------
//*********************************************************************************************
function parseDate(date) {
    var today = new Date(date);
    var dd = today.getDate();
    var mm = today.getMonth() + 1;
    var yyyy = today.getFullYear();
    var m = today.getMinutes();
    var h = today.getHours();
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
    today = yyyy + '/' + mm + '/' + dd + ' ' + h + ':' + m;
    return today;
}

//*********************************************************************************************
function getCookieValue(a) {
    var b = document.cookie.match('(^|;)\\s*' + a + '\\s*=\\s*([^;]+)');
    return b ? b.pop() : '';
}

    
//*********************************************************************************************
$(document).ready(function () {
    $(document).on('click', '#followup-button', function (e) {
        var id = document.getElementById('inquiry-id').value;
        var email = getCookieValue("email");
        var type = document.getElementById('followup-type').value;
        var status = document.getElementById('followup-status').value;
        var strength = document.getElementById('strength').value;
        var description = document.getElementById('description').value;
        var nextDate = document.getElementById('nextFollowUpDate').value;

        $.ajax({
            data: {id: id,
                type: type, email: email,
                status: status, strength: strength,
                description: description, nextDate: nextDate
            },
            type: "post",
            url: base_url+"/webresources/followup.followup/createFollowUp",
            success: function (data) {
                alert(data);
//                document.getElementById('success-alert').textContent = data;
//                document.getElementById('success-alert').style = "block";
                var frm = document.getElementsByName('inquiry-form')[0];
                frm.reset();
            },
            error: function (err) {
                alert(err);
            }
        });
    });
});
//*********************************************************************************************