
package com.mycompany.newmaketmaven.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import static com.mycompany.newmaketmaven.controller.ControllerBairro.codigo;
import com.mycompany.newmaketmaven.model.Bairro;
import com.mycompany.newmaketmaven.modelDAO.BairroDAO;
import com.mycompany.newmaketmaven.services.BairroService;
import com.mycompany.newmaketmaven.view.NewBuscaBairro;

/**
 *
 * @author aluno
 */
public class ControllerBuscaBairro implements ActionListener{
       
    NewBuscaBairro newBuscaBairro;
    
    public ControllerBuscaBairro(NewBuscaBairro newBuscaBairro){
        this.newBuscaBairro = newBuscaBairro;
        this.newBuscaBairro.getjButtonCarregar().addActionListener(this);
        this.newBuscaBairro.getjButtonSair().addActionListener(this);
        
        DefaultTableModel tabela = (DefaultTableModel) this.newBuscaBairro.getjTableDadosAchados().getModel();  
        
        
        for (Bairro objetoAtualDaLista : BairroService.buscar()) {
            tabela.addRow(new Object[]{objetoAtualDaLista.getId(),
                                       objetoAtualDaLista.getDescricao()});                                       
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent acao) {
        if(acao.getSource() == this.newBuscaBairro.getjButtonCarregar()){
            if(this.newBuscaBairro.getjTableDadosAchados().getValueAt(this.newBuscaBairro.getjTableDadosAchados().getSelectedRow(), 0 ) != null){
         
                ControllerBairro.codigo = (int) this.newBuscaBairro.getjTableDadosAchados().getValueAt(this.newBuscaBairro.getjTableDadosAchados().getSelectedRow(), 0);
                ControllerEndereco.codigoBair = (int) this.newBuscaBairro.getjTableDadosAchados().getValueAt(this.newBuscaBairro.getjTableDadosAchados().getSelectedRow(), 0);
                newBuscaBairro.dispose();
            }
            
        }else if(acao.getSource() == this.newBuscaBairro.getjButtonSair()){
            newBuscaBairro.dispose();
        }
    }
            
    
}
