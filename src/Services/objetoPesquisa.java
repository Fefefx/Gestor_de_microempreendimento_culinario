/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

/**
 *
 * @author felipe
 */
public class objetoPesquisa {
    
    private String cliente, diaAtual, diaLimite;
    

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setDiaAtual(String diaAtual) {
        this.diaAtual = diaAtual;
    }

    public void setDiaLimite(String diaLimite) {
        this.diaLimite = diaLimite;
    }

    public String getCliente() {
        return cliente;
    }

    public String getDiaAtual() {
        return diaAtual;
    }

    public String getDiaLimite() {
        return diaLimite;
    }
    
}
