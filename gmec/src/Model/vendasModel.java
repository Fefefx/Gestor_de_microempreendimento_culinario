/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Bank.Conexao;
import Bank.infoBanco;
import Objects.vendas;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
    public vendas pesquisar(String dia) {
        abrirConexao();
        String sql = "select * from vendas where data_venda='" + dia + "';";
        ResultSet resultado = Banco.consultar(sql);
        try {
            if (resultado.next()) {
                vendas res = new vendas();
                res.setCodigo(Integer.parseInt(resultado.getString("codigo")));
                res.setDataVenda(resultado.getString("data_venda"));
                res.setTotal(Float.parseFloat(resultado.getString("total")));
                return res;
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma venda localizada para o dia");
            }
        } catch (SQLException ex) {
            Logger.getLogger(vendasModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList pesquisarData(String dia) {
        abrirConexao();
        ArrayList lista = new ArrayList();
        String sql = "select * from vendas where data_venda='" + dia + "';";
        ResultSet resultado = Banco.consultar(sql);
        try {
            if (resultado.next()) {
                vendas venda = new vendas();
                venda.setCodigo(Integer.parseInt(resultado.getString("codigo")));
                venda.setDataVenda(resultado.getString("data_venda"));
                venda.setTotal(Float.parseFloat(resultado.getString("total")));
                lista.add(venda);
                resultado.close();
                return lista;
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma venda localizada para o dia");
            }
        } catch (SQLException ex) {
            Logger.getLogger(vendasModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList pesquisarIntervalo(String Ini, String Fim) {
        abrirConexao();
        ArrayList lista = new ArrayList();
        String sql = "select * from vendas where data_venda>='" + Ini + "' and data_venda<='" + Fim + "';";
        System.out.println("\n" + sql);
        ResultSet resultado = Banco.consultar(sql);
        try {
            while (resultado.next()) {
                vendas venda = new vendas();
                venda.setCodigo(Integer.parseInt(resultado.getString("codigo")));
                venda.setDataVenda(resultado.getString("data_venda"));
                venda.setTotal(Float.parseFloat(resultado.getString("total")));
                lista.add(venda);
            }
            resultado.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(vendasModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList retornarTudo() {
        abrirConexao();
        ArrayList lista = new ArrayList();
        String sql = "select * from vendas;";
        System.out.println("\n" + sql);
        ResultSet resultado = Banco.consultar(sql);
        try {
            while (resultado.next()) {
                vendas venda = new vendas();
                venda.setCodigo(Integer.parseInt(resultado.getString("codigo")));
                venda.setDataVenda(resultado.getString("data_venda"));
                venda.setTotal(Float.parseFloat(resultado.getString("total")));
                lista.add(venda);
            }
            resultado.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(vendasModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String relatorio_Vendas(String ini, String fim) {
        abrirConexao();
        int qtd=0;
        String valor = "";
        String sql = "select Count(*) 'qtd',sum(total) 'total',avg(total) 'media' from vendas "
                + "where data_venda >= '" + ini + "' and data_venda <= '" + fim + "';";
        ResultSet resultado = Banco.consultar(sql);
        try {
            if (resultado.next()) {
                qtd = resultado.getInt("qtd");
                float total = resultado.getFloat("total");
                BigDecimal arredondar = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);
                total = arredondar.floatValue();
                float media = resultado.getFloat("media");
                arredondar = new BigDecimal(media).setScale(2, RoundingMode.HALF_UP);
                media = arredondar.floatValue();
                valor = "Quantidade de vendas efetuadas: " + qtd + "\nTotal:" + total + "\nMedia:" + media + "\n";
            }
        } catch (SQLException ex) {
            System.out.println("Erro na primeira instrução sql: " + ex);
            return "";
        }
        if (qtd != 0) {
            sql = "select max(qtd)'max_dia',dia_semana from (select count(*)'qtd', Date_format(data_venda,'%w')'dia_semana' from vendas "
                    + "where data_venda >= '" + ini + "' and data_venda <= '" + fim + "' group by data_venda) as temp; ";
            ResultSet rs = Banco.consultar(sql);
            try {
                if (rs.next()) {
                    String dia;
                    int max_dia = rs.getInt("max_dia");
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
                            dia = "Não foi possível estimar";
                    }
                    valor = valor + "Dia da semana com mais vendas: " + dia + "\nQuantidade de vendas: " + max_dia;
                }
            } catch (SQLException ex) {
                System.out.println("Erro na segunda instrução sql: " + ex);
                return "";
            }
            return valor;
        }
        return valor;
    }
}
