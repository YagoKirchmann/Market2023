/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newmaketmaven.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import com.mycompany.newmaketmaven.model.Cidade;
import com.mycompany.newmaketmaven.modelDAO.CidadeDAO;
import com.mycompany.newmaketmaven.view.NewBuscaCidade;
import com.mycompany.newmaketmaven.view.NewViewCidade;
import com.mycompany.newmaketmaven.services.CidadeService;
import com.mycompany.newmaketmaven.utillities.Utils;


/**
 *
 * @author rafael.silva | Yago.kirchamnn
 */
public class ControllerCidade implements ActionListener{
    
    NewViewCidade telaCadCidade;
    public static int codigo;
    
    public ControllerCidade (NewViewCidade parTelaCadCidade){
        
        this.telaCadCidade = parTelaCadCidade;
        
            
            telaCadCidade.getjButtonBuscar().addActionListener(this);
            telaCadCidade.getjButtonCancelar().addActionListener(this);
            telaCadCidade.getjButtonGravar().addActionListener(this);
            telaCadCidade.getjButtonNovo().addActionListener(this);
            telaCadCidade.getjButtonSair().addActionListener(this);
    
            Utils.ativa(true, telaCadCidade.getjPanel2());
            Utils.ligaDesliga(false,telaCadCidade.getjPanel3());
            
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaCadCidade.getjButtonNovo()) {
            telaCadCidade.ativa(false);
            telaCadCidade.ligaDesliga(true);
            telaCadCidade.getTxtId().setEnabled(false);
            telaCadCidade.getTxtDescricao().requestFocus();
            
        } else if (e.getSource() == telaCadCidade.getjButtonCancelar()) {
            telaCadCidade.ativa(true);
            telaCadCidade.ligaDesliga(false);
            
        } else if (e.getSource() == telaCadCidade.getjButtonBuscar()) {
            this.codigo = 0;
            
            NewBuscaCidade telaBusca = new NewBuscaCidade(null, true);
            ControllerBuscaCidade controllerCidade = new ControllerBuscaCidade(telaBusca);
            telaBusca.setVisible(true);
            
            if(this.codigo != 0){
                Cidade cidade = new Cidade();
                CidadeService cidadeService = new CidadeService();
                cidade = cidadeService.buscar(codigo);
                
                Utils.ativa(false, telaCadCidade.getjPanel2());
                Utils.ligaDesliga(true,telaCadCidade.getjPanel3());
                
                telaCadCidade.getTxtId().setText(cidade.getId()+ "");
                telaCadCidade.getTxtDescricao().setText(cidade.getDescricao());
                telaCadCidade.getTxtId().setEnabled(false);
            }

        }else if (e.getSource() == telaCadCidade.getjButtonGravar()) {
            if (telaCadCidade.getTxtDescricao().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo Descrição é Obrigatório");
            } else {
                Cidade cidade = new Cidade();
                cidade.setDescricao(telaCadCidade.getTxtDescricao().getText());
                CidadeService cidadeService = new CidadeService();
                
               if(this.telaCadCidade.getTxtId().getText().equalsIgnoreCase("")){
                    cidadeService.criar(cidade);
                }else{
                    cidade.setId(Integer.parseInt(telaCadCidade.getTxtId().getText()));
                    cidadeService.atualizar(cidade);
                }
                Utils.ativa(true, telaCadCidade.getjPanel2());
                Utils.ligaDesliga(false,telaCadCidade.getjPanel3());
            }
                      
        } else if(e.getSource() == telaCadCidade.getjButtonSair()) {
            telaCadCidade.dispose();        
        }
    }
    }
    

