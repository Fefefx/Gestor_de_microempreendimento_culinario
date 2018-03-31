/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Objects.cliente;
import Bank.Conexao;
import Bank.infoBanco;
import javax.swing.JOptionPane;

/**
 *
 * @author felipe
 */
public class clienteModel {

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

    public boolean inserir(cliente client) {
        abrirConexao();
        String sql="insert into cliente(nome,telefone,endereco) values('"+client.getNome()+"',"
                    +client.getTelefone()+",'"+client.getEndereco()+"');";
        System.out.println(sql);
        int res=Banco.manipular(sql);
        if(res==-1)
            JOptionPane.showMessageDialog(null,"Não foi possível cadastrar o cliente");
        else{
            JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso");
            return true;
        }
        return false;
    }

    public boolean atualizar(cliente client) {
        abrirConexao();
        String sql="update cliente set nome='"+client.getNome()+"',telefone="
                +client.getTelefone()+",endereco='"+client.getEndereco()
                +"' where idcliente="+client.getIdCliente();
        System.out.println(sql);
        int res=Banco.manipular(sql);
        if(res==-1){
            JOptionPane.showMessageDialog(null,"Não foi possível atualizar o cliente");
        }else{
            JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso");
            return true;
        }
        return false;
    }
    
    public boolean excluir(int codigo){
        abrirConexao();
        String sql="delete from cliente where idcliente="+codigo+";";
        System.out.println(sql);
        //chamar excluir encomenda -> para evitar problemas com integridade referencial no banco de dados 
        int res=Banco.manipular(sql);
        if(res==-1){
            JOptionPane.showMessageDialog(null,"Não foi possível excluir o usuário");
        }else{
            JOptionPane.showMessageDialog(null,"Exclusão do cliente realizada");
            return true;
        }
        return false;
    }
    
    public void pesquisar(){
        abrirConexao();
    }
}
