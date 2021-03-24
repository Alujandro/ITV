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
    private final Coche[] cola;
    private static final int TOTAL=50;
    
    //Constructores
    public ColaGeneral(){
        this.cola=new Coche[TOTAL];
        for (int i=0; i<cola.length; i++){
            this.cola[i]=new Coche();
        }
    }
    
    //Metodos
    public void avanzar(){
        for (int i=0; i<this.cola.length-1; i++){
            if (this.cola[i].getMatricula()==null){
                this.cola[i-1]=new Coche();
                break;
            }
            this.cola[i]=new Coche(this.cola[i+1]);
        }
        this.cola[cola.length-1]=new Coche();
    }
    
    public Coche getSiguiente(){
        if (this.cola[0]==null) {
            return new Coche();
        }
        if (this.cola[0].getMatricula()==null){
            return new Coche();
        }
        return new Coche(this.cola[0]);
    }
    
    public void setCoche(Coche c){
        for (int i=0;i<cola.length; i++){
            if (cola[i].getMatricula()==null) {
                this.cola[i]=new Coche(c);
                System.out.println("Vehículo introducido satisfactoriamente");
                break;
            }
        }
    }
    
    public int getTOTAL(){
        return TOTAL;
    }
    
    public boolean meterEnBox(Box b){
        if (this.getSiguiente().getMatricula()==null){
            System.out.println("La cola de entrada está vacía");
            return true;
        } else {
            if (b.getVehiculo(0).getMatricula()!=null){
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
