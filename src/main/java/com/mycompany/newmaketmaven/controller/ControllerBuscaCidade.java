
package com.mycompany.newmaketmaven.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import com.mycompany.newmaketmaven.model.Cidade;
import com.mycompany.newmaketmaven.modelDAO.CidadeDAO;
import com.mycompany.newmaketmaven.services.CidadeService;
import com.mycompany.newmaketmaven.view.NewBuscaCidade;

/**
 *
 * @author aluno
 */
public class ControllerBuscaCidade implements ActionListener{
       
    NewBuscaCidade newBuscaCidade;
    
    public ControllerBuscaCidade(NewBuscaCidade newBuscaCidade){
        this.newBuscaCidade = newBuscaCidade;
        
        this.newBuscaCidade.getjButtonCarregar().addActionListener(this);
        this.newBuscaCidade.getjButtonSair().addActionListener(this);
        DefaultTableModel tabela = (DefaultTableModel) this.newBuscaCidade.getjTableDadosAchados().getModel();  
            
        for (Cidade objetoAtualDaLista : CidadeService.buscar()) {
            
            tabela.addRow(new Object[]{objetoAtualDaLista.getId(),
                                       objetoAtualDaLista.getDescricao()});                                       
        }
    }
    

    @Override
    public void actionPerformed(ActionEvent acao) {
       if(acao.getSource() == this.newBuscaCidade.getjButtonCarregar()){
            if(this.newBuscaCidade.getjTableDadosAchados().getValueAt(this.newBuscaCidade.getjTableDadosAchados().getSelectedRow(), 0 ) != null){         
                
                ControllerCidade.codigo = (int) this.newBuscaCidade.getjTableDadosAchados().getValueAt(this.newBuscaCidade.getjTableDadosAchados().getSelectedRow(), 0);
                ControllerEndereco.codigoCid = (int) this.newBuscaCidade.getjTableDadosAchados().getValueAt(this.newBuscaCidade.getjTableDadosAchados().getSelectedRow(), 0);
                newBuscaCidade.dispose();
               }
            
        }else if(acao.getSource() == this.newBuscaCidade.getjButtonSair()){
            newBuscaCidade.dispose();
    }
  }
}
            

