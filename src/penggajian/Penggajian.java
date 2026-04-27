/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian;

import penggajian.helper.*;
import penggajian.page.Login;
import penggajian.page.dashboard.Home;

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
        
        if (Session.isLogin) {
            new Home().setVisible(true);
        } else {
            new Login().setVisible(true);
        }


    }

}
