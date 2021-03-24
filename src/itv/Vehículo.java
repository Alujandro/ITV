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
public class Vehículo {
    //Atributos
    private String matricula;
    private String modelo;
    private String tipo;
    private int plazas;
    private int cilindros;
    public static final String PATRON="\\d{4}[A-Z]{3}";
    public static final String[] TIPOS={"Coche","Microbús","Furgoneta","Camión"};
    
    //Constructores
    public Vehículo(String ma, String mo, String ti){
        //Usado principalmente para pruebas
        this.matricula=ma;
        this.modelo=mo;
        this.tipo=ti;
    }
    
    public Vehículo(String ma, String mo, String ti, int p, int c){
        this.matricula=ma;
        this.modelo=mo;
        this.tipo=ti;
        this.plazas=p;
        this.cilindros=c;
    }
    
    public Vehículo(){
        this.matricula=null;
        this.modelo=null;
        this.tipo=null;
        this.plazas=0;
        this.cilindros=0;
    }
    
    public Vehículo(Vehículo co){
        if (co!=null){
            this.matricula=co.getMatricula();
            this.modelo=co.getModelo();
            this.tipo=co.getTipo();
            this.plazas=co.getPlazas();
            this.cilindros=co.getCilindros();
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
    
    //LLENA COCHE DEBE DEVOLVER UN OBJETO COCHE PARA PODER HACER UNO NUEVO SIN COMPLICACIONES
    public static Vehículo llenaCoche(Taller t1){
        Scanner enter=new Scanner(System.in);
        GestorIO nume=new GestorIO();
        String matri;
        String mode;
        String tip;
        int cili;
        int plaz;
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
        cili=llenaCili(num);
        plaz=llenaPlazas(num);
        
        return new Vehículo(matri,mode,tip,cili,plaz);
    }
    
    public static int llenaPlazas(int uno){
        GestorIO nume=new GestorIO();
        int num;
        switch (uno){
            case 0:
                while (true){
                    num=nume.inInt();
                    if (num>7 || num<2){
                        System.out.print("Introduce un número [2-7]: ");
                    } else {
                        return num;
                    }
                }
            case 1:
                while (true){
                    num=nume.inInt();
                    if (num>2 || num<20){
                        System.out.print("Introduce un número [2-20]: ");
                    } else {
                        return num;
                    }
                }
            case 2:
            case 3:
            default:
                return 2;
        }
    }
    
    public static int llenaCili(int uno){
        GestorIO nume=new GestorIO();
        int num;
        switch (uno){
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
    
    @Override
    public String toString(){
        return "Matrícula: "+this.matricula+" Modelo: "+this.modelo+" Tipo: "+this.tipo;
    }
    
}
