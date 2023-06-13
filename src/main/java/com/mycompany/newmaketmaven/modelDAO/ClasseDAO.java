/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newmaketmaven.modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.newmaketmaven.model.Classe;
import com.mycompany.newmaketmaven.model.Classe;

/**
 *
 * @author Trabalho
 */
public class ClasseDAO implements InterfaceDAO<com.mycompany.newmaketmaven.model.Classe> {

    @Override
    public void create(Classe objeto) {
        
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "INSERT INTO classe (descricao) VALUES (?)";
        PreparedStatement pstm = null ;
        
        try {
            pstm = conexao.prepareStatement(sqlExecute);
            pstm.setString(1, objeto.getDescricao());
            pstm.executeUpdate();
            
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        
        ConnectionFactory.closeConnection(conexao, pstm);
        
    }

    @Override
    public Classe retrieve(int codigo) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "SELECT classe.id, classe.descricao FROM classe WHERE classe.id = ?";  
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecute);
            pstm.setInt(1, codigo);
            rst = pstm.executeQuery();
            Classe classe = new Classe();
            
            while(rst.next()){
                classe.setId(rst.getInt("id"));
                classe.setDescricao(rst.getString("descricao"));     
            }
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return classe;
        }catch (SQLException ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return null;
        }
    }

    @Override
    public Classe retrieve(String descricao) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "SELECT classe.id, classe.descricao FROM classe WHERE classe.descricao = (?)";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecute);
            pstm.setString(1, descricao);
            rst = pstm.executeQuery();
            Classe classe = new Classe();
            while(rst.next()){
                classe.setId(rst.getInt("id"));
                classe.setDescricao(rst.getString("descricao"));     
            }
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return classe;
        }catch (SQLException ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return null;
        }    
    }

    @Override
    public List<Classe> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "SELECT classe.id, classe.descricao FROM classe";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Classe> listaClasse = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecute);
            rst = pstm.executeQuery();
            
            while(rst.next()){
                Classe classe = new Classe();
                classe.setId(rst.getInt("id"));
                classe.setDescricao(rst.getString("descricao"));
                listaClasse.add(classe);
            }
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return listaClasse;
            
        }catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return null;
        }
    }

    @Override
    public void update(Classe objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "UPDATE classe SET classe.descricao ? WHERE classe.id = ?";
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecute);
            pstm.setString(1, objeto.getDescricao());
            pstm.setInt(2, objeto.getId());
            pstm.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
         ConnectionFactory.closeConnection(conexao,pstm);         
    }

    @Override
    public void delete(Classe objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "DELETE FROM classe WHERE classe.id = ?";
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

