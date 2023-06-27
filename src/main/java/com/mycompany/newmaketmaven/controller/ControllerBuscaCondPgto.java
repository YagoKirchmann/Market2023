
package com.mycompany.newmaketmaven.controller;

import com.mycompany.newmaketmaven.model.CondicaoPagamento;
import com.mycompany.newmaketmaven.model.Produto;
import com.mycompany.newmaketmaven.services.CondicaoPagamentoService;
import com.mycompany.newmaketmaven.services.ProdutoService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mycompany.newmaketmaven.view.NewBuscaCondPgto;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aluno
 */
public class ControllerBuscaCondPgto implements ActionListener{
       
    NewBuscaCondPgto newBuscaCondPgto;
    
    public ControllerBuscaCondPgto(NewBuscaCondPgto newBuscaCondPgto){
        
        this.newBuscaCondPgto = newBuscaCondPgto;
        this.newBuscaCondPgto.getjButtonCarregar().addActionListener(this);
        this.newBuscaCondPgto.getjButtonSair().addActionListener(this);
        
        DefaultTableModel tabela = (DefaultTableModel) this.newBuscaCondPgto.getjTableDadosAchados().getModel();
        
        for (CondicaoPagamento objetoAtualDaLista : CondicaoPagamentoService.buscar()) {
            
            tabela.addRow(new Object[]{objetoAtualDaLista.getId(),          
                                       objetoAtualDaLista.getStatus()});                                       
        }
    }
    
    
    public void actioPerfomed(ActionEvent acao){
        
    }

    @Override
    public void actionPerformed(ActionEvent acao) {
        if(acao.getSource() == this.newBuscaCondPgto.getjButtonCarregar()){
            
        }else if(acao.getSource() == this.newBuscaCondPgto.getjButtonSair()){
            newBuscaCondPgto.dispose();
        }
    }
            
    
}
