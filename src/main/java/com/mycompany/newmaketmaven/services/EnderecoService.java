package com.mycompany.newmaketmaven.services;

import java.util.List;
import com.mycompany.newmaketmaven.model.Endereco;
import com.mycompany.newmaketmaven.modelDAO.EnderecoDAO;


public class EnderecoService{

    
    public static void criar(Endereco objeto) {
        EnderecoDAO enderecoDAO =  new EnderecoDAO();
        enderecoDAO.create(objeto);
    }

    
    public static Endereco buscar(int codigo) {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        return enderecoDAO.retrieve(codigo);
       
    }

   
    public static Endereco buscar(String descricao) {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        return enderecoDAO.retrieve(descricao);
    }

    
    public static List<Endereco> buscar() {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        return enderecoDAO.retrieve();
    }

    
    public static void atualizar(Endereco objeto) {
       EnderecoDAO enderecoDAO = new EnderecoDAO();
       enderecoDAO.update(objeto);
    }

   
    public static void excluir(Endereco objeto) {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.delete(objeto);
    }
    
    
    
}
