/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var pathArray = window.location.pathname.split('/');
var base_url = window.location.origin + '/' + window.location.pathname.split ('/') [1];
var id;

//--------------------------------------------------------------------------------------
//*********************************************************************************************
$(document).ready(function () {
    if (document.getElementById('filter').value.length == 0 || document.getElementById('filter').value.toString().length == 0) {
        id = sessionStorage.getItem("inquiryId");
        document.getElementById('filter').value = id;
        //setTimeout(sessionStorage.setItem("inquiryId",""),"10000")
    } else {
        id = document.getElementById('filter').value;
    }
    $(document).on('click', '#send', function (e) {
    e.preventDefault();
    
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {

            var xmlDoc = this.responseXML;
            var x = xmlDoc.getElementsByTagName("inquiry")[0];
            loadPic(id);
            
            document.getElementById('firstName').value = x.getElementsByTagName('firstName')[0].innerHTML;
            document.getElementById('lastName').value = x.getElementsByTagName('lastName')[0].innerHTML;
            document.getElementById('eMail').value = x.getElementsByTagName('emailId')[0].innerHTML;
            document.getElementById('mobileNo').value = x.getElementsByTagName('mobile')[0].innerHTML;
            document.getElementById('inquirySource').value = x.getElementsByTagName('inquirySource')[0].innerHTML;
            document.getElementById('gender').value = x.getElementsByTagName('gender')[0].innerHTML;
            document.getElementById('countryPreference').value = x.getElementsByTagName('country')[0].innerHTML;
            loadAnotherDoc(id);
            
        }
    };
    xmlhttp.open("GET", base_url+"/webresources/inquiry.inquiry/getInquiryById/" + id, true);
    xmlhttp.send();
});
});
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
function loadAnotherDoc(id) {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var xmlDoc = this.responseXML;
            var x = xmlDoc.getElementsByTagName("inquiryDetails")[0];
            var date1 = parseDate(x.getElementsByTagName('ieltsDate')[0].innerHTML);
            var date2 = parseDate(x.getElementsByTagName('gmatDate')[0].innerHTML);
            var date3 = parseDate(x.getElementsByTagName('satDate')[0].innerHTML);
            var date4 = parseDate(x.getElementsByTagName('toeflDate')[0].innerHTML);
            var date5 = parseDate(x.getElementsByTagName('greDate')[0].innerHTML);

            document.getElementById('dateTOEFL').value = date4;
            document.getElementById('dateIELTS').value = date1;
            document.getElementById('dateGRE').value = date5;
            document.getElementById('dateGMAT').value = date2;
            document.getElementById('dateSAT').value = date3;
            document.getElementById('perPG').value = x.getElementsByTagName('perPgDip')[0].innerHTML;
            document.getElementById('formType').value = x.getElementsByTagName('formType')[0].innerHTML;
            document.getElementById('passYearPG').value = x.getElementsByTagName('passyearPgDip')[0].innerHTML;
            document.getElementById('assigned').value = x.getElementsByTagName('assigned')[0].innerHTML;
            document.getElementById('namePG').value = x.getElementsByTagName('namePgDip')[0].innerHTML;
            document.getElementById('assignedTo').value = x.getElementsByTagName('assignedTo')[0].innerHTML;
            document.getElementById('awardingBodyPG').value = x.getElementsByTagName('awardPgDip')[0].innerHTML;
            document.getElementById('add1').value = x.getElementsByTagName('add1')[0].innerHTML;
            document.getElementById('durationPG').value = x.getElementsByTagName('durationPgDip')[0].innerHTML;
            document.getElementById('add2').value = x.getElementsByTagName('add2')[0].innerHTML;
            document.getElementById('perMasters').value = x.getElementsByTagName('perMasters')[0].innerHTML;
            document.getElementById('cityTown').value = x.getElementsByTagName('city')[0].innerHTML;
            document.getElementById('passYearMasters').value = x.getElementsByTagName('passyearMasters')[0].innerHTML;
            document.getElementById('state').value = x.getElementsByTagName('state')[0].innerHTML;
            document.getElementById('degreeNameMasters').value = x.getElementsByTagName('nameMasters')[0].innerHTML;
            document.getElementById('pin').value = x.getElementsByTagName('pincode')[0].innerHTML;
            document.getElementById('collegeMasters').value = x.getElementsByTagName('clgMasters')[0].innerHTML;
            document.getElementById('passport').value = x.getElementsByTagName('passportNo')[0].innerHTML;
            document.getElementById('durationMasters').value = x.getElementsByTagName('durationMasters')[0].innerHTML;
            document.getElementById('passport1').value = x.getElementsByTagName('addPassport1')[0].innerHTML;
            document.getElementById('backlogsMasters').value = x.getElementsByTagName('backlogsMasters')[0].innerHTML;
            document.getElementById('passport2').value = x.getElementsByTagName('addPassport2')[0].innerHTML;
            document.getElementById('scoreTOEFL').value = x.getElementsByTagName('toeflScore')[0].innerHTML;
            document.getElementById('per10').value = x.getElementsByTagName('per10')[0].innerHTML;
            document.getElementById('mockTOEFL').value = x.getElementsByTagName('toeflMockScore')[0].innerHTML;
            document.getElementById('passYear10').value = x.getElementsByTagName('passyear10')[0].innerHTML;
            document.getElementById('per12').value = x.getElementsByTagName('per12')[0].innerHTML;
            document.getElementById('scoreIELTS').value = x.getElementsByTagName('ieltsScore')[0].innerHTML;
            document.getElementById('passYear12').value = x.getElementsByTagName('passyear12')[0].innerHTML;
            document.getElementById('mockIELTS').value = x.getElementsByTagName('ieltsMockScore')[0].innerHTML;
            document.getElementById('stream12').value = x.getElementsByTagName('stream12')[0].innerHTML;
            document.getElementById('perDiploma').value = x.getElementsByTagName('perDip')[0].innerHTML;
            document.getElementById('scoreGRE').value = x.getElementsByTagName('greScore')[0].innerHTML;
            document.getElementById('passYearDiploma').value = x.getElementsByTagName('passyearDip')[0].innerHTML;
            document.getElementById('mockGRE').value = x.getElementsByTagName('greMockScore')[0].innerHTML;
            document.getElementById('nameDiploma').value = x.getElementsByTagName('nameDip')[0].innerHTML;
            document.getElementById('awardingBodyDiploma').value = x.getElementsByTagName('awardDip')[0].innerHTML;
            document.getElementById('scoreGMAT').value = x.getElementsByTagName('gmatScore')[0].innerHTML;
            document.getElementById('durationDiploma').value = x.getElementsByTagName('durationDip')[0].innerHTML;
            document.getElementById('mockGMAT').value = x.getElementsByTagName('gmatMockScore')[0].innerHTML;
            document.getElementById('perBachelor').value = x.getElementsByTagName('perBach')[0].innerHTML;
            document.getElementById('passYearBachelor').value = x.getElementsByTagName('passyearBach')[0].innerHTML;
            document.getElementById('scoreSAT').value = x.getElementsByTagName('satScore')[0].innerHTML;
            document.getElementById('degreeNameBachelor').value = x.getElementsByTagName('nameBach')[0].innerHTML;
            document.getElementById('mockSAT').value = x.getElementsByTagName('satMockScore')[0].innerHTML;
            document.getElementById('collegeBachelor').value = x.getElementsByTagName('clgBach')[0].innerHTML;
            document.getElementById('durationBachelor').value = x.getElementsByTagName('durationBach')[0].innerHTML;
            document.getElementById('specialNote').value = x.getElementsByTagName('note')[0].innerHTML;
            document.getElementById('backlogsBachelor').value = x.getElementsByTagName('backlogsBach')[0].innerHTML;
            //alert(id);
            
        }
    };
    xmlhttp.open("GET", base_url+"/webresources/inquiry.inquirydetails/getInquiryById/" + id, true);
    xmlhttp.send();
}
;

//*********************************************************************************************
$(document).ready(function () {
    $(document).on('click', '#update-inquiry', function (e) {
        var id = document.getElementById('filter').value;
        var perPG = document.getElementById('perPG').value;
        var formType = document.getElementById('formType').value;
        var passYearPG = document.getElementById('passYearPG').value;
        var assigned = document.getElementById('assigned').value;
        var namePG = document.getElementById('namePG').value;
        var assignedTo = document.getElementById('assignedTo').value;
        var awardingBodyPG = document.getElementById('awardingBodyPG').value;
        var add1 = document.getElementById('add1').value;
        var durationPG = document.getElementById('durationPG').value;
        var add2 = document.getElementById('add2').value;
        var perMasters = document.getElementById('perMasters').value;
        var cityTown = document.getElementById('cityTown').value;
        var passYearMasters = document.getElementById('passYearMasters').value;
        var state = document.getElementById('state').value;
        var degreeNameMasters = document.getElementById('degreeNameMasters').value;
        var pin = document.getElementById('pin').value;
        var collegeMasters = document.getElementById('collegeMasters').value;
        var passport = document.getElementById('passport').value;
        var durationMasters = document.getElementById('durationMasters').value;
        var passport1 = document.getElementById('passport1').value;
        var backlogsMasters = document.getElementById('backlogsMasters').value;
        var passport2 = document.getElementById('passport2').value;
        var scoreTOEFL = document.getElementById('scoreTOEFL').value;
        var per10 = document.getElementById('per10').value;
        var mockTOEFL = document.getElementById('mockTOEFL').value;
        var passYear10 = document.getElementById('passYear10').value;
        var dateTOEFL = document.getElementById('dateTOEFL').value;
        var per12 = document.getElementById('per12').value;
        var scoreIELTS = document.getElementById('scoreIELTS').value;
        var passYear12 = document.getElementById('passYear12').value;
        var mockIELTS = document.getElementById('mockIELTS').value;
        var stream12 = document.getElementById('stream12').value;
        var dateIELTS = document.getElementById('dateIELTS').value;
        var perDiploma = document.getElementById('perDiploma').value;
        var scoreGRE = document.getElementById('scoreGRE').value;
        var passYearDiploma = document.getElementById('passYearDiploma').value;
        var mockGRE = document.getElementById('mockGRE').value;
        var nameDiploma = document.getElementById('nameDiploma').value;
        var dateGRE = document.getElementById('dateGRE').value;
        var awardingBodyDiploma = document.getElementById('awardingBodyDiploma').value;
        var scoreGMAT = document.getElementById('scoreGMAT').value;
        var durationDiploma = document.getElementById('durationDiploma').value;
        var mockGMAT = document.getElementById('mockGMAT').value;
        var perBachelor = document.getElementById('perBachelor').value;
        var dateGMAT = document.getElementById('dateGMAT').value;
        var passYearBachelor = document.getElementById('passYearBachelor').value;
        var scoreSAT = document.getElementById('scoreSAT').value;
        var degreeNameBachelor = document.getElementById('degreeNameBachelor').value;
        var mockSAT = document.getElementById('mockSAT').value;
        var collegeBachelor = document.getElementById('collegeBachelor').value;
        var dateSAT = document.getElementById('dateSAT').value;
        var durationBachelor = document.getElementById('durationBachelor').value;
        var specialNote = document.getElementById('specialNote').value;
        var backlogsBachelor = document.getElementById('backlogsBachelor').value;

        $.ajax({
            data: {id: id,
                formType: formType, assigned: assigned,
                assignedTo: assignedTo, add1: add1,
                add2: add2, cityTown: cityTown,
                state: state, pin: pin,
                passport: passport, passport1: passport1,
                passport2: passport2, per10: per10,
                passYear10: passYear10, per12: per12,
                passYear12: passYear12, stream12: stream12,
                perDiploma: perDiploma, passYearDiploma: passYearDiploma,
                nameDiploma: nameDiploma, awardingBodyDiploma: awardingBodyDiploma,
                durationDiploma: durationDiploma, perBachelor: perBachelor,
                passYearBachelor: passYearBachelor, degreeNameBachelor: degreeNameBachelor,
                collegeBachelor: collegeBachelor, durationBachelor: durationBachelor,
                backlogsBachelor: backlogsBachelor, perPG: perPG,
                passYearPG: passYearPG, namePG: namePG,
                awardingBodyPG: awardingBodyPG, durationPG: durationPG,
                perMasters: perMasters, passYearMasters: passYearMasters,
                degreeNameMasters: degreeNameMasters, collegeMasters: collegeMasters,
                durationMasters: durationMasters, backlogsMasters: backlogsMasters,
                scoreTOEFL: scoreTOEFL, mockTOEFL: mockTOEFL,
                dateTOEFL: dateTOEFL, scoreIELTS: scoreIELTS,
                mockIELTS: mockIELTS, dateIELTS: dateIELTS,
                scoreGRE: scoreGRE, mockGRE: mockGRE,
                dateGRE: dateGRE, scoreGMAT: scoreGMAT,
                specialNote: specialNote, mockGMAT: mockGMAT,
                dateGMAT: dateGMAT, scoreSAT: scoreSAT,
                mockSAT: mockSAT, dateSAT: dateSAT
            },
            type: "put",
            url: base_url+"/webresources/inquiry.inquirydetails/addInquiryDetails",
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

$(document).ready(function () {
    $(document).on('click', '#convert', function (e) {
        var id = document.getElementById('filter').value;
        var input = document.querySelector('#file').files[0];
        var fData = new FormData();
        fData.append("file", input);
        fData.append("inquiryId", document.getElementById("filter").value);
        fData.append("documentName", document.getElementById("Profile Image").value);
        $.ajax({
            data: { id  : id  },
            type: "POST",
            url: base_url+"/webresources/inquiry.documents/uploadFile",
            success: function (data) {
                alert("success");
            },
            error: function (err) {
                alert(err);
            }
        });
 });
    });
    
    
//*********************************************************************************************
function loadPic(id) {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var xmlDoc = this.responseXML;
            var x = xmlDoc.getElementsByTagName('documentsPK');
            for(var i = 0; i<x.length; i++){
                var documentName = x[i].getElementsByTagName('documentName')[0].textContent.toString();
                var path = x[i].getElementsByTagName('path')[0].textContent;
                var res = path.split("\\");
                console.log("Image:"+res);
                var pathArray = window.location.pathname.split('/');
                var realPath = "/"+ pathArray[1] + "/images/"+res[8];
                if(documentName === "Passport size photograph"){
                    document.getElementById('profilePic').src = realPath;
                }
            }
            
        }
    };
    xmlhttp.open("GET", base_url+"/webresources/inquiry.documents/getDocumentsList/" + id, true);
    xmlhttp.send();
}
;

//*********************************************************************************************