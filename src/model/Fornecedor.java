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
public class Fornecedor {
    private Integer codFornecedor;
    private String nomeFornecedor;
    private String cidade;
    private String estado;
    private Boolean flgAtivo;
    
    public Fornecedor(Integer codFornecedor, String nomeFornecedor, String cidade, String estado, Boolean flgAtivo) {
        this.codFornecedor = codFornecedor;
        this.nomeFornecedor = nomeFornecedor;
        this.cidade = cidade;
        this.estado = estado;
        this.flgAtivo = flgAtivo;
    }
    public Fornecedor(){
    
    }

    public Integer getCodFornecedor() {
        return codFornecedor;
    }

    public void setCodFornecedor(Integer codFornecedor) {
        this.codFornecedor = codFornecedor;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
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
        return "Fornecedor{" + "codFornecedor=" + codFornecedor + ", nomeFornecedor=" + nomeFornecedor + ", cidade=" + cidade + ", estado=" + estado + ", flgAtivo=" + flgAtivo + '}';
    }

    
    
}
