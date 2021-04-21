/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itv;

import itv.vehiculos.Vehiculo;
import java.util.Scanner;

/**
 *
 * @author ciclost
 */
public class ColaPago {
    private Vehiculo[] cola, auxiliar;
    private static int TAMANO=0;
    private static double GANANCIAS=0;
    
    public ColaPago(){
        this.cola=new Vehiculo[TAMANO];
        this.auxiliar=new Vehiculo[TAMANO];
    }
    
    public double getGanancias(){
        return GANANCIAS;
    }
    
    public void llenaCola(Vehiculo ve){
        for (int i=0; i<cola.length; i++){
            auxiliar[i]=cola[i];
        }
        TAMANO++;
        this.cola=new Vehiculo[TAMANO];
        this.auxiliar=new Vehiculo[TAMANO];
        for (int i=0; i<auxiliar.length; i++){
            cola[i]=auxiliar[i];
        }
        this.cola[TAMANO-1]=ve;
        this.auxiliar=new Vehiculo[TAMANO];
    }
    
    public void coste(Vehiculo ve){
        System.out.println(ve.toString());
        System.out.println("La cantidad a pagar es de "+ve.calculaCoste()+"€");//Hay que mostrar el pago y luego llamar a vaciaCola
        GANANCIAS+=ve.calculaCoste();
    }
    
    public void vaciaCola(){
        Scanner ten=new Scanner(System.in);
        if (TAMANO>0) {
            coste(cola[TAMANO - 1]);
            for (int i = 0; i < cola.length; i++) {
                auxiliar[i] = cola[i];
            }
            TAMANO--;
            this.cola = new Vehiculo[TAMANO];
            for (int i = 0; i < (auxiliar.length - 1); i++) {
                cola[i] = auxiliar[i];
            }
        } else {
            System.out.print("No hay vehículos pendientes por pagar");
        }
        ten.nextLine(); //Esto nos obliga a pulsar intro para volver a ver el menú
    }
}
