/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Colaboradors/Class.java to edit this template
 */
package com.mycompany.newmaketmaven.modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.newmaketmaven.model.Colaborador;
import com.mycompany.newmaketmaven.model.Colaborador;

/**
 *
 * @author Trabalho
 */
public class ColaboradorDAO implements InterfaceDAO<com.mycompany.newmaketmaven.model.Colaborador> {

    @Override
    public void create(Colaborador objeto) {
        
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "INSERT INTO colaborador (descricao) VALUES (?)";
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
    public Colaborador retrieve(int codigo) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "SELECT colaborador.id, colaborador.nome FROM colaborador WHERE colaborador.id = ?";  
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecute);
            pstm.setInt(1, codigo);
            rst = pstm.executeQuery();
            Colaborador colaborador = new Colaborador();
            
            while(rst.next()){
                colaborador.setId(rst.getInt("id"));
                colaborador.setNome(rst.getString("nome"));     
            }
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return colaborador;
        }catch (SQLException ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return null;
        }
    }

    @Override
    public Colaborador retrieve(String descricao) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "SELECT colaborador.id, colaborador.nome FROM colaborador WHERE colaborador.descricao = (?)";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecute);
            pstm.setString(1, descricao);
            rst = pstm.executeQuery();
            Colaborador colaborador = new Colaborador();
            while(rst.next()){
                colaborador.setId(rst.getInt("id"));
                colaborador.setNome(rst.getString("nome"));     
            }
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return colaborador;
        }catch (SQLException ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return null;
        }    
    }

    @Override
    public List<Colaborador> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "SELECT colaborador.id, colaborador.descricao FROM colaborador";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Colaborador> listaColaborador = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecute);
            rst = pstm.executeQuery();
            
            while(rst.next()){
                Colaborador colaborador = new Colaborador();
                colaborador.setId(rst.getInt("id"));
                colaborador.setNome(rst.getString("nome"));
                listaColaborador.add(colaborador);
            }
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return listaColaborador;
            
        }catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return null;
        }
    }

    @Override
    public void update(Colaborador objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "UPDATE colaborador SET colaborador.nome ? WHERE colaborador.id = ?";
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
    public void delete(Colaborador objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "DELETE FROM colaborador WHERE colaborador.id = ?";
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

