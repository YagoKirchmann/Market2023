package com.mycompany.newmaketmaven.model;

import com.mycompany.newmaketmaven.model.ItensCompra;
import com.mycompany.newmaketmaven.model.ItensCupomFiscal;
import com.mycompany.newmaketmaven.model.Produto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-06-06T19:54:41")
@StaticMetamodel(HistoricoMovimentacao.class)
public class HistoricoMovimentacao_ { 

    public static volatile SingularAttribute<HistoricoMovimentacao, Float> qtd;
    public static volatile SingularAttribute<HistoricoMovimentacao, Character> tipo;
    public static volatile SingularAttribute<HistoricoMovimentacao, Date> data;
    public static volatile SingularAttribute<HistoricoMovimentacao, Produto> produto;
    public static volatile SingularAttribute<HistoricoMovimentacao, Date> hora;
    public static volatile SingularAttribute<HistoricoMovimentacao, ItensCupomFiscal> itensCupomFiscal;
    public static volatile SingularAttribute<HistoricoMovimentacao, Integer> id;
    public static volatile SingularAttribute<HistoricoMovimentacao, ItensCompra> itensCompra;
    public static volatile SingularAttribute<HistoricoMovimentacao, Character> status;

}