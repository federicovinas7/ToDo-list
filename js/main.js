const url = new URL("http://localhost:8080/folder");

fetch(url)
.then(response =>response.json())
.then(data =>{

    console.log(data)
})
.catch(err=>console.log(err))
