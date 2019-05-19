/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var pathArray = window.location.pathname.split('/');
var base_url = window.location.origin + '/' + window.location.pathname.split ('/') [1];
//--------------------------------------------------------------------------------------
//*********************************************************************************************
function getCookieValue(a) {
    var b = document.cookie.match('(^|;)\\s*' + a + '\\s*=\\s*([^;]+)');
    return b ? b.pop() : '';
}
//*********************************************************************************************
var form = document.getElementById('search-form');
form.addEventListener('submit', fillForm);

function fillForm(e) {
    e.preventDefault();

    //get input value
    var id = document.getElementById('filter').value;
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            
            var xmlDoc = this.responseXML;
            var x = xmlDoc.getElementsByTagName("inquiry")[0];
            
            document.getElementById('firstName').value = x.getElementsByTagName('firstName')[0].innerHTML;
            document.getElementById('lastName').value = x.getElementsByTagName('lastName')[0].innerHTML;
            document.getElementById('eMail').value = x.getElementsByTagName('emailId')[0].innerHTML;
            document.getElementById('mobileNo').value = x.getElementsByTagName('mobile')[0].innerHTML;
            document.getElementById('inquirySource').value = x.getElementsByTagName('inquirySource')[0].innerHTML;
            document.getElementById('gender').value = x.getElementsByTagName('gender')[0].innerHTML;
            document.getElementById('countryPreference').value = x.getElementsByTagName('country')[0].innerHTML;
            
        }
    };
    xmlhttp.open("GET", base_url+"/webresources/inquiry.inquiry/getInquiryById/" + id, true);
    xmlhttp.send();
}
//*********************************************************************************************


//*********************************************************************************************
$(document).ready(function () {
    $(document).on('click', '#create-inquiry', function (e) {

        var firstName = document.getElementById('firstName').value;
        var lastName = document.getElementById('lastName').value;
        var eMail = document.getElementById('eMail').value;
        var mobileNo = document.getElementById('mobileNo').value;
        var inquirySource = document.getElementById('inquirySource').value;
        var gender = document.getElementById('gender').value;
        var countryPreference = document.getElementById('countryPreference').value;
        var createdBy = getCookieValue('email');
        $.ajax({
            data: {firstName: firstName, lastName: lastName,
                email: eMail, mobileNo: mobileNo,
                inquirySource: inquirySource, gender: gender,
                countryPreference: countryPreference, createdBy: createdBy},
            type: "post",
            url: base_url+"/webresources/inquiry.inquiry/createInquiry",
            success: function (data) {
                document.getElementById('success-alert').textContent = data;
                document.getElementById('success-alert').style = "block";
                var frm = document.getElementsByName('inquiry-form')[0];
                frm.reset();
            },
            error: function (err) {
                document.getElementById('success-alert').style = "none";
            }
        });
    });
});
//*********************************************************************************************

//*********************************************************************************************
$(document).ready(function () {
    $(document).on('click', '#update-inquiry', function (e) {
        var id = document.getElementById('filter').value;
        var firstName = document.getElementById('firstName').value;
        var lastName = document.getElementById('lastName').value;
        var eMail = document.getElementById('eMail').value;
        var mobileNo = document.getElementById('mobileNo').value;
        var inquirySource = document.getElementById('inquirySource').value;
        var gender = document.getElementById('gender').value;
        var countryPreference = document.getElementById('countryPreference').value;

        $.ajax({
            data: {firstName: firstName, lastName: lastName,
                email: eMail, mobileNo: mobileNo,
                inquirySource: inquirySource, gender: gender,
                countryPreference: countryPreference, id: id},
            type: "put",
            url: base_url+"/webresources/inquiry.inquiry/updateInquiry",
            success: function (data) {
                document.getElementById('success-alert').textContent = data;
                document.getElementById('success-alert').style = "block";
                var frm = document.getElementsByName('inquiry-form')[0];
                frm.reset();
            },
            error: function (err) {
                document.getElementById('success-alert').style = "none";
            }
        });
    });
});
//*********************************************************************************************


