/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itv.exception;
import itv.vehiculos.Vehiculo;

/**
 *
 * @author ciclost
 */
public class YaExisteException extends Exception{
    private Vehiculo cocherepe;

    public YaExisteException(Vehiculo cochemal, String mensaje) {
        super(mensaje);
        this.cocherepe = cochemal;
    }
    
    public String getVehiculoRepetido(){
        return cocherepe.getMatricula();
    }
    
    @Override
    public String toString(){
        return super.toString()+" matrícula "+getVehiculoRepetido();
    }
}
