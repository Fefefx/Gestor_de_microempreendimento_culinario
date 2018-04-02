/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Bank.Conexao;
import Bank.infoBanco;
import Objects.encomenda;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        int valor;
        //Troca o verdadeiro ou falso por 0 ou 1
        if(!enco.isStatus())
            valor=0;
        else
            valor=1;
        String sql = "insert into encomenda(dia_pedido,dia_entrega,total,cliente_idcliente,status)"
                + " values('" + enco.getDiaPedido() + "','" + enco.getDiaEntrega() + "','" + enco.getTotal()
                + "'," + enco.client.getIdCliente() + ","+valor+");";
        System.out.println(sql);
        int res = Banco.manipular(sql);
        if (res == -1) {
            JOptionPane.showMessageDialog(null, "Não foi possível inserir a encomenda");
        } else {
            JOptionPane.showMessageDialog(null, "Encomenda inserida com sucesso");
            return true;
        }
        return false;
    }

    public boolean atualizar(encomenda enco) {
        abrirConexao();
        int valor;
        //Troca o verdadeiro ou falso por 0 ou 1
        if(!enco.isStatus())
            valor=0;
        else
            valor=1;
        String sql = "update encomenda set dia_pedido='" + enco.getDiaPedido() + "',"
                + "dia_entrega='" + enco.getDiaEntrega() + "',total='" + enco.getTotal() + "',"
                + "cliente_idcliente=" + enco.client.getIdCliente() 
                + ", status="+valor+" where codigo=" + enco.getCodigoEncomenda() + ";";
        System.out.println(sql);
        int res = Banco.manipular(sql);
        if (res == -1) {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar a encomenda");
        } else {
            JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso");
            return true;
        }
        return false;
    }

    //Exclui UMA encomenda em específico 
    public boolean excluir(int codigo) {
        abrirConexao();
        String sql = "delete from encomenda where codigo=" + codigo + ";";
        System.out.println(sql);
        //Exclui primeiro os itens da venda para então exclui-la
        produtosEncomendaModel itens = new produtosEncomendaModel();
        if (itens.excluirTodos(codigo)) {
            int res = Banco.manipular(sql);
            if (res == -1) {
                JOptionPane.showMessageDialog(null, "Não foi possível excluir a encomenda");
            } else {
                JOptionPane.showMessageDialog(null, "Exclusão da encomenda realizada");
                return true;
            }
        }
        return false;
    }

    //Exclui todas as encomendas de um cliente
    public boolean excluirEncomendasCliente(int codigoCliente) {
        abrirConexao();
        String sql = "delete from encomenda where cliente_idcliente=" + codigoCliente + ";";
        System.out.println(sql);
        //Exclui primeiro os itens da encomenda para então exclui-la
        produtosEncomendaModel itens = new produtosEncomendaModel();
        if (itens.excluirTodos(codigoCliente)) {
            int res = Banco.manipular(sql);
            if (res == -1) {
                JOptionPane.showMessageDialog(null, "Não foi possível excluir a encomenda");
            } else {
                JOptionPane.showMessageDialog(null, "Exclusão da encomenda realizada");
                return true;
            }
        }
        return false;
    }
    
    //listarEncomendas é uma view que reúne dados de produtos e encomendas
    public ResultSet pesquisar(String clienteEncomenda){
        abrirConexao();
        String sql="select * from listarEncomendas where nome like '"+clienteEncomenda+"%';";
        ResultSet resultado=Banco.consultar(sql);
        try {
            if(resultado.next()){
                System.out.println("\nEncomenda encontradas");
                return resultado;  //No retorno o status virá como 0 ou 1, tratar com if para verdade ou falso
            }
            else
                JOptionPane.showMessageDialog(null,"Nenhuma encomenda encontrada");
        } catch (SQLException ex) {
            Logger.getLogger(encomendaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}