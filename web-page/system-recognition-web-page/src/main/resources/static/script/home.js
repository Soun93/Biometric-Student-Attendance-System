// Llamada de funciones3
document.body.addEventListener('click', function(event) {
    if (event.target.classList.contains('verButton')){
        classRequest(event.target.id);
    }
    if (event.target.id === 'close') {
        deleteModal();
    }
});


function createCard(){
    const container = document.getElementById('class-container');
    const cardHtml = 
    `<div class="card-container">
        <div class="card-head">
            <img src="/img/Calendar_Empty.svg" alt="img-ast" />
            <h2>TSCIC2023</h2>
        </div>
        <div class="card-body">
            <div class="card-information">

                <p>Grupo3, ICE</p>
                <p>Miercoles</p>
                <p>B107</p>

            </div>
            <div class="card-button">
                <a href="#" class="verButton" id="2">Ver</a>
            </div>
        </div>
    </div>`
    addDom(container,cardHtml)

}

// Basicamente modificamos el DOM Para agregar un modal 

function createModal(id,asistenciaObject){
    const container = document.getElementById('home-container'); 
    const modalHtml = 
    `<div class="modal-flex" id=modal>
        <div class="modal">
                <div class="modal-container">
                    <div class="modal-title">
                        <h1>Temas Selectos de Cibernética / 5to año / Gp1 </h1>
                        <img src="/img/Close_S.svg" alt="" id="close"/>
                    </div>
                    <div class="modal-options">
                        <div class="search-box" id="search-box">
                            <input id="inputSearch" type="text" placeholder="Nombre del estudiante">
                            <input type="button" value="" id="buttonSearch">
                        </div>
                    </div>
                    <div class="table">
                        <table>
                            <thead>
                                <tr>
                                    <th>Nombre</th>
                                    <th>Fecha</th>
                                    <th>Entrada</th>
                                    <th>Salida</th>
                                    <th>Registro</th>
                                </tr>
                            </thead>
                            <tbody>
                                ${asistenciaObject.length > 0 ?
                                    asistenciaObject.map(d => `
                                        <tr>
                                            <td>${d.nombresAlumnos[0]}</td>
                                            <td>${d.fecha}</td>
                                            <td>${d.horaEntrada}</td>
                                            <td>${d.horaSalida}</td>
                                            <td><img src="${d.estadoAsistencia ? '/img/Check_Double_Big_Green.svg' : '/img/Check_Double_Big.svg'}" alt="" /></td>                                
                                        </tr>
                                    `).join('')
                                :
                                    '<tr><td colspan="5" style="text-align: center;"><h1 style="margin: 2rem;">Aún no se han registrado estudiantes.</h1></td></tr>'
                                }                             
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>`;
    // Creamos el elemento div y escribimos en su html. 
    addDom(container,modalHtml)
}

// Eliminamos modal
function deleteModal(){
    const modal = document.getElementById('modal'); 
    modal.parentNode.removeChild(modal);
}


function addDom(container,Html){
    const tempDiv = document.createElement('div'); 
    tempDiv.innerHTML = Html; 
    const object = tempDiv.firstChild; 
    container.appendChild(object); 
}
// Boton de busqueda
function classRequest(idClase){
    fetch(`/home/${idClase}/asistencias`)
        .then(response => response.json())
        .then(data => createModal(idClase,data))
        .catch(error => console.error(error));
}

