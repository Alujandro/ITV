/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itv;

import vehiculos.Vehiculo;

/**
 *
 * @author ciclost
 */
public class ColaGeneral {
    //Atributos
    private final Vehiculo[] cola;
    private static final int TOTAL=50;
    
    //Constructores
    public ColaGeneral(){
        this.cola=new Vehiculo[TOTAL];
        for (int i=0; i<cola.length; i++){
            this.cola[i]=new Vehiculo();
        }
    }
    
    //Metodos
    public void avanzar(){
        for (int i=0; i<this.cola.length-1; i++){
            if (this.cola[i]==null){
                this.cola[i-1]=new Vehiculo();
                break;
            }
            this.cola[i]=new Vehiculo(this.cola[i+1]);
        }
        this.cola[cola.length-1]=new Vehiculo();
    }
    
    public Vehiculo getSiguiente(){
        if (this.cola[0]==null) {
            return new Vehiculo();
        }
        if (this.cola[0]==null){
            return new Vehiculo();
        }
        return new Vehiculo(this.cola[0]);
    }
    
    public void setCoche(Vehiculo c){
        for (int i=0;i<cola.length; i++){
            if (cola[i]==null) {
                this.cola[i]=new Vehiculo(c);
                System.out.println("Vehículo introducido satisfactoriamente");
                break;
            }
        }
    }
    
    public int getTOTAL(){
        return TOTAL;
    }
    
    public boolean meterEnBox(Box b){
        if (this.getSiguiente()==null){
            System.out.println("La cola de entrada está vacía");
            return true;
        } else {
            if (b.getVehiculo(0)!=null){
                System.out.println("No hay hueco en el Box");
                return false;
            } else {
                b.setVehiculoNuevo(this.cola[0]);
                this.avanzar();
                return true;
            }
        }
    }
}
