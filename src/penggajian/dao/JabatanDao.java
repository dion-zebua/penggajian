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
import penggajian.model.JabatanModel;

/**
 *
 * @author Dion
 */
public class JabatanDao {
    
    public int getCount() {
        int count = 0;

        String sql = "SELECT COUNT(*) FROM jabatan";

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
       
    public List<JabatanModel> getAllData(String search) {
        List<JabatanModel> list = new ArrayList<JabatanModel>();

        String sql =
            "SELECT j.id, j.nama, j.tunjangan, " +
            "count(k.id) as total_karyawan " +
            "from jabatan as j " +
            "left join karyawan as k " +
            "on k.jabatan_id = j.id " +
            (!search.isEmpty() ? "WHERE j.nama LIKE '%" + search + "%' " : "") + 
            "group by j.id, j.nama " +
            "ORDER BY j.id DESC";
        
        try (Connection con = DBConnetion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                JabatanModel jabatan = new JabatanModel();

                jabatan.setId(rs.getInt("id"));
                jabatan.setNama(rs.getString("nama"));
                jabatan.setTunjangan(rs.getInt("tunjangan"));
                jabatan.setTotalKaryawan(rs.getInt("total_karyawan"));

                list.add(jabatan);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public boolean saveData(JabatanModel jabatan) {

        String sql = "INSERT INTO jabatan(nama, tunjangan) VALUES(?, ?)";

        try (
            Connection con = DBConnetion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, jabatan.getNama());
            ps.setInt(2, jabatan.getTunjangan());


            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public JabatanModel getById(Long id) {

        JabatanModel jabatan = null;

        String sql =
            "SELECT id, nama, tunjangan from jabatan " +
            "WHERE id = ? ";

        try (
            Connection con = DBConnetion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                jabatan = new JabatanModel();

                jabatan.setId(rs.getInt("id"));
                jabatan.setNama(rs.getString("nama"));
                jabatan.setTunjangan(rs.getInt("tunjangan"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return jabatan;
    }
    
    public boolean deleteData(Long id) {

        if (id == 1) {
            return false; 
        }

        String sqlUpdateKaryawan =
            "UPDATE karyawan SET jabatan_id = 1 WHERE jabatan_id = ?";

        String sqlDeleteJabatan =
            "DELETE FROM jabatan WHERE id = ?";

        Connection con = null;

        try {

            con = DBConnetion.getConnection();
            con.setAutoCommit(false);

            // pindahkan karyawan ke jabatan default
            PreparedStatement ps1 = con.prepareStatement(sqlUpdateKaryawan);
            ps1.setLong(1, id);
            ps1.executeUpdate();

            // hapus jabatan
            PreparedStatement ps2 = con.prepareStatement(sqlDeleteJabatan);
            ps2.setLong(1, id);
            int rows = ps2.executeUpdate();

            con.commit();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();

            try {
                if (con != null) con.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            return false;
        }
    }
    
    public boolean editData(JabatanModel jabatan) {

        String sql =
            "UPDATE jabatan SET nama = ?, tunjangan = ? WHERE id = ?";

        try (
            Connection con = DBConnetion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, jabatan.getNama());
            ps.setInt(2, jabatan.getTunjangan());
            ps.setLong(3, jabatan.getId());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }
}
