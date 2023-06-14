package com.mycompany.newmaketmaven.services;

import java.util.List;
import com.mycompany.newmaketmaven.model.Marca;
import com.mycompany.newmaketmaven.modelDAO.MarcaDAO;


public class MarcaService{

    
    public static void criar(Marca objeto) {
        MarcaDAO.getInstance().create(objeto);
    }
    
    public static Marca buscar(int codigo) {
        return MarcaDAO.getInstance().retrieve(codigo);
    }

    public static Marca buscar(String descricao) {
       return MarcaDAO.getInstance().retrieve(descricao);
    }
    
    public static List<Marca> buscar() {
       return  MarcaDAO.getInstance().retrieve();
    }
    
    public static void atualizar(Marca objeto) {
      MarcaDAO.getInstance().update(objeto);
    }
  
    public static void excluir(Marca objeto) {
        MarcaDAO.getInstance().delete(objeto);
    }
   
}
