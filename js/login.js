const API_LOGIN = "http://localhost:8080/user/login";



//button
document.getElementById('loginButton').addEventListener("click",login);

function login (username,password)
{
        username = document.getElementById('loginUsername').value;
        password = document.getElementById('loginPassword').value;
    



    fetch(API_LOGIN)
    .then(function(response) {
        return response.json();

    })
    if (response!=null){
        location.replace(UR)
    }
 

   /* if(username === user){

        if(password === pass){
            document.loginForm.submit();
        }
    }
    else{
        alert("incorrect user or password");
    }*/
}