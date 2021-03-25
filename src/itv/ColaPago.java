/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itv;

import itv.vehiculos.Vehiculo;

/**
 *
 * @author ciclost
 */
public class ColaPago {
    private Vehiculo[] cola, auxiliar;
    private static int TAMANO=0;
    
    public ColaPago(){
        this.cola=new Vehiculo[TAMANO];
        this.auxiliar=new Vehiculo[TAMANO];
    }
    
    public void llenaCola(Vehiculo ve){
        for (int i=0; i<cola.length; i++){
            auxiliar[i]=cola[i];
        }
        TAMANO++;
        this.cola=new Vehiculo[TAMANO];
        for (int i=0; i<auxiliar.length; i++){
            cola[i]=auxiliar[i];
        }
        this.cola[TAMANO]=ve;
    }
    
    public void vaciaCola(Vehiculo ve){
        for (int i=0; i<cola.length; i++){
            auxiliar[i]=cola[i];
        }
        TAMANO--;
        this.cola=new Vehiculo[TAMANO];
        for (int i=0; i<(auxiliar.length-1); i++){
            cola[i]=auxiliar[i];
        }
    }
}
