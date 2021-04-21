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
public class VehiculoDeCarga extends Vehiculo{
    protected double PMA;
    
    public VehiculoDeCarga (String matri, String mode, int tip, int cili, int plaz, int cece){
        super(matri, mode, tip, cili, plaz, cece);
    }
    
    public VehiculoDeCarga(Vehiculo co){
        super(co);
        
    }
    
    public double getPMA(){
        return this.PMA;
    }
    
    @Override
    public double calculaCoste(){
        double resultado;
        if (this.getCilindros()>=10){
            resultado=4*this.getPMA();
        } else {
            resultado=3*this.getPMA();
        }
        return resultado + this.getCilindros()*15;
    }
}
