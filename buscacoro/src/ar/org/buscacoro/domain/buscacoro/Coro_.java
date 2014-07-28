package ar.org.buscacoro.domain.buscacoro;

import java.sql.*;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import javax.persistence.metamodel.SetAttribute;

import ar.org.buscacoro.domain.buscacoro.Ciudad;
import ar.org.buscacoro.domain.buscacoro.Tipo;

@StaticMetamodel(Coro.class)
public class Coro_ {

    public static volatile SingularAttribute<Coro, Integer> id;

    public static volatile SingularAttribute<Coro, String> nombre;
    public static volatile SingularAttribute<Coro, String> detalle;
    public static volatile SingularAttribute<Coro, String> web;
    public static volatile SingularAttribute<Coro, String> email;
    public static volatile SingularAttribute<Coro, String> contacto;
    public static volatile SingularAttribute<Coro, Boolean> demo;
    public static volatile SingularAttribute<Coro, Boolean> material;
    public static volatile SingularAttribute<Coro, Boolean> activo;
    public static volatile SingularAttribute<Coro, Timestamp> modificacion;
    public static volatile SingularAttribute<Coro, Date> desde;
    public static volatile SingularAttribute<Coro, Date> hasta;


    public static volatile SingularAttribute<Coro, Ciudad> ciudad;
    public static volatile SingularAttribute<Coro, Integer> ciudad_;

    public static volatile SingularAttribute<Coro, Tipo> tipo;
    public static volatile SingularAttribute<Coro, Integer> tipo_;



}
