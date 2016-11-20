/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Maq01
 */
public class Venda {

    private Integer codVenda;
    private Cliente cliente;
    private Double valorTotal;
    private Date dataNota;

    public Venda(Integer codVenda, Cliente cliente, Double valorTotal, Date dataNota) {

        this.codVenda = codVenda;
        this.cliente = cliente;
        this.valorTotal = valorTotal;
        this.dataNota = dataNota;

    }

    public Venda() {
    }

    public Integer getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(Integer codVenda) {
        this.codVenda = codVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getDataNota() {
        return dataNota;
    }

    public void setDataNota(Date dataNota) {
        this.dataNota = dataNota;
    }

    @Override
    public String toString() {
        return "Venda{" + "codVenda=" + codVenda + ", cliente=" + cliente + ", valorTotal=" + valorTotal + ", dataNota=" + dataNota + '}';
    }

}
