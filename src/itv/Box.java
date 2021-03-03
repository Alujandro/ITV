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
    private static final int FASES=4;
    
    //Constructores
    public Box(){
        this.boxe=new Coches[FASES];
    }
    
    //Métodos
    public void avanzar(){
        for (int i=0; i<this.boxe.length-1; i++){
            this.boxe[i+1]=new Coches(this.boxe[i]);
        }
        this.boxe[0]=null;
    }
    
    public String getVehiculo(int i){
        return boxe[i].toString();
    }
    
    public void setVehiculoNuevo(Coches c){
        if (this.boxe[0]==null){
            this.boxe[0]=new Coches(c);
        }
    }
    
    public void mostrarBox(){
        for (int i=0; i<boxe.length; i++){
            if (boxe[i]!=null){
                System.out.println("Fase "+i+": "+boxe[i].toString());
            } else {
                System.out.println("Fase "+i+": Vacío");
            }
        }
    }
}
