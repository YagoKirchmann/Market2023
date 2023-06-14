package com.mycompany.newmaketmaven.services;

import java.util.List;
import com.mycompany.newmaketmaven.model.Fornecedor;
import com.mycompany.newmaketmaven.modelDAO.FornecedorDAO;


public class FornecedorService{

    
    public static void criar(Fornecedor objeto) {
        FornecedorDAO.getInstance().create(objeto);
    }
    
    public static Fornecedor buscar(int codigo) {
        return FornecedorDAO.getInstance().retrieve(codigo);
    }

    public static Fornecedor buscar(String descricao) {
       return FornecedorDAO.getInstance().retrieve(descricao);
    }
    
    public static List<Fornecedor> buscar() {
       return  FornecedorDAO.getInstance().retrieve();
    }
    
    public static void atualizar(Fornecedor objeto) {
      FornecedorDAO.getInstance().update(objeto);
    }
  
    public static void excluir(Fornecedor objeto) {
        FornecedorDAO.getInstance().delete(objeto);
    }
   
}