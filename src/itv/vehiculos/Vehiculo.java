/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itv.vehiculos;

import itv.Taller;
import java.util.regex.Pattern;
import java.util.Scanner;
import itv.util.GestorIO;

/**
 *
 * @author ciclost
 */
public class Vehiculo {
    //Atributos
    protected String matricula;
    protected String modelo;
    protected String tipo;
    protected int plazas;
    protected int cilindros;
    protected int centimetroscubicos;
    public static final String PATRON="\\d{4}[A-Z]{3}";
    public static final String[] TIPOS={"Coche","Microbús","Furgoneta","Camión"};
    
    //Constructores
    public Vehiculo(String ma, String mo, String ti){
        //Usado principalmente para pruebas
        this.matricula=ma;
        this.modelo=mo;
        this.tipo=ti;
    }
    
    public Vehiculo(String ma, String mo, String ti, int p, int c, int cc){
        this.matricula=ma;
        this.modelo=mo;
        this.tipo=ti;
        this.plazas=p;
        this.cilindros=c;
        this.centimetroscubicos=cc;
    }
    
    public Vehiculo(){
        this.matricula=null;
        this.modelo=null;
        this.tipo=null;
        this.plazas=0;
        this.cilindros=0;
        this.centimetroscubicos=0;
    }
    
    public Vehiculo(Vehiculo co){
        if (co!=null){
            this.matricula=co.getMatricula();
            this.modelo=co.getModelo();
            this.tipo=co.getTipo();
            this.plazas=co.getPlazas();
            this.cilindros=co.getCilindros();
            this.centimetroscubicos=co.getCentimetrosCubicos();
        }
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
    
    public int getPlazas(){
        return this.plazas;
    }
    
    public int getCilindros(){
        return this.cilindros;
    }
    
    public int getCentimetrosCubicos(){
        return this.centimetroscubicos;
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
    
    public void setPlazas(int i){
        this.plazas=i;
    }
    
    public void setCilindros(int i){
        this.cilindros=i;
    }
    
    public void setCentimetrosCubicos(int i){
        this.centimetroscubicos=i;
    }
    
    //LLENA COCHE DEBE DEVOLVER UN OBJETO COCHE PARA PODER HACER UNO NUEVO SIN COMPLICACIONES -Este método va a acabar formando parte de los hijos en vez del padre (espero que no)
    public static Vehiculo llenaCoche(Taller t1){ 
        Scanner enter=new Scanner(System.in);
        GestorIO nume=new GestorIO();
        String matri;
        String mode;
        String tip;
        int cili, plaz, num, cece;
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
        cili=llenaCili(num);
        plaz=llenaPlazas(num);
        cece=llenaCC();
        
        
        return new Vehiculo(matri,mode,tip,cili,plaz,cece);
    }
    
    public static int llenaPlazas(int uno){
        GestorIO nume=new GestorIO();
        int num;
        switch (uno-1){
            case 0:
                System.out.print("Introduce la cantidad de plazas: ");
                while (true){
                    num=nume.inInt();
                    if (num>7 || num<2){
                        System.out.print("Introduce un número [2-7]: ");
                    } else {
                        return num;
                    }
                }
            case 1:
                System.out.print("Introduce la cantidad de plazas: ");
                while (true){
                    num=nume.inInt();
                    if (num>20 || num<2){
                        System.out.print("Introduce un número [2-20]: ");
                    } else {
                        return num;
                    }
                }
            default:
                return 2;
        }
    }
    
    public static int llenaCili(int uno){
        GestorIO nume=new GestorIO();
        int num;
        System.out.print("Introduce la cantidad de cilindros: ");
        switch (uno-1){
            case 0:
            case 1:
                while (true){
                    num=nume.inInt();
                    if (num>6 || num<2){
                        System.out.print("Introduce un número [2-6]: ");
                    } else {
                        return num;
                    }
                }
            case 2:
                while (true){
                    num=nume.inInt();
                    if (num>10 || num<4){
                        System.out.print("Introduce un número [4-10]: ");
                    } else {
                        return num;
                    }
                }
            case 3:
                while (true){
                    num=nume.inInt();
                    if (num>16 || num<8){
                        System.out.print("Introduce un número [8-16]: ");
                    } else {
                        return num;
                    }
                }
            default:
                return 0;
        }
    }
    
    public static int llenaCC(){
        GestorIO nume=new GestorIO();
        int num;
        System.out.print("Introduce el tamaño del motor [centímetros cúbicos]: ");
        while (true){
            num=nume.inInt();
            if (num<0){
                System.out.print("Introduce una cantidad válida: ");
            } else {
                return num;
            }
        }
    }
    
    @Override
    public String toString(){
        return "Matrícula: "+this.matricula+" Modelo: "+this.modelo+" Tipo: "+this.tipo;
    }
    
}
