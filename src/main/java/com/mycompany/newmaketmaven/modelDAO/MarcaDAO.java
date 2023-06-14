/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newmaketmaven.modelDAO;

import java.util.List;
import com.mycompany.newmaketmaven.model.Marca;
import static com.mycompany.newmaketmaven.model.Marca_.descricao;
import javax.persistence.EntityManager;

/**
 *
 * @author Trabalho
 */
public class MarcaDAO implements InterfaceDAO<com.mycompany.newmaketmaven.model.Marca> {

    private static MarcaDAO instance;
    protected EntityManager entityManager;
    
    @Override
    public void create(Marca objeto) {
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
    public Marca retrieve(int codigo) {
        return entityManager.find(Marca.class, codigo);
    }

    @Override
    public Marca retrieve(String desc) {
        Marca marca = entityManager.createQuery("SELECT m FROM Marca m WHERE m.descricao = :parDescricao", Marca.class).setParameter("parDescricao", descricao).getSingleResult();

        return marca;
    }

    @Override
    public List<Marca> retrieve() {
        List<Marca> marcas;
            
        marcas = entityManager.createQuery("SELECT m FROM Marca m", Marca.class).getResultList();
        
        return marcas;
    }

    @Override
    public void update(Marca objeto) {
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
    public void delete(Marca objeto) {
        try {
            entityManager.getTransaction().begin();
            objeto = entityManager.find(Marca.class, objeto.getId());
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
