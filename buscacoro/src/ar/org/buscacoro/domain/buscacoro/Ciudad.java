package ar.org.buscacoro.domain.buscacoro;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

/**
 * 
 * <p>
 * Title: Ciudad
 * </p>
 * 
 * <p>
 * Description: Domain Object describing a Ciudad entity
 * </p>
 * 
 */
@Entity(name = "Ciudad")
@Table(name = "ciudad")
@Views({
		@View(name = "base", members = "" + "id  ; " + "nombre  ; "
				+ "provincia  ; " + "activo  ; "),

		@View(name = "Create", extendsView = "base"),
		@View(name = "Update", extendsView = "base", members = ""
				+ "coroCiudadViaCiudad { coroCiudadViaCiudad };"
				+ "recursoCiudadViaCiudad { recursoCiudadViaCiudad };"),
		@View(name = "DEFAULT", extendsView = "base", members = ""
				+ "coroCiudadViaCiudad { coroCiudadViaCiudad };"
				+ "recursoCiudadViaCiudad { recursoCiudadViaCiudad };"),
		@View(name = "ciudadDEFAULT_VIEW", members = " id ;" + "nombre  ; "
				+ "activo  ; "),
		@View(name = "reference", extendsView = "ciudadDEFAULT_VIEW"

		) })
@Tabs({ @Tab(properties = " nombre " + ",  activo "),
		@Tab(name = "CiudadTab", properties = " nombre " + ",  activo "),
		@Tab(name = "CiudadTabWithRef", properties = " nombre " + ",  activo ") })
public class Ciudad {

	@Column(name = "activo", nullable = false, unique = false)
	@Required
	private Boolean activo;

	// children
	@OneToMany(targetEntity = ar.org.buscacoro.domain.buscacoro.Coro.class, fetch = FetchType.LAZY, mappedBy = "ciudad", cascade = CascadeType.REMOVE)
	// , cascade=CascadeType.ALL)
	private Set<Coro> coroCiudadViaCiudad = new HashSet<Coro>();

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
	@JoinColumn(name = "provincia", referencedColumnName = "id", nullable = false, unique = false)
	@ReferenceView("reference")
	private Provincia provincia;

	@OneToMany(targetEntity = ar.org.buscacoro.domain.buscacoro.Recurso.class, fetch = FetchType.LAZY, mappedBy = "ciudad", cascade = CascadeType.REMOVE)
	// , cascade=CascadeType.ALL)
	private Set<Recurso> recursoCiudadViaCiudad = new HashSet<Recurso>();

	// m2m
	/**
	 * Default constructor
	 */
	public Ciudad() {
	}

	public void addCoroCiudadViaCiudad(Coro coro) {
		getCoroCiudadViaCiudad().add(coro);
	}

	public void addRecursoCiudadViaCiudad(Recurso recurso) {
		getRecursoCiudadViaCiudad().add(recurso);
	}

	public Boolean getActivo() {
		return activo;
	}

	public Set<Coro> getCoroCiudadViaCiudad() {
		if (coroCiudadViaCiudad == null) {
			coroCiudadViaCiudad = new HashSet<Coro>();
		}
		return coroCiudadViaCiudad;
	}

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Provincia getProvincia() { //
		return provincia;
	}

	public Set<Recurso> getRecursoCiudadViaCiudad() {
		if (recursoCiudadViaCiudad == null) {
			recursoCiudadViaCiudad = new HashSet<Recurso>();
		}
		return recursoCiudadViaCiudad;
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

	public void setCoroCiudadViaCiudad(Set<Coro> coroCiudadViaCiudad) {
		this.coroCiudadViaCiudad = coroCiudadViaCiudad;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;// this.provincia = provincia;
	}

	public void setRecursoCiudadViaCiudad(Set<Recurso> recursoCiudadViaCiudad) {
		this.recursoCiudadViaCiudad = recursoCiudadViaCiudad;
	}

}
