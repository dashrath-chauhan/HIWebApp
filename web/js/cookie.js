/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var pathArray = window.location.pathname.split('/');
var base_url = window.location.origin + '/' + window.location.pathname.split ('/') [1];
//--------------------------------------------------------------------------------------

$( document ).ready(function() {
    $(document).on('click', '#lobtn', function (e) {
        document.cookie = "email=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;domain=localhost;";
        window.location.replace("/" + pathArray[1] + "/index.jsp");
    });

    function getCookieValue(a) {
        var b = document.cookie.match('(^|;)\\s*' + a + '\\s*=\\s*([^;]+)');
        return b ? b.pop() : '';
    }

    var email = getCookieValue("email");
    //alert(email);
    if (email != "") {

    } else {
        window.location.replace("/" + pathArray[1] + "/index.jsp");
    }
});

