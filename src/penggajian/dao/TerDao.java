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
    
    public boolean saveData(TerModel ter) {

        String sql = "INSERT INTO ter(min, max, tarif, golongan) VALUES(?, ?, ?, ?)";

        try (
            Connection con = DBConnetion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, ter.getMin());
            ps.setInt(2, ter.getMax());
            ps.setDouble(3, ter.getTarif());
            ps.setString(4, ter.getGolongan());


            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public TerModel getById(Long id) {

        TerModel ter = null;

        String sql =
            "SELECT id, min, max, tarif, golongan from ter " +
            "WHERE id = ? ";

        try (
            Connection con = DBConnetion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                ter = new TerModel();

                ter.setId(rs.getInt("id"));
                ter.setMin(rs.getInt("min"));
                ter.setMax(rs.getInt("max"));
                ter.setTarif(rs.getDouble("tarif"));
                ter.setGolongan(rs.getString("golongan"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ter;
    }
    
        
    public boolean deleteData(Long id) {

        String sqlDeleteTer =
            "DELETE FROM ter WHERE id = ?";

        try (
            Connection con = DBConnetion.getConnection();
            PreparedStatement ps = con.prepareStatement(sqlDeleteTer);
        ){

            ps.setLong(1, id);
            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }
    
    public boolean editData(TerModel ter) {

        String sql =
            "UPDATE ter SET " +
            "min = ?, max = ?, tarif = ?, golongan = ? WHERE id = ?";

        try (
            Connection con = DBConnetion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, ter.getMin());
            ps.setInt(2, ter.getMax());
            ps.setDouble(3, ter.getTarif());
            ps.setString(4, ter.getGolongan());
            ps.setLong(5, ter.getId());
            
            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }
}
