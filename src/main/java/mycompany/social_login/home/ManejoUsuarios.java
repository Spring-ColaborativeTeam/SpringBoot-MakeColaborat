/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompany.social_login.home;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author santiago-chisco
 */
@Service
public class ManejoUsuarios {
    private List<Usuario> usuarios;

    public ManejoUsuarios() {
        usuarios = new ArrayList<>();
        crearUsuarios();
    }
    
    public void crearUsuarios(){
        Usuario us1 = new Usuario("Manuel","12345");
        Usuario us2 = new Usuario("Santiago","12345");
        Usuario us3 = new Usuario("Daniel","12345");
        usuarios.add(us1);
        usuarios.add(us2);
        usuarios.add(us3);
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    
    public void agregarUsuario(String name, String pass){
        Usuario user = new Usuario(name, pass);
        usuarios.add(user);
    }
    public void agregarUsuario(Usuario user){
        usuarios.add(user);
    }
    
    
}
