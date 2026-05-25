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
public class TerModel {
    private long id;
    private int min;
    private int max;
    private double tarif;
    private String golongan;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMin() {
        return min;
    }
    
    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }
    
    public void setMax(int max) {
        this.max = max;
    }

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    public String getGolongan() {
        return golongan;
    }
    
    public void setGolongan(String golongan) {
        this.golongan = golongan;
    }    
}
