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
    private boolean entrega1, entrega2, pagamento1,pagamento2;
    

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setDiaAtual(String diaAtual) {
        this.diaAtual = diaAtual;
    }

    public void setDiaLimite(String diaLimite) {
        this.diaLimite = diaLimite;
    }

    public void setEntrega1(boolean entrega1) {
        this.entrega1 = entrega1;
    }

    public void setEntrega2(boolean entrega2) {
        this.entrega2 = entrega2;
    }

    public void setPagamento1(boolean pagamento1) {
        this.pagamento1 = pagamento1;
    }

    public void setPagamento2(boolean pagamento2) {
        this.pagamento2 = pagamento2;
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

    public boolean isEntrega1() {
        return entrega1;
    }

    public boolean isEntrega2() {
        return entrega2;
    }

    public boolean isPagamento1() {
        return pagamento1;
    }

    public boolean isPagamento2() {
        return pagamento2;
    }
    
}
