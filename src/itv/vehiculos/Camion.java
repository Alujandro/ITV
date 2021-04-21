/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itv.vehiculos;

/**
 *
 * @author ciclost
 */
public class Camion extends VehiculoDeCarga{
    private static final double FIJO=40;
    
    public Camion (String matri, String mode, int tip, int cili, int plaz, int cece){
        super(matri, mode, tip, cili, plaz, cece);
    }
    
    public Camion(Vehiculo co){
        super(co);
        
    }
    
    @Override
    public double calculaCoste(){
        double resultado;
        if (this.getCilindros()>=10){
            resultado=4*this.getPMA();
        } else {
            resultado=3*this.getPMA();
        }
        if (this.getCentimetrosCubicos()>2000){
            resultado+=20;
        }
        return resultado + FIJO + (this.getCilindros()*15)*1.2;
    }
}
