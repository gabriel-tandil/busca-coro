package ar.org.buscacoro.domain.buscacoro;

import java.sql.*;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import javax.persistence.metamodel.SetAttribute;

import ar.org.buscacoro.domain.buscacoro.Ciudad;
import ar.org.buscacoro.domain.buscacoro.Pais;

@StaticMetamodel(Provincia.class)
public class Provincia_ {

    public static volatile SingularAttribute<Provincia, Integer> id;

    public static volatile SingularAttribute<Provincia, String> nombre;
    public static volatile SingularAttribute<Provincia, Boolean> activo;


    public static volatile SingularAttribute<Provincia, Pais> pais;
    public static volatile SingularAttribute<Provincia, Integer> pais_;

    public static volatile SetAttribute<Provincia, Ciudad> ciudadProvinciaViaProvincia;


}
