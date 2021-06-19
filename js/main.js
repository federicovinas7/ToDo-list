const API_URL = "http://localhost:8080/tasks";

let trashButton = "<a href=''><i class='bx bxs-trash bx-md '></i></a>"
let editButton = "<a href='' data-bs-toggle='modal' data-bs-target='#modalModifyTask'><i class='bx bx-edit bx-md'></i></a>";
let removeButton = "remove"


let pId = document.getElementById('idTask');

fetch(API_URL)
    .then(function(response) {
        return response.json();
    })
    .then(function(data){
        
            
        let table = document.getElementById('task-table');
        let count = 0;
        data.forEach(n => {

    
            var row = table.insertRow();
            var cell = row.insertCell(0);
            cell.innerHTML = n.id;
            var cell1 = row.insertCell(1);
            cell1.innerHTML = n.description;
            var cell2 = row.insertCell(2);
            cell2.innerHTML = n.done;
            var cell3 = row.insertCell(3);
            cell3.innerHTML = editButton;
            cell3.setAttribute('onclick','assignId('+n.id+')');
            var cell4 = row.insertCell(4);
            cell4.innerHTML = trashButton;
            cell4.setAttribute('id',count);
            cell4.setAttribute('onclick','deleteTask('+n.id+')');
            count++;
        })
    })

    function assignId(id){

        pId.setAttribute('value',id);
    }
    
 //