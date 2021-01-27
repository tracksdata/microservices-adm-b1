fetch('http://localhost:8080/api/pss')
.then(response => response.json())
.then(flights=>{
    console.log(flights);
})