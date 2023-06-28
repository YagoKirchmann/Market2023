package com.mycompany.newmaketmaven.model;

import com.mycompany.newmaketmaven.model.Bairro;
import com.mycompany.newmaketmaven.model.Cidade;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-06-27T20:55:17")
@StaticMetamodel(Endereco.class)
public class Endereco_ { 

    public static volatile SingularAttribute<Endereco, Cidade> cidade;
    public static volatile SingularAttribute<Endereco, String> logradouro;
    public static volatile SingularAttribute<Endereco, Bairro> bairro;
    public static volatile SingularAttribute<Endereco, Integer> id;
    public static volatile SingularAttribute<Endereco, String> cep;

}