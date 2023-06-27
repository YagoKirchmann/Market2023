
package com.mycompany.newmaketmaven.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CondicaoPagamento implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String descricaoCondicao;
    @Column
    private int numParcelas;
    @Column
    private int diasPrimeiraParcela;
    @Column
    private int diasEntreParcela;
    @Column
    private char status;

    public CondicaoPagamento() {
    }

    public CondicaoPagamento(int id, String descricaoCondicao, int numParcelas, int diasPrimeiraParcela, int diasEntreParcela, char status) {
        this.id = id;
        this.descricaoCondicao = descricaoCondicao;
        this.numParcelas = numParcelas;
        this.diasPrimeiraParcela = diasPrimeiraParcela;
        this.diasEntreParcela = diasEntreParcela;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricaoCondicao() {
        return descricaoCondicao;
    }

    public void setDescricaoCondicao(String descricaoCondicao) {
        this.descricaoCondicao = descricaoCondicao;
    }

    public int getNumParcelas() {
        return numParcelas;
    }

    public void setNumParcelas(int numParcelas) {
        this.numParcelas = numParcelas;
    }

    public int getDiasPrimeiraParcela() {
        return diasPrimeiraParcela;
    }

    public void setDiasPrimeiraParcela(int diasPrimeiraParcela) {
        this.diasPrimeiraParcela = diasPrimeiraParcela;
    }

    public int getDiasEntreParcela() {
        return diasEntreParcela;
    }

    public void setDiasEntreParcela(int diasEntreParcela) {
        this.diasEntreParcela = diasEntreParcela;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.getId() + ";" + this.getDescricaoCondicao() + ";" + this.getNumParcelas()+ ";" + this.getDiasPrimeiraParcela()+ ";" + this.getDiasPrimeiraParcela()+ ";" + this.getStatus() + ";";
    }
    
    
}
