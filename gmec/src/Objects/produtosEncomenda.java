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
    private int quantidade, codigoProduto,codigoEncomenda;
    private float totalProduto,valorUnitario;
    private String nome;

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

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public int getCodigoEncomenda() {
        return codigoEncomenda;
    }

    public void setCodigoEncomenda(int codigoEncomenda) {
        this.codigoEncomenda = codigoEncomenda;
    }
         
}
