const API_URL = "http://localhost:8080/tasks";

fetch(API_URL)
    .then(function(response) {
        return response.json();
    })
    .then(function(data){
        let table = document.getElementById('table');
        let count = 0;
        data.forEach(n => {
            var row = table.insertRow();
            var cell = row.insertCell(0);
            cell.innerHTML = data[count].description;
            cell.setAttribute('id',count);
            count++;
        })
    })



