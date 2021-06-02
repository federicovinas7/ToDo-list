let username = document.querySelector.getElementsByTagName('username');
let password = document.querySelector.getElementsByTagName('password');

let user = "user";
let pass = "1234";

//button
document.getElementById('loginButton').addEventListener("click",login);

function login (username,password)
{

   
    if(username === user){

        if(password === pass){
            document.loginForm.submit();
        }
    }
    else{
        alert("incorrect user or password");
    }
}