/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompany.social_login.home;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author santiago-chisco
 */
@RestController
@RequestMapping("/usuarios")
public class ControladorUsuario {
    @Autowired
    ManejoUsuarios mu;
    
    @RequestMapping(value = "/registro/{name}",method = RequestMethod.PUT)
    public ResponseEntity<?> manejadorLetras(@PathVariable("name") String val,@RequestBody String pass){
        System.out.println("Entro al PUT "+val);
        mu.agregarUsuario(val, pass);
        /*
       String x;
        System.out.println("Entro al leer");
        try {
            x=gameServices.addLetter(val, word);
            msgt.convertAndSend("/topic/wupdate."+val,x);
            System.out.println("Palabra nueva : "+x);
            
        } catch (GameNotFoundException ex) {
            Logger.getLogger(GamesResourceController.class.getName()).log(Level.SEVERE, null, ex);
        }
       */
       return new ResponseEntity<>(HttpStatus.CREATED);

    }
    
}
