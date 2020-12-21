function preventCreateFormFromSending(form){
    form.submit(function (event){
        event.preventDefault(); // forhindrer at formen bliver sendt
        getStudent();
    })
}

function preventCreateStudentFromSending(form){
    form.submit(function (event){
        event.preventDefault(); //forhindre at formen bliver sendt
        createStudent($("#studentName").val()) // hent value fra <input>
    });
}

function getStudent(){
    console.log("getStudent er kaldt");
    var $student = $('#student');
    $.ajax({
        url:"/api/studentservice",
        type:"POST",
        contentType:"application/JSON",
        success: function (data){
            $.each(data.student, function (index,value){
                $("#studentName").append("<div>" + value.studentName +
                "</div>")
                $("#email").append("<div>" + value.email + "</div>")
            })
            $("#status").html("Server: Student OK");
        },
        error:function (data){
            console.log("ERROR i svar fra server");
            $("#status").html("ERROR i svar fra server");
        }
    });
}


function createStudent(student){
    console.log("createStudent er kaldt");
    //AJAX request
    var createStudentObject = {};
    createStudentObject["studentName","email"] = student;
    var count = $("#student > div").length
    createStudentObject["count"] = count
    $.ajax({
        url:"api/createstudent",
        type:"POST",
        contentType:"application/JSON",
        data: JSON.stringify(createStudentObject),
        success:function (data){
            $("#student").prepend("<div>" + data.student.pop().studentName + "</div>"),
            $("#email").prepend("<div>" + data.email.pop().email + "</div>"),
            $("#status").html("Server: Student OK");
        },
        error:function (data){
            console.log("ERROR i svar fra server");
            $("#status").html("ERROR i svar fra server");
        }
    });
}


function checkQuery(){
    if(typeof jQuery != undefined){
        console.log("jQuery er loaded")
    } else {
        console.log("jQuery er IKKE loaded")
    }
}
