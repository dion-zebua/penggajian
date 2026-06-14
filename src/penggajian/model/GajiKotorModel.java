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
public class GajiKotorModel {
    private Long id;
    private Long karyawanId;

    private Integer gajiPokok;
    private Integer tunjanganJabatan;
    private Integer tunjanganTransportasi;
    private Integer tunjanganMakan;

    private Integer jumlahLembur;
    private Integer tunjanganLembur;

    private Long total1;

    private double jkk;
    private Integer totalJkk;

    private double jkm;
    private Integer totalJkm;

    private double jhtPerusahaan;
    private Integer totalJhtPerusahaan;

    private Long total2;

    private String golonganTer;
    
    private double tarifTer;
    private Integer totalTer;

    private Integer total;

    private String bulan;
    private Integer tahun;

    private String namaKaryawan;
    
    private KaryawanModel karyawanModel;
    
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

    public Integer getGajiPokok() {
        return gajiPokok;
    }

    public void setGajiPokok(Integer gajiPokok) {
        this.gajiPokok = gajiPokok;
    }

    public Integer getTunjanganJabatan() {
        return tunjanganJabatan;
    }

    public void setTunjanganJabatan(Integer tunjanganJabatan) {
        this.tunjanganJabatan = tunjanganJabatan;
    }

    public Integer getTunjanganTransportasi() {
        return tunjanganTransportasi;
    }

    public void setTunjanganTransportasi(Integer tunjanganTransportasi) {
        this.tunjanganTransportasi = tunjanganTransportasi;
    }

    public Integer getTunjanganMakan() {
        return tunjanganMakan;
    }

    public void setTunjanganMakan(Integer tunjanganMakan) {
        this.tunjanganMakan = tunjanganMakan;
    }

    public Integer getJumlahLembur() {
        return jumlahLembur;
    }

    public void setJumlahLembur(Integer jumlahLembur) {
        this.jumlahLembur = jumlahLembur;
    }

    public Integer getTunjanganLembur() {
        return tunjanganLembur;
    }

    public void setTunjanganLembur(Integer tunjanganLembur) {
        this.tunjanganLembur = tunjanganLembur;
    }

    public Long getTotal1() {
        return total1;
    }

    public void setTotal1(Long total1) {
        this.total1 = total1;
    }

    public double getJkk() {
        return jkk;
    }

    public void setJkk(double jkk) {
        this.jkk = jkk;
    }

    public Integer getTotalJkk() {
        return totalJkk;
    }

    public void setTotalJkk(Integer totalJkk) {
        this.totalJkk = totalJkk;
    }

    public double getJkm() {
        return jkm;
    }

    public void setJkm(double jkm) {
        this.jkm = jkm;
    }

    public Integer getTotalJkm() {
        return totalJkm;
    }

    public void setTotalJkm(Integer totalJkm) {
        this.totalJkm = totalJkm;
    }

    public double getJhtPerusahaan() {
        return jhtPerusahaan;
    }

    public void setJhtPerusahaan(double jhtPerusahaan) {
        this.jhtPerusahaan = jhtPerusahaan;
    }

    public Integer getTotalJhtPerusahaan() {
        return totalJhtPerusahaan;
    }

    public void setTotalJhtPerusahaan(Integer totalJhtPerusahaan) {
        this.totalJhtPerusahaan = totalJhtPerusahaan;
    }

    public Long getTotal2() {
        return total2;
    }

    public void setTotal2(Long total2) {
        this.total2 = total2;
    }

    public String getGolonganTer() {
        return golonganTer;
    }

    public void setGolonganTer(String golonganTer) {
        this.golonganTer = golonganTer;
    }

    public double getTarifTer() {
        return tarifTer;
    }

    public void setTarifTer(double tarifTer) {
        this.tarifTer = tarifTer;
    }

    public Integer getTotalTer() {
        return totalTer;
    }

    public void setTotalTer(Integer totalTer) {
        this.totalTer = totalTer;
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
    
    public KaryawanModel getKaryawanModel() {
        return karyawanModel;
    }

    public void setKaryawanModel(KaryawanModel karyawanModel) {
        this.karyawanModel = karyawanModel;
    }
}
