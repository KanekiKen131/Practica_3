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
public class ModeloTablaEjercicio {

    public class ModeloTablaEjercicio1 extends AbstractTableModel {

        private String[][] data;
        private String[] columnNames = {};

        public ModeloTablaEjercicio1() {
            this.data = new String[0][0];
        }

        public void setData(String[][] data) {
            this.data = data;
            fireTableDataChanged();
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
            return data[rowIndex][columnIndex];
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }
    }
}
