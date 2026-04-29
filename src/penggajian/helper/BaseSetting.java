/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian.helper;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
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
//        frame.setLocation(0, 0);
//        frame.setResizable(false);
    }
    
    
    public static void setGlobalFont() {

        Font font = new Font("Tahoma", Font.PLAIN, 24);

        UIManager.put("Label.font", font);
        UIManager.put("Button.font", font);
        UIManager.put("TextField.font", font);
        UIManager.put("PasswordField.font", font);
        UIManager.put("OptionPane.messageFont", font);
    }
}
