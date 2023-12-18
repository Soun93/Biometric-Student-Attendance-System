let buttonFlag = true;

document.body.addEventListener('click', function(event) {
    if (event.target.id === 'buttonSearch'){
        button(buttonFlag)
    }
});

function button(flag){
    let myDiv = document.getElementById("search-box");
    let myButton = document.getElementById("buttonSearch");
    let myInput = document.getElementById("inputSearch");
    // Mostrar searchbox
    if(flag === true) {

        Object.assign(myDiv.style, {
            justifyContent: "normal",
            transition: "1.5s", // Cambio en la transición del input
            width: "15rem",
        });

        Object.assign(myInput.style, {
            opacity: "1",
            transition: "1.5s", // Cambio en la transición del input
            width: "15rem",
        });  
        myButton.style.transform = "translateX(200px)"

        buttonFlag = false;
    }
    // Ocultar searchbox
    else{
        if(myInput.value.trim()){
            inputRequest(myInput.value.trim());
        }
        Object.assign(myDiv.style, {
            width: "0",
            transition: "1.5s", // Cambio en la transición del input
        });

        Object.assign(myInput.style, {
            opacity: "0",
            width: "0",
            transition: "1.5s" // Cambio en la transición del input
        });
        myButton.style.transform = "translateX(0px)";
        buttonFlag = true;   
    }
}

function inputRequest(searchInput){
    fetch(`/home/${searchInput}/search`)
        .then(response => response.json())
        .then(data => console.log(data))
        .catch(error => console.error(error));
}