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
public class vendas {
    private int codigo;
    private Date dataVenda;
    private float total;
    ArrayList vendaProdutos=new ArrayList(); //lista com os produtos da venda
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public vendas(int codigo, Date dataVenda, float total) {
        this.codigo = codigo;
        this.dataVenda = dataVenda;
        this.total = total;
    }
}
