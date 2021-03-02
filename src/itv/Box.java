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
public class Box {
    //Atributos
    private final Coches[] boxe;
    
    //Constructores
    public Box(){
        this.boxe=new Coches[6];
    }
    
    //Métodos
    public void avanzar(){
        for (int i=0; i<this.boxe.length-1; i++){
            this.boxe[i+1]=this.boxe[i];
        }
    }
    
    public String getVehiculo(int i){
        return boxe[i].toString();
    }
}
