/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompany.social_login.home;

/**
 *
 * @author Felipe
 */
public class Modelo {
    int numtablas;
      String name;
    public Modelo() {
    }

    public int getNumtablas() {
        return numtablas;
    }

    public void setNumtablas(int numtablas) {
        this.numtablas = numtablas;
       
    }

    public Modelo(int numtablas,String name) {
        this.numtablas = numtablas;
         this.name = name;
    }

    public Modelo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
