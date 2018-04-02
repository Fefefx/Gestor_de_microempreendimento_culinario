/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author felipe
 */
public class cliente {
    private int idCliente,telefone;
    private String nome,endereco;

    public cliente() {

    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public cliente(int idCliente, int telefone, String nome, String endereco) {
        this.idCliente = idCliente;
        this.telefone = telefone;
        this.nome = nome;
        this.endereco = endereco;
    }

    public cliente(int telefone, String nome, String endereco) {
        this.telefone = telefone;
        this.nome = nome;
        this.endereco = endereco;
        this.idCliente=0;
    }
    
}
