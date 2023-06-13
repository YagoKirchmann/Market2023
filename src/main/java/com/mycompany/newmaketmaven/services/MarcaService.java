package com.mycompany.newmaketmaven.services;

import java.util.List;
import com.mycompany.newmaketmaven.model.Marca;
import com.mycompany.newmaketmaven.modelDAO.MarcaDAO;


public class MarcaService{

    
    public static void criar(Marca objeto) {
        MarcaDAO marcaDAO =  new MarcaDAO();
        marcaDAO.create(objeto);
    }

    
    public static Marca buscar(int codigo) {
        MarcaDAO marcaDAO = new MarcaDAO();
        return marcaDAO.retrieve(codigo);
       
    }

   
    public static Marca buscar(String descricao) {
        MarcaDAO marcaDAO = new MarcaDAO();
        return marcaDAO.retrieve(descricao);
    }

    
    public static List<Marca> buscar() {
        MarcaDAO marcaDAO = new MarcaDAO();
        return marcaDAO.retrieve();
    }

    
    public static void atualizar(Marca objeto) {
       MarcaDAO marcaDAO = new MarcaDAO();
       marcaDAO.update(objeto);
    }

   
    public static void excluir(Marca objeto) {
        MarcaDAO marcaDAO = new MarcaDAO();
        marcaDAO.delete(objeto);
    }
    
    
    
}
