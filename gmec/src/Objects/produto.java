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
public class produto {
    private int codigo, rendimento;
    private float valorCusto,valorUnitario;
    private String nome,ingredientes, descricao;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getRendimento() {
        return rendimento;
    }

    public void setRendimento(int rendimento) {
        this.rendimento = rendimento;
    }

    public float getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(float valorCusto) {
        this.valorCusto = valorCusto;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public produto(int codigo, int rendimento, float valorCusto, float valorUnitario, String nome, String ingredientes, String descricao) {
        this.codigo = codigo;
        this.rendimento = rendimento;
        this.valorCusto = valorCusto;
        this.valorUnitario = valorUnitario;
        this.nome = nome;
        this.ingredientes = ingredientes;
        this.descricao = descricao;
    }
    
}
