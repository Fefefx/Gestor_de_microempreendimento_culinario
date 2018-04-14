/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import Objects.vendas;
import Objects.produtosVenda;
import Model.vendasModel;
import Model.produtosVendaModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author Beth
 */
public class vendaControl {
    
    public boolean verificarItens(vendas venda){
        if(venda.retornarItens().isEmpty()){
            return false;
        }
        return true;
    }
    
    public ArrayList validarDataPesquisa(String data) {
        vendasModel vendaModel = new vendasModel();
        return vendaModel.pesquisarData(data);
    }
    
    public boolean dataValida(String data){
        String testar= data.replace("-","");
        try{
            int tentar = Integer.parseInt(testar);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Digite apenas numeros na data");
        }
        return false;
    }
    
    public boolean salvarVenda(vendas vender){
        vendasModel salvaVenda=new vendasModel();
        salvaVenda.inserir(vender);
        ArrayList itens= vender.retornarItens();
        vendas registro= salvaVenda.pesquisar(vender.getDataVenda());
        for(int i=0;i<itens.size();i++){
            produtosVenda item= (produtosVenda) itens.get(i);
            item.setCodigoVenda(registro.getCodigo());
            produtosVendaModel salvaItem= new produtosVendaModel();
            if(salvaItem.inserir(item))
                return true;
        }
        return false;
    }
    
}
