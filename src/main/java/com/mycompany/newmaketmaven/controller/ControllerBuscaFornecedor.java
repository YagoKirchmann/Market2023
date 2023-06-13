
package com.mycompany.newmaketmaven.controller;

import com.mycompany.newmaketmaven.model.Fornecedor;
import com.mycompany.newmaketmaven.services.FornecedorService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mycompany.newmaketmaven.view.NewBuscaFornecedor;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aluno
 */
public class ControllerBuscaFornecedor implements ActionListener{
       
    NewBuscaFornecedor newBuscaFornecedor;
    
    public ControllerBuscaFornecedor(NewBuscaFornecedor newBuscaFornecedor){
        
        this.newBuscaFornecedor = newBuscaFornecedor;
        this.newBuscaFornecedor.getjButtonCarregar().addActionListener(this);
        this.newBuscaFornecedor.getjButtonSair().addActionListener(this);
        
        DefaultTableModel tabela = (DefaultTableModel) this.newBuscaFornecedor.getjTableDadosAchados().getModel();
         
        for (Fornecedor objetoAtualDaLista : FornecedorService.buscar()) {
            tabela.addRow(new Object[]{objetoAtualDaLista.getId(),          
                                       objetoAtualDaLista.getDtCadastro(),
                                       objetoAtualDaLista.getStatus()});                                       
        }
    }
    
    
    public void actioPerfomed(ActionEvent acao){
        
    }

    @Override
    public void actionPerformed(ActionEvent acao) {
        if(acao.getSource() == this.newBuscaFornecedor.getjButtonCarregar()){
            
        }else if(acao.getSource() == this.newBuscaFornecedor.getjButtonSair()){
            newBuscaFornecedor.dispose();
        }
    }
            
    
}
