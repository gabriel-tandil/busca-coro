package ar.org.buscacoro.domain.buscacoro;

import java.sql.*;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import javax.persistence.metamodel.SetAttribute;

import ar.org.buscacoro.domain.buscacoro.Coro;

@StaticMetamodel(Tipo.class)
public class Tipo_ {

    public static volatile SingularAttribute<Tipo, Integer> id;

    public static volatile SingularAttribute<Tipo, String> nombre;


    public static volatile SetAttribute<Tipo, Coro> coroTipoViaTipo;


}
