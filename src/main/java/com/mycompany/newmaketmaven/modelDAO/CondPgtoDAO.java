
package com.mycompany.newmaketmaven.modelDAO;

import java.util.List;
import com.mycompany.newmaketmaven.model.CondicaoPgto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class CondPgtoDAO implements InterfaceDAO<CondicaoPgto>{

     private static CondPgtoDAO instance;
    protected EntityManager entityManager;
    
    public static CondPgtoDAO getInstance(){
        if(instance == null){
            instance = new CondPgtoDAO();
    }
        return instance;
    }

    private CondPgtoDAO() {
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
    public void create(CondicaoPgto objeto) {
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
    public CondicaoPgto retrieve(int codigo) {
       return entityManager.find(CondicaoPgto.class, codigo);
    }

    @Override
    public CondicaoPgto retrieve(String descricaoCondicao) {
       return entityManager
               .createQuery("SELECT c FROM CondicaoPgto c WHERE c.descricaoCondicao = :parDescricao", CondicaoPgto.class)
               .setParameter("parDescricao", descricaoCondicao)
               .getSingleResult();
    }

    @Override
    public List<CondicaoPgto> retrieve() {
        return entityManager.createQuery("SELECT c FROM Classe c", CondicaoPgto.class)
                .getResultList();
    }

    @Override
    public void update(CondicaoPgto objeto) {
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
    public void delete(CondicaoPgto objeto) {
          try {
            entityManager.getTransaction().begin();
            objeto = entityManager.find(CondicaoPgto.class, objeto.getId());
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();   
        }
    }
}
