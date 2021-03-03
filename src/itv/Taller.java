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
public class Taller {
    //Atributos
    public final Box[] todas;
    
    //Constructores
    public Taller(){
        this.todas=new Box[6];
    }
    
    //Métodos
    public void muestraTodo(){
        for (int i=0; i<todas.length; i++) {
            System.out.println("Box "+i+":");
            todas[i].mostrarBox();
        }
    }
}
