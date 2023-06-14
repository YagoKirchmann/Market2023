package com.mycompany.newmaketmaven.services;

import java.util.List;
import com.mycompany.newmaketmaven.model.CondicaoPgto;
import com.mycompany.newmaketmaven.modelDAO.CondPgtoDAO;


public class CondPgtoService{

    
    public static void criar(CondPgto objeto) {
        CondPgtoDAO.getInstance().create(objeto);
    }
    
    public static CondPgto buscar(int codigo) {
        return CondPgtoDAO.getInstance().retrieve(codigo);
    }

    public static CondPgto buscar(String descricao) {
       return CondPgtoDAO.getInstance().retrieve(descricao);
    }
    
    public static List<CondPgto> buscar() {
       return  CondPgtoDAO.getInstance().retrieve();
    }
    
    public static void atualizar(CondPgto objeto) {
      CondPgtoDAO.getInstance().update(objeto);
    }
  
    public static void excluir(CondPgto objeto) {
        CondPgtoDAO.getInstance().delete(objeto);
    }
   
}
