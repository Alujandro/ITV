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
public class Coche extends Vehiculo{
    //Cosas en común: 
    //Cilindros: Coches y microbuses de 2 a 6, furgonetas de 4 a 10 y camiones de 8 a 16
    //
    //Coches: Las plazas de 2 a 7 1,3€ por plaza por encima de 3, y se añaden 10€ si el coche tiene más de 1200cc.
    //Microbuses: Plazas máximas son 20 y el precio por plaza es 2€
    //Vehículos de carga: PMA(en toneladas) 3€ multiplicado por PMA si menos de 10 cilindros 4*PMA si tiene 10 o más
    //Camiones: se le añaden 40€ a lo calculado antes y se le añade un 20% +20€ si tiene más de 2000cc
    
    //Constructor
    public Coche (String matri, String mode, int tip, int cili, int plaz, int cece){
        super(matri, mode, tip, cili, plaz, cece);
    }
    
    public Coche(Vehiculo co){
        super(co);
        
    }
    
    @Override
    public double calculaCoste(){
        double resultado=0;
        if (this.getCentimetrosCubicos()>1200){
            resultado=10;
        }
        if (this.getPlazas()>3){
            resultado+=(this.getPlazas()-3)*1.5;
        }
        return resultado + this.getCilindros()*15;
    }
}
