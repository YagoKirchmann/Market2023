package com.mycompany.newmaketmaven.services;

import java.util.List;
import com.mycompany.newmaketmaven.model.Classe;
import com.mycompany.newmaketmaven.modelDAO.ClasseDAO;


public class ClasseService{

    
    public static void criar(Classe objeto) {
        ClasseDAO.getInstance().create(objeto);
    }
    
    public static Classe buscar(int codigo) {
        return ClasseDAO.getInstance().retrieve(codigo);
    }

    public static Classe buscar(String descricao) {
       return ClasseDAO.getInstance().retrieve(descricao);
    }
    
    public static List<Classe> buscar() {
       return  ClasseDAO.getInstance().retrieve();
    }
    
    public static void atualizar(Classe objeto) {
      ClasseDAO.getInstance().update(objeto);
    }
  
    public static void excluir(Classe objeto) {
        ClasseDAO.getInstance().delete(objeto);
    }
   
}
