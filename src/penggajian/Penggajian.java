/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian;

import penggajian.helper.*;
import penggajian.page.*;
import penggajian.page.dashboard.*;

/**
 *
 * @author Dion
 */
public class Penggajian {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BaseSetting.setGlobalFont();
        
        new Dashboard().setVisible(true);
//        new Login().setVisible(true);


    }

}
