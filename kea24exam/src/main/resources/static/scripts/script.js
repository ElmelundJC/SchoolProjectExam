function preventStudent(form){
    form.submit(function (event){
        event.preventDefault(); // forhindrer at formen bliver sendt
        createStudent($("#name").val(), $("#email").val(), $("#supervisor_id").val());
        getStudent();
    })
}

function preventCreateUserFromSending(form){
    form.submit(function (event){
        event.preventDefault(); //forhindre at formen bliver sendt
        createStudent($("#studentName").val()) // hent value fra <input>
    });
}

function getStudent(){
    console.log("getStudent er kaldt");
    $("#tablename").empty();
    $("#tableemail").empty();
    $("#tablesupervisor").empty();

    $.ajax({
        url:"/api/studentservice",
        type:"POST",
        contentType:"application/JSON",
        success: function (data){
            $.each(data.studentList, function (index,value){
                $("#tablename").append("<div>" + value.name +
                    "</div>");
                $("#tableemail").append("<div>" + value.email +
                    "</div>");
                var name = value.supervisor.supervisorName
                $("#tablesupervisor").append("<div>" + name +
                    "</div>");

            })
            //$("#status").html("Server: Student OK");
        },
        error:function (data){
            console.log("ERROR i svar fra server");
            $("#status").html("ERROR i svar fra server");
        }
    });
}


function createStudent(name, email, supervisor_id){
    console.log("createStudent er kaldt");
//AJAX request
    var object2 = {};
    object2["supervisor_id"] = supervisor_id;
    var object1 = {};
    object1["name"] = name;
    object1["email"] = email;
    object1["supervisor"] = object2;
    $.ajax({
        url:"/api/createstudent",
        type:"POST",
        contentType:"application/JSON",
        data: JSON.stringify(object1),
        success:function (data){
            location.reload();
            /*$("#student").prepend("<div>" + data.name.pop().name +
                "</div>")
            $("#email").prepend("<div>" + data.email.pop().email + "</div>")
            $("#supervisor_id").prepend("<div>" + data.supervisor_id.pop().supervisor + "</div>")
            $("#status").html("Server: Student OK");*/
            //refreshDiv();
        },
        error:function (data){
            console.log("ERROR i svar fra server");
            $("#status").html("ERROR i svar fra server");
        }
    });
}


function checkQuery(){
    if(typeof jQuery !== undefined){
        console.log("jQuery er loaded")
    } else {
        console.log("jQuery er IKKE loaded")
    }
}


/*function refreshDiv(){
    var container = document.getElementById("refresh-page");
    var content = container.innerHTML;
    container.innerHTML= content;
}
*/