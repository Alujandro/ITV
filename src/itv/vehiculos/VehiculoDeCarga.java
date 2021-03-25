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
    
    public double getPMA(){
        return this.PMA;
    }
    
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
