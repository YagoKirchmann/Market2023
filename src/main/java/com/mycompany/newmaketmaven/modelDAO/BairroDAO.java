
package com.mycompany.newmaketmaven.modelDAO;

import java.sql.Connection;
import java.util.List;
import com.mycompany.newmaketmaven.model.Bairro;
import java.sql.PreparedStatement;  
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static org.eclipse.persistence.jpa.JpaHelper.getEntityManager;


public class BairroDAO implements InterfaceDAO<Bairro>{
    
    private static BairroDAO instance;
    protected EntityManager entityManager;
    
    public static BairroDAO getInstance(){
    if(instance == null){
    instance = new BairroDAO();
    }
    return instance;
    }

    private BairroDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_NewMarketMaven_jar_1.0-SNAPSHOTPU");
        
      if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        
        return entityManager;
    }
    
    @Override
    public void create(Bairro objeto) {
        
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "INSERT INTO bairro (descricao) VALUES (?)";
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
    public Bairro retrieve(int codigo) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "SELECT bairro.id, bairro.descricao FROM bairro WHERE bairro.id = ?";  
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecute);
            pstm.setInt(1, codigo);
            rst = pstm.executeQuery();
            Bairro bairro = new Bairro();
            
            while(rst.next()){
                bairro.setId(rst.getInt("id"));
                bairro.setDescricao(rst.getString("descricao"));     
            }
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return bairro;
        }catch (SQLException ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return null;
        }
    }

    @Override
    public Bairro retrieve(String descricao) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "SELECT bairro.id, bairro.descricao FROM bairro WHERE bairro.descricao = (?)";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecute);
            pstm.setString(1, descricao);
            rst = pstm.executeQuery();
            Bairro bairro = new Bairro();
            while(rst.next()){
                bairro.setId(rst.getInt("id"));
                bairro.setDescricao(rst.getString("descricao"));     
            }
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return bairro;
        }catch (SQLException ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return null;
        }    
    }

    @Override
    public List<Bairro> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "SELECT bairro.id, bairro.descricao FROM bairro";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Bairro> listaBairro = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecute);
            rst = pstm.executeQuery();
            
            while(rst.next()){
                Bairro bairro = new Bairro();
                bairro.setId(rst.getInt("id"));
                bairro.setDescricao(rst.getString("descricao"));
                listaBairro.add(bairro);
            }
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return listaBairro;
            
        }catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao,pstm,rst);
            return null;
        }
    }

    @Override
    public void update(Bairro objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "UPDATE bairro SET bairro.descricao ('?') WHERE bairro.id = (?)";
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecute);
            pstm.setString(0, objeto.getDescricao());
            pstm.setInt(1, objeto.getId());
            pstm.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
         ConnectionFactory.closeConnection(conexao,pstm);         
    }

    @Override
    public void delete(Bairro objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecute = "DELETE FROM bairro WHERE bairro.id = ?";
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
