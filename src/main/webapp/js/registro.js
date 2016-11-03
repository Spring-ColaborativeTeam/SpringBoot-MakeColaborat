/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function agregarUsuario() {

    var name = $("#user").val();
    var pass = $("#pass").val();
    var passv = $("#verificar").val();
    if (pass === passv) {
        console.log(passv);
        console.log("Entro agregar usuario");
        console.log("/usuarios/registro/" + name);
        return $.ajax({url: "/usuarios/registro/" + name,
            type: 'PUT',
            data: pass,
            contentType: "application/json"});
        
        
    } else {
        alert("Las contraseñas no coinciden");
    }
    
    

}

function ingresar(){
    var usuario = $("#usuario").val();
    var clave = $("#clave").val();

    $.get( "/usuarios/"+usuario, 
        function( data ) {
            
            if(clave === data.password) {
                console.log("Contraseña Correcta")
                
            }
            else{
                alert("Contraseña incorrecta");
            }
            
            
        }        
    );
    
}
function getUsuario(){
    
    
}

$(document).ready(
        function () {
            
            console.info('connecting to register');
        
        
    }
                
                
);
