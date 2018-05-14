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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Services.objetoPesquisa;
import java.math.BigDecimal;
import java.math.RoundingMode;

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
        int valor, sit;
        //Troca o verdadeiro ou falso por 0 ou 1
        if (!enco.isStatus()) {
            valor = 0;
        } else {
            valor = 1;
        }
        if (!enco.isStatusPagamento()) {
            sit = 0;
        } else {
            sit = 1;
        }
        String sql = "insert into encomenda(dia_pedido,dia_entrega,total,cliente_idcliente,status_entrega,status_pagamento,endereco_entrega,observacoes)"
                + " values('" + enco.getDiaPedido() + "','" + enco.getDiaEntrega() + "','" + enco.getTotal()
                + "'," + enco.client.getIdCliente() + "," + valor + "," + sit + ",'" + enco.getEnderecoEntrega() + "','" + enco.getObservacoes() + "');";
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
        int valor, sit;
        //Troca o verdadeiro ou falso por 0 ou 1
        if (!enco.isStatus()) {
            valor = 0;
        } else {
            valor = 1;
        }
        if (!enco.isStatusPagamento()) {
            sit = 0;
        } else {
            sit = 1;
        }
        String sql = "update encomenda set dia_pedido='" + enco.getDiaPedido() + "',"
                + "dia_entrega='" + enco.getDiaEntrega() + "',total='" + enco.getTotal() + "',"
                + "cliente_idcliente=" + enco.client.getIdCliente()
                + ", status_entrega=" + valor
                + ", status_pagamento=" + sit
                + ", endereco_entrega='" + enco.getEnderecoEntrega() + "',"
                + "observacoes='" + enco.getObservacoes() + "'"
                + " where codigo=" + enco.getCodigoEncomenda() + ";";
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
                System.out.println("\nNão foi possível excluir a encomenda");
            } else {
                System.out.println("\nExclusão da encomenda realizada");
                return true;
            }
        }
        return false;
    }

    //listarEncomendas é uma view que reúne dados de produtos e encomendas
    public ArrayList pesquisar(objetoPesquisa dados) {
        abrirConexao();
        ArrayList lista = new ArrayList();
        String sql = "select * from listarEncomendas where nome like '" + dados.getCliente() + "%'"
                + " and dia_entrega >= '" + dados.getDiaAtual() + "' and dia_entrega <= '" + dados.getDiaLimite() + "';";
        System.out.println(sql);
        ResultSet resultado = Banco.consultar(sql);
        try {
            while (resultado.next()) {
                encomenda enco = new encomenda();
                enco.setCodigoEncomenda(resultado.getInt("codigo"));
                enco.setDiaEntrega(resultado.getString("dia_entrega"));
                enco.setDiaPedido(resultado.getString("dia_pedido"));
                enco.setTotal(resultado.getFloat("total"));
                enco.setStatus(resultado.getBoolean("status_entrega"));
                enco.client.setIdCliente(resultado.getInt("idcliente"));
                enco.client.setNome(resultado.getString("nome"));
                enco.client.setEndereco(resultado.getString("endereco"));
                enco.client.setTelefone(resultado.getInt("telefone"));
                enco.setStatusPagamento(resultado.getBoolean("status_pagamento"));
                enco.setEnderecoEntrega(resultado.getString("endereco_entrega"));
                enco.setObservacoes(resultado.getString("observacoes"));
                lista.add(enco);
            }
            resultado.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(encomendaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList pesquisar() {
        abrirConexao();
        ArrayList lista = new ArrayList();
        String sql = "select * from listarEncomendas;";
        System.out.println(sql);
        ResultSet resultado = Banco.consultar(sql);
        try {
            while (resultado.next()) {
                encomenda enco = new encomenda();
                enco.setCodigoEncomenda(resultado.getInt("codigo"));
                enco.setDiaEntrega(resultado.getString("dia_entrega"));
                enco.setDiaPedido(resultado.getString("dia_pedido"));
                enco.setTotal(resultado.getFloat("total"));
                enco.setStatus(resultado.getBoolean("status_entrega"));
                enco.client.setIdCliente(resultado.getInt("idcliente"));
                enco.client.setNome(resultado.getString("nome"));
                enco.client.setEndereco(resultado.getString("endereco"));
                enco.client.setTelefone(resultado.getInt("telefone"));
                enco.setStatusPagamento(resultado.getBoolean("status_pagamento"));
                enco.setEnderecoEntrega(resultado.getString("endereco_entrega"));
                enco.setObservacoes(resultado.getString("observacoes"));
                lista.add(enco);
            }
            resultado.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(encomendaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //Verifica se existem encomendas pendentes para o cliente 
    public boolean pesquisarEncomendasCliente(int idCliente) {
        abrirConexao();
        String sql = "select * from encomenda e where e.cliente_idcliente=" + idCliente + " and e.status_pagamento=false or e.status_entrega=false;";
        System.out.println(sql);
        ResultSet resultado = Banco.consultar(sql);
        try {
            if (resultado.next()) {
                System.out.println("\nEncomendas do cliente encontradas");
                return true;
            } else {
                System.out.println("\nNenhuma encomenda do cliente encontrada");
            }
        } catch (SQLException ex) {
            Logger.getLogger(encomendaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int pesquisarCodigo(encomenda enco) {
        abrirConexao();
        String sql = "select codigo from encomenda where dia_pedido='" + enco.getDiaPedido() + "' "
                + "and dia_entrega='" + enco.getDiaEntrega() + "' and cliente_idcliente=" + enco.client.getIdCliente()
                + " and status_entrega is " + enco.isStatus() + " and  status_pagamento is " + enco.isStatusPagamento()
                + " and endereco_entrega='" + enco.getEnderecoEntrega() + "' and observacoes='" + enco.getObservacoes() + "';";
        System.out.println(sql);
        ResultSet resultado = Banco.consultar(sql);
        try {
            if (resultado.next()) {
                int codigo = resultado.getInt("codigo");
                return codigo;
            } else {
                System.out.println("\nNenhuma encomenda do cliente encontrada");
            }
        } catch (SQLException ex) {
            Logger.getLogger(encomendaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    //verifica se um determinado produto possui uma encomenda em aberto
    public boolean verificarProdutoNasEncomendas(int codigoProduto) {
        abrirConexao();
        String sql = "select * from produtos_da_encomenda pe inner join encomenda"
                + " e on pe.encomenda_codigo=e.codigo where e.status_pagamento=false or e.status_entrega=false and pe.produto_codigo="
                + codigoProduto + ";";
        System.out.println(sql);
        ResultSet resultado = Banco.consultar(sql);
        try {
            if (resultado.next()) {
                System.out.println("\nEncomendas com o produto encontradas");
                return true;
            } else {
                System.out.println("\nNenhuma encomenda com o produto encontrada");
            }
        } catch (SQLException ex) {
            Logger.getLogger(encomendaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //Retorna a quantidade de encomendas nos próximos 3 dias
    public int qtdEncomendas() {
        abrirConexao();
        String sql = "select count(*) 'Qtd' from encomenda where dia_entrega>=curdate() and dia_entrega <= curdate()+3 and status_entrega is false;";
        System.out.println(sql);
        ResultSet dado = Banco.consultar(sql);
        try {
            if (dado.next()) {
                return dado.getInt("Qtd");
            }
        } catch (SQLException ex) {
            Logger.getLogger(encomendaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public String relatorio_Encomendas(String ini, String fim) {
        abrirConexao();
        int qtd_encomendas = 0;
        String sql = "select Count(*) 'qtd_encomendas',sum(total) 'total', avg(total) 'media' from encomenda "
                + "where dia_pedido >= '" + ini + "' and dia_pedido <= '" + fim + "';";
        System.out.println(sql);
        String valor = "";
        ResultSet resultado = Banco.consultar(sql);
        try {
            if (resultado.next()) {
                qtd_encomendas = resultado.getInt("qtd_encomendas");
                float total = resultado.getFloat("total");
                BigDecimal arredondar = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);
                total = arredondar.floatValue();
                float media = resultado.getFloat("media");
                arredondar = new BigDecimal(media).setScale(2, RoundingMode.HALF_UP);
                media = arredondar.floatValue();
                valor = "Quantidade de encomendas: " + qtd_encomendas + "\nTotal: " + total + "\nMédia: " + media + " \n";
            }
        } catch (SQLException ex) {
            System.out.println("Erro na primeira instrução sql: " + ex);
            return "";
        }
        if (qtd_encomendas != 0) {
            sql = "select max(qtd)'max_dia',dia_semana from (select count(*)'qtd', Date_format(dia_pedido,'%w')'dia_semana' from encomenda "
                    + "where dia_pedido >= '" + ini + "' and dia_pedido <='" + fim + "' group by dia_semana) as temp; ";
            System.out.println(sql);
            ResultSet rs = Banco.consultar(sql);
            try {
                if (rs.next()) {
                    String dia;
                    int dia_semana = rs.getInt("dia_semana");
                    switch (dia_semana) {
                        case 0:
                            dia = "Domingo";
                            break;
                        case 1:
                            dia = "Segunda";
                            break;
                        case 2:
                            dia = "Terça";
                            break;
                        case 3:
                            dia = "Quarta";
                            break;
                        case 4:
                            dia = "Quinta";
                            break;
                        case 5:
                            dia = "Sexta";
                            break;
                        case 6:
                            dia = "Sábado";
                            break;
                        default:
                            dia = "dia inválido";
                    }
                    String max_dia = rs.getString("max_dia");
                    valor = valor + "Dia da semana com mais encomendas: " + dia + "\nQuantidade: " + max_dia + " \n";
                }
            } catch (SQLException ex) {
                System.out.println("Erro na segunda instrução sql: " + ex);
                return "";
            }
        }
        return valor;
    }
}
