package com.mycompany.newmaketmaven.model;

import com.mycompany.newmaketmaven.model.CupomFiscal;
import com.mycompany.newmaketmaven.model.Produto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-06-06T19:54:41")
@StaticMetamodel(ItensCupomFiscal.class)
public class ItensCupomFiscal_ { 

    public static volatile SingularAttribute<ItensCupomFiscal, Float> qtdProduto;
    public static volatile SingularAttribute<ItensCupomFiscal, Float> vlrUnitProd;
    public static volatile SingularAttribute<ItensCupomFiscal, Produto> produto;
    public static volatile SingularAttribute<ItensCupomFiscal, CupomFiscal> cupomFiscal;
    public static volatile SingularAttribute<ItensCupomFiscal, Integer> id;
    public static volatile SingularAttribute<ItensCupomFiscal, Character> status;

}