/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itv;
import itv.vehiculos.Vehiculo;
import itv.util.GestorIO;
import java.util.Scanner;

/**
 *
 * @author ciclost
 */
public class Taller {
    //Atributos
    public final Box[] todas;
    public final ColaGeneral cola;
    public static ColaPago pagos;
    
    //Constructores
    public Taller(){
        this.todas=new Box[6];
        for (int i=0; i<this.todas.length; i++){ //Esto no se me va a olvidar en la vida, 3 días para darme cuenta y una semana solucionando errores
            this.todas[i]=new Box();   
        }
        this.cola=new ColaGeneral();
        this.pagos=new ColaPago();
    }
    
    //Métodos
    public void muestraTodo(){
        for (int i=0; i<todas.length; i++) {
            System.out.println("Box "+i+":");
            todas[i].mostrarBox();
        }
    }
    
    public void menu(){
              
        boolean salida=false;
        while(!salida){
            System.out.println("\nITV");
            System.out.println("--------------------------------");
            System.out.println("1-Alta y recepción de vehículos");
            System.out.println("2-Reclamar vehículo para box");
            System.out.println("3-Avanzar box de fase");
            System.out.println("4-Información de box");
            System.out.println("5-Información de todos los boxes");
            System.out.println("6-Calcular y pagar vehículo revisado");
            System.out.println("7-Cálculo de ingresos");
            System.out.println("8-Salir del programa\n");
            System.out.print("Introduce una opción [1-8]: ");
            salida=opcion(menumeroValido()+1);
        }
    }
    
    public int numeroValido(){
        GestorIO menu=new GestorIO();
        int opcion;
        while (true){
            opcion=menu.inInt();
            if (opcion<=6 && 1<=opcion){
                return (opcion-1);
            }
            System.out.print("Introduce un número [1-6]: ");
        }
    }
    
    public int menumeroValido(){
        GestorIO menu=new GestorIO();
        int opcion;
        while (true){
            opcion=menu.inInt();
            if (opcion<=8 && 1<=opcion){
                return (opcion-1);
            }
            System.out.print("Introduce un número [1-8]: ");
        }
    }
    public int numeroValidoDos(){
        GestorIO menu=new GestorIO();
        int opcion;
        while (true){
            opcion=menu.inInt();
            if (opcion<=4 && 1<=opcion){
                return (opcion-1);
            }
            System.out.print("Introduce un número [1-4]: ");
        }
    }
    public boolean opcion(int num){
        Scanner ten=new Scanner(System.in);
        int i;
        switch (num) {
            case 1:
                //Código
                cola.setCoche(Vehiculo.llenaCoche(this));
                return false;
            case 2:
                //Código
                while (true){
                    if (sinBoxLibre()){
                        System.out.println("No quedan Boxes libres");
                        break;
                    }
                    System.out.print("Introduce un número de box [1-6]: ");
                    i=numeroValido();
                    if (!cola.meterEnBox(todas[i])){
                        System.out.println("Box ocupado.");
                    } else {
                        System.out.println("Operación realizada");
                        break;
                    }
                    
                }
                return false;
            case 3:
                //Código
                System.out.print("Introduce una box para avanzar [1-6]: ");
                i=numeroValido();
                todas[i].avanzar(pagos);
                System.out.println("La cola ha avanzado de forma satisfactoria");
                return false;
            case 4:
                //Código
                System.out.print("Introduce un número de Box: ");
                i=numeroValido();
                todas[i].mostrarBox();
                ten.nextLine(); //Esto nos obliga a pulsar intro para volver a ver el menú
                return false;
            case 5:
                //Código
                muestraBoxes();
                ten.nextLine(); //Esto nos obliga a pulsar intro para volver a ver el menú
                return false;
            case 6:
                //Código
                pagos.vaciaCola();
                return false;
            case 7:
                //Código
                System.out.println("Total de ingresos: "+pagos.getGanancias()+"€");
                ten.nextLine(); //Esto nos obliga a pulsar intro para volver a ver el menú
                return false;
            case 8:
                //Código
                System.out.println("Programa Finalizado");
                return true;
            default:
                System.out.println("ERROR");
                return false;
        }
    }
    
    public void muestraBoxes(){
        for (int i=0; i<this.todas.length; i++){
            System.out.println("Box "+(i+1)+": ");
            this.todas[i].mostrarBox();
        }
    }
    
    public boolean sinBoxLibre(){
        for (int i=0; i<this.todas.length; i++){
            if (this.todas[i]==null){
                return false;
            } else{
                if (this.todas[i].getVehiculo(0)==null){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean matriculaRepe(String mat){
        for (int i=0; i<cola.getTOTAL(); i++){
            if (cola.getSiguiente()!=null){
                if (mat.equals(cola.getSiguiente().getMatricula())){
                    return true;
                }
            } else {
                break;
            }
            
        }
        
        for (int i=0; i<todas.length; i++){
            for (int j=0; j<todas[i].getBoxe().length; j++){
                if (todas[i]!=null && todas[i].getVehiculo(j)!=null){
                    if (mat.equals(todas[i].getVehiculo(j).getMatricula())){
                        return true;
                    }
                } else {
                    break;
                }
            }
        }
        return false;
    }
}
