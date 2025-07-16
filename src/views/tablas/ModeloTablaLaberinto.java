/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.tablas;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alexa
 */
public class ModeloTablaLaberinto extends AbstractTableModel {

    private String[][] laberinto;
    private String[] columnNames;

    public ModeloTablaLaberinto() {
        this.laberinto = new String[0][0];
        this.columnNames = new String[0];
    }

    public ModeloTablaLaberinto(String[][] laberinto) {
        setLaberinto(laberinto);
    }

    public void setLaberinto(String[][] laberinto) {
        if (laberinto == null) {
            this.laberinto = new String[0][0];
            this.columnNames = new String[0];
        } else {
            this.laberinto = laberinto;
            if (laberinto.length > 0) {
                this.columnNames = new String[laberinto[0].length];
                for (int i = 0; i < laberinto[0].length; i++) {
                    this.columnNames[i] = String.valueOf(i);
                }
            } else {
                this.columnNames = new String[0];
            }
        }

        fireTableStructureChanged();
    }

    public String[][] getLaberinto() {
        return laberinto;
    }

    @Override
    public int getRowCount() {
        return laberinto.length;
    }

    @Override
    public int getColumnCount() {
        if (laberinto.length == 0) {
            return 0;
        }
        return laberinto[0].length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex >= 0 && rowIndex < laberinto.length
                && columnIndex >= 0 && columnIndex < laberinto[rowIndex].length) {
            return laberinto[rowIndex][columnIndex];
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        if (column >= 0 && column < columnNames.length) {
            return columnNames[column];
        }
        return " ";
    }

    

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

}