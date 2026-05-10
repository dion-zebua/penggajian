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
public class JabatanDao {
    private EntityManager em;

    public JabatanDao() {
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("penggajianPU");
        this.em = emf.createEntityManager();
    }

    public long getJumlahJabatan() {
        return (Long) em.createNativeQuery(
            "SELECT COUNT(id) FROM jabatan"
        ).getSingleResult();
    }
    
    public List<Object[]> getSemuaJabatan() {
        return em.createNativeQuery(
            "SELECT j.id, j.nama, j.tunjangan, COUNT(k.id) AS total_karyawan " + 
            "FROM jabatan j " +
            "JOIN karyawan k ON k.jabatan_id = j.id " +
            "GROUP BY j.id, j.nama, j.tunjangan " +
            "order by j.id desc"
        ).getResultList();
    }
}
