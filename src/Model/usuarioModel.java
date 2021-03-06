/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Objects.usuario;
import Bank.Conexao;
import Bank.infoBanco;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author felipe
 */
public class usuarioModel {

    private Conexao Banco;
    infoBanco dados = new infoBanco();

    private void abrirConexao() {
        Banco = new Conexao();
        Banco.conectar(dados.getBanco(), dados.getUsuario(), dados.getSenha());
        if (!Banco.getStatus()) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco código: " + Banco.getMensagemErro());
        } else {
            System.out.println("Banco conectado !");
        }
    }

    public boolean inserir(usuario user) {
        abrirConexao();
        String sql = "insert into usuario(user,senha) values('" + user.getUser() + "','" + user.getSenha() + "');";
        System.out.println(sql);
        int res = Banco.manipular(sql);
        if (res == -1) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o usuário");
        } else {
            JOptionPane.showMessageDialog(null, "Usuário inserido com sucesso");
            return true;
        }
        return false;
    }

    public boolean atualizar(usuario user) {
        abrirConexao();
        String sql = "update usuario set senha='" + user.getSenha() + "' where user='" + user.getUser() + "';";
        System.out.println(sql);
        int res = Banco.manipular(sql);
        if (res == -1) {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar a senha do usuário");
        } else {
            JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso");
            return true;
        }
        return false;
    }

    public boolean excluir(String nomeUsuario) {
        abrirConexao();
        String sql = "delete from usuario where user='" + nomeUsuario + "';";
        System.out.println(sql);
        int res = Banco.manipular(sql);
        if (res == -1) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o usuário");
        } else {
            JOptionPane.showMessageDialog(null, "Exclusão do usuário realizada");
            return true;
        }
        return false;
    }

    public boolean verificar(usuario user) {
        abrirConexao();
        String sql = "select * from usuario where user = '" + user.getUser() + "' and senha = '" + user.getSenha() + "';";
        ResultSet registro = Banco.consultar(sql);
        try {
            if (registro.next()) {
                System.out.println("\nUsuário localizado");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos");
            }
        } catch (SQLException ex) {
            Logger.getLogger(usuarioModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean pesquisarUsuario(String nome) {
        abrirConexao();
        String sql = "select user from usuario where user = '" + nome + "';";
        System.out.println(sql);
        ResultSet resultado = Banco.consultar(sql);
        try {
            if (resultado.next()) {
                JOptionPane.showMessageDialog(null, "Usuário já cadastrado. Tente outro login!");
                return true;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(usuarioModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList pesquisar(String nomeUsuario) {
        abrirConexao();
        ArrayList lista = new ArrayList();
        String sql = "select * from usuario where user like '" + nomeUsuario + "%';";
        System.out.println(sql);
        ResultSet resultado = Banco.consultar(sql);
        try {
            while (resultado.next()) {
                usuario user = new usuario();
                user.setUser(resultado.getString("user"));
                lista.add(user);
            }
            resultado.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(clienteModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
