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
import penggajian.model.GajiBersihModel;
import penggajian.model.GajiKotorModel;
import penggajian.model.JabatanModel;
import penggajian.model.KaryawanModel;

/**
 *
 * @author Dion
 */
public class GajiBersihDao {
    
    public List<GajiBersihModel> getAllData(String search) {

        List<GajiBersihModel> list = new ArrayList<>();

        String sql =
            "SELECT bersih.id, " +
            "bersih.karyawan_id, " +
            "bersih.gaji_kotor_id, " +
            "bersih.bulan, " +
            "bersih.tahun, " +
            "bersih.total AS total_bersih, " +
            "kotor.total AS total_kotor " +
            "FROM gaji_bersih bersih " +
            "JOIN karyawan kar ON bersih.karyawan_id = kar.id " +
            "JOIN gaji_kotor kotor ON bersih.gaji_kotor_id = kotor.id " +
            (!search.isEmpty()
                ? "WHERE kar.nama LIKE '%" + search + "%' " +
                  "OR CONCAT(bersih.tahun, ' ', bersih.bulan) LIKE '%" + search + "%' "
                : "") +
                "ORDER BY bersih.tahun DESC, " +
                "FIELD(bersih.bulan," +
                "'Desember','November','Oktober','September','Agustus','Juli'," +
                "'Juni','Mei','April','Maret','Februari','Januari')";
        
        try (
            Connection con = DBConnetion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                GajiBersihModel bersih = new GajiBersihModel();
                
                KaryawanDao karyawanDao = new KaryawanDao();
                KaryawanModel karyawan = karyawanDao.getById(rs.getLong("karyawan_id"));
                
                GajiKotorDao gajiKotorDao = new GajiKotorDao();
                GajiKotorModel kotor = gajiKotorDao.getById(rs.getLong("gaji_kotor_id"));
                
                bersih.setId(rs.getLong("id"));
                bersih.setKaryawanId(rs.getLong("karyawan_id"));
                bersih.setKaryawanModel(karyawan);
                bersih.setGajiKotorModel(kotor);
                bersih.setBulan(rs.getString("bulan"));
                bersih.setTahun(rs.getInt("tahun"));
                bersih.setTotal(rs.getInt("total_bersih"));

                list.add(bersih);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public GajiKotorModel getById(Long id) {

        GajiKotorModel gaji = null;

        String sql =
            "SELECT * from gaji_kotor WHERE id = ? ";

        try (
            Connection con = DBConnetion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                gaji = new GajiKotorModel();
                gaji.setId(rs.getLong("id"));
                gaji.setKaryawanId(rs.getLong("karyawan_id"));
                gaji.setGajiPokok(rs.getInt("gaji_pokok"));
                gaji.setTunjanganJabatan(rs.getInt("tunjangan_jabatan"));

                gaji.setTunjanganTransportasi(rs.getInt("tunjangan_transportasi"));
                gaji.setTunjanganMakan(rs.getInt("tunjangan_makan"));
                gaji.setJumlahLembur(rs.getInt("jumlah_lembur"));

                gaji.setTunjanganLembur(rs.getInt("tunjangan_lembur"));
                gaji.setTotal1(rs.getInt("total_1"));

                gaji.setJkk(rs.getDouble("jkk"));
                gaji.setJkm(rs.getDouble("jkm"));
                gaji.setJhtPerusahaan(rs.getDouble("jht_perusahaan"));

                gaji.setTotal2(rs.getInt("total_2"));

                gaji.setGolonganTer(rs.getString("golongan_ter"));
                gaji.setTarifTer(rs.getDouble("tarif_ter"));

                gaji.setTotalTer(rs.getInt("total_ter"));
                gaji.setTotal(rs.getInt("total"));

                gaji.setBulan(rs.getString("bulan"));
                gaji.setTahun(rs.getInt("tahun"));  
                
                KaryawanDao karyawanDao = new KaryawanDao();
                KaryawanModel karyawanModel =
                karyawanDao.getById(Long.valueOf(rs.getInt("karyawan_id")));
                gaji.setKaryawanModel(karyawanModel);  
                
//                JabatanDao jabatanDao = new JabatanDao();
//                JabatanModel jabatanModel =
//                    jabatanDao.getById(Long.valueOf(rs.getInt("jabatan_id")));
//
//                gaji.setJabatanModel(jabatanModel);            
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }

        return gaji;
    }
    
    public boolean saveData(GajiKotorModel kotor) {
        
        String sql = "INSERT INTO gaji_kotor ("
                + "karyawan_id, gaji_pokok, tunjangan_jabatan, "
                + "tunjangan_transportasi, tunjangan_makan, jumlah_lembur, "
                + "tunjangan_lembur, total_1, jkk, jkm, jht_perusahaan, "
                + "total_2, golongan_ter, tarif_ter, total_ter, total, "
                + "bulan, tahun"
                + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (
            Connection con = DBConnetion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setLong(1, kotor.getKaryawanId());
            ps.setInt(2, kotor.getGajiPokok());
            ps.setInt(3, kotor.getTunjanganJabatan());

            ps.setInt(4, kotor.getTunjanganTransportasi());
            ps.setInt(5, kotor.getTunjanganMakan());
            ps.setInt(6, kotor.getJumlahLembur());

            ps.setInt(7, kotor.getTunjanganLembur());
            ps.setInt(8, kotor.getTotal1());

            ps.setDouble(9, kotor.getJkk());
            ps.setDouble(10, kotor.getJkm());
            ps.setDouble(11, kotor.getJhtPerusahaan());

            ps.setInt(12, kotor.getTotal2());

            ps.setString(13, kotor.getGolonganTer());
            ps.setDouble(14, kotor.getTarifTer());

            ps.setInt(15, kotor.getTotalTer());
            ps.setInt(16, kotor.getTotal());

            ps.setString(17, kotor.getBulan());
            ps.setInt(18, kotor.getTahun());
            
            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
   
    public boolean deleteData(Long id) {

        String sql =
            "DELETE FROM gaji_kotor WHERE id = ?";

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
    
    public boolean editData(GajiKotorModel gaji) {

        String sql =
            "UPDATE gaji_kotor SET " +
            "jumlah_lembur = ?, " +
            "total_1 = ?, " +
            "total_2 = ?, " +
            "tarif_ter = ?, " +
            "total_ter = ?, " +
            "total = ?, " +
            "bulan = ?, " +
            "tahun = ? " +
            "WHERE id = ?";
        
        try (
            Connection con = DBConnetion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setInt(1, gaji.getJumlahLembur());
            ps.setInt(2, gaji.getTotal1());
            ps.setInt(3, gaji.getTotal2());
            ps.setDouble(4, gaji.getTarifTer());
            ps.setInt(5, gaji.getTotalTer());
            ps.setInt(6, gaji.getTotal());
            ps.setString(7, gaji.getBulan());
            ps.setInt(8, gaji.getTahun());
            ps.setLong(9, gaji.getId());
            
            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }
}
