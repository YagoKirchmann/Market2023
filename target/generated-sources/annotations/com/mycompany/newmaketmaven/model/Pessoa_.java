package com.mycompany.newmaketmaven.model;

import com.mycompany.newmaketmaven.model.Endereco;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-06-06T19:54:41")
@StaticMetamodel(Pessoa.class)
public abstract class Pessoa_ { 

    public static volatile SingularAttribute<Pessoa, String> fone1;
    public static volatile SingularAttribute<Pessoa, String> observacao;
    public static volatile SingularAttribute<Pessoa, String> fone2;
    public static volatile SingularAttribute<Pessoa, Endereco> endereco;
    public static volatile SingularAttribute<Pessoa, Date> dtCadastro;
    public static volatile SingularAttribute<Pessoa, String> complementoEndereco;
    public static volatile SingularAttribute<Pessoa, String> nome;
    public static volatile SingularAttribute<Pessoa, Integer> id;
    public static volatile SingularAttribute<Pessoa, String> email;
    public static volatile SingularAttribute<Pessoa, String> status;

}