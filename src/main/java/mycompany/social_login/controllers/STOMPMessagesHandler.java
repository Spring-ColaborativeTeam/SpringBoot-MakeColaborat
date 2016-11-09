/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompany.social_login.controllers;


import mycompany.social_login.home.ManejadorPuntos;
import mycompany.social_login.home.Rectangulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Felipe
 */
@Controller
public class STOMPMessagesHandler {
    @Autowired
    SimpMessagingTemplate msgt;
    @Autowired
    ManejadorPuntos mp;
    
    @MessageMapping("/newpoint")
    public synchronized void getLine(Rectangulo rec) throws Exception{

               
        msgt.convertAndSend("/topic/newpoint",rec);
        mp.adicionar(rec);
        if(mp.getSize()==4){
            msgt.convertAndSend("/topic/newpolygon",mp.Array());
            mp.reset();
        }
    }
}
