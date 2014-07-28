package ar.org.buscacoro.domain.buscacoro;

import javax.persistence.metamodel.*;

@StaticMetamodel(Provincia.class)
public class Provincia_ {

	public static volatile SingularAttribute<Provincia, Boolean> activo;

	public static volatile SetAttribute<Provincia, Ciudad> ciudadProvinciaViaProvincia;
	public static volatile SingularAttribute<Provincia, Integer> id;

	public static volatile SingularAttribute<Provincia, String> nombre;
	public static volatile SingularAttribute<Provincia, Pais> pais;

	public static volatile SingularAttribute<Provincia, Integer> pais_;

}
