package com.mycompany.newmaketmaven.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-06-06T19:54:41")
@StaticMetamodel(Pagamento.class)
public class Pagamento_ { 

    public static volatile SingularAttribute<Pagamento, Character> Status;
    public static volatile SingularAttribute<Pagamento, Float> vlrAcresc;
    public static volatile SingularAttribute<Pagamento, Float> vlrPago;
    public static volatile SingularAttribute<Pagamento, Date> hrPgto;
    public static volatile SingularAttribute<Pagamento, Integer> id;
    public static volatile SingularAttribute<Pagamento, Float> vlrDesc;
    public static volatile SingularAttribute<Pagamento, Date> dtPgto;

}