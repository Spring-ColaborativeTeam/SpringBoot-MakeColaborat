/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function agregarUsuario(){
    
    var name=$("#user").val();
    var pass=$("#pass").val();
    var passv=$("#verificar").val();
    if(pass === passv){
        alert("PAsswrod correcto");
    }
    else{
        alert("nO CONINDD");
    }
    
    
    console.log(passv);
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
