package com.mycompany.newmaketmaven.services;

import java.util.List;
import com.mycompany.newmaketmaven.model.Fornecedor;
import com.mycompany.newmaketmaven.modelDAO.FornecedorDAO;


public class FornecedorService{

    
    public static void criar(Fornecedor objeto) {
        FornecedorDAO classeDAO =  new FornecedorDAO();
        classeDAO.create(objeto);
    }

    
    public static Fornecedor buscar(int codigo) {
        FornecedorDAO classeDAO = new FornecedorDAO();
        return classeDAO.retrieve(codigo);
       
    }

   
    public static Fornecedor buscar(String descricao) {
        FornecedorDAO classeDAO = new FornecedorDAO();
        return classeDAO.retrieve(descricao);
    }

    
    public static List<Fornecedor> buscar() {
        FornecedorDAO classeDAO = new FornecedorDAO();
        return classeDAO.retrieve();
    }

    
    public static void atualizar(Fornecedor objeto) {
       FornecedorDAO classeDAO = new FornecedorDAO();
       classeDAO.update(objeto);
    }

   
    public static void excluir(Fornecedor objeto) {
        FornecedorDAO classeDAO = new FornecedorDAO();
        classeDAO.delete(objeto);
    }
    
}