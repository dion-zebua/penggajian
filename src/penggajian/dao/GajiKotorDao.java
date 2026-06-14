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
import penggajian.model.GajiKotorModel;
import penggajian.model.JabatanModel;
import penggajian.model.KaryawanModel;

/**
 *
 * @author Dion
 */
public class GajiKotorDao {
    
    public List<GajiKotorModel> getAllData(String search) {

        List<GajiKotorModel> list = new ArrayList<>();

        String sql =
            "SELECT g.id, " +
            "g.karyawan_id, " +
            "k.nama, " +
            "g.bulan, " +
            "g.tahun, " +
            "g.total " +
            "FROM gaji_kotor g " +
            "JOIN karyawan k ON g.karyawan_id = k.id " +
            (!search.isEmpty()
                ? "WHERE k.nama LIKE '%" + search + "%' " +
                  "OR CONCAT(g.tahun, ' ', g.bulan) LIKE '%" + search + "%' "
                : "") +
                "ORDER BY g.tahun DESC, " +
                "FIELD(g.bulan," +
                "'Desember','November','Oktober','September','Agustus','Juli'," +
                "'Juni','Mei','April','Maret','Februari','Januari')";
        
        try (
            Connection con = DBConnetion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                GajiKotorModel kotor = new GajiKotorModel();

                kotor.setId(rs.getLong("id"));
                kotor.setKaryawanId(rs.getLong("karyawan_id"));
                kotor.setNamaKaryawan(rs.getString("nama"));
                kotor.setBulan(rs.getString("bulan"));
                kotor.setTahun(rs.getInt("tahun"));
                kotor.setTotal(rs.getInt("total"));

                list.add(kotor);
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
    
    public boolean saveData(GajiKotorModel kotor) {
        
        String sql = "INSERT INTO haji_kotor ("
           + "nama, gaji_pokok, npwp, tunjangan_transportasi, "
           + "tunjangan_makan, tunjangan_lembur, potongan_absen, "
           + "golongan_ter, jabatan_id"
           + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (
            Connection con = DBConnetion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

//            ps.setString(1, kar.getNama());
//            ps.setInt(2, kar.getGajiPokok());
//            ps.setString(3, kar.getNpwp());
//            ps.setInt(4, kar.getTunjanganTransportasi());
//            ps.setInt(5, kar.getTunjanganMakan());
//            ps.setInt(6, kar.getTunjanganLembur());
//            ps.setInt(7, kar.getPotonganAbsen());
//            ps.setString(8, kar.getGolonganTer());
//            ps.setLong(9, kar.getJabatanId());
            
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
