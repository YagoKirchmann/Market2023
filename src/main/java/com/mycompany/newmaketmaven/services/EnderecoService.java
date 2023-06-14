package com.mycompany.newmaketmaven.services;

import java.util.List;
import com.mycompany.newmaketmaven.model.Endereco;
import com.mycompany.newmaketmaven.modelDAO.EnderecoDAO;


public class EnderecoService{

    
    public static void criar(Endereco objeto) {
        EnderecoDAO.getInstance().create(objeto);
    }
    
    public static Endereco buscar(int codigo) {
        return EnderecoDAO.getInstance().retrieve(codigo);
    }

    public static Endereco buscar(String descricao) {
       return EnderecoDAO.getInstance().retrieve(descricao);
    }
    
    public static List<Endereco> buscar() {
       return  EnderecoDAO.getInstance().retrieve();
    }
    
    public static void atualizar(Endereco objeto) {
      EnderecoDAO.getInstance().update(objeto);
    }
  
    public static void excluir(Endereco objeto) {
        EnderecoDAO.getInstance().delete(objeto);
    }
   
}