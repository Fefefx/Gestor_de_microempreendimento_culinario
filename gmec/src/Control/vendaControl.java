/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import Objects.vendas;
import Model.vendasModel;
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
    
}
