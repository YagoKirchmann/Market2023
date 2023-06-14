/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Clientes/Class.java to edit this template
 */
package com.mycompany.newmaketmaven.modelDAO;

import java.util.List;
import com.mycompany.newmaketmaven.model.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Trabalho
 */
public class ClienteDAO implements InterfaceDAO<com.mycompany.newmaketmaven.model.Cliente> {

    private static ClienteDAO instance;
    protected EntityManager entityManager;
    
    public static ClienteDAO getInstance(){
        if(instance == null){
            instance = new ClienteDAO();
    }
        return instance;
    }

    private ClienteDAO() {
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
    public void create(Cliente objeto) {
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
    public Cliente retrieve(int codigo) {
       return entityManager.find(Cliente.class, codigo);
    }

    @Override
    public Cliente retrieve(String cpf) {
       return entityManager
               .createQuery("SELECT c FROM Cliente c WHERE c.cpf = :parDescricao", Cliente.class)
               .setParameter("parDescricao", cpf)
               .getSingleResult();
    }

    @Override
    public List<Cliente> retrieve() {
        return entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class)
                .getResultList();
    }

    @Override
    public void update(Cliente objeto) {
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
    public void delete(Cliente objeto) {
          try {
            entityManager.getTransaction().begin();
            objeto = entityManager.find(Cliente.class, objeto.getId());
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();   
        }
    }
}

