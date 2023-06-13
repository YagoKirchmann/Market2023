
package com.mycompany.newmaketmaven.modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.newmaketmaven.model.Cidade;

public class CidadeDAO implements InterfaceDAO<Cidade>{

    @Override
    public void create(Cidade objeto) {
        //Buscar conexão || Persistir no Objeto || Encerrar a Conexão
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "INSERT INTO cidade (descricao) VALUES (?)";
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
    public Cidade retrieve(int codigo) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "SELECT cidade.id, cidade.descricao FROM cidade WHERE cidade.id = ?";  
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecute);
            pstm.setInt(1, codigo);
            rst = pstm.executeQuery();
            Cidade cidade = new Cidade();
            
            while(rst.next()){
                cidade.setId(rst.getInt("id"));
                cidade.setDescricao(rst.getString("descricao"));     
            }
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return cidade;
        }catch (SQLException ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return null;
        }
    }

    @Override
    public Cidade retrieve(String descricao) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "SELECT cidade.id, cidade.descricao FROM cidade WHERE cidade.descricao = (?)";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecute);
            pstm.setString(1, descricao);
            rst = pstm.executeQuery();
            Cidade cidade = new Cidade();
            while(rst.next()){
                cidade.setId(rst.getInt("id"));
                cidade.setDescricao(rst.getString("descricao"));     
            }
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return cidade;
        }catch (SQLException ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return null;
        }
    }

    @Override
    public List<Cidade> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "SELECT cidade.id, cidade.descricao FROM cidade";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Cidade> listaCidade = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecute);
            rst = pstm.executeQuery();
            
            while(rst.next()){
                Cidade cidade = new Cidade();
                cidade.setId(rst.getInt("id"));
                cidade.setDescricao(rst.getString("descricao"));
                listaCidade.add(cidade);
            }
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return listaCidade;
            
        }catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return null;
        }
    }

    @Override
    public void update(Cidade objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "UPDATE cidade SET cidade.descricao ? WHERE cidade.id = ?";
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
    public void delete(Cidade objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "DELETE FROM cidade WHERE cidade.id = ?";
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