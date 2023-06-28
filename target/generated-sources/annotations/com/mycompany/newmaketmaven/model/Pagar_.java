package com.mycompany.newmaketmaven.model;

import com.mycompany.newmaketmaven.model.Pagamento;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-06-27T20:55:17")
@StaticMetamodel(Pagar.class)
public class Pagar_ { 

    public static volatile SingularAttribute<Pagar, Date> dtEmissao;
    public static volatile SingularAttribute<Pagar, Integer> vlrPagar;
    public static volatile SingularAttribute<Pagar, Integer> dtVencimento;
    public static volatile SingularAttribute<Pagar, Integer> id;
    public static volatile SingularAttribute<Pagar, Date> hrEmissao;
    public static volatile SingularAttribute<Pagar, Pagamento> pagamento;
    public static volatile SingularAttribute<Pagar, Integer> status;

}