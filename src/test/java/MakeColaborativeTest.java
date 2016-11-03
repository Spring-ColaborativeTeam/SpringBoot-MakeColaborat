

import java.util.List;
import mycompany.social_login.home.ManejoUsuarios;
import mycompany.social_login.home.Usuario;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2100609
 */
public class MakeColaborativeTest {

    public MakeColaborativeTest() {
    }
    @Before
    public void setUp() {
    }


    /*
    Prueba verificar que exista al menos un usuario
    
    */
    @Test
    public void UsuariosNoVacios() {
        ManejoUsuarios mu = new ManejoUsuarios();
        assertNotNull(mu.getUsuarios());
       
        
    }
    /*
    Prueba creacion de un usuario
    
    */
    @Test
    public void CrearUsuario() {
        Usuario user = new Usuario("Ayala", "marrano@hotmail.com", "12345");
       
        assertEquals("Ayala", user.getName());
        
    }
     /*
    Prueba poder agrear un nuevo usuario
    
    */
    @Test
    public void AgregarUsuario() {
        ManejoUsuarios mu = new ManejoUsuarios();
        Usuario user = new Usuario("Ayala", "marrano@hotmail.com", "12345");
        mu.agregarUsuario(user);
         assertEquals("Ayala", mu.getUsuarios().get(mu.getUsuarios().size()-1).getName());
        
    }
    
    
}
