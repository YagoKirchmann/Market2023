
package com.mycompany.newmaketmaven.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import com.mycompany.newmaketmaven.model.Cliente;
import com.mycompany.newmaketmaven.modelDAO.ClienteDAO;
import com.mycompany.newmaketmaven.services.ClienteService;
import com.mycompany.newmaketmaven.view.NewBuscaCliente;

/**
 *
 * @author aluno
 */
public class ControllerBuscaClientes implements ActionListener{
       
    NewBuscaCliente newBuscaCliente;
    
    public ControllerBuscaClientes(NewBuscaCliente newBuscaCliente){
        
        this.newBuscaCliente = newBuscaCliente;
        this.newBuscaCliente.getjButtonCarregar().addActionListener(this);
        this.newBuscaCliente.getjButtonSair().addActionListener(this);
        
        DefaultTableModel tabela = (DefaultTableModel) this.newBuscaCliente.getjTableDadosAchados().getModel();  
        
        for (Cliente objetoAtualDaLista : ClienteService.buscar()) {
            
            tabela.addRow(new Object[]{objetoAtualDaLista.getId(),          
                                       objetoAtualDaLista.getNome(),
                                       objetoAtualDaLista.getCpf(),
                                       objetoAtualDaLista.getRg(),
                                       objetoAtualDaLista.getEmail(),
                                       objetoAtualDaLista.getFone1(),
                                       objetoAtualDaLista.getFone2(),
                                       objetoAtualDaLista.getObservacao(),
                                       objetoAtualDaLista.getDtCadastro(),
                                       objetoAtualDaLista.getStatus()});                                       
        }
    }
    
    
    public void actioPerfomed(ActionEvent acao){
        
    }

    @Override
    public void actionPerformed(ActionEvent acao) {
        if(this.newBuscaCliente.getjTableDadosAchados().getValueAt(this.newBuscaCliente.getjTableDadosAchados().getSelectedRow(), 0 ) != null){
         
                ControllerClientes.codigo = (int) this.newBuscaCliente.getjTableDadosAchados().getValueAt(this.newBuscaCliente.getjTableDadosAchados().getSelectedRow(), 0);
                
                newBuscaCliente.dispose();
            }else if(acao.getSource() == this.newBuscaCliente.getjButtonSair()){
            newBuscaCliente.dispose();
        }
    }
            
    
}
