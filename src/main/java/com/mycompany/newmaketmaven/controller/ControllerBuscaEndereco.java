
package com.mycompany.newmaketmaven.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import com.mycompany.newmaketmaven.model.Endereco;
import com.mycompany.newmaketmaven.modelDAO.EnderecoDAO;
import com.mycompany.newmaketmaven.services.EnderecoService;
import com.mycompany.newmaketmaven.view.NewBuscaEndereco;

/**
 *
 * @author aluno
 */
public class ControllerBuscaEndereco implements ActionListener{
       
    NewBuscaEndereco newBuscaEndereco;
    
    public ControllerBuscaEndereco(NewBuscaEndereco newBuscaEndereco){
        this.newBuscaEndereco = newBuscaEndereco;
        
        this.newBuscaEndereco.getjButtonCarregar().addActionListener(this);
        this.newBuscaEndereco.getjButtonSair().addActionListener(this);
        DefaultTableModel tabela = (DefaultTableModel) this.newBuscaEndereco.getjTableDadosAchados().getModel();  
        
        for (Endereco objetoAtualDaLista : EnderecoService.buscar()) {
            tabela.addRow(new Object[]{objetoAtualDaLista.getId(),
                                       objetoAtualDaLista.getCidade().getDescricao(),
                                       objetoAtualDaLista.getBairro().getDescricao(),
                                       objetoAtualDaLista.getLogradouro(),
                                       objetoAtualDaLista.getCep()});                                       
        }
    }
    
    
    public void actioPerfomed(ActionEvent acao){
        
    }

    @Override
    public void actionPerformed(ActionEvent acao) {
        if(this.newBuscaEndereco.getjTableDadosAchados().getValueAt(this.newBuscaEndereco.getjTableDadosAchados().getSelectedRow(), 0 ) != null){         
                ControllerEndereco.codigo = (int) this.newBuscaEndereco.getjTableDadosAchados().getValueAt(this.newBuscaEndereco.getjTableDadosAchados().getSelectedRow(), 0);   
                ControllerClientes.codigoEnd = (int) this.newBuscaEndereco.getjTableDadosAchados().getValueAt(this.newBuscaEndereco.getjTableDadosAchados().getSelectedRow(), 0);
                newBuscaEndereco.dispose();
            }else if(acao.getSource() == this.newBuscaEndereco.getjButtonSair()){
            newBuscaEndereco.dispose();
        }
    }
            
    
}
