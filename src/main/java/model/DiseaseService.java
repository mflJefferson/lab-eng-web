package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class DiseaseService {

    public List<Disease> list() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java_persistence");
        EntityManager em = emf.createEntityManager();

        List<Disease> diseases = null;
        Query query = em.createQuery("SELECT d FROM disease d ");
        diseases = query.getResultList();

        em.close();
        emf.close();

        return diseases;
    }

    public void create(String name, String symptoms) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java_persistence");
        EntityManager em = emf.createEntityManager();

        Disease d = new Disease();
        d.setName(name);
        d.setSymptoms(symptoms);

        em.getTransaction().begin();
        em.persist(d);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
