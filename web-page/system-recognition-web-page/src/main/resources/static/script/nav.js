document.body.addEventListener('click', function(event) {
    if (event.target.id === 'onArrow'){
        nav(true)
    }
    if (event.target.id === 'offArrow' ){
        nav(false)
    }
});

function nav(flag) {
    const inNav = document.getElementById("nav-container"); //Contenedor div de las opciones
    const imgRow = document.getElementById("offArrow"); //Nav oculto img 
    const nav = document.getElementById("nav"); //Nav general
    // Ocultar NAV 
    if (flag) {
        imgRow.style.display = "block";
        inNav.style.display = "none";
        //Modificando el NAV para centrar la img 
        Object.assign(nav.style, {
            width: "3rem",
            display: "flex",
            alignItems: "center",
            justifyContent:"center",
            transition: "1s",
        });
        //Modificando imagen 
        imgRow.style.width = "3rem"
    } 
    // Mostrar NAV 
    else {
        Object.assign(nav.style, {
            width: "15rem",
            display: "flex",
            alignItems: "",
            justifyContent:"",
            transition: "1s",
            transform: "translateX(0)" // Regresar el elemento a su posición original
        });
        inNav.style.display = "block";
        imgRow.style.display = "none";
    }
}


