package com.mycompany.newmaketmaven.model;

import com.mycompany.newmaketmaven.model.Classe;
import com.mycompany.newmaketmaven.model.Marca;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-06-27T20:55:17")
@StaticMetamodel(Produto.class)
public class Produto_ { 

    public static volatile SingularAttribute<Produto, Classe> classe;
    public static volatile SingularAttribute<Produto, Date> dtCadastro;
    public static volatile SingularAttribute<Produto, Float> estoqueMax;
    public static volatile SingularAttribute<Produto, String> barraSaida;
    public static volatile SingularAttribute<Produto, Float> vlrCompra;
    public static volatile SingularAttribute<Produto, String> descricao;
    public static volatile SingularAttribute<Produto, Marca> marca;
    public static volatile SingularAttribute<Produto, String> undCompra;
    public static volatile SingularAttribute<Produto, String> undVenda;
    public static volatile SingularAttribute<Produto, String> barraEntrada;
    public static volatile SingularAttribute<Produto, Integer> id;
    public static volatile SingularAttribute<Produto, Float> estoqueMin;
    public static volatile SingularAttribute<Produto, Integer> fatorConversao;
    public static volatile SingularAttribute<Produto, Float> vlrVenda;
    public static volatile SingularAttribute<Produto, Character> status;

}