package com.egs.egs_employee.dao;

import com.egs.egs_employee.entity.EmployeeEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class EmployeeDAO implements DAO<EmployeeEntity> {

    public EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");


    public EntityManager entityManager = emf.createEntityManager();

    @Override
    public EmployeeEntity get(long id) {
        entityManager.getTransaction().begin();
        EmployeeEntity employee = (EmployeeEntity) entityManager
                .createQuery("SELECT e FROM EmployeeEntity e WHERE e.id = :id")
                .setParameter("id", id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return employee;
    }

    @Override
    public List<EmployeeEntity> getAll() {
        return null;
    }

    @Override
    public EmployeeEntity save(EmployeeEntity employeeEntity) {

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(employeeEntity);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return employeeEntity;
    }

    @Override
    public void update(EmployeeEntity employeeEntity) {

    }

    @Override
    public int delete(EmployeeEntity employeeEntity) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("DELETE FROM EmployeeEntity e WHERE e.id = :employeeId");
        int deletedCount = query.setParameter("employeeId", employeeEntity.getId()).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        return deletedCount;
    }

    @Override
    public EmployeeEntity getByUsername(String username) {
        entityManager.getTransaction().begin();
        EmployeeEntity employee = (EmployeeEntity) entityManager
                .createQuery("SELECT e FROM EmployeeEntity e WHERE e.username LIKE :username")
                .setParameter("username", username).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return employee;
    }
}
