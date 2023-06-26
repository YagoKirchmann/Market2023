
package com.mycompany.newmaketmaven.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Cliente extends Pessoa implements Serializable  {

    @Column
    private String cpf;
    @Column
    private String rg;
    @Column
    @Temporal(TemporalType.DATE)
    private Date dtNascimento;
    @Column
    private char sexo;

    public Cliente() {
    }

    public Cliente(String cpf, String rg, Date dtNascimento, char sexo, int id, String nome, String fone1, String fone2, String email, Date dtCadastro, String observacao, String status, String complementoEndereco,Endereco endereco) {
        super(id, nome, fone1, fone2, email, dtCadastro, observacao, status, complementoEndereco,endereco);
        this.cpf = cpf;
        this.rg = rg;
        this.dtNascimento = dtNascimento;
        this.sexo = sexo;
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

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + this.getCpf() + this.getRg() + ";" + this.getDtNascimento() + ";" ;
    }     
}
