package com.mycompany.newmaketmaven.services;

import java.util.List;
import com.mycompany.newmaketmaven.model.CondicaoPagamento;
import com.mycompany.newmaketmaven.modelDAO.CondicaoPagamentoDAO;


public class CondicaoPagamentoService{

    
    public static void criar(CondicaoPagamento objeto) {
        CondicaoPagamentoDAO.getInstance().create(objeto);
    }
    
    public static CondicaoPagamento buscar(int codigo) {
        return CondicaoPagamentoDAO.getInstance().retrieve(codigo);
    }

    public static CondicaoPagamento buscar(String descricao) {
       return CondicaoPagamentoDAO.getInstance().retrieve(descricao);
    }
    
    public static List<CondicaoPagamento> buscar() {
       return  CondicaoPagamentoDAO.getInstance().retrieve();
    }
    
    public static void atualizar(CondicaoPagamento objeto) {
      CondicaoPagamentoDAO.getInstance().update(objeto);
    }
  
    public static void excluir(CondicaoPagamento objeto) {
        CondicaoPagamentoDAO.getInstance().delete(objeto);
    }
   
}
