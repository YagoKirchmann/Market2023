package com.mycompany.newmaketmaven.services;

import java.util.List;
import com.mycompany.newmaketmaven.model.CondicaoPgto;
import com.mycompany.newmaketmaven.modelDAO.CondPgtoDAO;


public class CondPgtoService{

    
     public static void criar(CondicaoPgto objeto) {
        CondPgtoDAO condPgtoDAO =  new CondPgtoDAO();
        condPgtoDAO.create(objeto);
    }

    
    public static CondicaoPgto buscar(int codigo) {
        CondPgtoDAO condPgtoDAO = new CondPgtoDAO();
        return condPgtoDAO.retrieve(codigo);
       
    }

   
    public static CondicaoPgto buscar(String descricao) {
        CondPgtoDAO condPgtoDAO = new CondPgtoDAO();
        return condPgtoDAO.retrieve(descricao);
    }

    
    public static List<CondicaoPgto> buscar() {
        CondPgtoDAO condPgtoDAO = new CondPgtoDAO();
        return condPgtoDAO.retrieve();
    }

    
    public static void atualizar(CondicaoPgto objeto) {
       CondPgtoDAO condPgtoDAO = new CondPgtoDAO();
       condPgtoDAO.update(objeto);
    }

   
    public static void excluir(CondicaoPgto objeto) {
        CondPgtoDAO condPgtoDAO = new CondPgtoDAO();
        condPgtoDAO.delete(objeto);
    }
    
    
    
    
    
}
