/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var user;
var models =[];
function agregarUsuario() {

    var usuario = $("#user").val();
    var pass = $("#pass").val();
    var passv = $("#verificar").val();
    if (pass === passv) {
        console.log(passv);
        console.log("Entro agregar usuario");
        alert("Usuario Registrado exitosamente : " + usuario);
       
        console.log("/userProfile."+usuario);
        location.href = "userProfile."+usuario;
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
function iraDiseñar(){
   return $.get( "/userwork."+user, 
        function(data) {
              console.log("/userwork."+user); 
                 console.log("data."+data.password);
            
                location.href ="userwork."+user;
                
                
                console.log("Gert correcto"+ user);
                
            
           
            
            
        }        
    );
}
function crearModelo(){
    var name = $("#namemodel").val();
    var tables = "3";
    var params = {numtablas: tables , name:name};
    console.log("hola"+JSON.stringify(params));
    if(name !== null || name !== ""){
        return $.ajax({url: "/usuarios/models."+user,
            type: 'PUT',
            
            data: JSON.stringify(params),
            contentType: "application/json"});   
    }
  else
      alert("Debe introducir un nombre");
}

function getModels(){
        $.get( "/usuarios/models."+user, 
        function(data) {
            $("#userTools").empty();
            var modelosdisp = [];
              console.log("/usuarios/models."+user); 
                  modelosdisp = JSON.parse(JSON.stringify(data));
                for (var i = 0; i < modelosdisp.length; i++) {
                    $("#userTools").append("<li><a id='user'class='text-center list-group-item' style='margin-right: 10%;margin-top: 5%;'>"+modelosdisp[i].name+"</a></li>");
                    //alert("Encontre modelos"+user + "data"+modelosdisp[i].numtablas);
                }        
         
            
            
        }        
    );
    
}

$(document).ready(
        function () {
            
            console.info('connecting to register');
           var cadena =location.pathname;
           if(cadena.includes("userProfile")|| cadena.includes("userwork")){
               var resp =cadena.split(".");
               user = resp[1]; 
            
           }
          
        
    }
                
                
);
