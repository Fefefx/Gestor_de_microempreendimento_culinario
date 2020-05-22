/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.encomendaModel;
import Objects.produto;
import Model.produtoModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author felipe
 */
public class produtoControl {

    /*Última função a ser chamada, valida os campos de texto e com base no valor do código executa insert ou 
    update */
    public boolean validarCamposTexto(produto prod) {
        if ("".equals(prod.getNome().trim())) {
            JOptionPane.showMessageDialog(null, "Digite um nome");
            return false;
        }
        if ("".equals(prod.getDescricao().trim())) {
            JOptionPane.showMessageDialog(null, "Digite uma descrição");
            return false;
        }
        if ("".equals(prod.getIngredientes().trim())) {
            JOptionPane.showMessageDialog(null, "Digite os ingredientes do produto");
            return false;
        } else {
            produtoModel prodModel = new produtoModel();
            if (prod.getCodigo() == 0) {
                prodModel.inserir(prod);
            } else {
                prodModel.atualizar(prod);
            }
            return true;
        }
    }

    //Valida se o inteiro digitado é válido
    public boolean validarRendimento(String rendimento) {
        try {
            int render = Integer.parseInt(rendimento);
            if (render > 0) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Valor inválido para rendimento");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Digite apenas números no campo rendimento");
        }
        return false;
    }

    //valida os valores e retorna um vetor de string com cada palavra tendo ponto no lugar de vírgula
    public String[] validarValores(String valorCusto, String valorUnitario, int rendimento) {
        String[] valor = new String[2];
        valor[0] = "NULO";
        valor[1] = "NULO";
        if (valorCusto.contains(",")) {
            valorCusto = valorCusto.replace(",", ".");
        }
        if (valorUnitario.contains(",")) {
            valorUnitario = valorUnitario.replace(",", ".");
        }
        System.out.println("\nC: " + valorCusto + " U:" + valorUnitario);
        try {
            float Custo = Float.parseFloat(valorCusto);
            float Unidade = Float.parseFloat(valorUnitario);
            if (Custo <= 0) {
                JOptionPane.showMessageDialog(null, "Digite um valor custo válido");
                return valor;
            }
            if (Unidade <= 0) {
                JOptionPane.showMessageDialog(null, "Digite um valor unitário válido");
                return valor;
            }
            if (Custo > (Unidade * rendimento)) {
                JOptionPane.showMessageDialog(null, "Digite um valor unitário maior que o custo, ou sairá no prejuízo");
                return valor;
            } else {
                System.out.println(Unidade+" * "+rendimento+" = "+(Unidade*rendimento));
                valor[0] = valorCusto;
                valor[1] = valorUnitario;
                return valor;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Digite números, ponto ou vírgula para os valores");
        }
        return valor;
    }

    public ArrayList validarNomePesquisa(String nome) {
        produtoModel prodModel = new produtoModel();
        return prodModel.pesquisar(nome);
    }
    
    public boolean validaProduto (String valor){
        if("".equals(valor.trim()))
            JOptionPane.showMessageDialog(null," Digite um produto");
        else
            return true;
        return false;
    }

    public int excluir(int codigo) {
        int res;
        produtoModel prodModel = new produtoModel();
        encomendaModel encomodel = new encomendaModel();
        if (encomodel.verificarProdutoNasEncomendas(codigo)) {
            res = JOptionPane.showConfirmDialog(null, "Foram encontradas encomendas em aberto contendo o seguinte produto. Deseja exclui-lo?");
            if (res == 0) {
                prodModel.excluir(codigo);
            }
        } else {
            res = JOptionPane.showConfirmDialog(null, "Deseja excluir o produto ?");
            if (res == 0) {
                prodModel.excluir(codigo);
            }
        }
        return res;
    }
}
