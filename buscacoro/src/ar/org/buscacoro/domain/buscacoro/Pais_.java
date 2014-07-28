package ar.org.buscacoro.domain.buscacoro;

import javax.persistence.metamodel.*;

@StaticMetamodel(Pais.class)
public class Pais_ {

	public static volatile SingularAttribute<Pais, Boolean> activo;

	public static volatile SingularAttribute<Pais, Integer> id;
	public static volatile SingularAttribute<Pais, String> nombre;

	public static volatile SetAttribute<Pais, Provincia> provinciaPaisViaPais;

}
