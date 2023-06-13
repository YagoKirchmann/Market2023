
package com.mycompany.newmaketmaven.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fornecedor extends Pessoa implements Serializable  {

    @Column    
    private String cnpj;
    @Column
    private String inscEstadual;
    @Column
    private String contato;
    @Column
    private String razaoSocial;
    @Column
    private String cpf;
    @Column
    private String rg;

    public Fornecedor() {
    }

    public Fornecedor(String cnpj, String inscEstadual, String contato, String razaoSocial, String cpf, String rg, int id, String nome, String fone1, String fone2, String email, Date dtCadastro, String observacao, String status, String complementoEndereco,Endereco endereco) {
        super(id, nome, fone1, fone2, email, dtCadastro, observacao, status, complementoEndereco, endereco);
        this.cnpj = cnpj;
        this.inscEstadual = inscEstadual;
        this.contato = contato;
        this.razaoSocial = razaoSocial;
        this.cpf = cpf;
        this.rg = rg;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscEstadual() {
        return inscEstadual;
    }

    public void setInscEstadual(String inscEstadual) {
        this.inscEstadual = inscEstadual;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + this.getCnpj() + ";" + this.getInscEstadual() + ";" + this.getContato() + ";" + this.getRazaoSocial() + ";" + this.getCpf() + ";"  + this.getRg() + ";" ;
    }
    
    
    
}
