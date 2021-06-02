// Here they go some vars

let backBoxLogin = document.getElementById('backBoxLogin');
let backBoxRegister = document.getElementById('backBoxRegister');
let containerLoginRegister = document.getElementById('loginRegister');

let formLogin = document.getElementById('login');
let formRegister = document.getElementById('signIn');


// buttons

document.getElementById("btn-register").addEventListener("click",showRegister);
document.getElementById("btn-login").addEventListener("click",showLogin);

function showRegister(){
    formRegister.style.display="block";
    containerLoginRegister.style.left="650px";
    formLogin.style.display="none";
    backBoxRegister.style.opacity="0";
    backBoxLogin.style.opacity = "1";

}

function showLogin(){
    formLogin.style.display = "block";
    containerLoginRegister.style.left="150px"
    formRegister.style.display="none";
    backBoxLogin.style.opacity="0";
    backBoxRegister.style.opacity="1";
}