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
public class produtosEncomenda {
    private int codigoEncomenda,codigoProduto,quantidade;
    private float totalProduto;

    public int getCodigoEncomenda() {
        return codigoEncomenda;
    }

    public void setCodigoEncomenda(int codigoEncomenda) {
        this.codigoEncomenda = codigoEncomenda;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
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

    public produtosEncomenda(int codigoEncomenda, int codigoProduto, int quantidade, float totalProduto) {
        this.codigoEncomenda = codigoEncomenda;
        this.codigoProduto = codigoProduto;
        this.quantidade = quantidade;
        this.totalProduto = totalProduto;
    }
}
