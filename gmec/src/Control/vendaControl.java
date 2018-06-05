/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Objects.vendas;
import Objects.produtosVenda;
import Model.vendasModel;
import Model.produtosVendaModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Date;

/**
 *
 * @author Beth
 */
public class vendaControl {

    public boolean verificarItens(vendas venda) {
        if (venda.retornarItens().isEmpty()) {
            return false;
        }
        return true;
    }

    public ArrayList validarDataPesquisa(String data) {
        vendasModel vendaModel = new vendasModel();
        return vendaModel.pesquisarData(data);
    }

    public boolean dataValida(String data) {
        String teste = data.replace(" ", "");
        if (!teste.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean salvarVenda(vendas vender) {
        boolean check = false;
        vender.adicionarItens(eliminarRepetidos(vender.retornarItens()));
        if (dataValida(vender.getDataVenda())) {
            vendasModel salvaVenda = new vendasModel();
            salvaVenda.inserir(vender);
            ArrayList itens = vender.retornarItens();
            vendas registro = salvaVenda.pesquisar(vender.getDataVenda());
            for (int i = 0; i < itens.size(); i++) {
                produtosVenda item = (produtosVenda) itens.get(i);
                item.setCodigoVenda(registro.getCodigo());
                produtosVendaModel salvaItem = new produtosVendaModel();
                if (salvaItem.inserir(item)) {
                    check = true;
                }
            }
            return check;
        }
        return false;
    }

    public boolean atualizaVenda(vendas vender) {
        boolean check = false;
        vender.adicionarItens(eliminarRepetidos(vender.retornarItens()));
        if (dataValida(vender.getDataVenda())) {
            vendasModel atualizaVenda = new vendasModel();
            produtosVendaModel pv = new produtosVendaModel();
            atualizaVenda.atualizar(vender);
            ArrayList itens = vender.retornarItens();
            if (pv.excluirTodos(vender.getCodigo())) {
                for (int i = 0; i < itens.size(); i++) {
                    produtosVenda item = (produtosVenda) itens.get(i);
                    produtosVendaModel salvaItem = new produtosVendaModel();
                    if (salvaItem.inserir(item)) {
                        check = true;
                    }
                }
                return check;
            }
        }
        return false;
    }

    public ArrayList formatarData(Date dataInicial, Date dataFinal) {
        SimpleDateFormat formatar = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String dataIni = formatar.format(dataInicial);
            formatar = new SimpleDateFormat("yyyy-MM-dd");
            String dataFim = formatar.format(dataFinal);
            vendasModel buscar = new vendasModel();
            return buscar.pesquisarIntervalo(dataIni, dataFim);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Selecione datas válidas");
        }
        return null;
    }

    public ArrayList devolverTudo() {
        vendasModel buscar = new vendasModel();
        return buscar.retornarTudo();
    }

    public boolean excluirVenda(int codigo) {
        vendasModel deletar = new vendasModel();
        return deletar.excluir(codigo);
    }
    //Corrigi o erro. Era int i2=0, desse jeito o item1 compara consigo mesmo no if e elimina-se da lista !
    public ArrayList eliminarRepetidos(ArrayList lista) {
        for (int i1 = 0; i1 < lista.size(); i1++) {
            produtosVenda item1 = (produtosVenda) lista.get(i1);
            for (int i2 = (i1+1); i2 < lista.size(); i2++) {
                produtosVenda item2 = (produtosVenda) lista.get(i2);
                if (item1.getCodigoProduto() == item2.getCodigoProduto()) {
                    item1.setQuantidade(item1.getQuantidade() + item2.getQuantidade());
                    item1.setTotalProduto(item1.getValorUnitario() * item1.getQuantidade());
                    lista.remove(i2);
                    i2--; //corrige problema de redimensionamento da lista.
                }
            }
        }
        return lista;
    }

    public void printList(ArrayList lista) {
        System.out.println("Lista de produtos");
        for (int i = 0; i < lista.size(); i++) {
            produtosVenda item = (produtosVenda) lista.get(i);
            System.out.println("Item[" + (i + 1) + "]: " + item.getNome() + " Qtd: " + item.getQuantidade() + " preço: " + item.getValorUnitario()
                    + " total: " + item.getTotalProduto() + " codigo: " + item.getCodigoProduto());
        }
    }

}
