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
import javax.persistence.*;
import javax.swing.JOptionPane;
import penggajian.helper.DBConnetion;
import penggajian.model.JabatanModel;
import penggajian.model.KaryawanModel;

/**
 *
 * @author Dion
 */
public class KaryawanDao {
    
    public int getCount() {
        int count = 0;

        String sql = "SELECT COUNT(*) FROM karyawan";

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
    
    public List<KaryawanModel> getAllData(String search, Boolean limit) {

        List<KaryawanModel> list = new ArrayList<>();

        String sql =
            "SELECT k.id, " +
            "k.nama, " +
            "k.golongan_ter, " +
            "k.npwp, " +
            "k.gaji_pokok, " +
            "j.nama AS jabatan " +
            "FROM karyawan k " +
            "JOIN jabatan j ON k.jabatan_id = j.id " +
            (!search.isEmpty()
                ? "WHERE k.nama LIKE '%" + search + "%' " +
                  "OR k.golongan_ter LIKE '%" + search + "%' " +
                  "OR j.nama LIKE '%" + search + "%' "
                : "") + 
            "ORDER BY k.id DESC " + 
            (limit ? "LIMIT 5" : "");

        try (
            Connection con = DBConnetion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                KaryawanModel karyawan = new KaryawanModel();

                karyawan.setId(rs.getInt("id"));
                karyawan.setNama(rs.getString("nama"));
                karyawan.setGajiPokok(rs.getInt("gaji_pokok"));
                karyawan.setNpwp(rs.getString("npwp"));
                karyawan.setGolonganTer(rs.getString("golongan_ter"));
                karyawan.setJabatan(rs.getString("jabatan"));

                list.add(karyawan);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public KaryawanModel getById(Long id) {

        KaryawanModel k = null;

        String sql =
            "SELECT * from karyawan WHERE id = ? ";

        try (
            Connection con = DBConnetion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                k = new KaryawanModel();
                k.setId(rs.getInt("id"));
                k.setNama(rs.getString("nama"));
                k.setGajiPokok(rs.getInt("gaji_pokok"));
                k.setNpwp(rs.getString("npwp"));
                k.setTunjanganTransportasi(rs.getInt("tunjangan_transportasi"));
                k.setTunjanganLembur(rs.getInt("tunjangan_lembur"));
                k.setTunjanganMakan(rs.getInt("tunjangan_makan"));
                k.setPotonganAbsen(rs.getInt("potongan_absen"));
                k.setGolonganTer(rs.getString("golongan_ter"));  
                JabatanDao jabatanDao = new JabatanDao();
                JabatanModel jabatanModel =
                    jabatanDao.getById(Long.valueOf(rs.getInt("jabatan_id")));

                k.setJabatanModel(jabatanModel);            
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }

        return k;
    }
    
    public boolean saveData(KaryawanModel kar) {
        
        String sql = "INSERT INTO karyawan ("
           + "nama, gaji_pokok, npwp, tunjangan_transportasi, "
           + "tunjangan_makan, tunjangan_lembur, potongan_absen, "
           + "golongan_ter, jabatan_id"
           + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (
            Connection con = DBConnetion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, kar.getNama());
            ps.setInt(2, kar.getGajiPokok());
            ps.setString(3, kar.getNpwp());
            ps.setInt(4, kar.getTunjanganTransportasi());
            ps.setInt(5, kar.getTunjanganMakan());
            ps.setInt(6, kar.getTunjanganLembur());
            ps.setInt(7, kar.getPotonganAbsen());
            ps.setString(8, kar.getGolonganTer());
            ps.setLong(9, kar.getJabatanId());
            
            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public boolean deleteData(Long id) {

        String sql =
            "DELETE FROM karyawan WHERE id = ?";

        try (
            Connection con = DBConnetion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ){

            ps.setLong(1, id);
            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }
    
    
    
    public boolean editData(KaryawanModel kar) {

        String sql =
            "UPDATE karyawan SET " +
            "nama = ?, " +
            "gaji_pokok = ?, " +
            "npwp = ?, " +
            "tunjangan_transportasi = ?, " +
            "tunjangan_makan = ?, " +
            "tunjangan_lembur = ?, " +
            "potongan_absen = ?, " +
            "golongan_ter = ?, " +
            "jabatan_id = ? " +
            "WHERE id = ?";

        try (
            Connection con = DBConnetion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, kar.getNama());
            ps.setInt(2, kar.getGajiPokok());
            ps.setString(3, kar.getNpwp());
            ps.setInt(4, kar.getTunjanganTransportasi());
            ps.setInt(5, kar.getTunjanganMakan());
            ps.setInt(6, kar.getTunjanganLembur());
            ps.setInt(7, kar.getPotonganAbsen());
            ps.setString(8, kar.getGolonganTer());
            ps.setLong(9, kar.getJabatanId());
            ps.setLong(10, kar.getId());
            
            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }
}
