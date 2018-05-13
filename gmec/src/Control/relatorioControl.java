/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.*;

/**
 *
 * @author felipe
 */
public class relatorioControl {
    public String despachante(int op,String ini,String fim){
        switch(op){
            case 0:
                return new clienteModel().relatorio_Clientes(ini, fim);
            case 1:
                return new produtoModel().relatorio_Produtos(ini, fim);
            default:
                System.out.println("Erro de opção no despachante: "+op);
                return null;
        }
    }
}
