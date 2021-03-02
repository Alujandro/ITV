/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itv;

/**
 *
 * @author ciclost
 */
public class ColaGeneral {
    //Atributos
    private final Coches[] cola;
    
    //Constructores
    public ColaGeneral(){
        this.cola=new Coches[50];
    }
    
    //Metodos
    public void avanzar(){
        for (int i=0; i<this.cola.length; i++){
            this.cola[i]=this.cola[i+1];
        }
    }
    
    public Coches getSiguiente(){
        return new Coches(this.cola[0]);
    }
}
