/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function agregarUsuario(){
    
    var name=$("#user").val();
    var pass=$("#pass").val();
    console.log("Entro agregar usuario");
    console.log("/usuarios/registro/"+name);
    return $.ajax({url: "/usuarios/registro/"+name, 
         type: 'PUT', 
         data: pass,
         contentType: "application/json"});
    
}


$(document).ready(
        function () {
           
            console.info('connecting to register');
        }
);

