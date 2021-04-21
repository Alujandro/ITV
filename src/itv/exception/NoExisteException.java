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
public class NoExisteException extends Exception{
    private Cliente cliente;

    public NoExisteException(Cliente hayCliente, String mensaje) {
        super(mensaje);
        this.cliente = hayCliente;
    }
    
    public int getCodigo(){
        return cliente.getCodigo();
    }
    
    @Override
    public String toString(){
        return super.toString();
    }
}