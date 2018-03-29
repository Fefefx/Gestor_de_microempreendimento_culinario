/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import Objects.usuario;
import Model.usuarioModel;
import javax.swing.JOptionPane;

/**
 *
 * @author felipe
 */
public class usuarioControl {
    public void verificarCampos(usuario user){
        if(user.getSenha()==null) //mudar para detectar string vazia
            JOptionPane.showMessageDialog(null,"Digite uma senha");
        else if(user.getUser()==null)
            JOptionPane.showMessageDialog(null, "Digite um usuário");
        else if(user.getSenha().length()>8)
            JOptionPane.showMessageDialog(null,"Senha incorreta");
        else if(user.getUser().length()>20)
            JOptionPane.showMessageDialog(null, "Usuário incorreto");
        else{
            usuarioModel userModel=new usuarioModel();
            userModel.verificar(user);
        } 
    }
}
