/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newmaketmaven.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import com.mycompany.newmaketmaven.model.Bairro;
import com.mycompany.newmaketmaven.model.Cidade;
import com.mycompany.newmaketmaven.model.Endereco;
import com.mycompany.newmaketmaven.view.NewBuscaEndereco;
import com.mycompany.newmaketmaven.view.NewViewEndereco;
import com.mycompany.newmaketmaven.services.BairroService;
import com.mycompany.newmaketmaven.services.CidadeService;
import com.mycompany.newmaketmaven.services.EnderecoService;
import com.mycompany.newmaketmaven.utillities.Utils;
import com.mycompany.newmaketmaven.view.NewBuscaBairro;
import com.mycompany.newmaketmaven.view.NewBuscaCidade;


public class ControllerEndereco implements ActionListener{
    NewViewEndereco telaCadEndereco;
    public static int codigo;
    public static int codigoCid;
    public static int codigoBair;
    

    public ControllerEndereco (NewViewEndereco parTelaCadEndereco){
        
        this.telaCadEndereco = parTelaCadEndereco;
        
            
            telaCadEndereco.getjButtonBuscar().addActionListener(this);
            telaCadEndereco.getjButtonCancelar().addActionListener(this);
            telaCadEndereco.getjButtonGravar().addActionListener(this);
            telaCadEndereco.getjButtonNovo().addActionListener(this);
            telaCadEndereco.getjButtonSair().addActionListener(this);
            telaCadEndereco.getjButtonBuscaCida().addActionListener(this);
            telaCadEndereco.getjButtonBuscaBair().addActionListener(this);
    
            Utils.ativa(true, telaCadEndereco.getjPanel2());
            Utils.ligaDesliga(false, telaCadEndereco.getjPanel3());  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaCadEndereco.getjButtonNovo()) {
            Utils.ativa(false, telaCadEndereco.getjPanel2());
            Utils.ligaDesliga(true, telaCadEndereco.getjPanel3()); 
            telaCadEndereco.getjTextFieldCep().requestFocus();
           
        }else if(e.getSource() == telaCadEndereco.getjButtonBuscaCida()){
            this.codigoCid = 0;
            NewBuscaCidade telaBuscaCidade = new NewBuscaCidade(telaCadEndereco, true);
            ControllerBuscaCidade controllerCidade = new ControllerBuscaCidade(telaBuscaCidade);
            telaBuscaCidade.setVisible(true);
                
            if(this.codigoCid != 0){
                Cidade cidade = new Cidade();
                CidadeService cidadeService = new CidadeService();
                cidade = cidadeService.buscar(codigoCid);
                  
                telaCadEndereco.getjTextFieldCidade().setText(cidade.getDescricao()+ "");
            }          
        }else if(e.getSource() == telaCadEndereco.getjButtonBuscaBair()){
            this.codigoBair = 0;
            NewBuscaBairro telaBuscaBairro = new NewBuscaBairro(telaCadEndereco, true);
            ControllerBuscaBairro controllerBairro = new ControllerBuscaBairro(telaBuscaBairro);
            telaBuscaBairro.setVisible(true);
                
            if(this.codigoBair != 0){
                Bairro bairro = new Bairro();
                BairroService bairroService = new BairroService();
                bairro = bairroService.buscar(codigoCid);
                  
                telaCadEndereco.getjTextFieldBairro().setText(bairro.getDescricao()+ "");
            }          
        }else if (e.getSource() == telaCadEndereco.getjButtonCancelar()) {
            
            this.codigo = 0;
            Utils.ativa(true, telaCadEndereco.getjPanel2());
            Utils.ligaDesliga(false, telaCadEndereco.getjPanel3()); 
            
        }else if (e.getSource() == telaCadEndereco.getjButtonBuscar()) {
            
            this.codigo = 0;
            
            NewBuscaEndereco telaBusca = new NewBuscaEndereco(null,true);
            ControllerBuscaEndereco controllerEndereco = new ControllerBuscaEndereco(telaBusca);
            telaBusca.setVisible(true);
            
            if(this.codigo != 0){
                Endereco endereco = new Endereco();
                EnderecoService enderecoService = new EnderecoService();
                endereco = enderecoService.buscar(codigoCid);
                
            Utils.ativa(false, telaCadEndereco.getjPanel2());
            Utils.ligaDesliga(true, telaCadEndereco.getjPanel3()); 
              
                telaCadEndereco.getjTextFieldCep().setText(endereco.getCep()+ "");
                telaCadEndereco.getjTextFieldCidade().setText(endereco.getCidade().getDescricao());
                telaCadEndereco.getjTextFieldBairro().setText(endereco.getBairro().getDescricao());
                telaCadEndereco.getjTextFieldLogradouro().setText(endereco.getLogradouro()+ "");
                telaCadEndereco.getjTextFieldCep().setEnabled(false);
 
            }
            
        
        } else if (e.getSource() == telaCadEndereco.getjButtonGravar()) {
            if (telaCadEndereco.getjTextFieldCidade().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo Cidade é Obrigatório");
            }else if(telaCadEndereco.getjTextFieldBairro().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Endereco é Obrigatório");
            }else if(telaCadEndereco.getjTextFieldLogradouro().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Logradouro é Obrigatório");
            }else if(telaCadEndereco.getjTextFieldCep().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Cep é Obrigatório");
            }else {
                
                Endereco endereco = new Endereco();
                Cidade cidade = (new CidadeService()).buscar(telaCadEndereco.getjTextFieldCidade().getText()); // sttar valores
                Bairro bairro = (new BairroService()).buscar(telaCadEndereco.getjTextFieldBairro().getText()); // sttar valores
                
                endereco.setCidade(cidade);
                endereco.setBairro(bairro);
                endereco.setLogradouro(telaCadEndereco.getjTextFieldLogradouro().getText());
                endereco.setCep(telaCadEndereco.getjTextFieldCep().getText());
                
                EnderecoService enderecoService = new EnderecoService();
                
                if(codigo != 0){
                    endereco.setId(codigo);
                    enderecoService.atualizar(endereco);
                    
                }else{
                    enderecoService.criar(endereco);
                };
            Utils.ativa(true, telaCadEndereco.getjPanel2());
            Utils.ligaDesliga(false, telaCadEndereco.getjPanel3()); 
            }
        } else if(e.getSource() == telaCadEndereco.getjButtonSair()) {
            telaCadEndereco.dispose();        
        }
    }
}

