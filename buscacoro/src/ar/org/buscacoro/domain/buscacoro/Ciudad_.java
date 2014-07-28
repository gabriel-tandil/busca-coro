package ar.org.buscacoro.domain.buscacoro;

import java.sql.*;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import javax.persistence.metamodel.SetAttribute;

import ar.org.buscacoro.domain.buscacoro.Coro;
import ar.org.buscacoro.domain.buscacoro.Recurso;
import ar.org.buscacoro.domain.buscacoro.Provincia;

@StaticMetamodel(Ciudad.class)
public class Ciudad_ {

    public static volatile SingularAttribute<Ciudad, Integer> id;

    public static volatile SingularAttribute<Ciudad, String> nombre;
    public static volatile SingularAttribute<Ciudad, Boolean> activo;


    public static volatile SingularAttribute<Ciudad, Provincia> provincia;
    public static volatile SingularAttribute<Ciudad, Integer> provincia_;

    public static volatile SetAttribute<Ciudad, Coro> coroCiudadViaCiudad;
    public static volatile SetAttribute<Ciudad, Recurso> recursoCiudadViaCiudad;


}
