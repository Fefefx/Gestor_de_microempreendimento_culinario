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
import java.util.ArrayList;
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
            System.out.println("\nNão foi possível inserir o produto "+itens.getNome()+" na encomenda.");
        } else {
            System.out.println("\n"+itens.getNome()+" inserido na encomenda com sucesso");
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
            System.out.println("\nNão foi possível atualizar o produto "+itens.getNome());
        } else {
            System.out.println("\nAtualização do produto "+itens.getNome()+" realizada com sucesso");
            return true;
        }
        return false;
    }

    //Exclui apenas UM produto da encomenda
    public boolean excluir(int codigoEncomenda, int codigoProduto) {
        abrirConexao();
        String sql = "delete from produtos_da_encomenda where encomenda_codigo=" + codigoEncomenda 
                    + " and produto_codigo="+codigoProduto+";";
        System.out.println(sql);
        int res = Banco.manipular(sql);
        if (res == -1) {
            System.out.println("\nNão foi possível excluir o produto da encomenda");
        } else {
            System.out.println("\nRemoção do produto realizada");
            return true;
        }
        return false;
    }
    
    //Exclui TODOS os produtos de uma encomenda    
    public boolean excluirTodos(int codigoEncomenda) {
        abrirConexao();
        String sql = "delete from produtos_da_encomenda where encomenda_codigo=" + codigoEncomenda+";";
        System.out.println(sql);
        int res = Banco.manipular(sql);
        if (res == -1) {
            System.out.println("\nNão foi possível excluir todos os produtos da encomenda");
        } else {
            System.out.println("\nRemoção dos produtos realizada");
            return true;
        }
        return false;
    }
    
    //Exclui TODOS os registros de UM produto nas ENCOMENDAS
    public boolean excluirRegistro(int codigoProduto){
        abrirConexao();
        String sql = "delete from produtos_da_encomenda where produto_codigo=" + codigoProduto+";";
        System.out.println(sql);
        int res = Banco.manipular(sql);
        if (res == -1) {
            System.out.println("\nNão foi possível excluir todos os registros do produto");
        } else {
            System.out.println("\nRemoção do produto realizada");
            return true;
        }
        return false;
    }

    // produtosEncomenda é uma view que junta os dados de produtos_da_encomenda e produto
    public ArrayList pesquisar(int codigoEncomenda) {
        abrirConexao();
        ArrayList lista = new ArrayList();
        String sql = "select * from produtosEncomenda where encomenda_codigo=" + codigoEncomenda + ";";
        System.out.println(sql);
        ResultSet registro = Banco.consultar(sql);
        try {
            while (registro.next()) {
                produtosEncomenda prod= new produtosEncomenda();
                prod.setNome(registro.getString("nome"));
                prod.setCodigoEncomenda(registro.getInt("encomenda_codigo"));
                prod.setCodigoProduto(registro.getInt("codigo"));
                prod.setQuantidade(registro.getInt("quantidade"));
                prod.setTotalProduto(registro.getFloat("total_produto"));
                prod.setValorUnitario(registro.getFloat("valor_unitario"));
                lista.add(prod);
            }
            registro.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(produtosEncomendaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
