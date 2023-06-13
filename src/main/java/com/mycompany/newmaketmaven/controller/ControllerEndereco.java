/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newmaketmaven.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import com.mycompany.newmaketmaven.model.Bairro;
import com.mycompany.newmaketmaven.model.Endereco;
import com.mycompany.newmaketmaven.model.Cidade;
import com.mycompany.newmaketmaven.model.Endereco;
import com.mycompany.newmaketmaven.modelDAO.BairroDAO;
import com.mycompany.newmaketmaven.modelDAO.CidadeDAO;
import com.mycompany.newmaketmaven.view.NewBuscaEndereco;
import com.mycompany.newmaketmaven.view.NewViewEndereco;
import com.mycompany.newmaketmaven.modelDAO.EnderecoDAO;
import com.mycompany.newmaketmaven.view.NewBuscaBairro;
import com.mycompany.newmaketmaven.view.NewBuscaCidade;

/**
 *
 * @author rafael.silva
 */
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
              
    
            telaCadEndereco.ativa(true);
            telaCadEndereco.ligaDesliga(false);
            
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaCadEndereco.getjButtonNovo()) {
            telaCadEndereco.ativa(false);
            telaCadEndereco.ligaDesliga(true);
            telaCadEndereco.getjTextFieldCep().requestFocus();
           
        }else if(e.getSource() == telaCadEndereco.getjButtonBuscaCida()){
            this.codigoCid = 0;
            NewBuscaCidade telaBuscaCidade = new NewBuscaCidade(telaCadEndereco, true);
            ControllerBuscaCidade controllerCidade = new ControllerBuscaCidade(telaBuscaCidade);
            telaBuscaCidade.setVisible(true);
                
            if(this.codigoCid != 0){
                Cidade cidade = new Cidade();
                CidadeDAO cidadeDAO = new CidadeDAO();
                cidade = cidadeDAO.retrieve(codigoCid);
                  
                telaCadEndereco.getjTextFieldCidade().setText(cidade.getDescricao()+ "");
            }          
        }else if(e.getSource() == telaCadEndereco.getjButtonBuscaBair()){
            this.codigoBair = 0;
            NewBuscaBairro telaBuscaBairro = new NewBuscaBairro(telaCadEndereco, true);
            ControllerBuscaBairro controllerBairro = new ControllerBuscaBairro(telaBuscaBairro);
            telaBuscaBairro.setVisible(true);
                
            if(this.codigoBair != 0){
                Bairro bairro = new Bairro();
                BairroDAO bairroDAO = new BairroDAO();
                bairro = bairroDAO.retrieve(codigoBair);
                  
                telaCadEndereco.getjTextFieldBairro().setText(bairro.getDescricao()+ "");
            }          
        }else if (e.getSource() == telaCadEndereco.getjButtonCancelar()) {
            
            this.codigo = 0;
            telaCadEndereco.ativa(true);
            telaCadEndereco.ligaDesliga(false);
            
        }else if (e.getSource() == telaCadEndereco.getjButtonBuscar()) {
            
            this.codigo = 0;
            
            NewBuscaEndereco telaBusca = new NewBuscaEndereco(null,true);
            ControllerBuscaEndereco controllerEndereco = new ControllerBuscaEndereco(telaBusca);
            telaBusca.setVisible(true);
            
            if(this.codigo != 0){
                Endereco endereco = new Endereco();
                EnderecoDAO enderecoDAO = new EnderecoDAO();
                endereco = enderecoDAO.retrieve(codigo);
                
                telaCadEndereco.ativa(false);
                telaCadEndereco.ligaDesliga(true);
              
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
                Cidade cidade = (new CidadeDAO()).retrieve(telaCadEndereco.getjTextFieldCidade().getText()); // sttar valores
                Bairro bairro = (new BairroDAO()).retrieve(telaCadEndereco.getjTextFieldBairro().getText()); // sttar valores
                
                
                
                
                endereco.setCidade(cidade);
                endereco.setBairro(bairro);
                endereco.setLogradouro(telaCadEndereco.getjTextFieldLogradouro().getText());
                endereco.setCep(telaCadEndereco.getjTextFieldCep().getText());
                
                EnderecoDAO enderecoDAO = new EnderecoDAO();
                
                if(codigo != 0){
                    endereco.setId(codigo);
                    enderecoDAO.update(endereco);
                    
                }else{
                    enderecoDAO.create(endereco);
                };
                telaCadEndereco.ativa(true);
                telaCadEndereco.ligaDesliga(false);
            }
        } else if(e.getSource() == telaCadEndereco.getjButtonSair()) {
            telaCadEndereco.dispose();        
        }
    }
}

