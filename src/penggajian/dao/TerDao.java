/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.persistence.*;
import penggajian.helper.DBConnetion;

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
}
