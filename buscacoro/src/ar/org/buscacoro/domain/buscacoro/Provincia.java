package ar.org.buscacoro.domain.buscacoro;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

/**
 * 
 * <p>
 * Title: Provincia
 * </p>
 * 
 * <p>
 * Description: Domain Object describing a Provincia entity
 * </p>
 * 
 */
@Entity(name = "Provincia")
@Table(name = "provincia")
@Views({
		@View(name = "base", members = "" + "id  ; " + "nombre  ; "
				+ "pais  ; " + "activo  ; "),

		@View(name = "Create", extendsView = "base"),
		@View(name = "Update", extendsView = "base", members = ""
				+ "ciudadProvinciaViaProvincia { ciudadProvinciaViaProvincia };"),
		@View(name = "DEFAULT", extendsView = "base", members = ""
				+ "ciudadProvinciaViaProvincia { ciudadProvinciaViaProvincia };"),
		@View(name = "provinciaDEFAULT_VIEW", members = " id ;" + "nombre  ; "
				+ "activo  ; "),
		@View(name = "reference", extendsView = "provinciaDEFAULT_VIEW"

		) })
@Tabs({
		@Tab(properties = " nombre " + ",  activo "),
		@Tab(name = "ProvinciaTab", properties = " nombre " + ",  activo "),
		@Tab(name = "ProvinciaTabWithRef", properties = " nombre "
				+ ",  activo ") })
public class Provincia {

	@Column(name = "activo", nullable = false, unique = false)
	@Required
	private Boolean activo;

	// children
	@OneToMany(targetEntity = ar.org.buscacoro.domain.buscacoro.Ciudad.class, fetch = FetchType.LAZY, mappedBy = "provincia", cascade = CascadeType.REMOVE)
	// , cascade=CascadeType.ALL)
	private Set<Ciudad> ciudadProvinciaViaProvincia = new HashSet<Ciudad>();

	@Hidden
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "nombre", length = 100, nullable = false, unique = false)
	@Required
	private String nombre;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	// remove optional=false to aggragate but leads to a side effect when going
	// directly to the entity: required check is not performed=> if no set DB
	// check constraint is raised...
	@JoinColumn(name = "pais", referencedColumnName = "id", nullable = false, unique = false)
	@ReferenceView("reference")
	private Pais pais;

	// m2m
	/**
	 * Default constructor
	 */
	public Provincia() {
	}

	public void addCiudadProvinciaViaProvincia(Ciudad ciudad) {
		getCiudadProvinciaViaProvincia().add(ciudad);
	}

	public Boolean getActivo() {
		return activo;
	}

	public Set<Ciudad> getCiudadProvinciaViaProvincia() {
		if (ciudadProvinciaViaProvincia == null) {
			ciudadProvinciaViaProvincia = new HashSet<Ciudad>();
		}
		return ciudadProvinciaViaProvincia;
	}

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Pais getPais() { //
		return pais;
	}

	@javax.persistence.PrePersist
	public void prePersist_() {
	}

	@javax.persistence.PreUpdate
	public void preUpdate_() {
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public void setCiudadProvinciaViaProvincia(
			Set<Ciudad> ciudadProvinciaViaProvincia) {
		this.ciudadProvinciaViaProvincia = ciudadProvinciaViaProvincia;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPais(Pais pais) {
		this.pais = pais;// this.pais = pais;
	}

}
