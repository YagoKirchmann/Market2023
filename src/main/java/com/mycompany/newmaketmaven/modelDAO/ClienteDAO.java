/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Clientes/Class.java to edit this template
 */
package com.mycompany.newmaketmaven.modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.newmaketmaven.model.Cliente;
import com.mycompany.newmaketmaven.model.Cliente;
import com.mycompany.newmaketmaven.model.Endereco;

/**
 *
 * @author Trabalho
 */
public class ClienteDAO implements InterfaceDAO<com.mycompany.newmaketmaven.model.Cliente> {

    @Override
    public void create(Cliente objeto) {
        
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "INSERT INTO cliente (nome) VALUES (?)";
        PreparedStatement pstm = null ;
        
        try {
            pstm = conexao.prepareStatement(sqlExecute);
            pstm.setString(1, objeto.getNome());
            pstm.executeUpdate();
            
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        
        ConnectionFactory.closeConnection(conexao, pstm);
        
    }

    @Override
    public Cliente retrieve(int codigo) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "SELECT cliente.id, cliente.rg, cliente.fone1,cliente.dtNascimento,cliente.complementoEndereco,cliente.fone2,cliente.observacao,cliente.email,cliente.cpf,cliente.dtCadastro,cliente.status,cliente.nome,endereco.cep,endereco.bairro_id FROM cliente,endereco WHERE cliente.id = ?";  
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecute);
            pstm.setInt(1, codigo);
            rst = pstm.executeQuery();
            Cliente cliente = new Cliente();
            
            while(rst.next()){
                cliente.setId(rst.getInt("id"));
                cliente.setNome(rst.getString("nome"));
                cliente.setCpf(rst.getString("cpf"));
                cliente.setRg(rst.getString("rg"));
                cliente.setEmail(rst.getString("email"));
                cliente.setFone1(rst.getString("fone1"));
                cliente.setFone2(rst.getString("fone2"));
                cliente.setObservacao(rst.getString("observacao"));
                cliente.setComplementoEndereco(rst.getString("complementoEndereco"));
                cliente.setDtNascimento(rst.getDate("dtNascimento"));
                cliente.setDtCadastro(rst.getDate("dtCadastro"));
                cliente.setStatus(rst.getString("status"));
            }
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return cliente;
        }catch (SQLException ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return null;
        }
    }

    @Override
    public Cliente retrieve(String nome) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "SELECT cliente.id, cliente.nome FROM cliente WHERE cliente.nome = (?)";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecute);
            pstm.setString(1, nome);
            rst = pstm.executeQuery();
            Cliente cliente = new Cliente();
            while(rst.next()){
                cliente.setId(rst.getInt("id"));
                cliente.setNome(rst.getString("nome"));     
            }
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return cliente;
        }catch (SQLException ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return null;
        }    
    }

    @Override
    public List<Cliente> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "SELECT cliente.id,cliente.nome,cliente.cpf,cliente.dtCadastro,cliente.status FROM cliente";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Cliente> listaCliente = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecute);
            rst = pstm.executeQuery();
            
            while(rst.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rst.getInt("id"));
                cliente.setNome(rst.getString("nome"));
                cliente.setCpf(rst.getString("cpf"));
                cliente.setDtCadastro(rst.getDate("dtCadastro"));
                cliente.setStatus(rst.getString("status"));
                listaCliente.add(cliente);
            }
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return listaCliente;
            
        }catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return null;
        }
    }

    @Override
    public void update(Cliente objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "UPDATE cliente SET cliente.nome ? WHERE cliente.id = ?";
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecute);
            pstm.setString(1, objeto.getNome());
            pstm.setInt(2, objeto.getId());
            pstm.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
         ConnectionFactory.closeConnection(conexao,pstm);         
    }

    @Override
    public void delete(Cliente objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "DELETE FROM cliente WHERE cliente.id = ?";
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecute);
            pstm.setInt(0,objeto.getId());
            pstm.executeQuery();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        ConnectionFactory.closeConnection(conexao,pstm);   
        
    }
    
}

