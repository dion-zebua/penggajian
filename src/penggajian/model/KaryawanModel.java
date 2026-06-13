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
public class KaryawanModel {
    private long id;
    private String nama;
    private int gajiPokok;
    private String npwp;
    private int tunjanganTransportasi;
    private int tunjanganMakan;
    private int tunjanganLembur;
    private int potonganAbsen;
    private String golonganTer;
    private long jabatanId;
    private String jabatan;
    private JabatanModel jabatanModel;


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

    public int getGajiPokok() {
        return gajiPokok;
    }

    public void setGajiPokok(int gajiPokok) {
        this.gajiPokok = gajiPokok;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public int getTunjanganTransportasi() {
        return tunjanganTransportasi;
    }

    public void setTunjanganTransportasi(int tunjanganTransportasi) {
        this.tunjanganTransportasi = tunjanganTransportasi;
    }

    public int getTunjanganMakan() {
        return tunjanganMakan;
    }

    public void setTunjanganMakan(int tunjanganMakan) {
        this.tunjanganMakan = tunjanganMakan;
    }

    public int getTunjanganLembur() {
        return tunjanganLembur;
    }

    public void setTunjanganLembur(int tunjanganLembur) {
        this.tunjanganLembur = tunjanganLembur;
    }

    public int getPotonganAbsen() {
        return potonganAbsen;
    }

    public void setPotonganAbsen(int potonganAbsen) {
        this.potonganAbsen = potonganAbsen;
    }

    public String getGolonganTer() {
        return golonganTer;
    }

    public void setGolonganTer(String golonganTer) {
        this.golonganTer = golonganTer;
    }

    public long getJabatanId() {
        return jabatanId;
    }

    public void setJabatanId(long jabatanId) {
        this.jabatanId = jabatanId;
    } 
    
    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }
    
    public JabatanModel getJabatanModel() {
        return jabatanModel;
    }
    
    public void setJabatanModel(JabatanModel jabatanModel) {
        this.jabatanModel = jabatanModel;
    }
    
    @Override
    public String toString() {
        return nama;
    }    
}
