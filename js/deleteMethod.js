
let URL = "http://localhost:8080/tasks";



function deleteTask(id){

    URL = URL +'/'+ id;

    fetch(URL, {
  method: 'DELETE',
})


};




