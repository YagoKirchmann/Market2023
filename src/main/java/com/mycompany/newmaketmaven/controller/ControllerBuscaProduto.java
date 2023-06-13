
package com.mycompany.newmaketmaven.controller;

import com.mycompany.newmaketmaven.model.Produto;
import com.mycompany.newmaketmaven.services.ProdutoService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mycompany.newmaketmaven.view.NewBuscaProduto;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aluno
 */
public class ControllerBuscaProduto implements ActionListener{
       
    NewBuscaProduto newBuscaProduto;
    
    public ControllerBuscaProduto(NewBuscaProduto newBuscaProduto){
        
        this.newBuscaProduto = newBuscaProduto;
        this.newBuscaProduto.getjButtonCarregar().addActionListener(this);
        this.newBuscaProduto.getjButtonSair().addActionListener(this);
        
        DefaultTableModel tabela = (DefaultTableModel) this.newBuscaProduto.getjTableDadosAchados().getModel();
         
        for (Produto objetoAtualDaLista : ProdutoService.buscar()) {
            
            tabela.addRow(new Object[]{objetoAtualDaLista.getId(),          
                                       objetoAtualDaLista.getDtCadastro(),
                                       objetoAtualDaLista.getStatus()});                                       
        }
    }
    
    
    public void actioPerfomed(ActionEvent acao){
        
    }

    @Override
    public void actionPerformed(ActionEvent acao) {
        if(acao.getSource() == this.newBuscaProduto.getjButtonCarregar()){
            
        }else if(acao.getSource() == this.newBuscaProduto.getjButtonSair()){
            newBuscaProduto.dispose();
        }
    }
            
    
}
