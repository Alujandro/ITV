/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itv.exception;
import itv.ColaGeneral;

/**
 *
 * @author ciclost
 */
public class ColaLlenaException extends Exception{
    int longitudCola;
    
    public ColaLlenaException(ColaGeneral cola, String mensaje) {
        super(mensaje);
        this.longitudCola = cola.getTOTAL();
    }
    
    public int getLongitudCola(){
        return this.longitudCola;
    }
    
    @Override
    public String toString(){
        return super.toString();
    }
}
