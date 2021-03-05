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
    public static final int FASES=4;
    //private static final String listaFases[]= {"Revisión de seguridad","Revisión sistema eléctrico","Revisión de humos","Revisión de frenos y dirección"};
    
    //Constructores
    public Box(){
        this.boxe=new Coches[FASES];
        this.aNull();
    }
    
    //Métodos
    public void avanzar(){
        for (int i=0; i<this.boxe.length-1; i++){
            this.boxe[i+1]=new Coches(this.boxe[i]);
        }
        this.boxe[0]=null;
        System.out.println("Cambio de fase completado");
    }
    
    public Coches getVehiculo(int i){ 
        return boxe[i];
    }
    
    public final void aNull(){
        for (int i=0; i<this.boxe.length; i++){
            this.boxe[i]=null;
        }
    }
    
    public void setVehiculoNuevo(Coches c){
        this.boxe[0]=new Coches(c);
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
