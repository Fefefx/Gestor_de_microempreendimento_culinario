/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.encomendaModel;
import Model.produtosEncomendaModel;
import Objects.encomenda;
import Objects.produtosEncomenda;
import java.util.ArrayList;

/**
 *
 * @author felip
 */
public class encomendaControl {

    public boolean verificarSalvar(encomenda enco) {
        ArrayList itens = enco.retornarItens();
        produtosEncomendaModel pem = new produtosEncomendaModel();
        if (!itens.isEmpty()) {
            encomendaModel salvar = new encomendaModel();
            salvar.inserir(enco);
            enco.setCodigoEncomenda(salvar.pesquisarCodigo(enco));
            for (int i = 0; i < itens.size(); i++) {
                produtosEncomenda pe = (produtosEncomenda) itens.get(i);
                pe.setCodigoEncomenda(enco.getCodigoEncomenda());
                pem.inserir(pe);
            }
            return true;
        }
        return false;
    }

    public ArrayList pesquisarEncomendas(String nome) {
        String testar = nome.replace(" ", "");
        if (testar.isEmpty()) {
            nome = testar;
        }
        encomendaModel pesquisar = new encomendaModel();
        ArrayList validar = pesquisar.pesquisar(nome);
        return validar;
    }

    public boolean excluir(encomenda enco) {
        encomendaModel deletarEncomenda = new encomendaModel();
        produtosEncomendaModel deletarItens = new produtosEncomendaModel();
        if (deletarItens.excluirTodos(enco.getCodigoEncomenda())) {
            return deletarEncomenda.excluir(enco.getCodigoEncomenda()); 
        }
        return false;
    }

}
