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
    
    //Constructores
    public ColaGeneral(){
        this.cola=new Coches[50];
    }
    
    //Metodos
    public void avanzar(){
        this.cola[cola.length-1]=null;
        for (int i=0; i<this.cola.length; i++){
            this.cola[i]=this.cola[i+1];
        }
        System.out.println("La cola ha avanzado de forma satisfactoria");
    }
    
    public Coches getSiguiente(){
        return new Coches(this.cola[0]);
    }
    
    public void setCoche(Coches c){
        for (int i=0; cola[i]!=null || i<cola.length; i++){
            this.cola[i]=new Coches(c);
            break;
        }
    }
    
    public void meterEnBox(Box b){
        if (b.getVehiculo(0)==null){
            b.setVehiculoNuevo(this.cola[0]);
            this.avanzar();
            System.out.println("Operación realizada con éxito");
        } else {
            System.out.println("No hay hueco en el Box");
        }
    }
}
