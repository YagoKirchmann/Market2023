/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newmaketmaven.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import com.mycompany.newmaketmaven.model.CondicaoPgto;
import com.mycompany.newmaketmaven.view.NewBuscaCondPgto;
import com.mycompany.newmaketmaven.view.NewViewCondPgto;

/**
 *
 * @author rafael.silva
 */
public class ControllerCondPgto implements ActionListener{
    NewViewCondPgto telaCadCondPgto;
    
    public ControllerCondPgto (NewViewCondPgto parTelaCadCondPgto){
        
        this.telaCadCondPgto = parTelaCadCondPgto;
        
            
            telaCadCondPgto.getjButtonBuscar().addActionListener(this);
            telaCadCondPgto.getjButtonCancelar().addActionListener(this);
            telaCadCondPgto.getjButtonGravar().addActionListener(this);
            telaCadCondPgto.getjButtonNovo().addActionListener(this);
            telaCadCondPgto.getjButtonSair().addActionListener(this);
    
            telaCadCondPgto.ativa(true);
            telaCadCondPgto.ligaDesliga(false);
            
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaCadCondPgto.getjButtonNovo()) {
            telaCadCondPgto.ativa(false);
            telaCadCondPgto.ligaDesliga(true);
            telaCadCondPgto.getjTextFieldDescricao().requestFocus();
            
        } else if (e.getSource() == telaCadCondPgto.getjButtonCancelar()) {
            telaCadCondPgto.ativa(true);
            telaCadCondPgto.ligaDesliga(false);
            
        } else if (e.getSource() == telaCadCondPgto.getjButtonBuscar()) {
            NewBuscaCondPgto telaBusca = new NewBuscaCondPgto();
            ControllerBuscaCondPgto controllerCondPgto = new ControllerBuscaCondPgto(telaBusca);
            telaBusca.setVisible(true);
        
        } else if (e.getSource() == telaCadCondPgto.getjButtonGravar()) {
            if (telaCadCondPgto.getjTextFieldDescricao().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo Descricao é Obrigatório");
            } else if (telaCadCondPgto.getjTextFieldNumParc().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Número De Parcelas é Obrigatório");
            }else if (telaCadCondPgto.getjTextField1DiasPrimParc().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Dias P/Primeira Parcela é Obrigatório");
            }else {
                CondicaoPgto condicaoPgto = new CondicaoPgto();
                condicaoPgto.setDescricaoCondicao(telaCadCondPgto.getjTextFieldDescricao().getText());
                telaCadCondPgto.ativa(true);
                telaCadCondPgto.ligaDesliga(false);
            }
        } else if(e.getSource() == telaCadCondPgto.getjButtonSair()) {
            telaCadCondPgto.dispose();        
        }
    }
}
