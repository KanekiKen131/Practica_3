/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author alexa
 */
public class Casas {

    private Utilidades u = new Utilidades();
    private final String file_name = "Casas.dat";
/**
 * 
 * @param nombre
 * @param largo
 * @param ancho
 * @param pisos
 * @return 
 */
    public boolean guardar_archivo(String nombre, Float largo, Float ancho, int pisos) {
        String dimensiones = largo + "," + ancho + "," + pisos;
        String data = generar_numeracion() + "\t" + nombre + "\t" + dimensiones + "\n";
        try {
            u.save(data, file_name);
            return true;
        } catch (Exception e) {
            System.err.println("Error al guardar casa: " + e.getMessage());
            return false;
        }
    }
/**
 * 
 * @return 
 */
    public String[][] listar() {
        try {
            String[][] data = u.listAll(file_name);
            if (data == null) {
                return new String[0][0];
            }
            return data;
        } catch (Exception e) {
            System.err.println("Error al listar archivos desde " + file_name + ": " + e.getMessage());
            return new String[0][0];
        }
    }
/**
 * 
 * @return 
 */
    public String generar_numeracion() {
        String[][] listado = listar();
        int num = (listado != null) ? listado.length + 1 : 1;
        return String.format("%06d", num);
    }

}
