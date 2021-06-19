
let tarea={

    
    description:"",
    
}

let bandera = 0;

function newTask(){
    
    pDescription = document.getElementById('newDescription').value;
    
    tarea.description = pDescription;
var xhr = new XMLHttpRequest();
xhr.open("POST", 'http://localhost:8080/tasks', true);
xhr.setRequestHeader('Content-Type', 'application/json');
xhr.send(JSON.stringify(
    
    tarea
    
));


    location.reload();
  

}

