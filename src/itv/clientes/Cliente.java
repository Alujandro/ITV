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
    private int codigo, revisiones, telefono;
    private boolean tarjeta;
    private String nombre;
    private final boolean vip;
    private static int cuenta;
    
    public Cliente(){
        this.codigo=cuenta;
        this.tarjeta=false;
        this.vip=false;
        this.nombre=null;
        this.telefono=0;
        this.revisiones=0;
        cuenta++;
    }
    
    public Cliente(String nom, int tl, boolean vip){
        this.nombre=nom;
        this.telefono=tl;
        this.revisiones=0;
        this.codigo=cuenta;
        this.tarjeta=false;
        this.vip=vip;
        cuenta++;
    }
    
    public Cliente(String nom, int tl){
        this.nombre=nom;
        this.telefono=tl;
        this.revisiones=0;
        this.codigo=cuenta;
        this.tarjeta=false;
        this.vip=false;
        cuenta++;
    }
    
    public int getCodigo(){
        return this.codigo;
    }
    public int getRevisiones(){
        return this.revisiones;
    }
    public boolean getVip(){
        return this.vip;
    }
    public boolean getTarjeta(){
        return this.tarjeta;
    }
    public String getNombre(){
        return this.nombre;
    }
    public int getTelefono(){
        return this.telefono;
    }
    
    public void setTarjeta(){
        if (vip){
            //throw YaExisteException();
        } else {
            this.tarjeta=true;
        }
    }
    public void setNombre(String no){
        this.nombre=no;
    }
    public void setTelefono(int tlf){
        this.telefono=tlf;
    }
    
    public void incrementoRevision(){
        this.revisiones++;
    }
}
