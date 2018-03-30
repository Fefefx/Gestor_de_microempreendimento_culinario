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
    private int codigoEncomenda,codigoCliente;
    private float total; 
    private Date diaPedido, diaEntrega;
    ArrayList encomendaProdutos= new ArrayList();// Produtos da encomenda

    public int getCodigoEncomenda() {
        return codigoEncomenda;
    }

    public void setCodigoEncomenda(int codigoEncomenda) {
        this.codigoEncomenda = codigoEncomenda;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getDiaPedido() {
        return diaPedido;
    }

    public void setDiaPedido(Date diaPedido) {
        this.diaPedido = diaPedido;
    }

    public Date getDiaEntrega() {
        return diaEntrega;
    }

    public void setDiaEntrega(Date diaEntrega) {
        this.diaEntrega = diaEntrega;
    }

    public encomenda(int codigoEncomenda, int codigoCliente, float total, Date diaPedido, Date diaEntrega) {
        this.codigoEncomenda = codigoEncomenda;
        this.codigoCliente = codigoCliente;
        this.total = total;
        this.diaPedido = diaPedido;
        this.diaEntrega = diaEntrega;
    }
    
}
