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
    
    //Constructores
    public Taller(){
        this.todas=new Box[6];
    }
    
    //Métodos
    public void muestraTodo(){
        for (int i=0; i<todas.length; i++) {
            System.out.println("Box "+i+":");
            todas[i].mostrarBox();
        }
    }
    
    public void menu(){
        System.out.println("ITV talleres Parodi");
        System.out.println("1-Alta y recepción de vehículos");
        System.out.println("2-Reclamar vehículo para box");
        System.out.println("3-Avanzar box de fase");
        System.out.println("4-Información de box");
        System.out.println("5-Información de todos los boxes");
        System.out.println("6-Salir del programa");
        System.out.println("Introduce una opción [1-6]: ");
        GestorIO menu=new GestorIO();
        int opcion;
        while (true){
            opcion=menu.inInt();
            if (opcion<=6 && 1<=opcion){
                opcion(opcion);
                break;
            }
            System.out.print("Introduce un número [1-6]: ");
        }
    }
    
    public void opcion(int num){
        switch (num) {
            case 1:
                //Código
                break;
            case 2:
                //Código
                break;
            case 3:
                //Código
                break;
            case 4:
                //Código
                break;
            case 5:
                //Código
                break;
            case 6:
                //Código
                break;
            default:
                System.out.println("ERROR");
                break;
        }
    }
}
