/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newmaketmaven.modelDAO;

import java.util.List;
import com.mycompany.newmaketmaven.model.Fornecedor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Trabalho
 */
public class FornecedorDAO implements InterfaceDAO<Fornecedor> {

    private static FornecedorDAO instance;
    protected EntityManager entityManager;
    
    public static FornecedorDAO getInstance(){
        if(instance == null){
            instance = new FornecedorDAO();
    }
        return instance;
    }

    private FornecedorDAO() {
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
    public void create(Fornecedor objeto) {
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
    public Fornecedor retrieve(int codigo) {
        return entityManager.find(Fornecedor.class, codigo);
    }

    @Override
    public Fornecedor retrieve(String cnpj) {
        Fornecedor fornecedor = entityManager.createQuery("SELECT f FROM Fornecedor f WHERE f.cnpj = :parCNPJ", Fornecedor.class).setParameter("parCNPJ", cnpj).getSingleResult();

        return fornecedor;
    }

    @Override
    public List<Fornecedor> retrieve() {
        List<Fornecedor> fornecedors;
            
        fornecedors = entityManager.createQuery("SELECT f FROM Fornecedor f", Fornecedor.class).getResultList();
        
        return fornecedors;
    }

    @Override
    public void update(Fornecedor objeto) {
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
    public void delete(Fornecedor objeto) {
        try {
            entityManager.getTransaction().begin();
            objeto = entityManager.find(Fornecedor.class, objeto.getId());
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }


}