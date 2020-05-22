/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.produtosVendaModel;
import java.util.ArrayList;

/**
 *
 * @author felip
 */
public class produtoVendaControl {

    produtosVendaModel buscarItens = new produtosVendaModel();

    public ArrayList itensVenda(int codigo) {
        return buscarItens.pesquisar(codigo);
    }
}
