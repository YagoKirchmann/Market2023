
package com.mycompany.newmaketmaven.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class HistoricoMovimentacao implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column
    @Temporal(TemporalType.DATE)
    private Date hora;
    @Column
    private char tipo; 
    @Column
    private float qtd;
    @Column
    private char status;
    @JoinColumn
    @ManyToOne
    private Produto produto;
    @JoinColumn
    @ManyToOne
    private ItensCompra itensCompra;
    @JoinColumn
    @ManyToOne
    private ItensCupomFiscal itensCupomFiscal;
    

    public HistoricoMovimentacao() {
    }

    public HistoricoMovimentacao(int id, Date data, Date hora, char tipo, float qtd, char status, Produto produto, ItensCompra itensCompra, ItensCupomFiscal itensCupomFiscal) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.tipo = tipo;
        this.qtd = qtd;
        this.status = status;
        this.produto = produto;
        this.itensCompra = itensCompra;
        this.itensCupomFiscal = itensCupomFiscal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public float getQtd() {
        return qtd;
    }

    public void setQtd(float qtd) {
        this.qtd = qtd;
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

    public ItensCompra getItensCompra() {
        return itensCompra;
    }

    public void setItensCompra(ItensCompra itensCompra) {
        this.itensCompra = itensCompra;
    }

    public ItensCupomFiscal getItensCupomFiscal() {
        return itensCupomFiscal;
    }

    public void setItensCupomFiscal(ItensCupomFiscal itensCupomFiscal) {
        this.itensCupomFiscal = itensCupomFiscal;
    }

    
    
    @Override
    public String toString() {
        return this.getId() + ";" + this.getData() + ";" + this.getHora() + ";" + this.getTipo() + ";" + this.getQtd() + ";" + this.getStatus() + ";" + produto.toString() + ";"+ itensCompra.toString() + ";" + itensCupomFiscal.toString();
    }
    
    
    
}
