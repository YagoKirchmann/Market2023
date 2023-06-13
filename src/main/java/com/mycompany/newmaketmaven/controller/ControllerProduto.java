/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newmaketmaven.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import com.mycompany.newmaketmaven.model.Produto;
import com.mycompany.newmaketmaven.view.NewBuscaProduto;
import com.mycompany.newmaketmaven.view.NewViewProduto;

/**
 *
 * @author rafael.silva
 */
public class ControllerProduto implements ActionListener{
    NewViewProduto telaCadProduto;
    
    public ControllerProduto (NewViewProduto parTelaCadProduto){
        
        this.telaCadProduto = parTelaCadProduto;
        
            
            telaCadProduto.getjButtonBuscar().addActionListener(this);
            telaCadProduto.getjButtonCancelar().addActionListener(this);
            telaCadProduto.getjButtonGravar().addActionListener(this);
            telaCadProduto.getjButtonNovo().addActionListener(this);
            telaCadProduto.getjButtonSair().addActionListener(this);
    
            telaCadProduto.ativa(true);
            telaCadProduto.ligaDesliga(false);
            
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaCadProduto.getjButtonNovo()) {
            telaCadProduto.ativa(false);
            telaCadProduto.ligaDesliga(true);
            telaCadProduto.getjTextFieldDescricao().requestFocus();
            
        } else if (e.getSource() == telaCadProduto.getjButtonCancelar()) {
            telaCadProduto.ativa(true);
            telaCadProduto.ligaDesliga(false);
            
        } else if (e.getSource() == telaCadProduto.getjButtonBuscar()) {
            
            NewBuscaProduto telaBusca = new NewBuscaProduto();
            ControllerBuscaProduto controllerProduto = new ControllerBuscaProduto(telaBusca);
            telaBusca.setVisible(true);
        
        } else if (e.getSource() == telaCadProduto.getjButtonGravar()) {
            if (telaCadProduto.getjTextFieldDescricao().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo Descricao é Obrigatório");
            }else if (telaCadProduto.getjTextFieldCodBarras().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Código de Barras é Obrigatório");
            }else if (telaCadProduto.getjTextFieldCodBarrasSaida().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Código de Barras Saída é Obrigatório");
            }else if (telaCadProduto.getjTextFieldVlrVenda().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Valor De Venda é Obrigatório");
            }else if (telaCadProduto.getjTextFieldVlrCompra().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Valor De Compra é Obrigatório");
            }else if (telaCadProduto.getjTextFieldUnidCompr().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Unidade de Compra é Obrigatório");
            }else if (telaCadProduto.getjTextFieldUnidVenda().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Unidade de Venda é Obrigatório");
            } else if (telaCadProduto.getjTextFieldEstoqMin().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Estoque Minímo é Obrigatório");
            }else if (telaCadProduto.getjTextFieldEstoqMax().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Estoque Máximo é Obrigatório");
            }else if (telaCadProduto.getjTextFieldFatConver().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Fator Conversão é Obrigatório");
            }else if (telaCadProduto.getjTextFieldDataCad().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Data de Cadastro é Obrigatório");
            }else {
                Produto produto = new Produto();
                produto.setDescricao(telaCadProduto.getjTextFieldDescricao().getText());
                telaCadProduto.ativa(true);
                telaCadProduto.ligaDesliga(false);
            }
        } else if(e.getSource() == telaCadProduto.getjButtonSair()) {
            telaCadProduto.dispose();        
        }
    }
}