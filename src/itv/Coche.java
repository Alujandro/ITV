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
public class Coche {
    //Atributos
    private String matricula;
    private String modelo;
    private String tipo;
    public static final String PATRON="\\d{4}[A-Z]{3}";
    public static final String[] TIPOS={"Coche","Microbús","Furgoneta","Camión"};
    
    //Constructores
    public Coche(String ma, String mo, String ti){
        this.matricula=ma;
        this.modelo=mo;
        this.tipo=ti;
    }
    
    public Coche(Coche co){
        if (co!=null){
            this.matricula=co.getMatricula();
            this.modelo=co.getModelo();
            this.tipo=co.getTipo();
        }
    }
    
    public Coche(){
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
    
    public static boolean matriculaValida(String mat, Taller t1){
        return Pattern.matches(PATRON, mat) && !t1.matriculaRepe(mat);
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
    public static Coche llenaCoche(Taller t1){
        Scanner enter=new Scanner(System.in);
        GestorIO nume=new GestorIO();
        String matri;
        String mode;
        String tip;
        int num;
        String entrar;
        System.out.print("Introduce la matrícula: ");
        entrar=enter.nextLine();
        while (!matriculaValida(entrar, t1)){
            System.out.print("Intoduce una matrícula válida: ");
            entrar=enter.nextLine();
        }
        matri=entrar;
        System.out.print("Introduce el modelo: ");
        mode=enter.nextLine();
        System.out.print("Introduce el tipo [1-Coche, 2-Microbús, 3-Furgoneta, 4-Camión]: ");
        while (true){
            num=nume.inInt();
            if (num>4 || num<1){
                System.out.print("Introduce un número [1-4]: ");
            } else {
                break;
            }
        }
        tip=TIPOS[num-1];
        
        return new Coche(matri,mode,tip);
    }
    @Override
    public String toString(){
        return "Matrícula: "+this.matricula+" Modelo: "+this.modelo+" Tipo: "+this.tipo;
    }
    
}
