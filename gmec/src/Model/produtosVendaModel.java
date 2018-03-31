/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Bank.Conexao;
import Bank.infoBanco;
import Objects.produtosVenda;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author felipe
 */
public class produtosVendaModel {
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

    public boolean inserir(produtosVenda itens) {
        abrirConexao();
        String sql = "insert into produtos_da_venda(vendas_codigo,produto_codigo,quantidade,total_produto) values("
                + itens.getCodigoVenda()+","+itens.getCodigoProduto()+","+itens.getQuantidade()
                +",'"+itens.getTotalProduto()+"');";
        System.out.println(sql);
        int res = Banco.manipular(sql);
        if (res == -1) {
            JOptionPane.showMessageDialog(null, "Não foi possível inserir o produto");
        } else {
            JOptionPane.showMessageDialog(null, "Produto inserido com sucesso");
            return true;
        }
        return false;
    }

    public boolean atualizar(produtosVenda itens) {
        abrirConexao();
        String sql = "update produtos_da_venda set quantidade="+itens.getQuantidade()
                +",total_produto='"+itens.getTotalProduto()+"' where vendas_codigo="+itens.getCodigoVenda()
                +" and produto_codigo="+itens.getCodigoProduto()+";";
        System.out.println(sql);
        int res = Banco.manipular(sql);
        if (res == -1) {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar o produto");
        } else {
            JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso");
            return true;
        }
        return false;
    }

    public boolean excluir(int codigoVenda,int codigoProduto) {
        abrirConexao();
        String sql = "delete from produtos_da_venda where vendas_codigo=" + codigoVenda 
                + " and produto_codigo="+codigoProduto+";";
        System.out.println(sql);
        int res = Banco.manipular(sql);
        if (res == -1) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o produto da venda");
        } else {
            JOptionPane.showMessageDialog(null, "Exclusão dos produtos realizada");
            return true;
        }
        return false;
    }

    // produtosVenda é uma view que junta os dados de produtos_da_venda e produto
    public ResultSet pesquisar(int codigoVenda) {
        abrirConexao();
        String sql = "select * from produtosVenda where vendas_codigo=" + codigoVenda + ";";
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
