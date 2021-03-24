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
    private final Vehículo[] cola;
    private static final int TOTAL=50;
    
    //Constructores
    public ColaGeneral(){
        this.cola=new Vehículo[TOTAL];
        for (int i=0; i<cola.length; i++){
            this.cola[i]=new Vehículo();
        }
    }
    
    //Metodos
    public void avanzar(){
        for (int i=0; i<this.cola.length-1; i++){
            if (this.cola[i]==null){
                this.cola[i-1]=new Vehículo();
                break;
            }
            this.cola[i]=new Vehículo(this.cola[i+1]);
        }
        this.cola[cola.length-1]=new Vehículo();
    }
    
    public Vehículo getSiguiente(){
        if (this.cola[0]==null) {
            return new Vehículo();
        }
        if (this.cola[0]==null){
            return new Vehículo();
        }
        return new Vehículo(this.cola[0]);
    }
    
    public void setCoche(Vehículo c){
        for (int i=0;i<cola.length; i++){
            if (cola[i]==null) {
                this.cola[i]=new Vehículo(c);
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
