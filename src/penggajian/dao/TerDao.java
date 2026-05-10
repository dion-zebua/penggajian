/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian.dao;

import javax.persistence.*;

/**
 *
 * @author Dion
 */
public class TerDao {
    private EntityManager em;

    public TerDao() {
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("penggajianPU");
        this.em = emf.createEntityManager();
    }

    public long getJumlahTer() {
        return (Long) em.createNativeQuery(
            "SELECT COUNT(id) FROM ter"
        ).getSingleResult();
    }
}
