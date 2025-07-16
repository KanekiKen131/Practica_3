/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author alexa
 */
public class Utilidades {

    private final String path = "data";

    /**
     * Metodo para crear la carpeta de la data.
     */
    public Utilidades() {
        File directory = new File(path);
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Directorio '" + path + "creado exitosamente. ");
            } else {
                System.err.println("Error: No se pudo crear el directorio '" + path + "'.");
            }
        }
    }

    /**
     * Metodo de guardado.
     *
     * @param text
     * @param name_file
     * @throws IOException
     */
    public void save(String text, String name_file) throws IOException {
        try (FileWriter file = new FileWriter(path + File.separatorChar + name_file, true)) {
            file.write(text);
        }
    }

    /**
     * Metodo utilizado en listAll para poder registrar los datos al archivo
     *
     * @param name_file
     * @return
     * @throws IOException
     */
    private int countRegister(String name_file) throws IOException {
        File fileCheck = new File(path + File.separatorChar + name_file);
        if (!fileCheck.exists() || fileCheck.length() == 0) {
            return 0;
        }
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileCheck))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * metodo aparte que se utiliza en listAll para poder colocar ordenadamente
     * los datos en cada columna.
     *
     * @param name_file
     * @return
     * @throws IOException
     */
    private int countColumn(String name_file) throws IOException {
        File fileCheck = new File(path + File.separatorChar + name_file);
        if (!fileCheck.exists() || fileCheck.length() == 0) {
            return 0;
        }
        try (FileReader file = new FileReader(fileCheck); BufferedReader br = new BufferedReader(file)) {
            String line = br.readLine();

            if (line == null || line.trim().isEmpty()) {
                return 0;
            }
            return line.split("\t").length;
        }
    }

    /**
     * Metodo para poder listar los datos en un archivo.
     *
     * @param name_file
     * @return
     * @throws IOException
     */
    public String[][] listAll(String name_file) throws IOException {
        File fileCheck = new File(path + File.separatorChar + name_file);
        if (!fileCheck.exists() || fileCheck.length() == 0) {
            return new String[0][0]; // esta linea me dice que devuelve una matriz vacía si el archivo no existe o está vacío
        }

        Integer filas = countRegister(name_file);
        if (filas == 0) {
            return new String[0][0];
        }
        Integer columna = countColumn(name_file);
        if (columna == 0) {
            return new String[0][0];
        }

        String[][] data = new String[filas][columna];
        try (FileReader file = new FileReader(fileCheck); BufferedReader br = new BufferedReader(file)) {
            String linea;
            int fil = 0;
            while ((linea = br.readLine()) != null && fil < filas) {
                if (!linea.trim().isEmpty()) {
                    String[] columnas = linea.split("\t");
                    for (int j = 0; j < Math.min(columnas.length, columna); j++) {
                        data[fil][j] = columnas[j];
                    }
                    fil++;
                }
            }
        }

        return data;
    }

    /**
     * Metodo que se utiliza para el ejercicio 13.
     *
     * @param tabla
     */
    public void iniciar(int[][][] tabla) {
        for (int i = 0; i < 10; i++) {
            tabla[i][i][i] = i;
        }
    }

    /**
     * Metodo que se utiliza para el ejercicio 13.
     *
     * @param tabla
     */
    public void cargarTabla(int[][][] tabla) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    System.out.printf("%d\t", tabla[i][j][k]);
                }
                System.out.println();
            }

        }
    }

}
