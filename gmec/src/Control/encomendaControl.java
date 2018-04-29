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
import Services.objetoPesquisa;

/**
 *
 * @author felip
 */
public class encomendaControl {

    public boolean verificarSalvar(encomenda enco) {
        ArrayList itens = eliminarRepetidos(enco.retornarItens());
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

    public ArrayList pesquisarEncomendas(objetoPesquisa dados) {
        String testar = dados.getCliente().replace(" ", "");
        if (testar.isEmpty()) {
            dados.setCliente(testar);
        }
        encomendaModel pesquisar = new encomendaModel();
        ArrayList validar = pesquisar.pesquisar(dados);
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

    public boolean atualizar(encomenda enco) {
        encomendaModel update = new encomendaModel();
        if (update.atualizar(enco)) {
            produtosEncomendaModel itens = new produtosEncomendaModel();
            if (itens.excluirTodos(enco.getCodigoEncomenda())) {
                ArrayList lista = eliminarRepetidos(enco.retornarItens());
                for (int i = 0; i < lista.size(); i++) {
                    produtosEncomenda item = (produtosEncomenda) lista.get(i);
                    item.setCodigoEncomenda(enco.getCodigoEncomenda());
                    if (!itens.inserir(item)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
    
    public ArrayList eliminarRepetidos(ArrayList lista){
        for(int i1=0;i1<lista.size();i1++){
            produtosEncomenda item1=(produtosEncomenda) lista.get(i1);
            for(int i2=(i1+1);i2<lista.size();i2++){
                produtosEncomenda item2=(produtosEncomenda) lista.get(i2);
                if(item1.getCodigoProduto()==item2.getCodigoProduto()){
                    item1.setQuantidade(item1.getQuantidade()+1);
                    item1.setTotalProduto(item1.getQuantidade()*item1.getValorUnitario());
                    lista.remove(i2);
                }
            }
        }
        return lista;
    }

}
