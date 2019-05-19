/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var pathArray = window.location.pathname.split('/');
var base_url = window.location.origin + '/' + window.location.pathname.split ('/') [1];
//--------------------------------------------------------------------------------------
$(document).ready(function () {
    $(document).on('click', '#getData', function (e) {
    var parsed = document.getElementById('inquiry-id').value;
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            thisDoc(this);
        }
    };
    xmlhttp.open("GET", base_url+"/webresources/inquiry.documentset/getDocumentsListById/" + parsed, true);
    xmlhttp.send();
});
});
//*********************************************************************************************
function thisDoc(xml) {
    var i;
    var xmlDoc = xml.responseXML;
    var x = xmlDoc.getElementsByTagName('documentSet');
    var application_table = '';
    var option = '<option>-----------------------Select Document to Delete------------------------</option>';
    for (i = 0; i < x.length; i++) {
        application_table += "<tr>";
        application_table += "<td>"+x[i].getElementsByTagName('inquiryId')[0].textContent+"</td>";
        application_table += "<td>"+x[i].getElementsByTagName('documentName')[0].textContent+"</td>";
        if(x[i].getElementsByTagName('status')[0].textContent == 0){
            application_table += "<td>Pending</td>";
        } else {
            application_table += "<td>Uploaded</td>";
            option += '<option>'+ x[i].getElementsByTagName('documentName')[0].innerHTML +'</option>';
        }
        application_table += "</tr>";
    }
    document.getElementById('documentName').innerHTML = option;
    document.getElementById("table-data").innerHTML = application_table;
    
}
//*********************************************************************************************
$(document).ready(function () {
    $(document).on('click', '#getDocs', function (e) {
        var xmlhttp = new XMLHttpRequest();
        var id = document.getElementById('inquiryId').value;
        xmlhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                myFunction(this);
            }
        };
        xmlhttp.open("GET", base_url+"/webresources/inquiry.documentset/findByInquiryIdAndStatus/"+id, true);
        xmlhttp.send();
    });
});

function myFunction(xml) {
    document.getElementById('documentName').innerHTML = '';
    var i;
    var xmlDoc = xml.responseXML;
    var x = xmlDoc.getElementsByTagName("documentSet");
    var option = '';
    for (i = 0; i < x.length; i++) {
        option += '<option>'+ x[i].getElementsByTagName('documentName')[0].innerHTML +'</option>';
    }
    document.getElementById('documentName').innerHTML = option;
}
//*********************************************************************************************

$(document).ready(function () {
    $(document).on('click', '#getUploadedDocs', function (e) {
        var id = document.getElementById('inquiry-id').value;
        var documentName = document.getElementById('documentName').value;
        $.ajax({
            data: { inquiryId  : id, documentName: documentName  },
            type: "PUT",
            url: base_url+"/webresources/inquiry.documents/deleteDocument",
            success: function (data) {
                //alert("success");
                document.getElementById('success-alert').textContent = data;
                document.getElementById('success-alert').style = "block";
            },
            error: function (err) {
                //alert(err);
                document.getElementById('success-alert').style = "block";
            }
        });
    });
});

//*********************************************************************************************
