/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Objects.usuario;
import BanK.Conexao;
import BanK.infoBanco;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author felipe
 */
public class usuarioModel {
    private Conexao Banco;
    infoBanco dados= new infoBanco();
    private void abrirConexao(){
        Banco=new Conexao();
        Banco.conectar(dados.getBanco(),dados.getUsuario(),dados.getSenha());
        if (!Banco.getStatus()) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco código: " + Banco.getMensagemErro());
        } else {
            System.out.println("Banco conectado !");
        }
    }
    public void verificar(usuario user){
        abrirConexao();
        String sql="select * from usuario where user = "+user.getUser()+" and senha = "+user.getSenha()+";";
        ResultSet registro=Banco.consultar(sql);
        try {
            if(registro.next()){
                JOptionPane.showMessageDialog(null,"Usuário localizado");
            }else
                JOptionPane.showMessageDialog(null,"Usuário não cadastrado!");
        } catch (SQLException ex) {
            Logger.getLogger(usuarioModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
