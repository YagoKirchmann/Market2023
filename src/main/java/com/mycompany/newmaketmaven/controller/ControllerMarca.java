/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newmaketmaven.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import com.mycompany.newmaketmaven.model.Marca;
import com.mycompany.newmaketmaven.utillities.Utils;
import com.mycompany.newmaketmaven.view.NewBuscaMarca;
import com.mycompany.newmaketmaven.view.NewViewMarca;

/**
 *
 * @author rafael.silva
 */
public class ControllerMarca implements ActionListener{
    NewViewMarca telaCadMarca;
    
    public ControllerMarca (NewViewMarca parTelaCadMarca){
        
        this.telaCadMarca = parTelaCadMarca;
        
            
            telaCadMarca.getjButtonBuscar().addActionListener(this);
            telaCadMarca.getjButtonCancelar().addActionListener(this);
            telaCadMarca.getjButtonGravar().addActionListener(this);
            telaCadMarca.getjButtonNovo().addActionListener(this);
            telaCadMarca.getjButtonSair().addActionListener(this);
    
            Utils.ativa(true, telaCadMarca.getjPanel2());
            Utils.ligaDesliga(false, telaCadMarca.getjPanel3());
            
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaCadMarca.getjButtonNovo()) {
            Utils.ativa(false, telaCadMarca.getjPanel2());
            Utils.ligaDesliga(true, telaCadMarca.getjPanel3());
            telaCadMarca.getTxtId().setEnabled(false);
            telaCadMarca.getjTextFieldDescricao().requestFocus();
            
        } else if (e.getSource() == telaCadMarca.getjButtonCancelar()) {
            Utils.ativa(true, telaCadMarca.getjPanel2());
            Utils.ligaDesliga(false, telaCadMarca.getjPanel3());
            
        } else if (e.getSource() == telaCadMarca.getjButtonBuscar()) {
            NewBuscaMarca telaBusca = new NewBuscaMarca(null,true);
            ControllerBuscaMarca controllerMarca = new ControllerBuscaMarca(telaBusca);
            telaBusca.setVisible(true);
        
        } else if (e.getSource() == telaCadMarca.getjButtonGravar()) {
            if (telaCadMarca.getjTextFieldDescricao().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo Descricao é Obrigatório");
            } else {
                Marca marca = new Marca();
                marca.setDescricao(telaCadMarca.getjTextFieldDescricao().getText());
            Utils.ativa(true, telaCadMarca.getjPanel2());
            Utils.ligaDesliga(false, telaCadMarca.getjPanel3());
            }
        } else if(e.getSource() == telaCadMarca.getjButtonSair()) {
            telaCadMarca.dispose();        
        }
    }
}
