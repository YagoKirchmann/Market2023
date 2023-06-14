/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Colaboradors/Class.java to edit this template
 */
package com.mycompany.newmaketmaven.modelDAO;

import java.util.List;
import com.mycompany.newmaketmaven.model.Colaborador;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Trabalho
 */
public class ColaboradorDAO implements InterfaceDAO<com.mycompany.newmaketmaven.model.Colaborador> {

     private static ColaboradorDAO instance;
    protected EntityManager entityManager;
    
    public static ColaboradorDAO getInstance(){
        if(instance == null){
            instance = new ColaboradorDAO();
    }
        return instance;
    }

    private ColaboradorDAO() {
        entityManager = getEntityManager();
    }
    
    private EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_NewMarketMaven_jar_1.0-SNAPSHOTPU");
        
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        
        return entityManager;
    }
    
    @Override
    public void create(Colaborador objeto) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public Colaborador retrieve(int codigo) {
       return entityManager.find(Colaborador.class, codigo);
    }

    @Override
    public Colaborador retrieve(String login) {
       return entityManager
               .createQuery("SELECT c FROM Colaborador c WHERE c.login = :parDescricao", Colaborador.class)
               .setParameter("parDescricao", login)
               .getSingleResult();
    }

    @Override
    public List<Colaborador> retrieve() {
        return entityManager.createQuery("SELECT c FROM Colaborador c", Colaborador.class)
                .getResultList();
    }

    @Override
    public void update(Colaborador objeto) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();   
        }        
    }

    @Override
    public void delete(Colaborador objeto) {
          try {
            entityManager.getTransaction().begin();
            objeto = entityManager.find(Colaborador.class, objeto.getId());
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();   
        }
    }
}

