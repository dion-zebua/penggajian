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
import penggajian.helper.DBConnetion;
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
            "k.created_at, " +
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
                karyawan.setJabatan(rs.getString("jabatan"));
                karyawan.setGolonganTer(rs.getString("golongan_ter"));
                karyawan.setGajiPokok(rs.getInt("gaji_pokok"));

                list.add(karyawan);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
