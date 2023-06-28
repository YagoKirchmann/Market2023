
package com.mycompany.newmaketmaven.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import com.mycompany.newmaketmaven.model.Marca;
import com.mycompany.newmaketmaven.modelDAO.MarcaDAO;
import com.mycompany.newmaketmaven.services.MarcaService;
import com.mycompany.newmaketmaven.view.NewBuscaMarca;

/**
 *
 * @author aluno
 */
public class ControllerBuscaMarca implements ActionListener{
       
    NewBuscaMarca newBuscaMarca;
    
    public ControllerBuscaMarca(NewBuscaMarca newBuscaMarca){
        this.newBuscaMarca = newBuscaMarca;
        this.newBuscaMarca.getjButtonCarregar().addActionListener(this);
        this.newBuscaMarca.getjButtonSair().addActionListener(this);
        
        DefaultTableModel tabela = (DefaultTableModel) this.newBuscaMarca.getjTableDadosAchados().getModel();  
        
        
        for (Marca objetoAtualDaLista : MarcaService.buscar()) {
            tabela.addRow(new Object[]{objetoAtualDaLista.getId(),
                                       objetoAtualDaLista.getDescricao()});                                       
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent acao) {
        if(acao.getSource() == this.newBuscaMarca.getjButtonCarregar()){
            if(this.newBuscaMarca.getjTableDadosAchados().getValueAt(this.newBuscaMarca.getjTableDadosAchados().getSelectedRow(), 0 ) != null){
         
                ControllerMarca.codigo = (int) this.newBuscaMarca.getjTableDadosAchados().getValueAt(this.newBuscaMarca.getjTableDadosAchados().getSelectedRow(), 0);
                
                newBuscaMarca.dispose();
            }
            
        }else if(acao.getSource() == this.newBuscaMarca.getjButtonSair()){
            newBuscaMarca.dispose();
        }
    }
            
    
}
