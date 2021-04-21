/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itv;

import itv.vehiculos.Camion;
import itv.vehiculos.Coche;
import itv.vehiculos.Microbus;
import itv.vehiculos.Vehiculo;
import itv.vehiculos.VehiculoDeCarga;

/**
 *
 * @author ciclost
 */
public class Box {
    //Atributos
    private final Vehiculo[] boxe;
    public static final int FASES=4;
    //private static final String listaFases[]= {"Revisión de seguridad","Revisión sistema eléctrico","Revisión de humos","Revisión de frenos y dirección"};
    
    //Constructores
    public Box(){
        this.boxe=new Vehiculo[FASES];
        this.aNull();
    }
    
    //Métodos
    public void avanzar(ColaPago c){
        for (int i=this.boxe.length-1; i>0; i--){
            if (i==this.boxe.length-1 && this.boxe[i]!=null){
                c.llenaCola(this.boxe[i]);
            }
            if (this.boxe[i-1]==null){
                this.boxe[i]=null;
            }
            if (this.boxe[i-1]==null){
                this.boxe[i]=null;
            } else {
                this.boxe[i]=meteCola(this.boxe[i-1]); //Usar método específico
            }
        }
        this.boxe[0]=null;
        System.out.println("Cambio de fase completado");
    }
    
    public Vehiculo getVehiculo(int i){ 
        return boxe[i];
    }
    
    public Vehiculo[] getBoxe(){
        return this.boxe;
    }
    
    public final void aNull(){
        for (int i=0; i<this.boxe.length; i++){
            this.boxe[i]=null;
        }
    }
    
    public void setVehiculoNuevo(Vehiculo c){
        this.boxe[0]=meteCola(c); //Método específico
    }
    
    public Vehiculo meteCola(Vehiculo c){
        switch (c.getTipo()) {
            case 1:
                return new Coche(c);
            case 2:
                return new Microbus(c);
            case 3:
                return new VehiculoDeCarga(c);
            case 4:
                return new Camion(c);
            default:
                return new Coche(c);
        }
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
