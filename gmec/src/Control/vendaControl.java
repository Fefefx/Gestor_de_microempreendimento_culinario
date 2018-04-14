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
        boolean check=false;
        if (dataValida(vender.getDataVenda())) {
            vendasModel atualizaVenda = new vendasModel();
            produtosVendaModel pv = new produtosVendaModel();
            atualizaVenda.atualizar(vender);
            ArrayList itens = vender.retornarItens();
            if (pv.excluirTodos(vender.getCodigo())) {
                for (int i = 0; i < itens.size(); i++) {
                    produtosVenda item = (produtosVenda) itens.get(i);
                    produtosVendaModel salvaItem = new produtosVendaModel();
                    if(salvaItem.inserir(item)){
                        check=true;
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
    
    public boolean excluirVenda(int codigo){
        vendasModel deletar= new vendasModel();
        return deletar.excluir(codigo);
    }
}
