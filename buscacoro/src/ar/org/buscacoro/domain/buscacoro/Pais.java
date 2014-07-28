package ar.org.buscacoro.domain.buscacoro;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

/**
 * 
 * <p>
 * Title: Pais
 * </p>
 * 
 * <p>
 * Description: Domain Object describing a Pais entity
 * </p>
 * 
 */
@Entity(name = "Pais")
@Table(name = "pais")
@Views({
		@View(name = "base", members = "" + "id  ; " + "nombre  ; "
				+ "activo  ; "),

		@View(name = "Create", extendsView = "base"),
		@View(name = "Update", extendsView = "base", members = ""
				+ "provinciaPaisViaPais { provinciaPaisViaPais };"),
		@View(name = "DEFAULT", extendsView = "base", members = ""
				+ "provinciaPaisViaPais { provinciaPaisViaPais };"),
		@View(name = "paisDEFAULT_VIEW", members = " id ;" + "nombre  ; "
				+ "activo  ; "),
		@View(name = "reference", extendsView = "paisDEFAULT_VIEW"

		) })
@Tabs({ @Tab(properties = " nombre " + ",  activo "),
		@Tab(name = "PaisTab", properties = " nombre " + ",  activo "),
		@Tab(name = "PaisTabWithRef", properties = " nombre " + ",  activo ") })
public class Pais {

	@Column(name = "activo", nullable = false, unique = false)
	@Required
	private Boolean activo;

	@Hidden
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "nombre", length = 100, nullable = false, unique = false)
	@Required
	private String nombre;

	// children
	@OneToMany(targetEntity = ar.org.buscacoro.domain.buscacoro.Provincia.class, fetch = FetchType.LAZY, mappedBy = "pais", cascade = CascadeType.REMOVE)
	// , cascade=CascadeType.ALL)
	private Set<Provincia> provinciaPaisViaPais = new HashSet<Provincia>();

	// m2m
	/**
	 * Default constructor
	 */
	public Pais() {
	}

	public void addProvinciaPaisViaPais(Provincia provincia) {
		getProvinciaPaisViaPais().add(provincia);
	}

	public Boolean getActivo() {
		return activo;
	}

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Set<Provincia> getProvinciaPaisViaPais() {
		if (provinciaPaisViaPais == null) {
			provinciaPaisViaPais = new HashSet<Provincia>();
		}
		return provinciaPaisViaPais;
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

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setProvinciaPaisViaPais(Set<Provincia> provinciaPaisViaPais) {
		this.provinciaPaisViaPais = provinciaPaisViaPais;
	}

}
