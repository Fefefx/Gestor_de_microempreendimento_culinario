/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Bank.Conexao;
import Bank.infoBanco;
import Objects.produto;
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
public class produtoModel {

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

    public void inserir(produto prod) {
        abrirConexao();
        String sql = "insert into produto(nome,rendimento,valor_custo,valor_unitario,Ingredientes,descricao) values('"
                + prod.getNome() + "'," + prod.getRendimento() + ",'" + prod.getValorCusto() + "','" + prod.getValorUnitario() + "','"
                + prod.getIngredientes() + "','" + prod.getDescricao() + "');";
        System.out.println(sql);
        int res = Banco.manipular(sql);
        if (res == -1) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o produto");
        } else {
            JOptionPane.showMessageDialog(null, "Produto inserido com sucesso");
        }
    }

    public void atualizar(produto prod) {
        abrirConexao();
        String sql = "update produto set nome='" + prod.getNome() + "',rendimento=" + prod.getRendimento() + ","
                + "valor_custo='" + prod.getValorCusto() + "',valor_unitario='" + prod.getValorUnitario() + "',"
                + "Ingredientes='" + prod.getIngredientes() + "',descricao='" + prod.getDescricao() + "'"
                + " where codigo=" + prod.getCodigo() + ";";
        System.out.println(sql);
        int res = Banco.manipular(sql);
        if (res == -1) {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar o produto");
        } else {
            JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso");
        }
    }

    public boolean excluir(int codigo) {
        abrirConexao();
        String sql = "delete from produto where codigo=" + codigo + ";";
        System.out.println(sql);
        //exclui os registros do produto nas encomendas e vendas para poder deletá-lo
        produtosEncomendaModel naEncomenda = new produtosEncomendaModel();
        produtosVendaModel naVenda = new produtosVendaModel();
        if (naEncomenda.excluirRegistro(codigo) && naVenda.excluirRegistro(codigo)) {
            int res = Banco.manipular(sql);
            if (res == -1) {
                JOptionPane.showMessageDialog(null, "Não foi possível excluir o produto");
            } else {
                JOptionPane.showMessageDialog(null, "Exclusão do produto realizada");
                matarVendasVazias();
                matarEncomendasVazias();
                return true;
            }
        }
        return false;
    }

    public void matarVendasVazias() {
        abrirConexao();
        String sql = "select v.codigo from vendas v left join produtos_da_venda pv on v.codigo=pv.vendas_codigo where vendas_codigo is null;";
        System.out.println(sql);
        ResultSet resultado = Banco.consultar(sql);
        try {
            while (resultado.next()) {
                int valor = resultado.getInt("codigo");
                sql = "delete from vendas where codigo = " + valor + ";";
                int res = Banco.manipular(sql);
                if (res == -1) {
                    System.out.println("\nExclusão da venda sem produtos realizada");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(vendasModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public void matarEncomendasVazias() {
        abrirConexao();
        String sql = "select codigo from encomenda e left join produtos_da_encomenda pe on e.codigo=pe.encomenda_codigo where encomenda_codigo is null;";
        System.out.println(sql);
        ResultSet resultado = Banco.consultar(sql);
        try {
            while (resultado.next()) {
                int valor = resultado.getInt("codigo");
                sql = "delete from encomenda where codigo = " + valor + ";";
                int res = Banco.manipular(sql);
                if (res == -1) {
                    System.out.println("\nExclusão da venda sem produtos realizada");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(vendasModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList pesquisar(String nomeProduto) {
        abrirConexao();
        ArrayList lista = new ArrayList();
        String sql = "select * from produto where nome like '" + nomeProduto + "%';";
        ResultSet resultado = Banco.consultar(sql);
        try {
            while (resultado.next()) {
                produto prod = new produto();
                prod.setCodigo(resultado.getInt("codigo"));
                prod.setNome(resultado.getString("nome"));
                prod.setRendimento(resultado.getInt("rendimento"));
                prod.setValorCusto(resultado.getFloat("valor_custo"));
                prod.setValorUnitario(resultado.getFloat("valor_unitario"));
                prod.setIngredientes(resultado.getString("Ingredientes"));
                prod.setDescricao(resultado.getString("descricao"));
                lista.add(prod);
            }
            resultado.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(produtoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
