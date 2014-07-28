package ar.org.buscacoro.domain.buscacoro;

import java.sql.*;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import javax.persistence.metamodel.SetAttribute;

import ar.org.buscacoro.domain.buscacoro.Ciudad;

@StaticMetamodel(Recurso.class)
public class Recurso_ {

    public static volatile SingularAttribute<Recurso, Integer> id;

    public static volatile SingularAttribute<Recurso, String> nombre;
    public static volatile SingularAttribute<Recurso, String> detalle;
    public static volatile SingularAttribute<Recurso, String> web;
    public static volatile SingularAttribute<Recurso, String> email;
    public static volatile SingularAttribute<Recurso, String> contacto;
    public static volatile SingularAttribute<Recurso, Boolean> demo;
    public static volatile SingularAttribute<Recurso, Boolean> material;
    public static volatile SingularAttribute<Recurso, Boolean> activo;
    public static volatile SingularAttribute<Recurso, Timestamp> modificacion;
    public static volatile SingularAttribute<Recurso, Date> hasta;
    public static volatile SingularAttribute<Recurso, Date> desde;


    public static volatile SingularAttribute<Recurso, Ciudad> ciudad;
    public static volatile SingularAttribute<Recurso, Integer> ciudad_;



}
