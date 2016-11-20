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
public class Produto {

    private Integer codProduto;
    private Fornecedor codFornecedor;
    private String nomeProduto;
    private Double precoUnitario;
    private Character flgAtivo;

    public Produto(Integer codProduto, Fornecedor codFornecedor, String nomeProduto, Double precoUnitario, Character flgAtivo) {
        this.codProduto = codProduto;
        this.codFornecedor = codFornecedor;
        this.nomeProduto = nomeProduto;
        this.precoUnitario = precoUnitario;
        this.flgAtivo = flgAtivo;
    }

    public Produto() {

    }

    public Integer getCodProduto() {

        return codProduto;
    }

    public void setCodProduto(Integer codProduto) {

        this.codProduto = codProduto;
    }

    public Fornecedor getCodFornecedor() {
        return codFornecedor;
    }

    public void setCodFornecedor(Fornecedor codFornecedor) {
        this.codFornecedor = codFornecedor;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Character getFlgAtivo() {
        return flgAtivo;
    }

    public void setFlgAtivo(Character flgAtivo) {
        this.flgAtivo = flgAtivo;
    }

    @Override
    public String toString() {
        return "Produto{" + "codProduto=" + codProduto + ", codFornecedor=" + codFornecedor + ", nomeProduto=" + nomeProduto + ", precoUnitario=" + precoUnitario + ", flgAtivo=" + flgAtivo + '}';
    }

}
