/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author felipe
 */
public class vendas {
    private int codigo;
    private String dataVenda;
    private float total;
    ArrayList vendaProdutos=new ArrayList(); //lista com os produtos da venda
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public vendas() {
        
    }
    
    public void adicionarItens(ArrayList itens){
        while(vendaProdutos.size()!=0) 
            vendaProdutos.remove(0);
        vendaProdutos=itens;
    }
    
    public ArrayList retornarItens(){
        return vendaProdutos;
    } 
    
    public void addItem(produtosVenda elemento){
        vendaProdutos.add(elemento);
    }
}
