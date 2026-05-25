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
import penggajian.helper.DBConnetion;
import penggajian.model.TerModel;

/**
 *
 * @author Dion
 */
public class TerDao {
    
    public int getCount() {
        int count = 0;

        String sql = "SELECT COUNT(*) FROM ter";

        try (Connection con = DBConnetion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }
    
    public List<TerModel> getAllData(String search) {
        List<TerModel> list = new ArrayList<TerModel>();

        String sql =
            "SELECT id, min, max, tarif, golongan " +
            "from ter " +
            (!search.isEmpty() ? "WHERE min LIKE '%" + search + "%' " : "") + 
            (!search.isEmpty() ? "OR max LIKE '%" + search + "%' " : "") + 
            (!search.isEmpty() ? "OR tarif LIKE '%" + search + "%' " : "") + 
            (!search.isEmpty() ? "OR golongan LIKE '%" + search + "%' " : "") + 
            "ORDER BY golongan ASC, tarif ASC"; 
        
        try (Connection con = DBConnetion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                TerModel ter = new TerModel();

                ter.setId(rs.getInt("id"));
                ter.setMin(rs.getInt("min"));
                ter.setMax(rs.getInt("max"));
                ter.setTarif(rs.getDouble("tarif"));
                ter.setGolongan(rs.getString("golongan"));

                list.add(ter);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
}
