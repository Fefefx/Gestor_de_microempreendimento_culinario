/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Bank.Conexao;
import Bank.infoBanco;
import Objects.encomenda;
import javax.swing.JOptionPane;

/**
 *
 * @author felipe
 */
public class encomendaModel {

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

    public boolean inserir(encomenda enco) {
        abrirConexao();
        String sql = "insert into encomenda(dia_pedido,dia_entrega,total,cliente_idcliente)"
                + " values('" + enco.getDiaPedido() + "','" + enco.getDiaEntrega() + "','" + enco.getTotal()
                + "'," + enco.getCodigoCliente() + ");";
        System.out.println(sql);
        int res = Banco.manipular(sql);
        if (res == -1) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o cliente");
        } else {
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
            return true;
        }
        return false;
    }

    public boolean atualizar(encomenda enco) {
        abrirConexao();
        String sql = "update encomenda set dia_pedido='" + enco.getDiaPedido() + "',"
                + "dia_entrega='" + enco.getDiaEntrega() + "',total='" + enco.getTotal() + "',"
                + "cliente_idcliente=" + enco.getCodigoCliente() + " where codigo=" + enco.getCodigoEncomenda() + ";";
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

    public boolean excluir(int codigo) {
        abrirConexao();
        String sql = "delete from encomenda where codigo=" + codigo + ";";
        System.out.println(sql);
        //chamar excluir produtos da venda para evitar problemas com integridade referencial
        int res = Banco.manipular(sql);
        if (res == -1) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o usuário");
        } else {
            JOptionPane.showMessageDialog(null, "Exclusão do cliente realizada");
            return true;
        }
        return false;
    }
}
