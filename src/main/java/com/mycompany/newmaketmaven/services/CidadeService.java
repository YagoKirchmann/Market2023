package com.mycompany.newmaketmaven.services;

import java.util.List;
import com.mycompany.newmaketmaven.model.Cidade;
import com.mycompany.newmaketmaven.modelDAO.CidadeDAO;


public class CidadeService{

    
    public static void criar(Cidade objeto) {
        CidadeDAO.getInstance().create(objeto);
    }
    
    public static Cidade buscar(int codigo) {
        return CidadeDAO.getInstance().retrieve(codigo);
    }

    public static Cidade buscar(String descricao) {
       return CidadeDAO.getInstance().retrieve(descricao);
    }
    
    public static List<Cidade> buscar() {
       return  CidadeDAO.getInstance().retrieve();
    }
    
    public static void atualizar(Cidade objeto) {
      CidadeDAO.getInstance().update(objeto);
    }
  
    public static void excluir(Cidade objeto) {
        CidadeDAO.getInstance().delete(objeto);
    }
   
}