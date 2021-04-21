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
public class RegistroClientes {
    private Cliente[] todoClientes=new Cliente[0];
    private Cliente[] auxiliar=new Cliente[0];
    private static int longitud=0;
    
    public RegistroClientes(){
        this.todoClientes=new Cliente[longitud];
    }
    
    public void meteCliente(Cliente cl){
        this.auxiliar=new Cliente[longitud];
        longitud++;
        for (int i = 0; i < todoClientes.length; i++) {
            this.auxiliar[i]=this.todoClientes[i];
        }
        this.todoClientes=new Cliente[longitud];
        for (int i = 0; i < auxiliar.length; i++) {
            this.todoClientes[i]=this.auxiliar[i];
        }
        this.todoClientes[longitud-1]=cl;
        
    }
    
    
}
