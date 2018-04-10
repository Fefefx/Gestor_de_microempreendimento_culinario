/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.ArrayList;
import Objects.produto;
import Control.produtoControl;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author felipe
 */
public class visualizarProdutos extends javax.swing.JFrame {

    ArrayList listaProdutos = new ArrayList();
    produtoControl prodControl = new produtoControl();
    private String user;

    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Creates new form visualizarProdutos
     */
    public visualizarProdutos() {
        initComponents();
        arrumaTela();
    }

    public void arrumaTela() {
        CT_produto.setText("");
        CT_produto.requestFocus();
        arrumaTabela();
    }

    public void arrumaTabela() {
        limpaLista();
        listaProdutos = prodControl.validarNomePesquisa(CT_produto.getText());
        if (listaProdutos != null) {
            DefaultTableModel modelo = (DefaultTableModel) Tab_produtos.getModel();
            while (modelo.getRowCount() != 0) {
                modelo.removeRow(0);
            }
            for (int i = 0; i < listaProdutos.size(); i++) {
                produto prod = (produto) listaProdutos.get(i);
                String[] linha = new String[4];
                linha[0] = String.valueOf(prod.getCodigo());
                linha[1] = prod.getNome();
                linha[2] = "R$ "+prod.getValorUnitario();
                linha[3] = prod.getDescricao(); 
                modelo.addRow(linha);
                Tab_produtos.setModel(modelo);
            }
        } else {
            System.out.println("\nArrayList retornou nulo");
        }
    }

    public void limpaLista() {
        if (listaProdutos != null) {
            while (!listaProdutos.isEmpty()) {
                listaProdutos.remove(0);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        CT_produto = new javax.swing.JTextField();
        B_pesquisar = new javax.swing.JButton();
        B_novo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tab_produtos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listar Produtos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("Filtrar Produto:");

        B_pesquisar.setText("Pesquisar");
        B_pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_pesquisarActionPerformed(evt);
            }
        });

        B_novo.setText("Novo");
        B_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_novoActionPerformed(evt);
            }
        });

        Tab_produtos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Preço", "Descrição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Tab_produtos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tab_produtosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tab_produtos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(CT_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(B_pesquisar)
                        .addGap(31, 31, 31)
                        .addComponent(B_novo)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CT_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_pesquisar)
                    .addComponent(B_novo))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void B_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_pesquisarActionPerformed
        arrumaTabela();
    }//GEN-LAST:event_B_pesquisarActionPerformed

    private void B_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_novoActionPerformed
        this.setVisible(false);
        cadastrarProduto cadProd = new cadastrarProduto(this, rootPaneCheckingEnabled);
        cadProd.setVisible(true);
        this.setVisible(true);
        arrumaTela();
    }//GEN-LAST:event_B_novoActionPerformed

    private void Tab_produtosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tab_produtosMouseClicked
        int linha=Tab_produtos.getSelectedRow();
        produto prod= (produto) listaProdutos.get(linha);
        cadastrarProduto cadprod = new cadastrarProduto(this,rootPaneCheckingEnabled);
        this.setVisible(false);
        cadprod.arrumarTela(prod);
        cadprod.setVisible(true);
        this.setVisible(true);
        this.arrumaTela();
    }//GEN-LAST:event_Tab_produtosMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        telaInicial iniciar = new telaInicial();
        iniciar.arrumaTela(user);
        iniciar.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(visualizarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(visualizarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(visualizarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(visualizarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new visualizarProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_novo;
    private javax.swing.JButton B_pesquisar;
    private javax.swing.JTextField CT_produto;
    private javax.swing.JTable Tab_produtos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
