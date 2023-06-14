package com.mycompany.newmaketmaven.services;

import java.util.List;
import com.mycompany.newmaketmaven.model.Colaborador;
import com.mycompany.newmaketmaven.modelDAO.ColaboradorDAO;


public class ColaboradorService{

    
    public static void criar(Colaborador objeto) {
        ColaboradorDAO.getInstance().create(objeto);
    }
    
    public static Colaborador buscar(int codigo) {
        return ColaboradorDAO.getInstance().retrieve(codigo);
    }

    public static Colaborador buscar(String descricao) {
       return ColaboradorDAO.getInstance().retrieve(descricao);
    }
    
    public static List<Colaborador> buscar() {
       return  ColaboradorDAO.getInstance().retrieve();
    }
    
    public static void atualizar(Colaborador objeto) {
      ColaboradorDAO.getInstance().update(objeto);
    }
  
    public static void excluir(Colaborador objeto) {
        ColaboradorDAO.getInstance().delete(objeto);
    }
   
}
