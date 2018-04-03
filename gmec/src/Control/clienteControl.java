/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import javax.swing.JOptionPane;
import Objects.cliente;
import Model.clienteModel;
import java.util.ArrayList;
import Model.encomendaModel;

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
        if (phone.length() < 8 || phone.length() > 9) {
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

    public boolean validarCampos(cliente client) {
        if ("".equals(client.getNome().trim())) {
            JOptionPane.showMessageDialog(null, "Digite um nome");
        } else if ("".equals(client.getEndereco().trim())) {
            JOptionPane.showMessageDialog(null, "Digite um endereço");
        } else {
            clienteModel clientModel = new clienteModel();
            if (client.getIdCliente() == 0) {
                clientModel.inserir(client);
            } else {
                clientModel.atualizar(client);
            }
            return true;
        }
        return false;
    }

    public ArrayList validarNomePesquisa(String nome) {
        clienteModel clientModel = new clienteModel();
        return clientModel.pesquisar(nome);
    }
    
    public boolean validarTexto(String nome){
        if("".equals(nome.trim()))
            return false;
        return true;
    }

    public int excluir(int codigo) {
        int res;
        clienteModel clientModel = new clienteModel();
        encomendaModel encomendar = new encomendaModel();
        if (encomendar.pesquisarEncomendasCliente(codigo)) {
            res=JOptionPane.showConfirmDialog(null,"Foram encontradas encomendas em aberto para o cliente. Deseja exclui-lo ?");
            if(res==0)
                clientModel.excluir(codigo);
        }else{
            res=JOptionPane.showConfirmDialog(null,"Deseja excluir o cliente ?");
            if(res==0)
                clientModel.excluir(codigo);
        }
        return res;
    }

}
