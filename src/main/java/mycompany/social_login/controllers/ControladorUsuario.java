/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompany.social_login.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;
import mycompany.social_login.home.ManejadorUsuarioExcepcion;
import mycompany.social_login.home.ManejoUsuarios;
import mycompany.social_login.home.Modelo;
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
    
    @RequestMapping(value = "/userProfile.{user}",method = RequestMethod.PUT)
    public ResponseEntity<?> manejadorLetras(@PathVariable("user") String user,@RequestBody String pass){
        System.out.println("Entro al PUT "+user);
        mu.agregarUsuario(user, pass);
       
       
       return new ResponseEntity<>(HttpStatus.CREATED);

    }
      @RequestMapping(value = "/models.{user}", method = RequestMethod.GET)
    public ResponseEntity<?> GetModelos(@PathVariable("user") String user) {
        try {
            return new ResponseEntity<>(mu.getModelos(user), HttpStatus.ACCEPTED);

        } catch (ManejadorUsuarioExcepcion ex) {
            Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No existen Modelos", HttpStatus.ACCEPTED);
        }
    }
      @RequestMapping(value = "/models.{user}",method = RequestMethod.PUT)
    public ResponseEntity<?> putModelo(@PathVariable("user") String user,@RequestBody String name) throws ManejadorUsuarioExcepcion{
        
        String[] split = name.split("-");
        //System.out.println("Entro al PUT  de guardar modelo "+tmp[0]);
        Modelo m = new Modelo(Integer.parseInt(split[1]),split[0]);
        mu.addmodel(m, user);
       
       
       return new ResponseEntity<>(HttpStatus.CREATED);

    }
    @RequestMapping(value = "/userProfile.{user}", method = RequestMethod.GET)
    public ResponseEntity<?> GetRecursoOrden(@PathVariable("user") String val) {
        boolean acceso = false;
        try {
            return new ResponseEntity<>(mu.getUsuario(val), HttpStatus.ACCEPTED);

        } catch (ManejadorUsuarioExcepcion ex) {
            Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No existe ese usuario", HttpStatus.ACCEPTED);
        }
    }
    
}
