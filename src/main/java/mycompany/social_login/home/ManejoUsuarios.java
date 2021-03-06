/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompany.social_login.home;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

/**
 *
 * @author santiago-chisco
 */
@Service
public class ManejoUsuarios {
    /*
    Map<Integer, String> map = new HashMap<Integer, String>();
map.put(1, "Casillas");		map.put(15, "Ramos");
map.put(3, "Pique");		map.put(5, "Puyol");
map.put(11, "Capdevila");	map.put(14, "Xabi Alonso");
map.put(16, "Busquets");	map.put(8, "Xavi Hernandez");
map.put(18, "Pedrito");		map.put(6, "Iniesta");
map.put(7, "Villa");

// Imprimimos el Map con un Iterador
Iterator it = map.keySet().iterator();
while(it.hasNext()){
  Integer key = it.next();
  System.out.println("Clave: " + key + " -> Valor: " + map.get(key));
}
*/
    
    private Map<String, Usuario> usuarios ;
  
    public ManejoUsuarios() {
        usuarios =  new HashMap<String, Usuario>();
        crearUsuarios();
    }
    
    public void crearUsuarios(){
        Usuario us1 = new Usuario("Manuel","12345");
        Usuario us2 = new Usuario("Santiago","12345");
        Usuario us3 = new Usuario("Daniel","12345");
        us1.agregarModelo("Trabajoenequipo1",new Modelo(4,"Trabajoenequipo1"));
        us1.agregarModelo("Modelodeprueba2",new Modelo(2,"Modelodeprueba2"));
        us2.agregarModelo("Prueba",new Modelo(3,"Modelo Prueba"));
        us2.agregarModelo("Chisco",new Modelo(4,"Modelo de Chisco"));
        us2.agregarModelo("Modelo",new Modelo(4,"Modelo"));
        /*
        us1.agregarModelo("Trabajoenequipo1",new Modelo(4,"Trabajoenequipo1"));
        us1.getModelos().add(new Modelo(2,"Modelodeprueba2"));
        us2.getModelos().add(new Modelo(3,"Modelo Prueba"));
        us2.getModelos().add((new Modelo(4,"Modelo de Chisco")));
        us3.getModelos().add(new Modelo(3,"Modelo Proyecto"));
        //us3.getModelos().add((new Modelo(4,"Modelo de Chisco")));
        */
        usuarios.put(us1.getName(), us1);
        usuarios.put(us2.getName(), us2);
        usuarios.put(us3.getName(), us3);
        
    }

    public Map<String, Usuario> getUsuarios() {
        return usuarios;
    }
    public List<Modelo>getModelos(String user) throws ManejadorUsuarioExcepcion{
         if (usuarios.get(user)==null) throw new ManejadorUsuarioExcepcion("No existe el usuario para modelarlo");
         System.out.println("Cantidad de modelos "+usuarios.get(user).getModelos().size());
         List<Modelo> list = new ArrayList<Modelo>(usuarios.get(user).getModelos().values());
         return list;
    }
    public void addmodel(Modelo m,String user) throws ManejadorUsuarioExcepcion{
        System.out.println("Agrego el modelo");
        if (usuarios.get(user)==null) throw new ManejadorUsuarioExcepcion("No existe el usuario");
            usuarios.get(user).agregarModelo(m.getName(), m);
    }

    public boolean ingresarUsuario(String name, String pass) throws ManejadorUsuarioExcepcion{
        boolean acceso = false;
        Usuario user = this.getUsuario(name);
        if (user==null) throw new ManejadorUsuarioExcepcion("No existe el usuario");
        else{
            if(user.getPassword()==pass){
                acceso = true;
            }
        }
        
        return acceso;
    }
    
    public void agregarUsuario(String name, String pass){
        Usuario user = new Usuario(name, pass);
        usuarios.put(user.getName(), user);
    }
    
    public void agregarUsuario(Usuario user) {
        usuarios.put(user.getName(), user);
    }
    
    public Usuario getUsuario(String name) throws ManejadorUsuarioExcepcion {
        if (usuarios.get(name)==null) throw new ManejadorUsuarioExcepcion("No existe el usuario");
        return usuarios.get(name);
    }
    
    
}
