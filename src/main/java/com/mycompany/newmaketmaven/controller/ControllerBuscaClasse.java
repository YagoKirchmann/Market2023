
package com.mycompany.newmaketmaven.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import com.mycompany.newmaketmaven.model.Classe;
import com.mycompany.newmaketmaven.modelDAO.ClasseDAO;
import com.mycompany.newmaketmaven.services.ClasseService;
import com.mycompany.newmaketmaven.view.NewBuscaClasse;

/**
 *
 * @author aluno
 */
public class ControllerBuscaClasse implements ActionListener{
       
    NewBuscaClasse newBuscaClasse;
    
    public ControllerBuscaClasse(NewBuscaClasse newBuscaClasse){
        this.newBuscaClasse = newBuscaClasse;
        
        this.newBuscaClasse.getjButtonCarregar().addActionListener(this);
        this.newBuscaClasse.getjButtonSair().addActionListener(this);
        DefaultTableModel tabela = (DefaultTableModel) this.newBuscaClasse.getjTableDadosAchados().getModel();  
        
        for (Classe objetoAtualDaLista : ClasseService.buscar()) {
            
            tabela.addRow(new Object[]{objetoAtualDaLista.getId(),
                                       objetoAtualDaLista.getDescricao()});                                       
        }
    }
    
    
    public void actioPerfomed(ActionEvent acao){
        
    }

    @Override
    public void actionPerformed(ActionEvent acao) {
         if(this.newBuscaClasse.getjTableDadosAchados().getValueAt(this.newBuscaClasse.getjTableDadosAchados().getSelectedRow(), 0 ) != null){
         
                ControllerClasse.codigo = (int) this.newBuscaClasse.getjTableDadosAchados().getValueAt(this.newBuscaClasse.getjTableDadosAchados().getSelectedRow(), 0);
                
                newBuscaClasse.dispose();
            }else if(acao.getSource() == this.newBuscaClasse.getjButtonSair()){
            newBuscaClasse.dispose();
        }
    }
            
    
}
