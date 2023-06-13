package com.mycompany.newmaketmaven.services;

import java.util.List;
import com.mycompany.newmaketmaven.model.Colaborador;
import com.mycompany.newmaketmaven.modelDAO.ColaboradorDAO;


public class ColaboradorService{

    
    public static void criar(Colaborador objeto) {
        ColaboradorDAO colaboradorDAO =  new ColaboradorDAO();
        colaboradorDAO.create(objeto);
    }

    
    public static Colaborador buscar(int codigo) {
        ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
        return colaboradorDAO.retrieve(codigo);
       
    }

   
    public static Colaborador buscar(String descricao) {
        ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
        return colaboradorDAO.retrieve(descricao);
    }

    
    public static List<Colaborador> buscar() {
        ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
        return colaboradorDAO.retrieve();
    }

    
    public static void atualizar(Colaborador objeto) {
       ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
       colaboradorDAO.update(objeto);
    }

   
    public static void excluir(Colaborador objeto) {
        ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
        colaboradorDAO.delete(objeto);
    }
    
    
    
}
