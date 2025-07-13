/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;
import controller.Casas;
/**
 *
 * @author alexa
 */
public class GuadadoCasa {
    public static void main(String[] args) {
        Casas c = new Casas();
        if (c.guardar_archivo("hola", 120.5f, 123f, 0)){
            
            System.out.println("Se ha guardado correctamente");
        }else
            System.out.println("Se ha presentado un error"); 
} 
}
