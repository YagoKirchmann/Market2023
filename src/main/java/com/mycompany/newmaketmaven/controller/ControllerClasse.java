/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newmaketmaven.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import com.mycompany.newmaketmaven.model.Classe;
import com.mycompany.newmaketmaven.modelDAO.ClasseDAO;
import com.mycompany.newmaketmaven.view.NewBuscaClasse;
import com.mycompany.newmaketmaven.view.NewViewClasse;
import com.mycompany.newmaketmaven.services.ClasseService;
import com.mycompany.newmaketmaven.utillities.Utils;

/**
 *
 * @author rafael.silva
 */
public class ControllerClasse implements ActionListener{
    NewViewClasse telaCadClasse;
    public static int codigo;
    
    public ControllerClasse (NewViewClasse parTelaCadClasse){
        
        this.telaCadClasse = parTelaCadClasse;
        
            
            telaCadClasse.getjButtonBuscar().addActionListener(this);
            telaCadClasse.getjButtonCancelar().addActionListener(this);
            telaCadClasse.getjButtonGravar().addActionListener(this);
            telaCadClasse.getjButtonNovo().addActionListener(this);
            telaCadClasse.getjButtonSair().addActionListener(this);
    
            Utils.ativa(true, telaCadClasse.getjPanel2());
            Utils.ligaDesliga(false, telaCadClasse.getjPanel3()); 
            
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaCadClasse.getjButtonNovo()) {
            Utils.ativa(false, telaCadClasse.getjPanel2());
            Utils.ligaDesliga(true, telaCadClasse.getjPanel3());;
            telaCadClasse.getTxtId().setEnabled(false);
            telaCadClasse.getTxtDescricao().requestFocus();
            
        } else if (e.getSource() == telaCadClasse.getjButtonCancelar()) {
            Utils.ativa(true, telaCadClasse.getjPanel2());
            Utils.ligaDesliga(false, telaCadClasse.getjPanel3());
            
        }else if (e.getSource() == telaCadClasse.getjButtonBuscar()) {
            this.codigo = 0;
            
            NewBuscaClasse telaBusca = new NewBuscaClasse(null, true);
            ControllerBuscaClasse controllerClasse = new ControllerBuscaClasse(telaBusca);
            telaBusca.setVisible(true);
            
            if(this.codigo != 0){
                Classe classe = new Classe();
                ClasseService classeService = new ClasseService();
                classe = classeService.buscar(codigo);
                
                    Utils.ativa(false, telaCadClasse.getjPanel2());
            Utils.ligaDesliga(true, telaCadClasse.getjPanel3());
                
                telaCadClasse.getTxtId().setText(classe.getId()+ "");
                telaCadClasse.getTxtDescricao().setText(classe.getDescricao());
                telaCadClasse.getTxtId().setEnabled(false);
            }

        }else if (e.getSource() == telaCadClasse.getjButtonGravar()) {
            if (telaCadClasse.getTxtDescricao().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo Descrição é Obrigatório");
            } else {
                Classe classe = new Classe();
                classe.setDescricao(telaCadClasse.getTxtDescricao().getText());
                
                ClasseService classeService = new ClasseService();
                classeService.criar(classe);
                
            Utils.ativa(true, telaCadClasse.getjPanel2());
            Utils.ligaDesliga(false, telaCadClasse.getjPanel3());
            }
        } else if(e.getSource() == telaCadClasse.getjButtonSair()) {
            telaCadClasse.dispose();        
        }
    }
}
