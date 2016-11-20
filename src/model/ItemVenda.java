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
public class ItemVenda {

    private Integer codItem;
    private Venda codVenda;
    private Produto codProduto;
    private Integer quantidade;
    public ItemVenda (Integer codItem,Venda codVenda,Produto codProduto, Integer quantidade ){
        this.codItem=codItem;
        this.codVenda=codVenda;
        this.codProduto=codProduto;
        this.quantidade=quantidade;
    }
    public ItemVenda(){
    
    }
    
    public Integer getCodItem() {
        return codItem;
    }

    public void setCodItem(Integer codItem) {
        this.codItem = codItem;
    }

    public Venda getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(Venda codVenda) {
        this.codVenda = codVenda;
    }

    public Produto getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Produto codProduto) {
        this.codProduto = codProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "ItemVenda{" + "codItem=" + codItem + ", codVenda=" + codVenda + ", codProduto=" + codProduto + ", quantidade=" + quantidade + '}';
    }
    
        
    
    
    
    
    
    
}
