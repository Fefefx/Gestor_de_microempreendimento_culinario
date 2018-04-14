/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Bank.Conexao;
import Bank.infoBanco;
import Objects.vendas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        String sql = "insert into vendas(data_venda,total) values('" + vend.getDataVenda() + "','"
                + vend.getTotal() + "');";
        System.out.println(sql);
        int res = Banco.manipular(sql);
        if (res == -1) {
            JOptionPane.showMessageDialog(null, "Não foi possível inserir a venda");
        } else {
            JOptionPane.showMessageDialog(null, "Venda inserida com sucesso");
            return true;
        }
        return false;
    }

    public boolean atualizar(vendas vend) {
        abrirConexao();
        String sql = "update vendas set data_venda='" + vend.getDataVenda() + "',total='" + vend.getTotal() + "'"
                + " where codigo=" + vend.getCodigo() + ";";
        System.out.println(sql);
        int res = Banco.manipular(sql);
        if (res == -1) {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar a venda");
        } else {
            JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso");
            return true;
        }
        return false;
    }

    public boolean excluir(int codigo) {
        abrirConexao();
        String sql = "delete from vendas where codigo=" + codigo + ";";
        System.out.println(sql);
        //Exclui primeiro os produtos da venda para então exclui-la
        produtosVendaModel itens = new produtosVendaModel();
        if (itens.excluirTodos(codigo)) {
            int res = Banco.manipular(sql);
            if (res == -1) {
                JOptionPane.showMessageDialog(null, "Não foi possível excluir a venda");
            } else {
                JOptionPane.showMessageDialog(null, "Exclusão da venda realizada");
                return true;
            }
        }
        return false;
    }
    //Retorna dados de uma venda
    public vendas pesquisar(String dia){
        abrirConexao();
        String sql="select * from vendas where data_venda='"+dia+"';";
        ResultSet resultado=Banco.consultar(sql);
        try {
            if(resultado.next()){
                vendas res = new vendas();
                res.setCodigo(Integer.parseInt(resultado.getString("codigo")));
                res.setDataVenda(resultado.getString("data_venda"));
                res.setTotal(Float.parseFloat(resultado.getString("total")));
                return res;
            }else
                JOptionPane.showMessageDialog(null,"Nenhuma venda localizada para o dia");
        } catch (SQLException ex) {
            Logger.getLogger(vendasModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList pesquisarData(String dia){
        abrirConexao();
        ArrayList lista=new ArrayList();
        String sql="select * from vendas where data_venda='"+dia+"';";
        ResultSet resultado=Banco.consultar(sql);
        try {
            if(resultado.next()){
                vendas venda = new vendas();
                venda.setCodigo(Integer.parseInt(resultado.getString("codigo")));
                venda.setDataVenda(resultado.getString("data_venda"));
                venda.setTotal(Float.parseFloat(resultado.getString("total")));
                lista.add(venda);
                resultado.close();
                return lista;
            }else
                JOptionPane.showMessageDialog(null,"Nenhuma venda localizada para o dia");
        } catch (SQLException ex) {
            Logger.getLogger(vendasModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
