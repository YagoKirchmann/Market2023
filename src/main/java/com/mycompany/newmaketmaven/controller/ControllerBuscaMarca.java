
package com.mycompany.newmaketmaven.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    }
    
    
    public void actioPerfomed(ActionEvent acao){
        
    }

    @Override
    public void actionPerformed(ActionEvent acao) {
        if(acao.getSource() == this.newBuscaMarca.getjButtonCarregar()){
            
        }else if(acao.getSource() == this.newBuscaMarca.getjButtonSair()){
            newBuscaMarca.dispose();
        }
    }
            
    
}
