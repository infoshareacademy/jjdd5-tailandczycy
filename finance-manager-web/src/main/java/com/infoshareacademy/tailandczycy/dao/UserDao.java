package com.infoshareacademy.tailandczycy.dao;

import com.infoshareacademy.tailandczycy.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Long save(User s) {
        entityManager.persist(s);
        return s.getId();
    }

    public User update(User s) {
        return entityManager.merge(s);
    }

    public void delete(Long id) {
        final User s = entityManager.find(User.class, id);
        if (s != null) {
            entityManager.remove(s);
        }
    }

    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    public List<User> findAll() {
        final Query query = entityManager.createQuery("SELECT s FROM User s");

        return query.getResultList();
    }
}
