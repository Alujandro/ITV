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
public class Microbus extends Vehiculo{
    public Microbus (String matri, String mode, int tip, int cili, int plaz, int cece){
        super(matri, mode, tip, cili, plaz, cece);
    }
    
    public Microbus(Vehiculo co){
        super(co);
        
    }
    
    @Override
    public double calculaCoste(){
        double resultado=0;
        if (this.getCentimetrosCubicos()>1200){
            resultado=10;
        }
        if (this.getPlazas()>3){
            resultado+=(this.getPlazas()-3)*2.0;
        }
        return resultado + this.getCilindros()*15;
    }
}
