
package com.mycompany.newmaketmaven.services;


import java.util.List;
import com.mycompany.newmaketmaven.model.Produto;
import com.mycompany.newmaketmaven.modelDAO.ProdutoDAO;


public class ProdutoService{

    
    public static void criar(Produto objeto) {
        ProdutoDAO.getInstance().create(objeto);
    }
    
    public static Produto buscar(int codigo) {
        return ProdutoDAO.getInstance().retrieve(codigo);
    }

    public static Produto buscar(String descricao) {
       return ProdutoDAO.getInstance().retrieve(descricao);
    }
    
    public static List<Produto> buscar() {
       return  ProdutoDAO.getInstance().retrieve();
    }
    
    public static void atualizar(Produto objeto) {
      ProdutoDAO.getInstance().update(objeto);
    }
  
    public static void excluir(Produto objeto) {
        ProdutoDAO.getInstance().delete(objeto);
    }
   
}
