/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Control.clienteControl;
import Objects.cliente;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author felipe
 */
public class visualizarClientes extends javax.swing.JFrame {

    clienteControl clientControl = new clienteControl();
    private String user;


    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Creates new form frameTeste
     */
    public visualizarClientes() {
        initComponents();
        arrumarTela();
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
        CT_nome = new javax.swing.JTextField();
        B_pesquisa = new javax.swing.JButton();
        B_novo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tab_clientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listar Clientes ");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("Filtrar por Nome:");

        B_pesquisa.setText("Pesquisar");
        B_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_pesquisaActionPerformed(evt);
            }
        });

        B_novo.setText("Novo");
        B_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_novoActionPerformed(evt);
            }
        });

        Tab_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Endereço", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Tab_clientes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Tab_clientesFocusGained(evt);
            }
        });
        Tab_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tab_clientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tab_clientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(CT_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(B_pesquisa)
                        .addGap(31, 31, 31)
                        .addComponent(B_novo)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CT_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_pesquisa)
                    .addComponent(B_novo))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void B_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_pesquisaActionPerformed
        arrumaTabela();
    }//GEN-LAST:event_B_pesquisaActionPerformed

    private void B_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_novoActionPerformed
        this.setVisible(false);
        new clienteCadastro(this, rootPaneCheckingEnabled).show();
        this.setVisible(true);
        CT_nome.setText("");
        arrumaTabela();
    }//GEN-LAST:event_B_novoActionPerformed

    private void Tab_clientesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Tab_clientesFocusGained

    }//GEN-LAST:event_Tab_clientesFocusGained

    private void Tab_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tab_clientesMouseClicked
        int linha = Tab_clientes.getSelectedRow();
        cliente client = new cliente();
        client.setIdCliente(Integer.parseInt(Tab_clientes.getValueAt(linha, 0).toString()));
        client.setNome(Tab_clientes.getValueAt(linha, 1).toString());
        client.setEndereco(Tab_clientes.getValueAt(linha, 2).toString());
        client.setTelefone(Integer.parseInt(Tab_clientes.getValueAt(linha, 3).toString()));
        this.setVisible(false);
        clienteCadastro clicad = new clienteCadastro(this, rootPaneCheckingEnabled);
        clicad.arrumarTela(client);
        clicad.setVisible(true);
        CT_nome.setText("");
        arrumaTabela();
        this.setVisible(true);
    }//GEN-LAST:event_Tab_clientesMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        telaInicial ini= new telaInicial();
        ini.arrumaTela(user);
        ini.setVisible(true);
    }//GEN-LAST:event_formWindowClosing
    public void arrumaTabela() {
        ArrayList resultado = clientControl.validarNomePesquisa(CT_nome.getText());
        if (resultado != null) {
            DefaultTableModel modelo = (DefaultTableModel) Tab_clientes.getModel();
            while (modelo.getRowCount() != 0) {
                modelo.removeRow(0);
            }
            for (int i = 0; i < resultado.size(); i++) {
                cliente client = new cliente();
                client = (cliente) resultado.get(i);
                String[] linha = new String[4];
                linha[0] = String.valueOf(client.getIdCliente());
                linha[1] = client.getNome();
                linha[2] = client.getEndereco();
                linha[3] = String.valueOf(client.getTelefone());
                modelo.addRow(linha);
                Tab_clientes.setModel(modelo);
            }
        } else {
            System.out.println("\nArrayList retornou nulo");
        }
    }

    public void arrumarTela() {
        CT_nome.setText("");
        CT_nome.requestFocus();
        arrumaTabela();
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
            java.util.logging.Logger.getLogger(visualizarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(visualizarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(visualizarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(visualizarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new visualizarClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_novo;
    private javax.swing.JButton B_pesquisa;
    private javax.swing.JTextField CT_nome;
    private javax.swing.JTable Tab_clientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
