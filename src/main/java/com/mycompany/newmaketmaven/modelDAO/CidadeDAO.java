
package com.mycompany.newmaketmaven.modelDAO;

import com.mycompany.newmaketmaven.model.Bairro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.newmaketmaven.model.Cidade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CidadeDAO implements InterfaceDAO<Cidade>{

    private static CidadeDAO instance;
    protected EntityManager entityManager;
    
    public static CidadeDAO getInstance(){
        if(instance == null){
            instance = new CidadeDAO();
    }
        return instance;
    }

    private CidadeDAO() {
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
    public void create(Cidade objeto) {
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
    public Cidade retrieve(int codigo) {
       return entityManager.find(Cidade.class, codigo);
    }

    @Override
    public Cidade retrieve(String descricao) {
       return entityManager
               .createQuery("SELECT c FROM Cidade c WHERE c.descricao = :parDescricao", Cidade.class)
               .setParameter("parDescricao", descricao)
               .getSingleResult();
    }

    @Override
    public List<Cidade> retrieve() {
        return entityManager.createQuery("SELECT c FROM Cidade c", Cidade.class)
                .getResultList();
    }

    @Override
    public void update(Cidade objeto) {
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
    public void delete(Cidade objeto) {
          try {
            entityManager.getTransaction().begin();
            objeto = entityManager.find(Cidade.class, objeto.getId());
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();   
        }
    }
    
}