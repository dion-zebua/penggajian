/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian.model;

/**
 *
 * @author Dion
 */
public class JabatanModel {
    private long id;
    private String nama;
    private int tunjangan;
    private int totalKaryawan;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getTunjangan() {
        return tunjangan;
    }

    public void setTunjangan(int tunjangan) {
        this.tunjangan = tunjangan;
    }
    
    public int getTotalKaryawan() {
        return totalKaryawan;
    }
    public void setTotalKaryawan(int totalKaryawan) {
        this.totalKaryawan = totalKaryawan;
    }
}
