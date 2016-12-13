var stompClient = null;
var count = 0;
 var rect  = null;
var graph = new joint.dia.Graph();
    var paper = new joint.dia.Paper({
          el: $('#paper'),
        width: 800,
        height: 600,
        gridSize: 1,
       model: graph
         });

var uml = joint.shapes.uml;
function connect() {
    
    var socket = new SockJS('/stompendpoint');
    stompClient = Stomp.over(socket);
    
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic', function (data) {           
           var cor = JSON.parse(data.body);
    rect  = new uml.Class({
        position: { x:cor.x  , y: cor.y },
        size: { width: 220, height: 100 },
        name: 'Class1',
        attributes: ['bloodGroup: String'],
        methods: ['+ isCompatible(bG: String): Boolean'],
        attrs: {
            '.uml-class-name-rect': {
                fill: '#ff8450',
                stroke: '#fff',
                'stroke-width': 0.5,
            },
        
            '.uml-class-methods-text': {
                ref: '.uml-class-methods-rect',
                'ref-y': 0.5,
                'y-alignment': 'middle'
            }
        }
    });
      graph.addCell(rect);
        
        rect.on('change:position', function() {
         
        });
           //canvas = document.getElementById('myCanvas');
         //pap  = document.getElementById('paper'); 
      
           //context = canvas.getContext('2d');
            
           // context.fillStyle="#DCDCDC"; //cambiamos color de relleno a blanco.
            //context.strokeStyle="black";
       
        
     
          // context.fillRect(cor.x,cor.y,cor.widht,cor.heigh);//dibujamos un rectángulo.
            // context.strokeRect(cor.x,cor.y,cor.widht,cor.heigh); 
             //context.font = "bold 22px sans-serif";
             //context.fillStyle="black";
             //context.fillText("Tabla"+ count,cor.x,cor.y);
            
 
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
        
            canvas = document.getElementById('paper');
                  
             $("li").draggable({
                    helper: 'clone'
                });
                $("#paper").droppable({
                drop: function (event, ui) {
                    var idElementoSoltado = ui.draggable.attr("id");
                    
                    var mousePos = getMousePos(canvas, event);
                    $.ajax({
                 url: "/userwork/add",
               type: 'PUT',    
                 data: JSON.stringify({x:mousePos.x,y:mousePos.y ,widht:200 , heigh: 150}),
                 contentType: "application/json",
                 dataType: 'json',
                 success: function(result) {
                alert("success?");
                console.log("PUT OK");
             }
    });        count ++;
               //stompClient.send("/app/newpoint", {}, JSON.stringify({x:mousePos.x,y:mousePos.y ,widht:200 , heigh: 150})); 
                
                }
            });
         
            canvas.addEventListener('mousedown', function(evt) {
                
                
            }, false);
    }
                
                
);
