/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import javax.swing.JOptionPane;
import Objects.cliente;
import Model.clienteModel;

/**
 *
 * @author felipe
 */
public class clienteControl {

    public boolean validarTelefone(String phone) {
        if ("".equals(phone.trim())) {
            JOptionPane.showMessageDialog(null, "Digite um valor para o campo telefone");
            return false;
        }
        if (phone.length() > 9) {
            JOptionPane.showMessageDialog(null, "Formato de telefone incorreto");
            return false;
        }
        try {
            int tel = Integer.parseInt(phone);
            if (tel != 0) {
                return true;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Digite apenas números no campo telefone");
        }
        return false;
    }

    public void validarCampos(cliente client) {
        if ("".equals(client.getNome().trim())) {
            JOptionPane.showMessageDialog(null, "Digite um nome");
        } 
        if ("".equals(client.getEndereco().trim())) {
            JOptionPane.showMessageDialog(null, "Digite um endereço");
        } else {
            clienteModel clientModel = new clienteModel(); 
            if(client.getIdCliente()==0)
                clientModel.inserir(client);
            else
                clientModel.atualizar(client);
        }
    }
}
