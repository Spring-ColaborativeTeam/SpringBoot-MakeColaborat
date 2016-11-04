/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function agregarUsuario() {

    var usuario = $("#user").val();
    var pass = $("#pass").val();
    var passv = $("#verificar").val();
    if (pass === passv) {
        console.log(passv);
        console.log("Entro agregar usuario");
        console.log("/userProfile."+usuario);
        return $.ajax({url: "/usuarios/userProfile."+usuario,
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
 console.log("clave."+clave);
    $.get( "/usuarios/userProfile."+usuario, 
        function(data) {
              console.log("/usuarios/userProfile."+usuario); 
                 console.log("data."+data.password);
            if(clave === data.password) {
                location.href ="userProfile."+usuario;
                console.log("Contraseña Correcta"+ usuario);
                
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
