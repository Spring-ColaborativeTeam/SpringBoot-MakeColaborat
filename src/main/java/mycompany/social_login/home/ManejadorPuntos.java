/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompany.social_login.home;


import java.util.concurrent.ConcurrentLinkedQueue;
import org.springframework.stereotype.Service;

/**
 *
 * @author Manuel Felipe.
 */

@Service
public class ManejadorPuntos {
    
    ConcurrentLinkedQueue<Rectangulo> puntos =    new ConcurrentLinkedQueue<Rectangulo>();

    
    
    public void adicionar ( Rectangulo pt){
        puntos.add(pt);
    }
    
    public int getSize(){
        return puntos.size();
    }
    
    public Object[] Array(){
        return puntos.toArray();
    }
    
    public void reset(){
        puntos = new ConcurrentLinkedQueue<Rectangulo>();
    }
    
    
}
