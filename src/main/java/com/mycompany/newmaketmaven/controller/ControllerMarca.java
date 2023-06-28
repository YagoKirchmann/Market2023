/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newmaketmaven.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import com.mycompany.newmaketmaven.model.Marca;
import com.mycompany.newmaketmaven.services.MarcaService;
import com.mycompany.newmaketmaven.utillities.Utils;
import com.mycompany.newmaketmaven.view.NewBuscaMarca;
import com.mycompany.newmaketmaven.view.NewViewMarca;

/**
 *
 * @author rafael.silva
 */
public class ControllerMarca implements ActionListener{
    NewViewMarca telaCadMarca;
    public static int codigo;
    
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
            this.codigo = 0;
            
            NewBuscaMarca telaBusca = new NewBuscaMarca(null, true);
            ControllerBuscaMarca controllerMarca = new ControllerBuscaMarca(telaBusca);
            telaBusca.setVisible(true);
            
            if(this.codigo != 0){
                Marca marca = new Marca();
                MarcaService marcaService = new MarcaService();
                marca = MarcaService.buscar(codigo);
                
                Utils.ativa(false, telaCadMarca.getjPanel2());
                Utils.ligaDesliga(true,telaCadMarca.getjPanel3());
                
                telaCadMarca.getTxtId().setText(marca.getId()+ "");
                telaCadMarca.getjTextFieldDescricao().setText(marca.getDescricao());
                telaCadMarca.getTxtId().setEnabled(false);
            }
        
        } else if (e.getSource() == telaCadMarca.getjButtonGravar()) {
            if (telaCadMarca.getjTextFieldDescricao().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo Descricao é Obrigatório");
            } else {
                
                Marca marca = new Marca();
                marca.setDescricao(telaCadMarca.getjTextFieldDescricao().getText());
                MarcaService marcaService = new MarcaService();
                
                 if(this.telaCadMarca.getTxtId().getText().equalsIgnoreCase("")){
                    MarcaService.criar(marca);
                }else{
                    marca.setId(Integer.parseInt(telaCadMarca.getTxtId().getText()));
                    marcaService.atualizar(marca);
                }
  
                Utils.ativa(true, telaCadMarca.getjPanel2());
                Utils.ligaDesliga(false, telaCadMarca.getjPanel3());
                
            }
        } else if(e.getSource() == telaCadMarca.getjButtonSair()) {
            telaCadMarca.dispose();        
        }
    }
}
