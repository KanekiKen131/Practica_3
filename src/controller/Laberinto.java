
package controller;
import java.util.Random;

/**
 *
 * @author alexa
 */
public class Laberinto {

    private static final String MURO = "";
    private static final String CAMINO = " ";
    private static final String ENTRADA = "I";
    private static final String SALIDA = "F";

    private Random random;

    public Laberinto() {
        this.random = new Random();
    }
/**
 * 
 * @param dimension
 * @return
 * @throws IllegalArgumentException 
 */
    public String[][] generarLaberinto(int dimension) throws IllegalArgumentException {
        if (dimension < 10 || dimension > 100) {
            throw new IllegalArgumentException("La dimensión debe estar entre 10 y 100");
        }
        double porcentajeMuros = calcularMuros();
        String[][] laberinto = new String[dimension][dimension];
        llenarCaminos(laberinto);
        colocarMuros(laberinto, porcentajeMuros);
        colocarEntradaSalida(laberinto);

        return laberinto;
    }
/**
 * 
 * @return 
 */
    private double calcularMuros() {
        double porcentaje = 40 + (random.nextDouble() * 20);
        return porcentaje / 100.0;
    }
/**
 * 
 * @param laberinto 
 */
    private void llenarCaminos(String[][] laberinto) {
        for (int i = 0; i < laberinto.length; i++) {
            for (int j = 0; j < laberinto[i].length; j++) {
                laberinto[i][j] = CAMINO;
            }
        }
    }
/**
 * 
 * @param laberinto
 * @param porcentajeMuros 
 */
    private void colocarMuros(String[][] laberinto, double porcentajeMuros) {
        int dimension = laberinto.length;
        int totalCeldas = dimension * dimension;
        int numeroMuros = (int) (totalCeldas * porcentajeMuros);

        int murosColocados = 0;

        while (murosColocados < numeroMuros) {
            int fila = random.nextInt(dimension);
            int columna = random.nextInt(dimension);

            if (laberinto[fila][columna].equals(CAMINO)) {
                laberinto[fila][columna] = MURO;
                murosColocados++;
            }
        }
    }
/**
 * 
 * @param laberinto 
 */
    private void colocarEntradaSalida(String[][] laberinto) {
        int dimension = laberinto.length;
        boolean entradaColocada = false;
        int intentosEntrada = 0;
        while (!entradaColocada && intentosEntrada < 100) {
            int filaEntrada = 0; 
            int columnaEntrada = random.nextInt(dimension);

            if (!laberinto[filaEntrada][columnaEntrada].equals(MURO)) {
                laberinto[filaEntrada][columnaEntrada] = ENTRADA;
                entradaColocada = true;
            } else {

                laberinto[0][0] = ENTRADA;
                entradaColocada = true;
            }
            intentosEntrada++;
        }

        boolean salidaColocada = false;
        int intentosSalida = 0;

        while (!salidaColocada && intentosSalida < 100) {
            int filaSalida = dimension - 1;
            int columnaSalida = random.nextInt(dimension);

            if (!laberinto[filaSalida][columnaSalida].equals(MURO)
                    && !laberinto[filaSalida][columnaSalida].equals(ENTRADA)) {
                laberinto[filaSalida][columnaSalida] = SALIDA;
                salidaColocada = true;
            } else {
                laberinto[dimension - 1][dimension - 1] = SALIDA;
                salidaColocada = true;
            }
            intentosSalida++;
        }
    }
   }
