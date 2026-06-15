/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian.model;

import java.math.BigDecimal;

/**
 *
 * @author Dion
 */
public class GajiBersihModel {
    private Long id;
    private Long karyawanId;
    private Long gajiKotorId;

    private Integer potonganJabatan;
    private Integer potonganAbsen;
    private Integer jumlahAbsen;

    private double jht;

    private Integer total;

    private String bulan;
    private Integer tahun;

    private String namaKaryawan;
    private Integer totalKotor;
    
    private KaryawanModel karyawanModel;
    private GajiKotorModel gajiKotorModel;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getKaryawanId() {
        return karyawanId;
    }

    public void setKaryawanId(Long karyawanId) {
        this.karyawanId = karyawanId;
    }
    
    public Long getGajiKotorId() {
        return gajiKotorId;
    }

    public void setGajiKotorId(Long gajiKotorId) {
        this.gajiKotorId = gajiKotorId;
    }

    public Integer getPotonganJabatan() {
        return potonganJabatan;
    }

    public void setPotonganJabatan(Integer potonganJabatan) {
        this.potonganJabatan = potonganJabatan;
    }
    
    public Integer getPotonganAbsen() {
        return potonganAbsen;
    }

    public void setPotonganAbsen(Integer potonganAbsen) {
        this.potonganAbsen = potonganAbsen;
    }

    public Integer getJumlahAbsen() {
        return jumlahAbsen;
    }

    public void setJumlahLembur(Integer jumlahAbsen) {
        this.jumlahAbsen = jumlahAbsen;
    }

    public Double getJht() {
        return jht;
    }

    public void setJht(Double jht) {
        this.jht = jht;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getBulan() {
        return bulan;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    public Integer getTahun() {
        return tahun;
    }

    public void setTahun(Integer tahun) {
        this.tahun = tahun;
    }

    public String getNamaKaryawan() {
        return namaKaryawan;
    }

    public void setNamaKaryawan(String namaKaryawan) {
        this.namaKaryawan = namaKaryawan;
    }

    public Integer getTotalKotor() {
        return totalKotor;
    }

    public void setTotalKotor(Integer totalKotor) {
        this.totalKotor = totalKotor;
    }

    public KaryawanModel getKaryawanModel() {
        return karyawanModel;
    }

    public void setKaryawanModel(KaryawanModel karyawanModel) {
        this.karyawanModel = karyawanModel;
    }
    
    public GajiKotorModel getGajiKotorModel() {
        return gajiKotorModel;
    }

    public void setGajiKotorModel(GajiKotorModel gajiKotorModel) {
        this.gajiKotorModel = gajiKotorModel;
    }
}
