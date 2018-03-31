/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Bank.Conexao;
import Bank.infoBanco;
import Objects.vendas;
import javax.swing.JOptionPane;

/**
 *
 * @author felipe
 */
public class vendasModel {
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

    public boolean inserir(vendas vend) {
        abrirConexao();
        String sql = "insert into vendas(data_venda,total) values('"+vend.getDataVenda()+"','"
                    +vend.getTotal()+"');";
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

    public boolean atualizar(vendas vend) {
        abrirConexao();
        String sql = "update vendas set data_venda='"+vend.getDataVenda()+"',total='"+vend.getTotal()+"'"
                    +" where codigo="+vend.getCodigo()+";";
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
        String sql = "delete from vendas where codigo="+codigo+";";
        System.out.println(sql);
        //deletar os produtos da venda
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
