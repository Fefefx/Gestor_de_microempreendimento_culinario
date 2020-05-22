/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import java.util.ArrayList;
import Model.produtosEncomendaModel;

/**
 *
 * @author felip
 */
public class produtoEncomendaControl {
    public ArrayList localizarProdutos(int codigo){
        produtosEncomendaModel buscar= new produtosEncomendaModel();
        return buscar.pesquisar(codigo);
    }
}
