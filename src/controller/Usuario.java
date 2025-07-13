/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Random;

/**
 *
 * @author alexa
 */
public class Usuario {

    private Integer[][] matriz;
   
    Random r = new Random();

    public void setMatriz(Integer[][] matriz) {
        this.matriz = matriz;
    }
/**
 * 
 * @param filas
 * @param columnas
 * @return 
 */
    public Integer[][] crearMatriz(int filas, int columnas) {
        Integer[][] matriz = new Integer[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {

                matriz[i][j] = r.nextInt(100) + 1;
            }
        }

        return matriz;
    }
/**
 * 
 * @param numero
 * @param matriz
 * @return 
 */
    public boolean eliminarNumero(int numero, Integer[][] matriz) {
        if (matriz == null) {
            return false;
        }
        boolean encontrado = false;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] != null && matriz[i][j].equals(numero)) {
                    matriz[i][j] = -1;
                    encontrado = true;
                }
            }
        }
        return encontrado;
    }
/**
 * 
 */
    public void eliminarNumerosPrimos() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (Primo(matriz[i][j])) {
                    matriz[i][j] = -2;
                }
            }
        }
    }
/**
 * 
 * @return 
 */
    public int nrPrimos() {
        int contador = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (Primo(matriz[i][j])) {
                    contador++;
                }
            }
        }
        return contador;
    }
/**
 * 
 * @param numero
 * @return 
 */
    private boolean Primo(int numero) {
        if (numero <= 1) {
            return false;
        }
        if (numero == 2) {
            return true;
        }
        if (numero % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= numero; i += 2) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

}
