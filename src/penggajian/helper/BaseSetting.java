/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian.helper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/**
 *
 * @author Dion
 */
public class BaseSetting {
    public static void applyFrame(JFrame frame) {
        frame.setMinimumSize(new Dimension(1800, 1012));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(0, 0);
    }
    
    
    public static void setGlobalFont() {

        Font font = new Font("Tahoma", Font.PLAIN, 24);

        UIManager.put("Label.font", font);
        UIManager.put("Button.font", font);
        UIManager.put("TextField.font", font);
        UIManager.put("PasswordField.font", font);
        UIManager.put("OptionPane.messageFont", font);
    }
    

    
    public static void setTitlePage(JLabel label, String text) {
        label.setText(text);
        label.setForeground(new Color(51, 0, 153));
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        label.setFont(new Font("Tahoma", Font.BOLD, 48));
        label.setHorizontalAlignment(SwingConstants.CENTER);
    }
    
    public static void setBoxPanel(JPanel panel) {
        setBoxPanel(panel, true);
    }
    public static void setBoxPanel(JPanel panel, Boolean light) {
        panel.setBackground(light ? new java.awt.Color(255, 255, 255) : new java.awt.Color(51, 0, 153));
        panel.setLayout(new javax.swing.BoxLayout(panel, javax.swing.BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
    }
        
    public static void setTitlePanel(JLabel label, String text) {        
        setTitlePanel(label, text, 36, false);
    }
    public static void setTitlePanel(JLabel label, String text, Boolean light) {        
        setTitlePanel(label, text, 36, light);
    }
    public static void setTitlePanel(JLabel label, String text, int size) {        
        setTitlePanel(label, text, size, false);
    }
    public static void setTitlePanel(JLabel label, String text, int size, Boolean light) {
        label.setText(text);
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        label.setForeground(light ? new Color(255,255,255) : new Color(50,50,50));
        label.setFont(new Font("Tahoma", Font.PLAIN, size));
    }
    
    public static void setTable(JTable table) {
        
        table.setRowHeight(40);
        table.setFont(new Font("Tahoma", Font.PLAIN, 24));

        table.setGridColor(new java.awt.Color(204, 204, 204));

        table.setIntercellSpacing(new Dimension(15, 10));

        table.setRowSorter(null);
        table.setAutoCreateRowSorter(false);

        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);

        table.getTableHeader().setFont(
            new Font("Tahoma", Font.BOLD, 24)
        );
    }
}
