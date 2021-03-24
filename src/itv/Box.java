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
    private final Vehículo[] boxe;
    public static final int FASES=4;
    //private static final String listaFases[]= {"Revisión de seguridad","Revisión sistema eléctrico","Revisión de humos","Revisión de frenos y dirección"};
    
    //Constructores
    public Box(){
        this.boxe=new Vehículo[FASES];
        this.aNull();
    }
    
    //Métodos
    public void avanzar(){
        for (int i=this.boxe.length-1; i>0; i--){
            if (this.boxe[i-1]==null){
                this.boxe[i]=new Vehículo();
            }
            this.boxe[i]=new Vehículo(this.boxe[i-1]);
        }
        this.boxe[0]=new Vehículo();
        System.out.println("Cambio de fase completado");
    }
    
    public Vehículo getVehiculo(int i){ 
        return boxe[i];
    }
    
    public Vehículo[] getBoxe(){
        return this.boxe;
    }
    
    public final void aNull(){
        for (int i=0; i<this.boxe.length; i++){
            this.boxe[i]=new Vehículo();
        }
    }
    
    public void setVehiculoNuevo(Vehículo c){
        this.boxe[0]=new Vehículo(c);
    }
    
    public void mostrarBox(){
        for (int i=0; i<boxe.length; i++){
            if (boxe[i]!=null){
                if (boxe[i]==null){
                    System.out.println("Fase "+(i+1)+": Vacío");
                } else {
                    System.out.println("Fase "+(i+1)+": "+boxe[i].toString());
                }
            } else {
                System.out.println("Fase "+(i+1)+": Vacío");
            }
        }
    }
}
