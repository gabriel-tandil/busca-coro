package ar.org.buscacoro.domain.buscacoro;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

/**
 * 
 * <p>
 * Title: Tipo
 * </p>
 * 
 * <p>
 * Description: Domain Object describing a Tipo entity
 * </p>
 * 
 */
@Entity(name = "Tipo")
@Table(name = "tipo")
@Views({
		@View(name = "base", members = "" + "id  ; " + "nombre  ; "),

		@View(name = "Create", extendsView = "base"),
		@View(name = "Update", extendsView = "base", members = ""
				+ "coroTipoViaTipo { coroTipoViaTipo };"),
		@View(name = "DEFAULT", extendsView = "base", members = ""
				+ "coroTipoViaTipo { coroTipoViaTipo };"),
		@View(name = "tipoDEFAULT_VIEW", members = " id ;" + "nombre  ; "),
		@View(name = "reference", extendsView = "tipoDEFAULT_VIEW"

		) })
@Tabs({ @Tab(properties = " nombre "),
		@Tab(name = "TipoTab", properties = " nombre "),
		@Tab(name = "TipoTabWithRef", properties = " nombre ") })
public class Tipo {

	// children
	@OneToMany(targetEntity = ar.org.buscacoro.domain.buscacoro.Coro.class, fetch = FetchType.LAZY, mappedBy = "tipo", cascade = CascadeType.REMOVE)
	// , cascade=CascadeType.ALL)
	private Set<Coro> coroTipoViaTipo = new HashSet<Coro>();

	@Hidden
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "nombre", length = 100, nullable = false, unique = false)
	@Required
	private String nombre;

	// m2m
	/**
	 * Default constructor
	 */
	public Tipo() {
	}

	public void addCoroTipoViaTipo(Coro coro) {
		getCoroTipoViaTipo().add(coro);
	}

	public Set<Coro> getCoroTipoViaTipo() {
		if (coroTipoViaTipo == null) {
			coroTipoViaTipo = new HashSet<Coro>();
		}
		return coroTipoViaTipo;
	}

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setCoroTipoViaTipo(Set<Coro> coroTipoViaTipo) {
		this.coroTipoViaTipo = coroTipoViaTipo;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
