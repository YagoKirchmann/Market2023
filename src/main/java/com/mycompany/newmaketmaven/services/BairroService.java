package com.mycompany.newmaketmaven.services;

import java.util.List;
import com.mycompany.newmaketmaven.model.Bairro;
import com.mycompany.newmaketmaven.modelDAO.BairroDAO;


public class BairroService{

    
    public static void criar(Bairro objeto) {
        BairroDAO bairroDAO =  new BairroDAO();
        bairroDAO.create(objeto);
    }

    
    public static Bairro buscar(int codigo) {
        BairroDAO bairroDAO = new BairroDAO();
        return bairroDAO.retrieve(codigo);
       
    }

   
    public static Bairro buscar(String descricao) {
        BairroDAO bairroDAO = new BairroDAO();
        return bairroDAO.retrieve(descricao);
    }

    
    public static List<Bairro> buscar() {
        BairroDAO bairroDAO = new BairroDAO();
        return bairroDAO.retrieve();
    }

    
    public static void atualizar(Bairro objeto) {
       BairroDAO bairroDAO = new BairroDAO();
       bairroDAO.update(objeto);
    }

   
    public static void excluir(Bairro objeto) {
        BairroDAO bairroDAO = new BairroDAO();
        bairroDAO.delete(objeto);
    }
   
}
