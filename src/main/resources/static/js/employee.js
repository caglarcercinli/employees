"use strict";
const employeesUrl = "https://caglaremployees.herokuapp.com/employees";
readEmployees();
async function readEmployees() {
    const response = await fetch(employeesUrl);
    if (response.ok) {
        showEmployees(await response.json());
    } else {
        technicalError();
    }
}
function showEmployees(employees) {
    const table = document.getElementById("employees");
    for (const employee of employees) {
        const tr = document.createElement("tr");
        //
        const tdId = document.createElement("td");
        var idNode = document.createTextNode(employee.id);
        tdId.appendChild(idNode);
        tr.appendChild(tdId);
        //
        const tdFirstName = document.createElement("td");
        var nameNode = document.createTextNode(employee.firstName);
        tdFirstName.appendChild(nameNode);
        tr.appendChild(tdFirstName);
        //
        const tdLastName = document.createElement("td");
        var nameNode = document.createTextNode(employee.lastName);
        tdLastName.appendChild(nameNode);
        tr.appendChild(tdLastName);
        //
        const tdEmail = document.createElement("td");
        var emailNode = document.createTextNode(employee.email);
        tdEmail.appendChild(emailNode);
        tr.appendChild(tdEmail);
        //
        table.appendChild(tr);
    }
}
function technicalError() {
    document.getElementById("error").hidden = false;
}
