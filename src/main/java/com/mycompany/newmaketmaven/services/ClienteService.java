package com.mycompany.newmaketmaven.services;

import java.util.List;
import com.mycompany.newmaketmaven.model.Cliente;
import com.mycompany.newmaketmaven.modelDAO.ClienteDAO;


public class ClienteService{

    
    public static void criar(Cliente objeto) {
        ClienteDAO clienteDAO =  new ClienteDAO();
        clienteDAO.create(objeto);
    }

    
    public static Cliente buscar(int codigo) {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.retrieve(codigo);
       
    }

   
    public static Cliente buscar(String descricao) {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.retrieve(descricao);
    }

    
    public static List<Cliente> buscar() {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.retrieve();
    }

    
    public static void atualizar(Cliente objeto) {
       ClienteDAO clienteDAO = new ClienteDAO();
       clienteDAO.update(objeto);
    }

   
    public static void excluir(Cliente objeto) {
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.delete(objeto);
    }
    
    
    
}
