/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import penggajian.helper.DBConnetion;
import penggajian.model.BpjsModel;
import penggajian.model.TerModel;

/**
 *
 * @author Dion
 */
public class BpjsDao {
    
    public BpjsModel getDataFirst() {

        BpjsModel bpjs = null;

        String sql =
            "SELECT jkk, jkm, jht_perusahaan, jht_karyawan from bpjs limit 1";

        try (
            Connection con = DBConnetion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                bpjs = new BpjsModel();

                bpjs.setJkk(rs.getDouble("jkk"));
                bpjs.setJkm(rs.getDouble("jkm"));
                bpjs.setJhtP(rs.getDouble("jht_perusahaan"));
                bpjs.setJhtK(rs.getDouble("jht_karyawan"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bpjs;
    }

    public boolean editData(BpjsModel bpjs) {
       boolean success = false;

       String sql = "UPDATE bpjs SET jkk = ?, jkm = ?, jht_perusahaan = ?, jht_karyawan = ? " + 
               "limit 1";

       try (
           Connection con = DBConnetion.getConnection();
           PreparedStatement ps = con.prepareStatement(sql)
       ) {
           ps.setDouble(1, bpjs.getJkk());
           ps.setDouble(2, bpjs.getJkm());
           ps.setDouble(3, bpjs.getJhtP());
           ps.setDouble(4, bpjs.getJhtK());

           int rowsUpdated = ps.executeUpdate();

           if (rowsUpdated > 0) {
               success = true;
           }

       } catch (Exception e) {
           e.printStackTrace();
       }

       return success;
   }
}
