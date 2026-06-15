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
    
    public GajiBersihModel getById(Long id) {

        GajiBersihModel gaji = null;

        String sql =
            "SELECT * from gaji_bersih WHERE id = ? ";

        try (
            Connection con = DBConnetion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                gaji = new GajiBersihModel();
                gaji.setId(rs.getLong("id"));
                gaji.setKaryawanId(rs.getLong("karyawan_id"));
                gaji.setGajiKotorId(rs.getLong("gaji_kotor_id"));
                gaji.setPotonganJabatan(rs.getInt("potongan_jabatan"));
                gaji.setPotonganAbsen(rs.getInt("potongan_absen"));
                gaji.setJumlahAbsen(rs.getInt("jumlah_absen"));
                gaji.setJht(rs.getDouble("jht_karyawan"));
                gaji.setTotal(rs.getInt("total"));

                gaji.setBulan(rs.getString("bulan"));
                gaji.setTahun(rs.getInt("tahun"));  
                
                KaryawanDao karyawanDao = new KaryawanDao();
                KaryawanModel karyawanModel =
                karyawanDao.getById(Long.valueOf(rs.getInt("karyawan_id")));
                gaji.setKaryawanModel(karyawanModel);  
                
                GajiKotorDao gajiKotorDao = new GajiKotorDao();
                GajiKotorModel gajiKotorModel =
                    gajiKotorDao.getById(rs.getLong("gaji_kotor_id"));

                gaji.setGajiKotorModel(gajiKotorModel);            
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }

        return gaji;
    }
    
    public boolean saveData(GajiBersihModel bersih) {
        
        String sql = "INSERT INTO gaji_bersih ("
            + "karyawan_id, gaji_kotor_id, potongan_jabatan, "
            + "potongan_absen, jumlah_absen, jht_karyawan, "
            + "total, bulan, tahun"
            + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
        try (
            Connection con = DBConnetion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setLong(1, bersih.getKaryawanId());
            ps.setLong(2, bersih.getGajiKotorId());

            ps.setInt(3, bersih.getPotonganJabatan());
            ps.setInt(4, bersih.getPotonganAbsen());
            ps.setInt(5, bersih.getJumlahAbsen());

            ps.setDouble(6, bersih.getJht());

            ps.setInt(7, bersih.getTotal());

            ps.setString(8, bersih.getBulan());
            ps.setInt(9, bersih.getTahun());
            
            int rows = ps.executeUpdate();

            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
   
    public boolean deleteData(Long id) {

        String sql =
            "DELETE FROM gaji_bersih WHERE id = ?";

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
