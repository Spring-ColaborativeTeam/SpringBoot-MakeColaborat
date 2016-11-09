var stompClient = null;
var count = 0;
function connect() {
    
    var socket = new SockJS('/stompendpoint');
    stompClient = Stomp.over(socket);
    
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/newpoint', function (data) {           
           var cor = JSON.parse(data.body);
          
           canvas = document.getElementById('myCanvas');
           context = canvas.getContext('2d');
          
            context.fillStyle="#DCDCDC"; //cambiamos color de relleno a blanco.
            context.strokeStyle="black";
       
           context.fillRect(cor.x,cor.y,cor.widht,cor.heigh);//dibujamos un rectángulo.
             context.strokeRect(cor.x,cor.y,cor.widht,cor.heigh); 
             context.font = "bold 22px sans-serif";
             context.fillStyle="black";
             context.fillText("Tabla"+ count,cor.x,cor.y);
            
 
           //context.beginPath();
           //context.arc(cor.x,cor.y,1,0,2*Math.PI);
           //context.stroke();           
        });
        
   
    });
}


function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function getMousePos(canvas, evt) {
var rect = canvas.getBoundingClientRect();
        return {
        x: evt.clientX - rect.left,
        y: evt.clientY - rect.top
        };
}
var canvas = null;
var context = null;




$(document).ready(
        function () {
            connect();
            console.info('connecting to websockets');
        
            canvas = document.getElementById('myCanvas');
                  
             $("li").draggable({
                    helper: 'clone'
                });
                $("#myCanvas").droppable({
                drop: function (event, ui) {
                    var idElementoSoltado = ui.draggable.attr("id");
                    
                    var mousePos = getMousePos(canvas, event);
                    $.ajax({
                 url: "http://localhost:8080/userwork/add",
               type: 'PUT',    
                 data: JSON.stringify({x:mousePos.x,y:mousePos.y ,widht:200 , heigh: 150}),
                 contentType: "application/json",
                 dataType: 'json',
                 success: function(result) {
                alert("success?");
                console.log("PUT OK");
             }
    });        count ++;
                stompClient.send("/app/newpoint", {}, JSON.stringify({x:mousePos.x,y:mousePos.y ,widht:200 , heigh: 150})); 
                
                }
            });
            
            canvas.addEventListener('mousedown', function(evt) {
                
                
            }, false);
    }
                
                
);
