/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian.dao;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Dion
 */
public class KaryawanDao {
    private EntityManager em;

    public KaryawanDao() {
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("penggajianPU");
        this.em = emf.createEntityManager();
    }

    public long getJumlahKaryawan() {
        return (Long) em.createNativeQuery(
            "SELECT COUNT(id) FROM karyawan"
        ).getSingleResult();
    }
    
    public List<Object[]> getKaryawanTerbaru() {
        return em.createNativeQuery(
            "SELECT k.id, k.nama, k.golongan_ter, k.created_at, j.nama AS jabatan FROM karyawan k " +
            "JOIN jabatan j ON k.jabatan_id = j.id " +
            "order by k.created_at desc limit 5"
        ).getResultList();
    }
}
