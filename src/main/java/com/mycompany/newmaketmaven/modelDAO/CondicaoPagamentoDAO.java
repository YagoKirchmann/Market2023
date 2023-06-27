/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/CondicaoPagamentos/Class.java to edit this template
 */
package com.mycompany.newmaketmaven.modelDAO;

import com.mycompany.newmaketmaven.model.CondicaoPagamento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Trabalho
 */
public class CondicaoPagamentoDAO implements InterfaceDAO<com.mycompany.newmaketmaven.model.CondicaoPagamento> {

    private static CondicaoPagamentoDAO instance;
    protected EntityManager entityManager;
    
    public static CondicaoPagamentoDAO getInstance(){
        if(instance == null){
            instance = new CondicaoPagamentoDAO();
    }
        return instance;
    }

    private CondicaoPagamentoDAO() {
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
    public void create(CondicaoPagamento objeto) {
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
    public CondicaoPagamento retrieve(int codigo) {
       return entityManager.find(CondicaoPagamento.class, codigo);
    }

    @Override
    public CondicaoPagamento retrieve(String descricao) {
       return entityManager
               .createQuery("SELECT c FROM CondicaoPagamento c WHERE c.descricao = :parDescricao", CondicaoPagamento.class)
               .setParameter("parDescricao", descricao)
               .getSingleResult();
    }

    @Override
    public List<CondicaoPagamento> retrieve() {
        return entityManager.createQuery("SELECT c FROM CondicaoPagamento c", CondicaoPagamento.class)
                .getResultList();
    }

    @Override
    public void update(CondicaoPagamento objeto) {
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
    public void delete(CondicaoPagamento objeto) {
          try {
            entityManager.getTransaction().begin();
            objeto = entityManager.find(CondicaoPagamento.class, objeto.getId());
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();   
        }
    }
}

