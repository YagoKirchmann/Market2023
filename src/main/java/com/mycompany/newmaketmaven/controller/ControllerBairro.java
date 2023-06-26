/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newmaketmaven.controller;

import com.mycompany.newmaketmaven.model.Bairro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import com.mycompany.newmaketmaven.view.NewBuscaBairro;
import com.mycompany.newmaketmaven.view.NewViewBairro;
import com.mycompany.newmaketmaven.services.BairroService;
import com.mycompany.newmaketmaven.utillities.Utils;


/**
 *
 * @author rafael.silva
 */
public class ControllerBairro implements ActionListener{
    NewViewBairro telaCadBairro;
    public static int codigo;

    public ControllerBairro (NewViewBairro parTelaCadBairro){

        this.telaCadBairro = parTelaCadBairro;
        
            telaCadBairro.getjButtonBuscar().addActionListener(this);
            telaCadBairro.getjButtonCancelar().addActionListener(this);
            telaCadBairro.getjButtonGravar().addActionListener(this);
            telaCadBairro.getjButtonNovo().addActionListener(this);
            telaCadBairro.getjButtonSair().addActionListener(this);
            
        
            Utils.ativa(true, telaCadBairro.getjPanel2());
            Utils.ligaDesliga(false, telaCadBairro.getjPanel3());
            
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == telaCadBairro.getjButtonNovo()) {
            Utils.ativa(false, telaCadBairro.getjPanel2());
            Utils.ligaDesliga(true,telaCadBairro.getjPanel3());
            telaCadBairro.getTxtId().setEnabled(false);
            telaCadBairro.getTxtDescricao().requestFocus();
            
        } else if (e.getSource() == telaCadBairro.getjButtonCancelar()) {
            Utils.ativa(true,  telaCadBairro.getjPanel2());
            Utils.ligaDesliga(false,telaCadBairro.getjPanel3());
            
        } else if (e.getSource() == telaCadBairro.getjButtonBuscar()) {
            this.codigo = 0;
            
            NewBuscaBairro telaBusca = new NewBuscaBairro(null, true);
            ControllerBuscaBairro controllerBairro = new ControllerBuscaBairro(telaBusca);
            telaBusca.setVisible(true);
            
            if(this.codigo != 0){
                Bairro bairro = new Bairro();
                BairroService bairroService = new BairroService();
                bairro = BairroService.buscar(codigo);
                
                Utils.ativa(false, telaCadBairro.getjPanel2());
                Utils.ligaDesliga(true,telaCadBairro.getjPanel3());
                
                telaCadBairro.getTxtId().setText(bairro.getId()+ "");
                telaCadBairro.getTxtDescricao().setText(bairro.getDescricao());
                telaCadBairro.getTxtId().setEnabled(false);
            }

        } else if (e.getSource() == telaCadBairro.getjButtonGravar()) {
            if (telaCadBairro.getTxtDescricao().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo Descrição é Obrigatório");
            } else {
                Bairro bairro = new Bairro();
                bairro.setDescricao(telaCadBairro.getTxtDescricao().getText());
                
                BairroService bairroService = new BairroService(); 
                
                if(this.telaCadBairro.getTxtId().getText().equalsIgnoreCase("")){
                    BairroService.criar(bairro);
                }else{
                    bairro.setId(Integer.parseInt(telaCadBairro.getTxtId().getText()));
                    bairroService.atualizar(bairro);
                }
  
                Utils.ativa(true, telaCadBairro.getjPanel2());
                Utils.ligaDesliga(false,telaCadBairro.getjPanel3());
            }
        } else if(e.getSource() == telaCadBairro.getjButtonSair()) {
            telaCadBairro.dispose();        
        }
    }
}
