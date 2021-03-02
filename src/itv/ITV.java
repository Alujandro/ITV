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
public class ITV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //El taller tiene 6 boxes
        //
        //Se debe poner una opción que permita mover todos los vehículos de un box a la siguiente fase de revisión (se presupone que todos pueden pasar)
        //Cuando un vehículo entra al taller se le toma matrícula (4 números y 3 letras), modelo y tipo enum(microbús, furgoneta o camión) matrícula actúa como clave y se mete directamente en la cola general
        //La cola no es un box, y de la cosa se pasa directamente a las fases de revisión de un box siempre y cuando no esté lleno.
        //
        //Opciones del menú:
        //1-Alta y recepción de vehículos
        //2-Reclamar vehículo para entrar en box
        //3-Mover todos los vehículos de fase
        //4-Información de estado de box (mostrar 1-6 y mostrar matrícula, modelo, etc de los vehículos y su estado, todas las fases)
        //5-Información general de box (el 4 pero con todos los boxes a la vez)
        //6-Salir del programa
        //
        //Método de trabajo:
        //1: Diseñar topología top-down
        //2: El programa mostrará el menú al inicio
        //3: Tener cuidado con la gestión de colas
        //4: Informar al usuario de todas las operaciones
        //5: Si el usuario mete datos erróneos, volverlos a pedir, usar gestorIO
        //6: Subir el archivo .zip
        //7: Recomendable hacer tests
        //8: Hacer uso de la sentencia assert para precondicionar la llamada de un método (No sé que significa esto)
    }   
    
}
