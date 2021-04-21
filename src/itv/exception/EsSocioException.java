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
public class EsSocioException extends Exception{
    private Cliente socio;

    public EsSocioException(Cliente cli, String mensaje) {
        super(mensaje);
        this.socio = cli;
    }
    
    public boolean getTarjeta(){
        return socio.getTarjeta();
    }
    
    @Override
    public String toString(){
        return "Ya tiene tarjeta";
    }
}
