
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
public class ItensCupomFiscal implements Serializable {
    
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
    private CupomFiscal cupomFiscal;
     
    public ItensCupomFiscal() {
    }

    public ItensCupomFiscal(int id, float qtdProduto, float vlrUnitProd, char status, Produto produto, CupomFiscal cupomFiscal) {
        this.id = id;
        this.qtdProduto = qtdProduto;
        this.vlrUnitProd = vlrUnitProd;
        this.status = status;
        this.produto = produto;
        this.cupomFiscal = cupomFiscal;
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

    public CupomFiscal getCupomFiscal() {
        return cupomFiscal;
    }

    public void setCupomFiscal(CupomFiscal cupomFiscal) {
        this.cupomFiscal = cupomFiscal;
    }

    @Override
    public String toString() {
        return this.getId() + ";" + this.getQtdProduto() + ";" + this.getVlrUnitProd() + ";" + this.getStatus() + ";" + cupomFiscal.toString() + ";" + produto.toString()+ ";";
    }
   
    
    
}
