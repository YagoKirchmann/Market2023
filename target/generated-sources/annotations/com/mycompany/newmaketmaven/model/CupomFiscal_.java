package com.mycompany.newmaketmaven.model;

import com.mycompany.newmaketmaven.model.Cliente;
import com.mycompany.newmaketmaven.model.Colaborador;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-06-27T20:55:17")
@StaticMetamodel(CupomFiscal.class)
public class CupomFiscal_ { 

    public static volatile SingularAttribute<CupomFiscal, Date> dtVenda;
    public static volatile SingularAttribute<CupomFiscal, Colaborador> colaborador;
    public static volatile SingularAttribute<CupomFiscal, Cliente> cliente;
    public static volatile SingularAttribute<CupomFiscal, Float> vlrAcresc;
    public static volatile SingularAttribute<CupomFiscal, Float> totalCupom;
    public static volatile SingularAttribute<CupomFiscal, Integer> id;
    public static volatile SingularAttribute<CupomFiscal, Float> vlrDesc;
    public static volatile SingularAttribute<CupomFiscal, Date> hrVenda;
    public static volatile SingularAttribute<CupomFiscal, Character> status;

}