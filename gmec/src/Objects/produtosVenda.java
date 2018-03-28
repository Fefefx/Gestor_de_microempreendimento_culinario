/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author felipe
 */
public class produtosVenda {
    private int codigoProduto,codigoVenda,quantidade;
    private float totalProduto;

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public int getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(int codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getTotalProduto() {
        return totalProduto;
    }

    public void setTotalProduto(float totalProduto) {
        this.totalProduto = totalProduto;
    }

    public produtosVenda(int codigoProduto, int codigoVenda, int quantidade, float totalProduto) {
        this.codigoProduto = codigoProduto;
        this.codigoVenda = codigoVenda;
        this.quantidade = quantidade;
        this.totalProduto = totalProduto;
    }
    
}
