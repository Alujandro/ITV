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
public abstract class Vehiculo {
    //Atributos
    protected String matricula;
    protected String modelo;
    protected int tipo;
    protected int plazas;
    protected int cilindros;
    protected int centimetroscubicos;
    public static final String PATRON="\\d{4}[A-Z]{3}";
    public static final String[] TIPOS={"Coche","Microbús","Furgoneta","Camión"};
    public static final double BASE=15;
    
    //Constructores
    public Vehiculo(){
        
    }
    public Vehiculo(String ma, String mo, int ti){
        //Usado principalmente para pruebas
        this.matricula=ma;
        this.modelo=mo;
        this.tipo=ti;
    }
    
    public Vehiculo(String ma, String mo, int ti, int p, int c, int cc){
        this.matricula=ma;
        this.modelo=mo;
        this.tipo=ti;
        this.plazas=p;
        this.cilindros=c;
        this.centimetroscubicos=cc;
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
    
    public int getTipo(){
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
        this.tipo=i-1;
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
        int cili, plaz, num, cece, tip;
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
        tip=num-1;
        cili=llenaCili(num);
        plaz=llenaPlazas(num);
        cece=llenaCC();
        
        
        return newVehiculo(matri, mode, tip, cili, plaz, cece); //Esto está para ser reparado haciendo una llamada dependiendo de num
    }
    
    public static Vehiculo newVehiculo(String matri, String mode, int tip, int cili, int plaz, int cece){ //Retocar para que funcione correctamente
        switch (tip) {
            case 1:
                return new Coche(matri, mode, tip, cili, plaz, cece);
            case 2:
                return new Microbus(matri, mode, tip, cili, plaz, cece);
            case 3:
                return new VehiculoDeCarga(matri, mode, tip, cili, plaz, cece);
            case 4:
                return new Camion(matri, mode, tip, cili, plaz, cece);
            default:
                return new Coche(matri, mode, tip, cili, plaz, cece);
        }
    }
    
    public static Vehiculo sustitutoCopia(Vehiculo co){ //Retocar para que funcione correctamente
        switch (co.getTipo()) {
            case 1:
                return new Coche(co);
            case 2:
                return new Microbus(co);
            case 3:
                return new VehiculoDeCarga(co);
            case 4:
                return new Camion(co);
            default:
                return new Coche(co);
        }
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
    
    public abstract double calculaCoste();
    
    @Override
    public String toString(){
        return "Matrícula: "+this.matricula+" Modelo: "+this.modelo+" Tipo: "+TIPOS[this.getTipo()]; //Cambiado el funcionamiento de tipo
    }
    
}
