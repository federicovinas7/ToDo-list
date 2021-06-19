
let task={

    id: 1,
    description:"",
    done: true
}

let flag =0;


function editTask(){
   let pId = document.getElementById('idTask').value;
   let  pDescription = document.getElementById('description').value;
   let pDone = document.querySelector('.checkbox-modal:checked');

   
   if(pDone ===null)
   {
       pDone = 'false';
       
   }else{
       pDone = 'true';
   }
   task.id = pId;
   task.description =pDescription;
   task.done=pDone;

   
    var xhr = new XMLHttpRequest();
    xhr.open("PUT", 'http://localhost:8080/tasks', true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify(
    task
    ));
  //  flag=1;
    //if(flag===1){
        location.reload();
       // flag = 0;
   //}
}
