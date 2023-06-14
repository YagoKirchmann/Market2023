/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.newmaketmaven.modelDAO;

import java.util.List;
import com.mycompany.newmaketmaven.model.Produto;
import static com.mycompany.newmaketmaven.model.Produto_.descricao;
import javax.persistence.EntityManager;


public class ProdutoDAO implements InterfaceDAO<com.mycompany.newmaketmaven.model.Produto> {

    private static ProdutoDAO instance;
    protected EntityManager entityManager;
    
    @Override
    public void create(Produto objeto) {
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
    public Produto retrieve(int codigo) {
        return entityManager.find(Produto.class, codigo);
    }

    @Override
    public Produto retrieve(String desc) {
        Produto produto = entityManager.createQuery("SELECT p FROM Produto p WHERE p.descricao = :parDescricao", Produto.class).setParameter("parDescricao", descricao).getSingleResult();

        return produto;
    }

    @Override
    public List<Produto> retrieve() {
        List<Produto> produtos;
            
        produtos = entityManager.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
        
        return produtos;
    }


    @Override
    public void update(Produto objeto) {
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
    public void delete(Produto objeto) {
        try {
            entityManager.getTransaction().begin();
            objeto = entityManager.find(Produto.class, objeto.getId());
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}