/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica3;
import controller.Utilidades;

public class Practica3 {
 
    public static void main(String[] args) {
        Utilidades u = new Utilidades();
        int[][][] tabla = new int[10][10][10]; 
        u.iniciar(tabla);
        u.cargarTabla(tabla);
    } 
}
