
package com.mycompany.newmaketmaven.modelDAO;

import java.sql.Connection;
import java.util.List;
import com.mycompany.newmaketmaven.model.CondicaoPgto;
import java.sql.PreparedStatement;  
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;


public class CondPgtoDAO implements InterfaceDAO<CondicaoPgto>{

    @Override
    public void create(CondicaoPgto objeto) {
        
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "INSERT INTO condicaoPgto (descricaoCondicao) VALUES (?)";
        PreparedStatement pstm = null ;
        
        try {
            pstm = conexao.prepareStatement(sqlExecute);
            pstm.setString(1, objeto.getDescricaoCondicao());
            pstm.executeUpdate();
            
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        
        ConnectionFactory.closeConnection(conexao, pstm);
        
    }

    @Override
    public CondicaoPgto retrieve(int codigo) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "SELECT condicaoPgto.id, condicaoPgto.descricaoCondicao FROM condicaoPgto WHERE condicaoPgto.id = ?";  
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecute);
            pstm.setInt(1, codigo);
            rst = pstm.executeQuery();
            CondicaoPgto condicaoPgto = new CondicaoPgto();
            
            while(rst.next()){
                condicaoPgto.setId(rst.getInt("id"));
                condicaoPgto.setDescricaoCondicao(rst.getString("descricaoCondicao"));     
            }
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return condicaoPgto;
        }catch (SQLException ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return null;
        }
    }

    @Override
    public CondicaoPgto retrieve(String descricaoCondicao) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "SELECT condicaoPgto.id, condicaoPgto.descricaoCondicao FROM condicaoPgto WHERE condicaoPgto.descricaoCondicao = (?)";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecute);
            pstm.setString(1, descricaoCondicao);
            rst = pstm.executeQuery();
            CondicaoPgto condicaoPgto = new CondicaoPgto();
            while(rst.next()){
                condicaoPgto.setId(rst.getInt("id"));
                condicaoPgto.setDescricaoCondicao(rst.getString("descricaoCondicao"));     
            }
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return condicaoPgto;
        }catch (SQLException ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return null;
        }    
    }

    @Override
    public List<CondicaoPgto> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "SELECT condicaoPgto.id, condicaoPgto.descricaoCondicao FROM condicaoPgto";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<CondicaoPgto> listaCondicaoPgto = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecute);
            rst = pstm.executeQuery();
            
            while(rst.next()){
                CondicaoPgto condicaoPgto = new CondicaoPgto();
                condicaoPgto.setId(rst.getInt("id"));
                condicaoPgto.setDescricaoCondicao(rst.getString("descricaoCondicao"));
                listaCondicaoPgto.add(condicaoPgto);
            }
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return listaCondicaoPgto;
            
        }catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return null;
        }
    }

    @Override
    public void update(CondicaoPgto objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "UPDATE condicaoPgto SET condicaoPgto.descricaoCondicao ? WHERE condicaoPgto.id = (?)";
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecute);
            pstm.setString(1, objeto.getDescricaoCondicao());
            pstm.setInt(2, objeto.getId());
            pstm.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
         ConnectionFactory.closeConnection(conexao,pstm);         
    }

    @Override
    public void delete(CondicaoPgto objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "DELETE FROM condicaoPgto WHERE condicaoPgto.id = ?";
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
