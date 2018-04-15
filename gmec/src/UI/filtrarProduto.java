/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Control.produtoControl;
import Objects.encomenda;
import Objects.produto;
import Objects.produtosEncomenda;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author felip
 */
public class filtrarProduto extends javax.swing.JFrame {

    ArrayList lista;
    private String usuario;
    encomenda dadosPedido = new encomenda();
    private boolean fechar = false;

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Creates new form filtrarProduto
     */
    public filtrarProduto() {
        initComponents();
    }

    public void armazenarDados(encomenda pedido) {
        dadosPedido = pedido;
    }

    public void arrumaTabela(String pesquisar) {
        produtoControl acessar = new produtoControl();
        lista = acessar.validarNomePesquisa(pesquisar);
        if (lista != null) {
            DefaultTableModel modelo = (DefaultTableModel) Tab_produtos.getModel();
            while (modelo.getRowCount() != 0) {
                modelo.removeRow(0);
            }
            for (int i = 0; i < lista.size(); i++) {
                produto prod = new produto();
                prod = (produto) lista.get(i);
                String[] linha = new String[4];
                linha[0] = prod.getNome();
                linha[1] = "R$ " + prod.getValorUnitario();
                modelo.addRow(linha);
                Tab_produtos.setModel(modelo);
            }
        } else {
            System.out.println("\nArrayList retornou nulo");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        Tab_produtos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Produtos Encontrados:");

        Tab_produtos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Produto", "Valor Unitário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tab_produtos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tab_produtosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tab_produtos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Tab_produtosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tab_produtosMouseClicked
        int posicao = Tab_produtos.getSelectedRow();
        produto prod = (produto) lista.get(posicao);
        produtosEncomenda prodEncomenda = new produtosEncomenda();
        prodEncomenda.setCodigoProduto(prod.getCodigo());
        prodEncomenda.setNome(prod.getNome());
        prodEncomenda.setQuantidade(1);
        prodEncomenda.setTotalProduto(prod.getValorUnitario());
        prodEncomenda.setValorUnitario(prod.getValorUnitario());
        dadosPedido.addItem(prodEncomenda);
        vendaEncomenda ve = new vendaEncomenda();
        ve.setUser(usuario);
        ve.arrumaTela(dadosPedido);
        ve.armazenarDados(dadosPedido);
        ve.arrumarCliente();
        if (dadosPedido.getCodigoEncomenda() != 0) {
            ve.liberarAlterar();
        } else {
            ve.arrumarCombo();
        }
        ve.setVisible(true);
        System.out.println("\nCliente antes de enviar: " + dadosPedido.client.getNome());
        fechar = true;
        this.dispose();

    }//GEN-LAST:event_Tab_produtosMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (!fechar) {
            vendaEncomenda ve = new vendaEncomenda();
            ve.setUser(usuario);
            ve.arrumaTela(dadosPedido);
            ve.armazenarDados(dadosPedido);
            ve.arrumarCliente();
            if (dadosPedido.getCodigoEncomenda() != 0) {
                ve.liberarAlterar();
            } else {
                ve.arrumarCombo();
            }
            ve.setVisible(true);
        }
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
            java.util.logging.Logger.getLogger(filtrarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(filtrarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(filtrarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(filtrarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new filtrarProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tab_produtos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
