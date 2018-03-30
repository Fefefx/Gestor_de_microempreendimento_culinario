/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bank;

import javax.swing.JOptionPane;

/**
 *
 * @author felipe
 */
//Tenho um computador com senha root então se der erro de conexão só deixar senha="" 
public class infoBanco {
    private final String banco = "GMEC",usuario="root",senha="root";

    public String getBanco() {
        return banco;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }
        
}
