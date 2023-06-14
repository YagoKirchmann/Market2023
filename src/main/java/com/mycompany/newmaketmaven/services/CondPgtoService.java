package com.mycompany.newmaketmaven.services;

import java.util.List;
import com.mycompany.newmaketmaven.model.CondicaoPgto;
import com.mycompany.newmaketmaven.modelDAO.CondPgtoDAO;


public class CondPgtoService{

    
    public static void criar(CondicaoPgto objeto) {
        CondPgtoDAO.getInstance().create(objeto);
    }
    
    public static CondicaoPgto buscar(int codigo) {
        return CondPgtoDAO.getInstance().retrieve(codigo);
    }

    public static CondicaoPgto buscar(String descricao) {
       return CondPgtoDAO.getInstance().retrieve(descricao);
    }
    
    public static List<CondicaoPgto> buscar() {
       return  CondPgtoDAO.getInstance().retrieve();
    }
    
    public static void atualizar(CondicaoPgto objeto) {
      CondPgtoDAO.getInstance().update(objeto);
    }
  
    public static void excluir(CondicaoPgto objeto) {
        CondPgtoDAO.getInstance().delete(objeto);
    }
   
}
