/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itv;

/**
 *
 * @author ciclost
 */
public class Coches {
    //Atributos
    private String matricula;
    private String modelo;
    private String tipo;
    
    //Constructores
    public Coches(String ma, String mo, String ti){
        this.matricula=ma;
        this.modelo=mo;
        this.tipo=ti;
    }
    
    public Coches(Coches co){
        this.matricula=co.getMatricula();
        this.modelo=co.getModelo();
        this.tipo=co.getTipo();
    }
    
    //Métodos
    public String getMatricula(){
        return this.matricula;
    }
    
    public String getModelo(){
        return this.modelo;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    @Override
    public String toString(){
        return "Matrícula: "+this.matricula+" Modelo: "+this.modelo+" Tipo: "+this.tipo;
    }
    
}
