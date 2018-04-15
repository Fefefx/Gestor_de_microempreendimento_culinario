/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Objects.cliente;
import Bank.Conexao;
import Bank.infoBanco;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author felipe
 */
public class clienteModel {

    private Conexao Banco;
    infoBanco dados = new infoBanco();

    private void abrirConexao() {
        Banco = new Conexao();
        Banco.conectar(dados.getBanco(), dados.getUsuario(), dados.getSenha());
        if (!Banco.getStatus()) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco código: " + Banco.getMensagemErro());
        } else {
            System.out.println("Banco conectado !");
        }
    }

    public void inserir(cliente client) {
        abrirConexao();
        String sql = "insert into cliente(nome,telefone,endereco) values('" + client.getNome() + "',"
                + client.getTelefone() + ",'" + client.getEndereco() + "');";
        System.out.println(sql);
        int res = Banco.manipular(sql);
        if (res == -1) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o cliente");
        } else {
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
        }
    }

    public boolean atualizar(cliente client) {
        abrirConexao();
        String sql = "update cliente set nome='" + client.getNome() + "',telefone="
                + client.getTelefone() + ",endereco='" + client.getEndereco()
                + "' where idcliente=" + client.getIdCliente();
        System.out.println(sql);
        int res = Banco.manipular(sql);
        if (res == -1) {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar o cliente");
        } else {
            JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso");
            return true;
        }
        return false;
    }

    public void excluir(int codigo) {
        abrirConexao();
        String sql = "delete from cliente where idcliente=" + codigo + ";";
        System.out.println(sql);
        //deleta todas encomendas do cliente antes de exclui-lo
        encomendaModel pedido = new encomendaModel();
        if (pedido.excluirEncomendasCliente(codigo)) {
            int res = Banco.manipular(sql);
            if (res == -1) {
                JOptionPane.showMessageDialog(null, "Não foi possível excluir o cliente");
            } else {
                JOptionPane.showMessageDialog(null, "Exclusão do cliente realizada");
            }
        }
    }

    /*pesquisa os clientes que começam com o nome fornecido por parâmetro 
    retorna uma lista com todos os registros */
    public ArrayList pesquisar(String nomeCliente) {
        abrirConexao();
        ArrayList lista=new ArrayList();
        String sql="select * from cliente where nome like '"+nomeCliente+"%';";
        System.out.println(sql);
        ResultSet resultado=Banco.consultar(sql);
        try {
            while(resultado.next()){
                cliente client=new cliente();
                client.setIdCliente(resultado.getInt("idcliente"));
                client.setNome(resultado.getString("nome"));
                client.setTelefone(resultado.getInt("telefone"));
                client.setEndereco(resultado.getString("endereco"));
                lista.add(client);
            }
            resultado.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(clienteModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    

}
