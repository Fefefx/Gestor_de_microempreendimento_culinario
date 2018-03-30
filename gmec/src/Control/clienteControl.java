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
        int tel = Integer.parseInt(phone);
        try {
            if (tel != 0) {
                return true;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Digite apenas números no campo telefone");
        }
        return false;
    }

    public boolean validarCampos(cliente client) {
        boolean resposta=false;
        if ("".equals(client.getNome().trim())) {
            JOptionPane.showMessageDialog(null, "Digite um nome");
        } else if ("".equals(client.getEndereco().trim())) {
            JOptionPane.showMessageDialog(null, "Digite um endereço");
        } else {
            clienteModel clientModel = new clienteModel(); 
            if(client.getIdCliente()==0)
                resposta=clientModel.inserir(client);
            else
                resposta=clientModel.atualizar(client);
        }
        return resposta;
    }
}
