/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itv;

import java.util.regex.Pattern;
import java.util.Scanner;
import itv.util.GestorIO;

/**
 *
 * @author ciclost
 */
public class Coches {
    //Atributos
    private String matricula;
    private String modelo;
    private String tipo;
    public static final String PATRON="\\d{4}[A-Z]{3}";
    public static final String[] TIPOS={"Microbús","Furgoneta","Camión"};
    
    //Constructores
    public Coches(String ma, String mo, String ti){
        this.matricula=ma;
        this.modelo=mo;
        this.tipo=ti;
    }
    
    public Coches(Coches co){
        if (co!=null){
            this.matricula=co.getMatricula();
            this.modelo=co.getModelo();
            this.tipo=co.getTipo();
        }
    }
    
    public Coches(){
        this.matricula=null;
        this.modelo=null;
        this.tipo=null;
    }
    
    //Métodos
    public String getMatricula(){
        if (this.matricula==null){
            return null;
        }
        return this.matricula;
    }
    
    public String getModelo(){
        if (this.modelo==null){
            return null;
        }
        return this.modelo;
    }
    
    public String getTipo(){
        if (this.tipo==null){
            return null;
        }
        return this.tipo;
    }
    
    public static boolean matriculaValida(String mat){
        return Pattern.matches(PATRON, mat);
    }
    
    public void setMatricula(String mat){
        this.matricula=mat;
    }
    
    public void setModelo(String mod){
        this.modelo=mod;
    }
    
    public void setTipo(int i){
        this.tipo=TIPOS[i-1];
    }
    
    //LLENA COCHE DEBE DEVOLVER UN OBJETO COCHE PARA PODER HACER UNO NUEVO SIN COMPLICACIONES
    public static Coches llenaCoche(){
        Scanner enter=new Scanner(System.in);
        GestorIO nume=new GestorIO();
        String matri;
        String mode;
        String tip;
        int num;
        String entrar;
        System.out.print("Introduce la matrícula: ");
        entrar=enter.nextLine();
        while (!matriculaValida(entrar)){
            System.out.print("Intoduzca una matrícula válida: ");
            entrar=enter.nextLine();
        }
        matri=entrar;
        System.out.print("Introduce el modelo: ");
        mode=enter.nextLine();
        System.out.print("Introduce el tipo [1-Microbús, 2-Furgoneta, 3-Camión]: ");
        while (true){
            num=nume.inInt();
            if (num>3 || num<1){
                System.out.print("Introduce un número [1-3]: ");
            } else {
                break;
            }
        }
        tip=TIPOS[num-1];
        
        return new Coches(matri,mode,tip);
    }
    @Override
    public String toString(){
        return "Matrícula: "+this.matricula+" Modelo: "+this.modelo+" Tipo: "+this.tipo;
    }
    
}
