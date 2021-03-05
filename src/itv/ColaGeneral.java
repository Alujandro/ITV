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
            this.cola[i]=null;
        }
    }
    
    //Metodos
    public void avanzar(){
        this.cola[cola.length-1]=null;
        for (int i=0; i<this.cola.length-1; i++){
            this.cola[i]=this.cola[i+1];
        }
        System.out.println("La cola ha avanzado de forma satisfactoria");
    }
    
    public Coches getSiguiente(){
        if (this.cola[0]==null) {
            return null;
        }
        return new Coches(this.cola[0]);
    }
    
    public void setCoche(Coches c){
        for (int i=0; cola[i]!=null || i<cola.length; i++){
            this.cola[i]=new Coches(c);
            System.out.println("Vehículo introducido satisfactoriamente");
            break;
        }
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
                System.out.println("Operación realizada con éxito");
                return true;
            }
        }
    }
}
