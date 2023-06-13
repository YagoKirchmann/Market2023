
package com.mycompany.newmaketmaven.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class ItensCompra implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private float qtdProduto;
    @Column
    private float vlrUnitProd;
    @Column
    private char status;
    @JoinColumn
    @ManyToOne
    private Produto produto; 
    @JoinColumn
    @ManyToOne
    private HistoricoMovimentacao historicoMovimentacao;
    
    public ItensCompra() {
    }

    public ItensCompra(int id, float qtdProduto, float vlrUnitProd, char status, Produto produto, HistoricoMovimentacao historicoMovimentacao) {
        this.id = id;
        this.qtdProduto = qtdProduto;
        this.vlrUnitProd = vlrUnitProd;
        this.status = status;
        this.produto = produto;
        this.historicoMovimentacao = historicoMovimentacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(float qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public float getVlrUnitProd() {
        return vlrUnitProd;
    }

    public void setVlrUnitProd(float vlrUnitProd) {
        this.vlrUnitProd = vlrUnitProd;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public HistoricoMovimentacao getHistoricoMovimentacao() {
        return historicoMovimentacao;
    }

    public void setHistoricoMovimentacao(HistoricoMovimentacao historicoMovimentacao) {
        this.historicoMovimentacao = historicoMovimentacao;
    }

   

    @Override
    public String toString() {
        return this.getId() + ";" + this.getQtdProduto() + ";" + this.getVlrUnitProd() + ";" + this.getStatus() + ";" + historicoMovimentacao.toString() + ";" + produto.toString();
    }
    
    
}
