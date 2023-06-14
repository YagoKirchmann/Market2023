
package com.mycompany.newmaketmaven.modelDAO;

import java.util.List;
import com.mycompany.newmaketmaven.model.Endereco;
import javax.persistence.EntityManager;



public class EnderecoDAO implements InterfaceDAO<Endereco> {

    private static EnderecoDAO instance;
    protected EntityManager entityManager;
    
    @Override
    public void create(Endereco objeto) {
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
    public Endereco retrieve(int codigo) {
        return entityManager.find(Endereco.class, codigo);
    }

    @Override
    public Endereco retrieve(String cep) {
        Endereco endereco = entityManager.createQuery("SELECT e FROM Endereco e WHERE e.cep = :parCep", Endereco.class).setParameter("parCep", cep).getSingleResult();

        return endereco;
    }

    @Override
    public List<Endereco> retrieve() {
        List<Endereco> enderecos;
            
        enderecos = entityManager.createQuery("SELECT e FROM Endereco e", Endereco.class).getResultList();
        
        return enderecos;
    }

    @Override
    public void update(Endereco objeto) {
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
    public void delete(Endereco objeto) {
        try {
            entityManager.getTransaction().begin();
            objeto = entityManager.find(Endereco.class, objeto.getId());
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}