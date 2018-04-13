/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author felipe
 */
public class encomenda {

    private int codigoEncomenda;
    private float total;
    private String diaPedido, diaEntrega;
    private boolean status;
    ArrayList encomendaProdutos = new ArrayList();// Produtos da encomenda
    public cliente client = new cliente();  //Dono da encomenda

    public int getCodigoEncomenda() {
        return codigoEncomenda;
    }

    public void setCodigoEncomenda(int codigoEncomenda) {
        this.codigoEncomenda = codigoEncomenda;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getDiaPedido() {
        return diaPedido;
    }

    public void setDiaPedido(String diaPedido) {
        this.diaPedido = diaPedido;
    }

    public String getDiaEntrega() {
        return diaEntrega;
    }

    public void setDiaEntrega(String diaEntrega) {
        this.diaEntrega = diaEntrega;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void addItem(produtosEncomenda elemento) {
        encomendaProdutos.add(elemento);
    }

    public ArrayList retornarItens() {
        return encomendaProdutos;
    }

    public void adicionarItens(ArrayList itens) {
        encomendaProdutos = itens;
    }

}
