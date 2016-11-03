

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mycompany.social_login.home.ManejadorUsuarioExcepcion;
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
    public void AgregarUsuario() throws ManejadorUsuarioExcepcion {
        ManejoUsuarios mu = new ManejoUsuarios();
        Usuario user = new Usuario("Ayala", "marrano@hotmail.com", "12345");
        mu.agregarUsuario(user);
         assertEquals("Ayala", mu.getUsuario("Ayala").getName());
        
    }
    /*
    Prueba para consultar un usuario y compararlo con un dato propio del usuario
    */
    
    @Test
    public void ConsultarUsuario() {
        ManejoUsuarios mu = new ManejoUsuarios();
         
        try {
            assertEquals(mu.getUsuario("Santiago").getPassword(),"12345");
        } catch (ManejadorUsuarioExcepcion ex) {
            Logger.getLogger(MakeColaborativeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    /*
    Prueba para determinar que un usuario desconocido
    no este en la base de datos estatica
    */
    @Test
    public void NoExisteUsuario() {
        ManejoUsuarios mu = new ManejoUsuarios();
         
        try {
            mu.getUsuario("Prueba");
            fail();
        } catch (ManejadorUsuarioExcepcion ex) {
            Logger.getLogger(MakeColaborativeTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(true);
        }
        
    }
    /*
    Prueba para comprobar que un usuario conocido
    pueda ingresar al sistema con su clave respectiva
    */
    @Test
    public void IngresarUsuarioCorrecto()  {
        ManejoUsuarios mu = new ManejoUsuarios();
        try {
            assertTrue(mu.ingresarUsuario("Santiago","12345"));
        } catch (ManejadorUsuarioExcepcion ex) {
            Logger.getLogger(MakeColaborativeTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
        
    }
    /*
    Prueba para comprobar que un usuario conocido
    no pueda ingresar al sistema con una clave erronea
    */
    @Test
    public void IngresarUsuarioIncorrecto() {
        ManejoUsuarios mu = new ManejoUsuarios();
        try {
            assertFalse(mu.ingresarUsuario("Santiago","123458987"));
        } catch (ManejadorUsuarioExcepcion ex) {
            Logger.getLogger(MakeColaborativeTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
        
    }
    
    
}
