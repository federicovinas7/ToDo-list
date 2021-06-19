const API_LOGIN = "http://localhost:8080/user/login";

let user = {
    username : "",
    password : ""
}

//button
document.getElementById('loginButton').addEventListener("click",login);

function login ()
{
    
        user.username = document.getElementById('loginUsername').value;
        user.password = document.getElementById('loginPassword').value;

    // HAGO UN POST AL ENDPOINT PARA LOGEARME
    var xhr = new XMLHttpRequest();
    xhr.open("POST", API_LOGIN, true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify(user));
    
    //ACA DEBERIA HACER UN FETCH DEL USER O DEL TOKEN VERIFICAR Y REDIRIGIR
}