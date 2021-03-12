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
    private final Coches[] cola;
    private static final int TOTAL=50;
    
    //Constructores
    public ColaGeneral(){
        this.cola=new Coches[TOTAL];
        for (int i=0; i<cola.length; i++){
            this.cola[i]=new Coches();
        }
    }
    
    //Metodos
    public void avanzar(){
        for (int i=0; i<this.cola.length-1; i++){
            if (this.cola[i].getMatricula()==null){
                this.cola[i-1]=new Coches();
                break;
            }
            this.cola[i]=new Coches(this.cola[i+1]);
        }
        this.cola[cola.length-1]=new Coches();
    }
    
    public Coches getSiguiente(){
        if (this.cola[0]==null) {
            return new Coches();
        }
        if (this.cola[0].getMatricula()==null){
            return new Coches();
        }
        return new Coches(this.cola[0]);
    }
    
    public void setCoche(Coches c){
        for (int i=0;i<cola.length; i++){
            if (cola[i].getMatricula()==null) {
                this.cola[i]=new Coches(c);
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
