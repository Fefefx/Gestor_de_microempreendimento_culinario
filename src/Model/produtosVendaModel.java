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
import java.util.ArrayList;

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
                + itens.getCodigoVenda() + "," + itens.getCodigoProduto() + "," + itens.getQuantidade()
                + ",'" + itens.getTotalProduto() + "');";
        System.out.println(sql);
        int res = Banco.manipular(sql);
        if (res == -1) {
            System.out.println("\nNão foi possível inserir o produto " + itens.getNome() + " na venda");
        } else {
            System.out.println("\n" + itens.getNome() + " inserido na venda com sucesso");
            return true;
        }
        return false;
    }

    public boolean atualizar(produtosVenda itens) {
        abrirConexao();
        String sql = "update produtos_da_venda set quantidade=" + itens.getQuantidade()
                + ",total_produto='" + itens.getTotalProduto() + "' where vendas_codigo=" + itens.getCodigoVenda()
                + " and produto_codigo=" + itens.getCodigoProduto() + ";";
        System.out.println(sql);
        int res = Banco.manipular(sql);
        if (res == -1) {
            System.out.println("\nNão foi possível atualizar o produto " + itens.getNome());
        } else {
            System.out.println("\nAtualização do produto " + itens.getNome() + " realizada com sucesso");
            return true;
        }
        return false;
    }

    //Exclui apenas UM produto da venda
    public boolean excluir(int codigoVenda, int codigoProduto) {
        abrirConexao();
        String sql = "delete from produtos_da_venda where vendas_codigo=" + codigoVenda
                + " and produto_codigo=" + codigoProduto + ";";
        System.out.println(sql);
        int res = Banco.manipular(sql);
        if (res == -1) {
            System.out.println("\nNão foi possível excluir o produto da venda");
        } else {
            System.out.println("\nExclusão do produto realizada");
            return true;
        }
        return false;
    }

    //Exclui TODOS os produtos da venda    
    public boolean excluirTodos(int codigoVenda) {
        abrirConexao();
        String sql = "delete from produtos_da_venda where vendas_codigo=" + codigoVenda + ";";
        System.out.println(sql);
        int res = Banco.manipular(sql);
        if (res == -1) {
            System.out.println("\nNão foi possível excluir todos os produtos da venda");
        } else {
            System.out.println("\nExclusão dos produtos realizada");
            return true;
        }
        return false;
    }

    //deleta TODOS os registros de UM produto das VENDAS
    public boolean excluirRegistro(int codigoProduto) {
        abrirConexao();
        String sql = "delete from produtos_da_venda where produto_codigo=" + codigoProduto + ";";
        System.out.println(sql);
        int res = Banco.manipular(sql);
        if (res == -1) {
            System.out.println("\nNão foi possível excluir todos os registros do produto");
        } else {
            System.out.println("\nExclusão do produto realizada");
            return true;
        }
        return false;
    }

    // produtosVenda é uma view que junta os dados de produtos_da_venda e produto
    public ArrayList pesquisar(int codigoVenda) {
        abrirConexao();
        ArrayList lista = new ArrayList();
        String sql = "select * from produtosVenda where vendas_codigo=" + codigoVenda + ";";
        System.out.println(sql);
        ResultSet registro = Banco.consultar(sql);
        try {
            while (registro.next()) {
                System.out.println("\nProdutos encontrados");
                produtosVenda item = new produtosVenda();
                item.setCodigoProduto(registro.getInt("codigo"));
                item.setCodigoVenda(registro.getInt("vendas_codigo"));
                item.setNome(registro.getString("nome"));
                item.setQuantidade(registro.getInt("quantidade"));
                item.setValorUnitario(registro.getFloat("valor_unitario"));
                item.setTotalProduto(registro.getFloat("total_produto"));
                lista.add(item);
            }
            registro.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(produtosEncomendaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
