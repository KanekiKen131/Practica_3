/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.tablas;

import javax.swing.table.AbstractTableModel;

public class ModeloTablaUsuario extends AbstractTableModel {

    private Integer[][] datos;
    private int filas = 0;
    private int columnas = 0;

    public void setDatos(Integer[][] datos, int filas, int columnas) {
        this.datos = datos;
        this.filas = filas;
        this.columnas = columnas;
        fireTableStructureChanged();
    }

    @Override
    public int getRowCount() {
        return filas;
    }

    @Override
    public int getColumnCount() {
        return columnas;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (datos != null && rowIndex < datos.length && columnIndex < datos[0].length) {
            Integer valor = datos[rowIndex][columnIndex];
            if (valor != null) {
                if (valor == -1) {
                    return " - ";
                } else if (valor == -2) {
                    return " - ";
                }
            }

            return valor;
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return "Col " + (column + 1);
    }

     @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

}
