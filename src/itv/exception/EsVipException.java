/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itv.exception;
import itv.clientes.Cliente;

/**
 *
 * @author ciclost
 */
public class EsVipException extends Exception{
    private Cliente vip;

    public EsVipException(Cliente cli, String mensaje) {
        super(mensaje);
        this.vip = cli;
    }
    
    public boolean getVip(){
        return vip.getVip();
    }
    
    @Override
    public String toString(){
        return super.toString();
    }
    
}
