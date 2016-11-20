/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Maq01
 */
public class Cliente {

    private Integer codCliente;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String endereco;
    private String cidade;
    private String estado;
    private Boolean flgAtivo;

    public Cliente(Integer codCliente, String nome, String sobrenome, String cpf, String endereco, String cidade, String estado, Boolean flgAtivo) {

        this.codCliente = codCliente;
        this.cpf = cpf;
        this.cidade = cidade;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.sobrenome = sobrenome;
        this.flgAtivo = flgAtivo;

    }

    public Cliente() {

    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Boolean getFlgAtivo() {
        return flgAtivo;
    }

    public void setFlgAtivo(Boolean flgAtivo) {
        this.flgAtivo = flgAtivo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codCliente=" + codCliente + ", nome=" + nome + ", sobrenome=" + sobrenome + ", cpf=" + cpf + ", endereco=" + endereco + ", cidade=" + cidade + ", estado=" + estado + ", flgAtivo=" + flgAtivo + '}';
    }

}
