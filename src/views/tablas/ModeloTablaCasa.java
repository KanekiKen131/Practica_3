/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.tablas;

import javax.swing.table.AbstractTableModel;

public class ModeloTablaCasa extends AbstractTableModel {

    private String[][] data;
    private String[] columnNames = {"Nro Casa", "Nombre", "Largo", "Ancho", "Pisos", "Homónima"};
    private boolean[] homonimas;

    public ModeloTablaCasa() {
        this.data = new String[0][0];
        this.homonimas = new boolean[0];
    }

    public void setData(String[][] data) {
        this.data = data;
        this.homonimas = new boolean[data.length];
        detectarHomonimas();
        fireTableDataChanged();
    }

    private void detectarHomonimas() {
        for (int i = 0; i < data.length; i++) {
            if (data[i].length < 3) {
                continue;
            }
            String[] d1 = data[i][2].split(",");
            if (d1.length != 3) {
                continue;
            }

            for (int j = i + 1; j < data.length; j++) {
                if (data[j].length < 3) {
                    continue;
                }
                String[] d2 = data[j][2].split(",");
                if (d2.length != 3) {
                    continue;
                }

                if (sonIguales(d1, d2)) {
                    homonimas[i] = true;
                    homonimas[j] = true;
                }
            }
        }
    }

    private boolean sonIguales(String[] d1, String[] d2) {
        return d1[0].trim().equals(d2[0].trim())
                && d1[1].trim().equals(d2[1].trim())
                && d1[2].trim().equals(d2[2].trim());
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (data.length == 0) {
            return null;
        }

        if (columnIndex < 2) {

            return data[rowIndex][columnIndex];
        } else if (columnIndex < 5) {

            String[] dimensiones = data[rowIndex][2].split(",");
            return dimensiones[columnIndex - 2];
        } else if (columnIndex == 5) {

            return homonimas[rowIndex] ? "Sí" : "No";
        }

        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
