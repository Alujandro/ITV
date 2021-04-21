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
public class ColaGeneral {
    //Atributos
    private final Vehiculo[] cola;
    private static final int TOTAL=50;
    
    //Constructores
    public ColaGeneral(){
        this.cola=new Vehiculo[TOTAL];
        for (int i=0; i<cola.length; i++){
            this.cola[i]=null;
        }
    }
    
    //Metodos
    public void avanzar(){
        for (int i=0; i<this.cola.length-1; i++){
            if (this.cola[i]==null){
                this.cola[i-1]=null;
                break;
            }
            if (this.cola[i+1]==null){
                this.cola[i]=null;
            } else{
                this.cola[i]=meteCola(this.cola[i+1]); //Voy ha hacer un método para esto
            }
        }
        this.cola[cola.length-1]=null;
    }
    
    public Vehiculo getSiguiente(){
        if (this.cola[0]==null) {
            return null;
        }
        if (this.cola[0]==null){
            return null;
        }
        return meteCola(this.cola[0]); //Hacer método para devolver un objeto adecuado
    }
    
    public void setCoche(Vehiculo c){
        for (int i=0;i<cola.length; i++){
            if (cola[i]==null) {
                this.cola[i]=meteCola(c);
                System.out.println("Vehículo introducido satisfactoriamente");
                break;
            }
        }
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
