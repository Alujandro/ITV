/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itv;
import itv.util.GestorIO;

/**
 *
 * @author ciclost
 */
public class Taller {
    //Atributos
    public final Box[] todas;
    public final ColaGeneral cola;
    
    //Constructores
    public Taller(){
        this.todas=new Box[6];
        for (int i=0; i<this.todas.length; i++){
            this.todas[i]=new Box();
            
        }
        this.cola=new ColaGeneral();
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
            System.out.println("ITV talleres Parodi");
            System.out.println("1-Alta y recepción de vehículos");
            System.out.println("2-Reclamar vehículo para box");
            System.out.println("3-Avanzar box de fase");
            System.out.println("4-Información de box");
            System.out.println("5-Información de todos los boxes");
            System.out.println("6-Salir del programa");
            System.out.print("Introduce una opción [1-6]: ");
            salida=opcion(numeroValido());
        }
    }
    
    public int numeroValido(){
        GestorIO menu=new GestorIO();
        int opcion;
        while (true){
            opcion=menu.inInt();
            if (opcion<=6 && 1<=opcion){
                return opcion;
            }
            System.out.print("Introduce un número [1-6]: ");
        }
    }
    public int numeroValidoDos(){
        GestorIO menu=new GestorIO();
        int opcion;
        while (true){
            opcion=menu.inInt();
            if (opcion<=4 && 1<=opcion){
                return opcion;
            }
            System.out.print("Introduce un número [1-4]: ");
        }
    }
    
    public boolean opcion(int num){
        int i;
        int j;
        switch (num) {
            case 1:
                //Código
                cola.setCoche(Coches.llenaCoche());
                return false;
            case 2:
                //Código
                while (true){
                    if (sinBoxLibre()){
                        System.out.println("No quedan Boxes libres");
                        break;
                    }
                    System.out.print("Introduce un número de box [1-6]");
                    i=numeroValido();
                    if (!cola.meterEnBox(todas[i])){
                        System.out.println("Box ocupado.");
                    } else {
                        System.out.println("Operación realizada con éxito");
                        break;
                    }
                }
                return false;
            case 3:
                //Código
                i=numeroValido();
                todas[i].avanzar();
                return false;
            case 4:
                //Código
                i=numeroValido();
                j=numeroValidoDos();
                todas[i].getVehiculo(j);
                return false;
            case 5:
                //Código
                muestraBoxes();
                return false;
            case 6:
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
            }
        }
        return true;
    }
}
