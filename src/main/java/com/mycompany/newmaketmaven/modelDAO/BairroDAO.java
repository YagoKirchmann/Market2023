
package com.mycompany.newmaketmaven.modelDAO;

import java.util.List;
import com.mycompany.newmaketmaven.model.Bairro;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class BairroDAO implements InterfaceDAO<Bairro>{
    
    private static BairroDAO instance;
    protected EntityManager entityManager;
    
    public static BairroDAO getInstance(){
    if(instance == null){
    instance = new BairroDAO();
    }
    return instance;
    }

    private BairroDAO() {
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
    public void create(Bairro objeto) {
        
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
    public Bairro retrieve(int codigo) {
         return entityManager.find(Bairro.class, codigo);
    }

    @Override
    public Bairro retrieve(String descricao) {
        Bairro bairro = entityManager.createQuery("SELECT b FROM Bairro b WHERE b.descricao = :parDescricao", Bairro.class).setParameter("parDescricao", descricao).getSingleResult();
        return bairro;  
    }

    @Override
    public List<Bairro> retrieve() {
        List<Bairro> bairros;
        bairros = entityManager.createQuery("SELECT b FROM bairro b", Bairro.class).getResultList();      
        return bairros;
    }

    @Override
    public void update(Bairro objeto) {
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
    public void delete(Bairro objeto) {
          try {
            entityManager.getTransaction().begin();
            objeto = entityManager.find(Bairro.class, objeto.getId());
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
}
