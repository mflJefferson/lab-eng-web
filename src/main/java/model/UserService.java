package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UserService { //persistence class

    public List<User> list() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java_persistence");
        EntityManager em = emf.createEntityManager();

        List<User> users = null;
        Query query = em.createQuery("SELECT u FROM user u ");
        users = query.getResultList();

        em.close();
        emf.close();

        return users;
    }

}
