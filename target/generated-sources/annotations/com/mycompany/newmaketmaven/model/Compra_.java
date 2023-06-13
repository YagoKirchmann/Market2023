package com.mycompany.newmaketmaven.model;

import com.mycompany.newmaketmaven.model.CondicaoPgto;
import com.mycompany.newmaketmaven.model.Fornecedor;
import com.mycompany.newmaketmaven.model.ItensCompra;
import com.mycompany.newmaketmaven.model.Pagar;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-06-06T19:54:41")
@StaticMetamodel(Compra.class)
public class Compra_ { 

    public static volatile SingularAttribute<Compra, Date> dtCompra;
    public static volatile SingularAttribute<Compra, String> tipoNF;
    public static volatile SingularAttribute<Compra, Float> vlrAcresc;
    public static volatile SingularAttribute<Compra, Date> hrCompra;
    public static volatile SingularAttribute<Compra, CondicaoPgto> condicaoPgto;
    public static volatile SingularAttribute<Compra, Pagar> pagar;
    public static volatile SingularAttribute<Compra, Float> totalNF;
    public static volatile SingularAttribute<Compra, String> numNF;
    public static volatile SingularAttribute<Compra, Integer> id;
    public static volatile SingularAttribute<Compra, ItensCompra> itensCompra;
    public static volatile SingularAttribute<Compra, Fornecedor> fornecedor;
    public static volatile SingularAttribute<Compra, Float> vlrDesc;
    public static volatile SingularAttribute<Compra, Character> status;

}