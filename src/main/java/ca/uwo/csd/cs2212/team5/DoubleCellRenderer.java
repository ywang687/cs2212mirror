package ca.uwo.csd.cs2212.team5;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;

import javax.swing.*;

public class DoubleCellRenderer extends DefaultTableCellRenderer {
    private static final long serialVersionUID = 1L;
    private static final DecimalFormat formatter = new DecimalFormat( "#.###" );

    public DoubleCellRenderer(){
        super();
        formatter.setMinimumFractionDigits(3);
    }

    public Component getTableCellRendererComponent(
        JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    // First format the cell value as required

        if(value instanceof Double){
            value = formatter.format((Number)value);
        }

        return super.getTableCellRendererComponent(
            table, value, isSelected, hasFocus, row, column );
    } 
}
