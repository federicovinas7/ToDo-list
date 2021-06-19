
let userRegister={
    name:"",
    surname:"",
    email:"",
    username:"",
    password:""
}


function register(){

        userRegister.name = document.getElementById('nameRegister').value;
        userRegister.surname = document.getElementById('surnameRegister').value;
        userRegister.email = document.getElementById('emailRegister').value;
        userRegister.username = document.getElementById('usernameRegister').value;
        userRegister.password = document.getElementById('passwordRegister').value;
        

    var xhr = new XMLHttpRequest();
    xhr.open("POST", 'http://localhost:8080/user', true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify(
        
        userRegister
        
    ));
    
        alert('Login successful!');
        location.reload();
      

}