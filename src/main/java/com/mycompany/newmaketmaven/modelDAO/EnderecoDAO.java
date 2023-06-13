
package com.mycompany.newmaketmaven.modelDAO;

import java.util.List;
import com.mycompany.newmaketmaven.model.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;  
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.newmaketmaven.model.Bairro;
import com.mycompany.newmaketmaven.model.Cidade;



public class EnderecoDAO implements InterfaceDAO<Endereco> {

    @Override
    public void create(Endereco objeto) {
        
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "INSERT INTO endereco (cidade_id,bairro_id,logradouro,cep) VALUES (?,?,?,?)";
        PreparedStatement pstm = null ;
        
        try {
            pstm = conexao.prepareStatement(sqlExecute);
            
            pstm.setInt(1, objeto.getCidade().getId());
            pstm.setInt(2, objeto.getBairro().getId());
            pstm.setString(3, objeto.getLogradouro());
            pstm.setString(4, objeto.getCep());
            pstm.executeUpdate();
            
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        
        ConnectionFactory.closeConnection(conexao, pstm);
        
    }

    @Override
    public Endereco retrieve(int codigo) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "SELECT id, cep, cidade_id, bairro_id, logradouro FROM endereco WHERE endereco.id = ?";  
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecute);
            pstm.setInt(1, codigo);
            rst = pstm.executeQuery();
            Endereco endereco = new Endereco();
            
            while(rst.next()){
                endereco.setId(rst.getInt("id"));
                endereco.setCep(rst.getString("cep"));
                endereco.setLogradouro(rst.getString("logradouro"));

                // Recuperar a cidade usando o ID da cidade do registro atual
                int cidadeId = rst.getInt("cidade_id");
                CidadeDAO cidadeDAO = new CidadeDAO();
                Cidade cidade = cidadeDAO.retrieve(cidadeId);
                endereco.setCidade(cidade);

                // Recuperar o bairro usando o ID do bairro do registro atual
                int bairroId = rst.getInt("bairro_id");
                BairroDAO bairroDAO = new BairroDAO();
                Bairro bairro = bairroDAO.retrieve(bairroId);
                endereco.setBairro(bairro);    
            }
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return endereco;
        }catch (SQLException ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return null;
        }
    }

    @Override
    public Endereco retrieve(String cep) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "SELECT endereco.id, endereco.descricao FROM endereco WHERE endereco.descricao = (?)";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecute);
            pstm.setString(1, cep);
            rst = pstm.executeQuery();
            Endereco endereco = new Endereco();
            while(rst.next()){
                endereco.setId(rst.getInt("id"));
                endereco.setCep(rst.getString("cep"));
                endereco.setLogradouro(rst.getString("logradouro"));

                // Recuperar a cidade usando o ID da cidade do registro atual
                int cidadeId = rst.getInt("cidade_id");
                CidadeDAO cidadeDAO = new CidadeDAO();
                Cidade cidade = cidadeDAO.retrieve(cidadeId);
                endereco.setCidade(cidade);

                // Recuperar o bairro usando o ID do bairro do registro atual
                int bairroId = rst.getInt("bairro_id");
                BairroDAO bairroDAO = new BairroDAO();
                Bairro bairro = bairroDAO.retrieve(bairroId);
                endereco.setBairro(bairro);    
            }
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return endereco;
        }catch (SQLException ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return null;
        }    
    }

    @Override
    public List<Endereco> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "SELECT endereco.id, endereco.cep, endereco.logradouro, endereco.cidade_id,endereco.bairro_id FROM endereco";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Endereco> listaEndereco = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecute);
            rst = pstm.executeQuery();
            
            while(rst.next()){
                Endereco endereco = new Endereco();
                endereco.setId(rst.getInt("id"));
                endereco.setCep(rst.getString("cep"));
                endereco.setLogradouro(rst.getString("logradouro"));

                // Recuperar a cidade usando o ID da cidade do registro atual
                int cidadeId = rst.getInt("cidade_id");
                CidadeDAO cidadeDAO = new CidadeDAO();
                Cidade cidade = cidadeDAO.retrieve(cidadeId);
                endereco.setCidade(cidade);

                // Recuperar o bairro usando o ID do bairro do registro atual
                int bairroId = rst.getInt("bairro_id");
                BairroDAO bairroDAO = new BairroDAO();
                Bairro bairro = bairroDAO.retrieve(bairroId);
                endereco.setBairro(bairro); 
                listaEndereco.add(endereco);
            }
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return listaEndereco;
            
        }catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return null;
        }
    }

    @Override
    public void update(Endereco objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "UPDATE endereco SET logradouro = ?,cep = ?,bairro_id = ?,cidade_id = ? WHERE endereco.id = (?)";
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecute);
            
            pstm.setString(1, objeto.getLogradouro());
            pstm.setString(2, objeto.getCep());
            pstm.setInt(3, objeto.getBairro().getId());
            pstm.setInt(4, objeto.getCidade().getId());
            pstm.setInt(5,objeto.getId());
            pstm.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
         ConnectionFactory.closeConnection(conexao,pstm);         
    }

    @Override
    public void delete(Endereco objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "DELETE FROM endereco WHERE endereco.id = ?";
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
