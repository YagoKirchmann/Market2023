/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Clientess/Class.java to edit this template
 */
package com.mycompany.newmaketmaven.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import com.mycompany.newmaketmaven.model.Cliente;
import com.mycompany.newmaketmaven.model.Endereco;
import com.mycompany.newmaketmaven.view.NewBuscaCliente;
import com.mycompany.newmaketmaven.view.NewViewClientes;
import com.mycompany.newmaketmaven.view.NewBuscaEndereco;
import com.mycompany.newmaketmaven.services.ClienteService;
import com.mycompany.newmaketmaven.services.EnderecoService;


public class ControllerClientes implements ActionListener{
    NewViewClientes telaCadClientes;
    public static int codigo;
    public static int codigoEnd;
      
    public ControllerClientes (NewViewClientes parTelaCadClientes){
        
        this.telaCadClientes = parTelaCadClientes;
        
            
            telaCadClientes.getjButtonBuscar().addActionListener(this);
            telaCadClientes.getjButtonCancelar().addActionListener(this);
            telaCadClientes.getjButtonGravar().addActionListener(this);
            telaCadClientes.getjButtonNovo().addActionListener(this);
            telaCadClientes.getjButtonSair().addActionListener(this);
            telaCadClientes.getjButtonPesquisaCida().addActionListener(this);
    
            telaCadClientes.ativa(true);
            telaCadClientes.ligaDesliga(false);
            
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaCadClientes.getjButtonNovo()) {
            telaCadClientes.ativa(false);
            telaCadClientes.ligaDesliga(true);
            telaCadClientes.getjTextFieldLogradouro().setEnabled(false);
            telaCadClientes.getjTextFieldCidade().setEnabled(false);
            telaCadClientes.getjTextFieldBairro().setEnabled(false);  
            telaCadClientes.getjTextFieldCpf().requestFocus();
            
        } else if (e.getSource() == telaCadClientes.getjButtonPesquisaCida()) {
            NewBuscaEndereco telaBuscaEndereco = new NewBuscaEndereco(telaCadClientes, true);
            ControllerBuscaEndereco controllerEndereco = new ControllerBuscaEndereco(telaBuscaEndereco);
            telaBuscaEndereco.setVisible(true);
            
            if(this.codigoEnd != 0){
                Endereco endereco = new Endereco();
                EnderecoService enderecoService = new EnderecoService();
                endereco = EnderecoService.buscar(codigoEnd);
                  
                telaCadClientes.getjTextFieldCidade().setText(endereco.getCidade().getDescricao()+ "");
                telaCadClientes.getjTextFieldBairro().setText(endereco.getBairro().getDescricao()+ "");
                telaCadClientes.getjTextFieldLogradouro().setText(endereco.getLogradouro()+ "");
                telaCadClientes.getjTextFieldCep().setText(endereco.getCep()+ "");
            } 
            
            
        } else if (e.getSource() == telaCadClientes.getjButtonCancelar()) {
            telaCadClientes.ativa(true);
            telaCadClientes.ligaDesliga(false);
            
        } else if (e.getSource() == telaCadClientes.getjButtonBuscar()) {
            this.codigo = 0;
            
            NewBuscaCliente telaBusca = new NewBuscaCliente(null, true);
            ControllerBuscaClientes controllerCliente = new ControllerBuscaClientes(telaBusca);
            telaBusca.setVisible(true);
            
            if(this.codigo != 0){
                Cliente cliente = new Cliente();
                ClienteService clienteService = new ClienteService();
                cliente = clienteService.buscar(codigo);
                
                telaCadClientes.ativa(false);
                telaCadClientes.ligaDesliga(true);
                
                telaCadClientes.getjTextFieldCpf().setText(cliente.getCpf()+ "");
                telaCadClientes.getjTextFieldRg().setText(cliente.getRg()+ "");
                telaCadClientes.getjTextFieldNome().setText(cliente.getNome());
                telaCadClientes.getjTextFieldDataCad().setText(cliente.getDtCadastro()+"");
                telaCadClientes.getjTextFieldEmail().setText(cliente.getEmail()+ "");
                telaCadClientes.getjTextFieldCelular().setText(cliente.getFone1()+"");
                telaCadClientes.getjTextFieldTelefone().setText(cliente.getFone2()+"");
                telaCadClientes.getjTextFieldCompleEnd().setText(cliente.getComplementoEndereco()+ "");
                telaCadClientes.getjTextFieldDataNasc().setText(cliente.getDtNascimento()+"");
                telaCadClientes.getjTextFieldObs().setText(cliente.getObservacao());
                telaCadClientes.getjTextFieldCpf().setEnabled(false);
            }

        }else if (e.getSource() == telaCadClientes.getjButtonGravar()) {
            if (telaCadClientes.getjTextFieldCpf().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo CPF é Obrigatório");
            }else if (telaCadClientes.getjTextFieldNome().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Nome é Obrigatório");
            }else if (telaCadClientes.getjTextFieldCep().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Cep é Obrigatório");
            }else if (telaCadClientes.getjTextFieldEmail().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Email é Obrigatório");
            }else if (telaCadClientes.getjTextFieldCelular().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Celular é Obrigatório");
            }else {
                Cliente cliente = new Cliente();
                cliente.setCpf(telaCadClientes.getjTextFieldCpf().getText());
                telaCadClientes.ativa(true);
                telaCadClientes.ligaDesliga(false);
            }
        } else if(e.getSource() == telaCadClientes.getjButtonSair()) {
            telaCadClientes.dispose();        
        }
    }
}
