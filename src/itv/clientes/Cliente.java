/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itv.clientes;

/**
 *
 * @author ciclost
 */
public class Cliente {
    private int codigo;
    private boolean tarjeta;
    private final boolean vip;
    private static int cuenta;
    
    public Cliente(){
        this.codigo=cuenta;
        this.tarjeta=false;
        this.vip=false;
        cuenta++;
    }
    
    public Cliente(boolean vip){
        this.codigo=cuenta;
        this.tarjeta=false;
        this.vip=vip;
        cuenta++;
    }
    
    public int getCodigo(){
        return this.codigo;
    }
    
    public void setTarjeta(){
        if (vip){
            //throw YaExisteException();
        } else {
            this.tarjeta=true;
        }
    }
}
