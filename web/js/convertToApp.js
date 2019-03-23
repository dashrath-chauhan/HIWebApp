/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function getCookieValue(a) {
    var b = document.cookie.match('(^|;)\\s*' + a + '\\s*=\\s*([^;]+)');
    return b ? b.pop() : '';
}

//*********************************************************************************************
$(document).ready(function () {
    $(document).on('click', '#convert', function (e) {
        var id = document.getElementById('inquiry-id').value;
        var email = getCookieValue("email");
        $.ajax({
            data: { id  : id, email: email  },
            type: "put",
            url: "http://localhost:46854/HIRestApp/webresources/inquiry.inquiry/convertToApplication",
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


