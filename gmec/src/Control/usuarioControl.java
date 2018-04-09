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
    public boolean verificarCampos(usuario user){
        if("".equals(user.getSenha().trim()))
            JOptionPane.showMessageDialog(null,"Digite uma senha");
        else if("".equals(user.getUser().trim()))
            JOptionPane.showMessageDialog(null, "Digite um usuário");
        else if(user.getSenha().length()>8)
            JOptionPane.showMessageDialog(null,"Senha incorreta");
        else if(user.getUser().length()>20)
            JOptionPane.showMessageDialog(null, "Usuário incorreto");
        else{
            usuarioModel userModel=new usuarioModel();
            return userModel.verificar(user);
        }
        return false;
    }
    
    public boolean validarCampos(usuario user){
        if("".equals(user.getUser().trim()))
            JOptionPane.showMessageDialog(null,"Digite uma senha");
        else if("".equals(user.getUser().trim()))
            JOptionPane.showMessageDialog(null, "Digite um nome de usuário");
        else if(user.getSenha().length()>8)
            JOptionPane.showMessageDialog(null,"A senha deve conter até 8 caracteres");
        else if(user.getUser().length()>20)
            JOptionPane.showMessageDialog(null, "O nome de usuário deve conter de até 20 caracteres");
        else{
            usuarioModel userModel=new usuarioModel();
            return userModel.inserir(user);
        }
        return false;
    }
}
