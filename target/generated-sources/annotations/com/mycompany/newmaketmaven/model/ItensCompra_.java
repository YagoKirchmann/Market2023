package com.mycompany.newmaketmaven.model;

import com.mycompany.newmaketmaven.model.HistoricoMovimentacao;
import com.mycompany.newmaketmaven.model.Produto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-06-06T19:54:41")
@StaticMetamodel(ItensCompra.class)
public class ItensCompra_ { 

    public static volatile SingularAttribute<ItensCompra, Float> qtdProduto;
    public static volatile SingularAttribute<ItensCompra, Float> vlrUnitProd;
    public static volatile SingularAttribute<ItensCompra, Produto> produto;
    public static volatile SingularAttribute<ItensCompra, HistoricoMovimentacao> historicoMovimentacao;
    public static volatile SingularAttribute<ItensCompra, Integer> id;
    public static volatile SingularAttribute<ItensCompra, Character> status;

}