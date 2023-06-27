
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
public class Compra implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    @Temporal(TemporalType.DATE)
    private Date dtCompra;
    @Column
    @Temporal(TemporalType.DATE)
    private Date hrCompra;
    @Column
    private String numNF;
    @Column
    private String tipoNF;
    @Column
    private float vlrDesc;
    @Column
    private float vlrAcresc;
    @Column
    private float totalNF;
    @Column
    private char status;
    @JoinColumn
    @ManyToOne
    private CondicaoPagamento condicaoPgto;
    @JoinColumn
    @ManyToOne
    private Pagar pagar;
    @JoinColumn
    @ManyToOne
    private ItensCompra itensCompra;
    @JoinColumn
    @ManyToOne
    private Fornecedor fornecedor;

    public Compra() {
    }

    public Compra(int id, Date dtCompra, Date hrCompra, String numNF, String tipoNF, float vlrDesc, float vlrAcresc, float totalNF, char status, CondicaoPagamento condicaoPgto, Pagar pagar, ItensCompra itensCompra, Fornecedor fornecedor) {
        this.id = id;
        this.dtCompra = dtCompra;
        this.hrCompra = hrCompra;
        this.numNF = numNF;
        this.tipoNF = tipoNF;
        this.vlrDesc = vlrDesc;
        this.vlrAcresc = vlrAcresc;
        this.totalNF = totalNF;
        this.status = status;
        this.condicaoPgto = condicaoPgto;
        this.pagar = pagar;
        this.itensCompra = itensCompra;
        this.fornecedor = fornecedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDtCompra() {
        return dtCompra;
    }

    public void setDtCompra(Date dtCompra) {
        this.dtCompra = dtCompra;
    }

    public Date getHrCompra() {
        return hrCompra;
    }

    public void setHrCompra(Date hrCompra) {
        this.hrCompra = hrCompra;
    }

    public String getNumNF() {
        return numNF;
    }

    public void setNumNF(String numNF) {
        this.numNF = numNF;
    }

    public String getTipoNF() {
        return tipoNF;
    }

    public void setTipoNF(String tipoNF) {
        this.tipoNF = tipoNF;
    }

    public float getVlrDesc() {
        return vlrDesc;
    }

    public void setVlrDesc(float vlrDesc) {
        this.vlrDesc = vlrDesc;
    }

    public float getVlrAcresc() {
        return vlrAcresc;
    }

    public void setVlrAcresc(float vlrAcresc) {
        this.vlrAcresc = vlrAcresc;
    }

    public float getTotalNF() {
        return totalNF;
    }

    public void setTotalNF(float totalNF) {
        this.totalNF = totalNF;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public CondicaoPagamento getCondicaoPgto() {
        return condicaoPgto;
    }

    public void setCondicaoPgto(CondicaoPagamento condicaoPgto) {
        this.condicaoPgto = condicaoPgto;
    }

    public Pagar getPagar() {
        return pagar;
    }

    public void setPagar(Pagar pagar) {
        this.pagar = pagar;
    }

    public ItensCompra getItensCompra() {
        return itensCompra;
    }

    public void setItensCompra(ItensCompra itensCompra) {
        this.itensCompra = itensCompra;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public String toString() {
        return this.getId() + ";" + this.getDtCompra() + ";" + this.getHrCompra() + ";" + this.getNumNF() + ";" + this.getTipoNF() + ";" + this.getVlrDesc() + ";" + this.getVlrAcresc() + ";" + this.getTotalNF() + ";" + this.getStatus() + ";" + fornecedor.toString() + ";" + condicaoPgto.toString() + ";" + pagar.toString() + ";" + itensCompra.toString();
    }
    
    
}
