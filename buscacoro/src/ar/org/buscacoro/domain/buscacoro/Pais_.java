package ar.org.buscacoro.domain.buscacoro;

import java.sql.*;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import javax.persistence.metamodel.SetAttribute;

import ar.org.buscacoro.domain.buscacoro.Provincia;

@StaticMetamodel(Pais.class)
public class Pais_ {

    public static volatile SingularAttribute<Pais, Integer> id;

    public static volatile SingularAttribute<Pais, String> nombre;
    public static volatile SingularAttribute<Pais, Boolean> activo;


    public static volatile SetAttribute<Pais, Provincia> provinciaPaisViaPais;


}
