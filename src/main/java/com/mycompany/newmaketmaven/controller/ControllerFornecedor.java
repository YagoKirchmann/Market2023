/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newmaketmaven.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import com.mycompany.newmaketmaven.model.Fornecedor;
import com.mycompany.newmaketmaven.utillities.Utils;
import com.mycompany.newmaketmaven.view.NewBuscaFornecedor;
import com.mycompany.newmaketmaven.view.NewViewFornecedor;

/**
 *
 * @author rafael.silva
 */
public class ControllerFornecedor implements ActionListener{
    NewViewFornecedor telaCadFornecedor;
    
    public ControllerFornecedor (NewViewFornecedor parTelaCadFornecedor){
        
        this.telaCadFornecedor = parTelaCadFornecedor;
        
            
            telaCadFornecedor.getjButtonBuscar().addActionListener(this);
            telaCadFornecedor.getjButtonCancelar().addActionListener(this);
            telaCadFornecedor.getjButtonGravar().addActionListener(this);
            telaCadFornecedor.getjButtonNovo().addActionListener(this);
            telaCadFornecedor.getjButtonSair().addActionListener(this);
    
            Utils.ativa(true, telaCadFornecedor.getjPanel2());
            Utils.ligaDesliga(false, telaCadFornecedor.getjPanel3());
            
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaCadFornecedor.getjButtonNovo()) {
            Utils.ativa(false, telaCadFornecedor.getjPanel2());
            Utils.ligaDesliga(true, telaCadFornecedor.getjPanel3());
            telaCadFornecedor.getjTextFieldLogradouro().setEnabled(false);
            telaCadFornecedor.getjTextFieldCidade().setEnabled(false);
            telaCadFornecedor.getjTextFieldBairro().setEnabled(false);        
            telaCadFornecedor.getjTextFieldNome().requestFocus();
            
        } else if (e.getSource() == telaCadFornecedor.getjButtonCancelar()) {
            Utils.ativa(true, telaCadFornecedor.getjPanel2());
            Utils.ligaDesliga(false, telaCadFornecedor.getjPanel3());
            
        } else if (e.getSource() == telaCadFornecedor.getjButtonBuscar()) {
            NewBuscaFornecedor telaBusca = new NewBuscaFornecedor();
            ControllerBuscaFornecedor controllerFornecedor = new ControllerBuscaFornecedor(telaBusca);
            telaBusca.setVisible(true);
        
        } else if (e.getSource() == telaCadFornecedor.getjButtonGravar()) {
            if (telaCadFornecedor.getjTextFieldNome().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo Nome é Obrigatório");
            }else if (telaCadFornecedor.getjTextFieldCNPJ().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo CNPJ é Obrigatório");
            }else if (telaCadFornecedor.getjTextFieldCPF().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo CPF é Obrigatório");
            }else if (telaCadFornecedor.getjTextFieldCep().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo CEP é Obrigatório");
            }else if (telaCadFornecedor.getjTextFieldCelular().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Celular é Obrigatório");
            } else {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setNome(telaCadFornecedor.getjTextFieldNome().getText());
            Utils.ativa(true, telaCadFornecedor.getjPanel2());
            Utils.ligaDesliga(false, telaCadFornecedor.getjPanel3());
            }
        } else if(e.getSource() == telaCadFornecedor.getjButtonSair()) {
            telaCadFornecedor.dispose();        
        }
    }
}
