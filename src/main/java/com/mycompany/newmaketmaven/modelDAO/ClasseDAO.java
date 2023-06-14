/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newmaketmaven.modelDAO;

import com.mycompany.newmaketmaven.model.Classe;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Trabalho
 */
public class ClasseDAO implements InterfaceDAO<com.mycompany.newmaketmaven.model.Classe> {

    private static ClasseDAO instance;
    protected EntityManager entityManager;
    
    public static ClasseDAO getInstance(){
        if(instance == null){
            instance = new ClasseDAO();
    }
        return instance;
    }

    private ClasseDAO() {
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
    public void create(Classe objeto) {
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
    public Classe retrieve(int codigo) {
       return entityManager.find(Classe.class, codigo);
    }

    @Override
    public Classe retrieve(String descricao) {
       return entityManager
               .createQuery("SELECT c FROM Classe c WHERE c.descricao = :parDescricao", Classe.class)
               .setParameter("parDescricao", descricao)
               .getSingleResult();
    }

    @Override
    public List<Classe> retrieve() {
        return entityManager.createQuery("SELECT c FROM Classe c", Classe.class)
                .getResultList();
    }

    @Override
    public void update(Classe objeto) {
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
    public void delete(Classe objeto) {
          try {
            entityManager.getTransaction().begin();
            objeto = entityManager.find(Classe.class, objeto.getId());
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();   
        }
    }
}

