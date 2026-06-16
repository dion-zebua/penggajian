/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian.helper;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.*;
import penggajian.model.JabatanModel;

/**
 *
 * @author Dion
 */
public class BaseSetting {
    
    public static String getBrand(){
        return "SMK Forward Nusantara";
    }
    public static Color getPrimaryColor() {
        return new Color(131, 22, 22);
    }
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
        UIManager.put("ComboBox.font", font);
        UIManager.put("TextArea.font", font);
    }
    
    public static void setTitlePage(JLabel label) {
        label.setForeground(getPrimaryColor());
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        label.setFont(new Font("Tahoma", Font.BOLD, 48));
        label.setHorizontalAlignment(SwingConstants.CENTER);
    }
    
    public static void setBoxPanel(JPanel panel) {
        setBoxPanel(panel, true);
    }
    public static void setBoxPanel(JPanel panel, Boolean light) {
        panel.setBackground(light ? new java.awt.Color(255, 255, 255) : getPrimaryColor());
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
    }
        
    public static void setTitlePanel(JLabel label) {        
        setTitlePanel(label, 36, false);
    }
    public static void setTitlePanel(JLabel label, Boolean light) {        
        setTitlePanel(label, 36, light);
    }
    public static void setTitlePanel(JLabel label, int size) {        
        setTitlePanel(label, size, false);
    }
    public static void setTitlePanel(JLabel label, int size, Boolean light) {
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        label.setForeground(light ? new Color(255,255,255) : new Color(50,50,50));
        label.setFont(new Font("Tahoma", Font.PLAIN, size));
    }
    
    public static void setTable(JTable table) {
        
        Font font = new Font("Tahoma", Font.PLAIN, 24);
        table.setRowHeight(40);
        table.setFont(font);

        table.setGridColor(new java.awt.Color(204, 204, 204));

        table.setIntercellSpacing(new Dimension(15, 10));

        table.setRowSorter(null);
        table.setAutoCreateRowSorter(false);

        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);

        table.getTableHeader().setFont(font);
    }
    
    public static void setButton(JButton btn) {

        btn.setBackground(new Color(40, 39, 39));
        if(!btn.getText().equalsIgnoreCase("delete")){
            btn.setBackground(getPrimaryColor());
        }
        btn.setMargin(new java.awt.Insets(7, 14, 7, 14));
        btn.setForeground(new java.awt.Color(255, 255, 255));
    }
    
    
    public static void setInput(JTextField input) 
    {    
        input.setMargin(new java.awt.Insets(5, 10, 5, 10));
        java.awt.Dimension minSize = new java.awt.Dimension(300, 50);
        input.setMinimumSize(minSize);
        input.setPreferredSize(minSize); 
    }
    
    public static void setCombo(JComboBox<?> comboBox) 
    {    
        comboBox.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        Dimension minSize = new Dimension(300, 50);
        comboBox.setBackground(new java.awt.Color(255, 255, 254));
        comboBox.setMinimumSize(minSize);
        comboBox.setPreferredSize(minSize); 
    }

    
    public static void setDialog(JDialog dialog)
    {
        dialog.getRootPane().setBorder(
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );
            
//        dialog.setSize(1060, 800);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
        dialog.setVisible(true);  
    }
    public static void unsetDialog(JDialog dialog)
    {
        dialog.setVisible(false);
        dialog.dispose();
    }
    
    public static void exportTable(JTable table){
        try {
            table.print();
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Print Gagal: " + e.getMessage());
        }
    }
    
    public static String setRupiah(int nominal) {
        DecimalFormat kursIndonesia = (DecimalFormat)
                DecimalFormat.getCurrencyInstance();

        DecimalFormatSymbols formatRp =
                new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);

        return kursIndonesia.format(nominal);
    }
}
