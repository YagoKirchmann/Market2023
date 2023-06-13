package com.mycompany.newmaketmaven.view;

import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.mycompany.newmaketmaven.controller.ControllerBairro;
import com.mycompany.newmaketmaven.controller.ControllerCidade;
import com.mycompany.newmaketmaven.controller.ControllerClientes;
import com.mycompany.newmaketmaven.controller.ControllerColaborador;
import com.mycompany.newmaketmaven.controller.ControllerCondPgto;
import com.mycompany.newmaketmaven.controller.ControllerEndereco;
import com.mycompany.newmaketmaven.controller.ControllerFornecedor;
import com.mycompany.newmaketmaven.controller.ControllerMarca;
import com.mycompany.newmaketmaven.controller.ControllerProduto;
import com.mycompany.newmaketmaven.controller.ControllerClasse;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author rafael.silva
 */
public class NewViewMenu extends javax.swing.JFrame {

    /**
     * Creates new form newMarket22View
     */
    public NewViewMenu () {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jLabel1 = new javax.swing.JLabel();
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastros = new javax.swing.JMenu();
        jRadioButtonMenuIBairro = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuCidade = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuEndereco = new javax.swing.JRadioButtonMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jRadioButtonMenuCliente = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuColaborador = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuFornecedor = new javax.swing.JRadioButtonMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jRadioButtonMenuProduto = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuMarca = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuClasse = new javax.swing.JRadioButtonMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jRadioButtonMenuSair = new javax.swing.JRadioButtonMenuItem();
        jMenuMovimentos = new javax.swing.JMenu();
        jRadioButtonMenuConPagamento = new javax.swing.JRadioButtonMenuItem();
        jMenuRelatorios = new javax.swing.JMenu();
        jMenuAjuda = new javax.swing.JMenu();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenuItem1.setText("jMenuItem1");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jRadioButtonMenuItem2.setSelected(true);
        jRadioButtonMenuItem2.setText("jRadioButtonMenuItem2");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 51, 222));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 706, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(0, 51, 222));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setPreferredSize(new java.awt.Dimension(2, 51));

        jPanel3.setBackground(new java.awt.Color(178, 191, 253));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 681, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 292, Short.MAX_VALUE)
        );

        jMenuCadastros.setText("Cadastros");

        jRadioButtonMenuIBairro.setSelected(true);
        jRadioButtonMenuIBairro.setText("Bairro");
        jRadioButtonMenuIBairro.setIcon(new javax.swing.ImageIcon("C:\\Users\\aluno\\Documents\\Kirchmann\\Yago\\NewMarketMaven\\src\\test\\java\\imagens\\Component.png")); // NOI18N
        jRadioButtonMenuIBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuIBairroActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jRadioButtonMenuIBairro);

        jRadioButtonMenuCidade.setSelected(true);
        jRadioButtonMenuCidade.setText("Cidade");
        jRadioButtonMenuCidade.setIcon(new javax.swing.ImageIcon("C:\\Users\\aluno\\Documents\\Kirchmann\\Yago\\NewMarketMaven\\src\\test\\java\\imagens\\Company.png")); // NOI18N
        jRadioButtonMenuCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuCidadeActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jRadioButtonMenuCidade);

        jRadioButtonMenuEndereco.setSelected(true);
        jRadioButtonMenuEndereco.setText("Endereço");
        jRadioButtonMenuEndereco.setIcon(new javax.swing.ImageIcon("C:\\Users\\aluno\\Documents\\Kirchmann\\Yago\\NewMarketMaven\\src\\test\\java\\imagens\\Home.png")); // NOI18N
        jRadioButtonMenuEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuEnderecoActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jRadioButtonMenuEndereco);
        jMenuCadastros.add(jSeparator1);

        jRadioButtonMenuCliente.setSelected(true);
        jRadioButtonMenuCliente.setText("Cliente");
        jRadioButtonMenuCliente.setIcon(new javax.swing.ImageIcon("C:\\Users\\aluno\\Documents\\Kirchmann\\Yago\\NewMarketMaven\\src\\test\\java\\imagens\\People.png")); // NOI18N
        jRadioButtonMenuCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuClienteActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jRadioButtonMenuCliente);

        jRadioButtonMenuColaborador.setSelected(true);
        jRadioButtonMenuColaborador.setText("Colaborador");
        jRadioButtonMenuColaborador.setIcon(new javax.swing.ImageIcon("C:\\Users\\aluno\\Documents\\Kirchmann\\Yago\\NewMarketMaven\\src\\test\\java\\imagens\\Male.png")); // NOI18N
        jRadioButtonMenuColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuColaboradorActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jRadioButtonMenuColaborador);

        jRadioButtonMenuFornecedor.setSelected(true);
        jRadioButtonMenuFornecedor.setText("Fornecedor");
        jRadioButtonMenuFornecedor.setIcon(new javax.swing.ImageIcon("C:\\Users\\aluno\\Documents\\Kirchmann\\Yago\\NewMarketMaven\\src\\test\\java\\imagens\\Boss.png")); // NOI18N
        jRadioButtonMenuFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuFornecedorActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jRadioButtonMenuFornecedor);
        jMenuCadastros.add(jSeparator2);

        jRadioButtonMenuProduto.setSelected(true);
        jRadioButtonMenuProduto.setText("Produto");
        jRadioButtonMenuProduto.setIcon(new javax.swing.ImageIcon("C:\\Users\\aluno\\Documents\\Kirchmann\\Yago\\NewMarketMaven\\src\\test\\java\\imagens\\Blue tag.png")); // NOI18N
        jRadioButtonMenuProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuProdutoActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jRadioButtonMenuProduto);

        jRadioButtonMenuMarca.setSelected(true);
        jRadioButtonMenuMarca.setText("Marca");
        jRadioButtonMenuMarca.setIcon(new javax.swing.ImageIcon("C:\\Users\\aluno\\Documents\\Kirchmann\\Yago\\NewMarketMaven\\src\\test\\java\\imagens\\Favourites.png")); // NOI18N
        jRadioButtonMenuMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuMarcaActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jRadioButtonMenuMarca);

        jRadioButtonMenuClasse.setSelected(true);
        jRadioButtonMenuClasse.setText("Classe");
        jRadioButtonMenuClasse.setIcon(new javax.swing.ImageIcon("C:\\Users\\aluno\\Documents\\Kirchmann\\Yago\\NewMarketMaven\\src\\test\\java\\imagens\\In-yang.png")); // NOI18N
        jRadioButtonMenuClasse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuClasseActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jRadioButtonMenuClasse);
        jMenuCadastros.add(jSeparator3);

        jRadioButtonMenuSair.setSelected(true);
        jRadioButtonMenuSair.setText("Sair");
        jRadioButtonMenuSair.setIcon(new javax.swing.ImageIcon("C:\\Users\\aluno\\Documents\\Kirchmann\\Yago\\NewMarketMaven\\src\\test\\java\\imagens\\Exit.png")); // NOI18N
        jRadioButtonMenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuSairActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jRadioButtonMenuSair);

        jMenuBar1.add(jMenuCadastros);

        jMenuMovimentos.setText("Movimentos");

        jRadioButtonMenuConPagamento.setSelected(true);
        jRadioButtonMenuConPagamento.setText("Condição de Pagamento");
        jRadioButtonMenuConPagamento.setIcon(new javax.swing.ImageIcon("C:\\Users\\aluno\\Documents\\Kirchmann\\Yago\\NewMarketMaven\\src\\test\\java\\imagens\\Dollar.png")); // NOI18N
        jRadioButtonMenuConPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuConPagamentoActionPerformed(evt);
            }
        });
        jMenuMovimentos.add(jRadioButtonMenuConPagamento);

        jMenuBar1.add(jMenuMovimentos);

        jMenuRelatorios.setText("Relatórios");
        jMenuBar1.add(jMenuRelatorios);

        jMenuAjuda.setText("Ajuda");
        jMenuBar1.add(jMenuAjuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonMenuConPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuConPagamentoActionPerformed
        NewViewCondPgto newViewCondPgto = new NewViewCondPgto();        
     
        ControllerCondPgto controllerCondPgto = new ControllerCondPgto(newViewCondPgto);
  
        newViewCondPgto.setVisible(true); // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonMenuConPagamentoActionPerformed

    private void jRadioButtonMenuMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuMarcaActionPerformed
        NewViewMarca newViewMarca = new NewViewMarca();

        ControllerMarca controllerMarca = new ControllerMarca(newViewMarca);

        newViewMarca.setVisible(true);           // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonMenuMarcaActionPerformed

    private void jRadioButtonMenuFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuFornecedorActionPerformed
        NewViewFornecedor newViewFornecedor = new NewViewFornecedor();

        ControllerFornecedor controllerFornecedor = new ControllerFornecedor(newViewFornecedor);

        newViewFornecedor.setVisible(true); // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonMenuFornecedorActionPerformed

    private void jRadioButtonMenuColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuColaboradorActionPerformed
        NewViewColaborador newViewColaborador = new NewViewColaborador();

        ControllerColaborador controllerColaborador = new ControllerColaborador(newViewColaborador);

        newViewColaborador.setVisible(true);   // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonMenuColaboradorActionPerformed

    private void jRadioButtonMenuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuClienteActionPerformed
        NewViewClientes newViewClientes = new NewViewClientes();

        ControllerClientes controllerCliente = new ControllerClientes(newViewClientes);

        newViewClientes.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonMenuClienteActionPerformed

    private void jRadioButtonMenuEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuEnderecoActionPerformed
        NewViewEndereco newViewEndereco = new NewViewEndereco();

        ControllerEndereco controllerEndereco = new ControllerEndereco(newViewEndereco);

        newViewEndereco.setVisible(true);          // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonMenuEnderecoActionPerformed

    private void jRadioButtonMenuCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuCidadeActionPerformed
        NewViewCidade newViewCidade = new NewViewCidade();

        ControllerCidade controllerCidade = new ControllerCidade(newViewCidade);

        newViewCidade.setVisible(true);
    }//GEN-LAST:event_jRadioButtonMenuCidadeActionPerformed

    private void jRadioButtonMenuIBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuIBairroActionPerformed

        NewViewBairro newViewBairro = new NewViewBairro();

        ControllerBairro controllerBairro = new ControllerBairro(newViewBairro);

        newViewBairro.setVisible(true);

    }//GEN-LAST:event_jRadioButtonMenuIBairroActionPerformed

    private void jRadioButtonMenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuSairActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonMenuSairActionPerformed

    private void jRadioButtonMenuProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuProdutoActionPerformed
        NewViewProduto newViewProduto = new NewViewProduto();

        ControllerProduto controllerProduto = new ControllerProduto(newViewProduto);

        newViewProduto.setVisible(true); // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonMenuProdutoActionPerformed

    private void jRadioButtonMenuClasseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuClasseActionPerformed
       NewViewClasse newViewClasse = new NewViewClasse();

        ControllerClasse controllerClasse = new ControllerClasse(newViewClasse);

        newViewClasse.setVisible(true); // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonMenuClasseActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewViewMenu().setVisible(true);
            }
        });
    }
    
    
    

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenuAjuda;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenu jMenuCadastros;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenu jMenuMovimentos;
    private javax.swing.JMenu jMenuRelatorios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuCidade;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuClasse;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuCliente;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuColaborador;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuConPagamento;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuEndereco;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuFornecedor;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuIBairro;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuMarca;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuProduto;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuSair;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    // End of variables declaration//GEN-END:variables

   

 
}
