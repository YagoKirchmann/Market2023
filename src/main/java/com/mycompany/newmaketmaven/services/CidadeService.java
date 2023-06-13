package com.mycompany.newmaketmaven.services;

import java.util.List;
import com.mycompany.newmaketmaven.model.Cidade;
import com.mycompany.newmaketmaven.modelDAO.CidadeDAO;


public class CidadeService{

    
    public static void criar(Cidade objeto) {
        CidadeDAO cidadeDAO =  new CidadeDAO();
        cidadeDAO.create(objeto);
    }

    
    public static Cidade buscar(int codigo) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        return cidadeDAO.retrieve(codigo);
       
    }

   
    public static Cidade buscar(String descricao) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        return cidadeDAO.retrieve(descricao);
    }

    
    public static List<Cidade> buscar() {
        CidadeDAO cidadeDAO = new CidadeDAO();
        return cidadeDAO.retrieve();
    }

    
    public static void atualizar(Cidade objeto) {
       CidadeDAO cidadeDAO = new CidadeDAO();
       cidadeDAO.update(objeto);
    }

   
    public static void excluir(Cidade objeto) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.delete(objeto);
    }

}
