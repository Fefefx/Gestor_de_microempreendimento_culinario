/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Objects.produto;
import Model.produtoModel;
import javax.swing.JOptionPane;

/**
 *
 * @author felipe
 */
public class produtoControl {

    /*Última função a ser chamada, valida os campos de texto e com base no valor do código executa inset ou 
    update */
    public void validarCamposTexto(produto prod) {
        if ("".equals(prod.getNome())) {
            JOptionPane.showMessageDialog(null, "Digite um nome");
        } else if ("".equals(prod.getDescricao())) {
            JOptionPane.showMessageDialog(null, "Digite uma descrição");
        } else if ("".equals(prod.getIngredientes())) {
            JOptionPane.showMessageDialog(null, "Digite os ingredientes do produto");
        } else {
            produtoModel prodModel = new produtoModel();
            if (prod.getCodigo() == 0) {
                prodModel.inserir(prod);
            } else {
                prodModel.atualizar(prod);
            }
        }
    }
    
    //Valida se o inteiro digitado é válido
    public boolean validarRendimento(String rendimento){
        try{
            int render=Integer.parseInt(rendimento);
            if(render > 0)
                return true;
            else
                JOptionPane.showMessageDialog(null,"Valor inválido para rendimento");
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Digite apenas números no campo rendimento");
        }
        return false;
    }
    //valida os valores e retorna um vetor de string com cada palavra tendo ponto no lugar de vírgula
    public String[] validarValores(String valorCusto, String valorUnitario){
        if(valorCusto.contains(","))
           valorCusto.replace(",",".");
        if(valorUnitario.contains(","))
            valorUnitario.replace(",",".");
        System.out.println("\nC: "+valorCusto+" U:"+valorUnitario);
        try{
            float Custo=Float.parseFloat(valorCusto);
            float Unidade=Float.parseFloat(valorUnitario);
            if(Custo <= 0){
                JOptionPane.showMessageDialog(null,"Digite um valor custo válido");
                return null;
            }
            if(Unidade <= 0){
                JOptionPane.showMessageDialog(null,"Digite um valor unitário válido");
                return null;
            }
            String[] vetor= new String[2];
            vetor[0]=valorCusto;
            vetor[1]=valorUnitario;
            return vetor;
        }catch(NumberFormatException e){
           JOptionPane.showMessageDialog(null,"Digite apenas números, ponto ou vírgula para os valores");
        }
        return null;
    }

}
