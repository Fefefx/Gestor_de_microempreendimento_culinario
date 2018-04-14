/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.MaskFormatter;
import Objects.encomenda;
import Objects.produtosEncomenda;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import Control.produtoControl;
import Objects.cliente;
import javax.swing.JOptionPane;

/**
 *
 * @author Beth
 */
public class vendaEncomenda extends javax.swing.JFrame {

    encomenda pedido = new encomenda();
    private String user;
    private int codigoEncomenda = 0;
    ArrayList itens = new ArrayList();
    private boolean fechar = false;

    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Creates new form vendaEncomenda
     */
    public vendaEncomenda() {
        initComponents();
        arrumaTela();
    }

    public String formataData() {
        String formatar = CT_data_encomenda.getText().replace("/", "-");
        formatar = formatar.substring(6) + "-" + formatar.substring(3, 5) + "-" + formatar.substring(0, 2);
        System.out.println(formatar);
        return formatar;
    }

    public void aplicarMascara() {
        try {
            MaskFormatter mascara = new MaskFormatter("##/##/####");
            mascara.install(CT_data_entrega);
            mascara = new MaskFormatter("##/##/####");
            mascara.install(CT_data_encomenda);
        } catch (ParseException ex) {
            Logger.getLogger(vendaEncomenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void arrumaTela() {
        aplicarMascara();
        CT_produto.setEnabled(false);
        B_pesquisar_produtos.setEnabled(false);
        B_removerItem.setEnabled(false);
        CT_data_entrega.setEnabled(false);
        CT_total.setEnabled(false);
        B_salvar.setEnabled(false);
        B_excluir.setEnabled(false);
        B_alterar.setEnabled(false);
        Tab_itens.setEnabled(false);
        CT_total.setEditable(false);
    }

    public void liberarEncomenda() {
        CT_produto.setEnabled(true);
        B_pesquisar_produtos.setEnabled(true);
        B_removerItem.setEnabled(false);
        CT_data_entrega.setEnabled(true);
        CT_total.setEnabled(true);
        B_salvar.setEnabled(true);
        B_excluir.setEnabled(true);
        B_alterar.setEnabled(true);
        CT_produto.requestFocus();
        Tab_itens.setEnabled(true);
    }

    public void arrumaTela(encomenda dados) {

        codigoEncomenda = dados.getCodigoEncomenda();
        CT_data_encomenda.setText("");
        CT_data_encomenda.setText(dados.getDiaPedido());
        CT_data_entrega.setText("");
        CT_data_entrega.setText(dados.getDiaEntrega());
        itens = dados.retornarItens();
        arrumarCliente();
        arrumaTabela(dados.retornarItens());
    }

    public void arrumaTabela(ArrayList valores) {
        float valorTotal = 0;
        DefaultTableModel modelo = (DefaultTableModel) Tab_itens.getModel();
        while (modelo.getRowCount() != 0) {
            modelo.removeRow(0);
        }
        for (int i = 0; i < valores.size(); i++) {
            produtosEncomenda prodVenda = (produtosEncomenda) valores.get(i);
            String[] linha = new String[4];
            linha[0] = prodVenda.getNome();
            linha[1] = String.valueOf(prodVenda.getQuantidade());
            linha[2] = String.valueOf(prodVenda.getValorUnitario());
            linha[3] = String.valueOf(prodVenda.getTotalProduto());
            valorTotal += prodVenda.getTotalProduto();
            modelo.addRow(linha);
        }
        Tab_itens.setModel(modelo);
        itens = valores;
        BigDecimal arredondar = new BigDecimal(valorTotal).setScale(2, RoundingMode.HALF_UP);
        valorTotal = arredondar.floatValue();
        CT_total.setText(String.valueOf(valorTotal));
        if (modelo.getRowCount() != 0) {
            if (codigoEncomenda == 0) {
                B_salvar.setEnabled(true);
            } else {
                B_excluir.setEnabled(true);
                B_alterar.setEnabled(true);
            }
        } else {
            desativaBTela();
        }
    }

    public void desativaBTela() {
        aplicarMascara();
        CT_total.setEditable(false);
        CT_data_encomenda.requestFocus();
        CT_produto.setEditable(true);
        B_removerItem.setEnabled(false);
        B_salvar.setEnabled(false);
        B_alterar.setEnabled(false);
        B_excluir.setEnabled(false);
    }

    public void arrumarCliente() {
        DefaultTableModel modelo = (DefaultTableModel) Tab_cliente.getModel();
        while (modelo.getRowCount() != 0) {
            modelo.removeRow(0);
        }
        String[] linha = new String[3];
        linha[0] = pedido.client.getNome();
        linha[1] = pedido.client.getEndereco();
        linha[2] = String.valueOf(pedido.client.getTelefone());
        modelo.addRow(linha);
        Tab_cliente.setModel(modelo);
        liberarEncomenda();
    }

    public void armazenarDados(encomenda dados) {
        pedido = dados;
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
        jLabel2 = new javax.swing.JLabel();
        CT_cliente = new javax.swing.JTextField();
        B_pesquisa_cliente = new javax.swing.JButton();
        CT_data_encomenda = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tab_cliente = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        CT_produto = new javax.swing.JTextField();
        B_pesquisar_produtos = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tab_itens = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        CT_data_entrega = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        CT_total = new javax.swing.JTextField();
        B_salvar = new javax.swing.JButton();
        B_alterar = new javax.swing.JButton();
        B_excluir = new javax.swing.JButton();
        B_removerItem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciar Encomenda");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("Data da Encomenda");

        jLabel2.setText("Cliente");

        CT_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CT_clienteActionPerformed(evt);
            }
        });

        B_pesquisa_cliente.setText("Pesquisar");
        B_pesquisa_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_pesquisa_clienteActionPerformed(evt);
            }
        });

        CT_data_encomenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CT_data_encomendaActionPerformed(evt);
            }
        });

        Tab_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Nome", "Endereço", "Telefone"
            }
        ));
        Tab_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tab_clienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tab_cliente);

        jLabel3.setText("Produto");

        CT_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CT_produtoActionPerformed(evt);
            }
        });

        B_pesquisar_produtos.setText("Pesquisar");
        B_pesquisar_produtos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_pesquisar_produtosActionPerformed(evt);
            }
        });

        Tab_itens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Produto", "Quantidade", "Valor Unitário", "Total"
            }
        ));
        Tab_itens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tab_itensMouseClicked(evt);
            }
        });
        Tab_itens.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Tab_itensKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(Tab_itens);

        jLabel4.setText("Data da Entrega");

        CT_data_entrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CT_data_entregaActionPerformed(evt);
            }
        });

        jLabel5.setText("Total do Pedido");

        B_salvar.setText("Salvar");

        B_alterar.setText("Alterar");

        B_excluir.setText("Excluir");

        B_removerItem.setText("Remover Item");
        B_removerItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_removerItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 16, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CT_data_encomenda, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(CT_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B_pesquisa_cliente))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CT_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(B_pesquisar_produtos))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(CT_total, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(114, 114, 114)
                                        .addComponent(B_salvar)
                                        .addGap(43, 43, 43)
                                        .addComponent(B_alterar)
                                        .addGap(37, 37, 37)
                                        .addComponent(B_excluir))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(CT_data_entrega, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(B_removerItem)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(CT_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_pesquisa_cliente)
                    .addComponent(CT_data_encomenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CT_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_pesquisar_produtos))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(CT_data_entrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_removerItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(CT_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_salvar)
                    .addComponent(B_alterar)
                    .addComponent(B_excluir))
                .addGap(30, 30, 30))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CT_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CT_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CT_clienteActionPerformed

    private void CT_data_encomendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CT_data_encomendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CT_data_encomendaActionPerformed

    private void CT_produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CT_produtoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CT_produtoActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (!fechar) {
            telaInicial start = new telaInicial();
            start.arrumaTela(user);
            start.setVisible(true);
        }
    }//GEN-LAST:event_formWindowClosed

    private void B_pesquisar_produtosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_pesquisar_produtosActionPerformed
        produtoControl validar = new produtoControl();
        constroiEncomenda();
        if (validar.validaProduto(CT_produto.getText())) {
            filtrarProduto buscar = new filtrarProduto();
            buscar.armazenarDados(pedido);
            buscar.arrumaTabela(CT_produto.getText());
            buscar.setVisible(true);
            fechar = true;
            this.dispose();
        } else {
            CT_produto.requestFocus();
        }
    }//GEN-LAST:event_B_pesquisar_produtosActionPerformed

    private void CT_data_entregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CT_data_entregaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CT_data_entregaActionPerformed

    private void B_pesquisa_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_pesquisa_clienteActionPerformed
        listarClientes localizar = new listarClientes(this, true);
        this.setVisible(false);
        localizar.arrumaTabela(CT_cliente.getText());
        localizar.setVisible(true);
        this.setVisible(true);
        if (localizar.isControle()) {
            pedido.client = localizar.getClient();
            System.out.println("Cliente: " + pedido.client.getNome());
            arrumarCliente();
        }
    }//GEN-LAST:event_B_pesquisa_clienteActionPerformed

    private void Tab_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tab_clienteMouseClicked
        int res = JOptionPane.showConfirmDialog(null, "Deseja remover esse cliente da venda ?");
        if (res == 0) {
            pedido.client = new cliente();
            DefaultTableModel modelo = (DefaultTableModel) Tab_cliente.getModel();
            while (modelo.getRowCount() != 0) {
                modelo.removeRow(0);
            }
            String[] linha = new String[3];
            for (int i = 0; i < linha.length; i++) {
                linha[i] = "";
            }
            modelo.addRow(linha);
            Tab_cliente.setModel(modelo);
            arrumaTela();
        }
    }//GEN-LAST:event_Tab_clienteMouseClicked

    private void Tab_itensKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Tab_itensKeyReleased
        int posicao = Tab_itens.getSelectedRow();
        int unidade = Integer.parseInt(Tab_itens.getValueAt(posicao, 1).toString());
        if (unidade <= 0) {
            JOptionPane.showMessageDialog(null, "Unidade digitada inválida");
            unidade = 1;
        }
        produtosEncomenda prodVenda = (produtosEncomenda) itens.get(posicao);
        float total = prodVenda.getValorUnitario() * unidade;
        BigDecimal formatar = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);
        total = formatar.floatValue();
        prodVenda.setTotalProduto(total);
        prodVenda.setQuantidade(unidade);
        itens.remove(posicao);
        itens.add(posicao, prodVenda);
        arrumaTabela(itens);
    }//GEN-LAST:event_Tab_itensKeyReleased

    private void Tab_itensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tab_itensMouseClicked
        B_removerItem.setEnabled(true);
    }//GEN-LAST:event_Tab_itensMouseClicked

    private void B_removerItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_removerItemActionPerformed
        int res= Tab_itens.getSelectedRow();
        if(res!=-1){
            itens.remove(res);
            arrumaTabela(itens);
        }else
            B_removerItem.setEnabled(false);
    }//GEN-LAST:event_B_removerItemActionPerformed

    public void constroiEncomenda() {
        pedido.setCodigoEncomenda(codigoEncomenda);
        pedido.setDiaPedido(CT_data_encomenda.getText());
        pedido.setDiaEntrega(CT_data_entrega.getText());
        if (!CT_total.getText().isEmpty()) {
            pedido.setTotal(Float.parseFloat(CT_total.getText()));
        }
        pedido.adicionarItens(itens);
    }

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
            java.util.logging.Logger.getLogger(vendaEncomenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vendaEncomenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vendaEncomenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vendaEncomenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vendaEncomenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_alterar;
    private javax.swing.JButton B_excluir;
    private javax.swing.JButton B_pesquisa_cliente;
    private javax.swing.JButton B_pesquisar_produtos;
    private javax.swing.JButton B_removerItem;
    private javax.swing.JButton B_salvar;
    private javax.swing.JTextField CT_cliente;
    private javax.swing.JFormattedTextField CT_data_encomenda;
    private javax.swing.JFormattedTextField CT_data_entrega;
    private javax.swing.JTextField CT_produto;
    private javax.swing.JTextField CT_total;
    private javax.swing.JTable Tab_cliente;
    private javax.swing.JTable Tab_itens;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
