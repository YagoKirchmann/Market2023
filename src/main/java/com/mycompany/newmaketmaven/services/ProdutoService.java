
package com.mycompany.newmaketmaven.services;


import java.util.List;
import com.mycompany.newmaketmaven.model.Produto;
import com.mycompany.newmaketmaven.modelDAO.ProdutoDAO;


public class ProdutoService{

    
    public static void criar(Produto objeto) {
        ProdutoDAO produtoDAO =  new ProdutoDAO();
        produtoDAO.create(objeto);
    }

    
    public static Produto buscar(int codigo) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.retrieve(codigo);
       
    }

   
    public static Produto buscar(String descricao) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.retrieve(descricao);
    }

    
    public static List<Produto> buscar() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.retrieve();
    }

    
    public static void atualizar(Produto objeto) {
       ProdutoDAO produtoDAO = new ProdutoDAO();
       produtoDAO.update(objeto);
    }

   
    public static void excluir(Produto objeto) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.delete(objeto);
    }
    
    
    
}

