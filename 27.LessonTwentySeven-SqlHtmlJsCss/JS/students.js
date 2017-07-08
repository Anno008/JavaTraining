var students = [
    { id: 1, name: "Jhon", surname: "Chrono" },
    { id: 2, name: "Wendy", surname: "Kvry" },
    { id: 3, name: "Bob", surname: "Rand" }
];


function displayStudents() {
    var studentsTable = document.getElementById("studentsTable");
    var studentsHTML = "<thead><tr><td>Id</td><td>Name</td><td>Surname</td><td>Commands</td></tr></thead>";
    studentsHTML += "<tbody>";
    for (var i = 0; i < students.length; i++) {
        studentsHTML += "<tr><td>" + students[i].id + "</td><td>" + students[i].name + "</td><td>" + students[i].surname + "</td><td>" + createStudentDeleteBtn(students[i].id) + "</td></tr>";
    }
    studentsHTML += "</tbody>";
    studentsTable.innerHTML = studentsHTML;
    registerClickHandlers();
}

function registerClickHandlers() {
    var rows = document.querySelectorAll("table tbody tr");
    for (var i = 0; i < rows.length; i++) {
        rows[i].onclick = (function () {
            var id = rows[i].children[0].innerHTML;
            return function () {
                var st = findStudent(id);
                document.getElementById("studentInfo").innerHTML = "<p>Id: " + st.id + "<br/>Name: " + st.name + "<br/>Surname: " + st.surname + "</p>";
            }
        }());
    }
}

function createStudent() {
    var name = document.getElementById("nameTxt").value;
    var surname = document.getElementById("surnameTxt").value;
    var ele = document.getElementById("info");
    if (name === "") {
        ele.innerHTML = "You need to enter the students name";
        document.getElementById("nameTxt").focus();
        return;
    }
    if (surname === "") {
        ele.innerHTML = "You need to enter the students surname";
        document.getElementById("surnameTxt").focus();
        return;
    }

    var id = 1;
    for (var i = 0; i < students.length; i++) {
        if (id <= students[i].id) {
            id = students[i].id + 1;
        }
    }

    students.push({ id: id, name: name, surname: surname });
    ele.innerHTML = "Student created";
    displayStudents();
    document.getElementById("nameTxt").value = "";
    document.getElementById("surnameTxt").value = "";
}

function createStudentDeleteBtn(id) {
    return '<input type="button" value="Delete student" onClick="deleteStudent(\'' + id + '\')"/>';
}

function deleteStudent(id) {
    for (i in students) {
        if (students[i].id == id) {
            students.splice(i, 1);
            break;
        }
    }
    displayStudents();
}

function findStudent(id) {
    for (var i = 0; i < students.length; i++) {
        if (students[i].id == id) {
            return students[i];
        }
    }
}