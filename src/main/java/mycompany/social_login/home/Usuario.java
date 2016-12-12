/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompany.social_login.home;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author 2100609
 */
public class Usuario {
    private String name;
    private String email;
    private String password;
      List<Modelo> modelos ;
    
    public Usuario(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
           this.modelos = new LinkedList<>();
    }

    public Usuario(String name, String password) {
        this.name = name;
        this.password = password;
           this.modelos = new LinkedList<>();
    }
    
    
    public void setPassword(String password){
        this.password = password;
        
    }

    public List<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }

    

    public String getPassword() {
        return password;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
