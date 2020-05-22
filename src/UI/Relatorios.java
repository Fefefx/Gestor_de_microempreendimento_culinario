/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Services.data;
import Control.relatorioControl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author felipe
 */
public class Relatorios extends javax.swing.JFrame {
    
    private String user;
    private int control;
    private String inicio,fim;
    
    
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Creates new form Relatorios
     */
    public Relatorios() {
        initComponents();
    }

    public Relatorios(int control) {
        initComponents();
        this.control = control;
        arrumaTela();
    }
    
    public void arrumaTela() {
        switch (control) {
            case 0:
                jLabel2.setText("Relatório de Clientes");
                break;
            case 1:
                jLabel2.setText("Relatório de Produtos");
                break;
            case 2:
                jLabel2.setText("Relatório de Vendas");
                break;
            case 3:
                jLabel2.setText("Relatório de Encomendas");
                break;
            default:
                System.out.println("Opção passada inválida");
        }
        AT_relat.setEditable(false);
        B_gerar.setEnabled(true);
        CC_periodo.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        B_gerar = new javax.swing.JButton();
        CC_periodo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AT_relat = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatórios do sistema");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        B_gerar.setText("Gerar");
        B_gerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_gerarActionPerformed(evt);
            }
        });

        CC_periodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "7 dias", "15 dias", "30 dias" }));

        jLabel1.setText("Filtrar dos últimos:");

        jLabel2.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel2.setText("Relatório de Clientes: ");

        AT_relat.setColumns(20);
        AT_relat.setRows(5);
        jScrollPane1.setViewportView(AT_relat);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29)
                        .addComponent(CC_periodo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(B_gerar)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CC_periodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_gerar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        telaRelatorios voltar = new telaRelatorios();
        voltar.setVisible(true);
        voltar.setUser(user);
    }//GEN-LAST:event_formWindowClosed

    private void B_gerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_gerarActionPerformed
        String dias=String.valueOf(CC_periodo.getSelectedItem());
        dias=dias.replace(" dias","");
        int qtd=Integer.parseInt(dias);
        qtd*=-1;
        data time = new data();
        fim=time.obterData();
        SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
        try{
            Date v_final = new Date(formatar.parse(fim).getTime());
            Calendar operar = Calendar.getInstance();
            operar.setTime(v_final);
            operar.add(Calendar.DAY_OF_MONTH, qtd);
            v_final = operar.getTime();
            fim=time.formatarBanco(fim);
            inicio=time.formatarBanco(v_final);
            System.out.println("Data inicial: "+inicio+" Data Final: "+fim);
            relatorioControl relat= new relatorioControl();
            String valor=relat.despachante(control, inicio, fim);
            if(valor != null){
                AT_relat.setText(valor);
            }
        }catch(ParseException psex){
            System.out.println("Erro ao converter a data: "+psex);
        }
    }//GEN-LAST:event_B_gerarActionPerformed

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
            java.util.logging.Logger.getLogger(Relatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Relatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Relatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Relatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Relatorios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AT_relat;
    private javax.swing.JButton B_gerar;
    private javax.swing.JComboBox<String> CC_periodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
