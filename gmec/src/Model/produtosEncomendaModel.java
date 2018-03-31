/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Bank.Conexao;
import Bank.infoBanco;
import Objects.produtosEncomenda;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author felipe
 */
public class produtosEncomendaModel {

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

    public boolean inserir(produtosEncomenda itens) {
        abrirConexao();
        String sql = "insert into produtos_da_encomenda(encomenda_codigo,produto_codigo,quantidade,total_produto) values("
                + itens.getCodigoEncomenda() + "," + itens.getCodigoProduto() + "," + itens.getQuantidade() + ",'" + itens.getTotalProduto() + "');";
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

    public boolean atualizar(produtosEncomenda itens) {
        abrirConexao();
        String sql = "update produtos_da_encomenda set quantidade=" + itens.getQuantidade()
                + ",total_produto='" + itens.getTotalProduto() + "' where encomenda_codigo=" + itens.getCodigoEncomenda()
                + " and produto_codigo=" + itens.getCodigoProduto() + ";";
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

    public boolean excluir(int codigoEncomenda) {
        abrirConexao();
        String sql = "delete from produtos_da_encomenda where encomenda_codigo=" + codigoEncomenda + ";";
        System.out.println(sql);
        int res = Banco.manipular(sql);
        if (res == -1) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o usuário");
        } else {
            JOptionPane.showMessageDialog(null, "Exclusão do cliente realizada");
            return true;
        }
        return false;
    }

    // produtosEncomenda é uma view que junta os dados de produtos_da_encomenda e produto
    public ResultSet pesquisar(String nome) {
        abrirConexao();
        String sql = "select * from produtosEncomenda where nome='" + nome + "';";
        System.out.println(sql);
        ResultSet registro = Banco.consultar(sql);
        try {
            if (registro.next()) {
                System.out.println("Registros encontrados");
                return registro;
            }
        } catch (SQLException ex) {
            Logger.getLogger(produtosEncomendaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
