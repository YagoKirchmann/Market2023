
package com.mycompany.newmaketmaven.controller;

import com.mycompany.newmaketmaven.model.Colaborador;
import com.mycompany.newmaketmaven.services.ColaboradorService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mycompany.newmaketmaven.view.NewBuscaColaborador;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author aluno
 */
public class ControllerBuscaColaborador implements ActionListener{
       
    NewBuscaColaborador newBuscaColaborador;
    
    public ControllerBuscaColaborador(NewBuscaColaborador newBuscaColaborador){
        
        this.newBuscaColaborador = newBuscaColaborador;
        this.newBuscaColaborador.getjButtonCarregar().addActionListener(this);
        this.newBuscaColaborador.getjButtonSair().addActionListener(this);
        
        DefaultTableModel tabela = (DefaultTableModel) this.newBuscaColaborador.getjTableDadosAchados().getModel();
       
        for (Colaborador objetoAtualDaLista : ColaboradorService.buscar()) {
            
            tabela.addRow(new Object[]{objetoAtualDaLista.getId(),          
                                       objetoAtualDaLista.getDtCadastro(),
                                       objetoAtualDaLista.getStatus()});                                       
        }
    }
    
    
    public void actioPerfomed(ActionEvent acao){
        
    }

    @Override
    public void actionPerformed(ActionEvent acao) {
        if(acao.getSource() == this.newBuscaColaborador.getjButtonCarregar()){
            
        }else if(acao.getSource() == this.newBuscaColaborador.getjButtonSair()){
            newBuscaColaborador.dispose();
        }
    }
            
    
}
