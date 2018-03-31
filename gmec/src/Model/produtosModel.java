/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Bank.Conexao;
import Bank.infoBanco;
import Objects.produtos;
import javax.swing.JOptionPane;

/**
 *
 * @author felipe
 */
public class produtosModel {
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

    public boolean inserir(produtos prod) {
        abrirConexao();
        String sql = "insert into produto(nome,rendimento,valor_custo,valor_unitario,Ingredientes,descricao) values('"
                    +prod.getNome()+"',"+prod.getRendimento()+",'"+prod.getValorCusto()+"','"+prod.getValorUnitario()+"','"
                    +prod.getIngredientes()+"','"+prod.getDescricao()+"');";
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

    public boolean atualizar(produtos prod) {
        abrirConexao();
        String sql = "update produto set nome='"+prod.getNome()+"',rendimento="+prod.getRendimento()+","
                    +"valor_custo='"+prod.getValorCusto()+"',valor_unitario='"+prod.getValorUnitario()+"',"
                    +"Ingredientes='"+prod.getIngredientes()+"',descricao='"+prod.getDescricao()+"'"
                    +" where codigo="+prod.getCodigo()+";";
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

    public boolean excluir(produtos prod) {
        abrirConexao();
        String sql = "delete from produto where codigo="+prod.getCodigo()+";";
        System.out.println(sql);
        //deletar das tabelas de muitos para muitos
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
