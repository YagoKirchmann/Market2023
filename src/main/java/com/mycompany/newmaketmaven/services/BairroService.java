package com.mycompany.newmaketmaven.services;

import java.util.List;
import com.mycompany.newmaketmaven.model.Bairro;
import com.mycompany.newmaketmaven.modelDAO.BairroDAO;


public class BairroService{

    
    public static void criar(Bairro objeto) {
        BairroDAO.getInstance().create(objeto);
    }
    
    public static Bairro buscar(int codigo) {
        return BairroDAO.getInstance().retrieve(codigo);
    }

    public static Bairro buscar(String descricao) {
       return BairroDAO.getInstance().retrieve(descricao);
    }
    
    public static List<Bairro> buscar() {
       return  BairroDAO.getInstance().retrieve();
    }
    
    public static void atualizar(Bairro objeto) {
      BairroDAO.getInstance().update(objeto);
    }
  
    public static void excluir(Bairro objeto) {
        BairroDAO.getInstance().delete(objeto);
    }
   
}
