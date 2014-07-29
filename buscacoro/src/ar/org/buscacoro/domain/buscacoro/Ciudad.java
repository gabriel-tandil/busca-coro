package ar.org.buscacoro.domain.buscacoro;

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
public class Ciudad {

	@Column(name = "activo", nullable = false, unique = false)
	@Required
	private Boolean activo;

	@Hidden
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "nombre", length = 100, nullable = false, unique = false)
	@Required
	private String nombre;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	// remove optional=false to aggragate but leads to a side effect when going
	// directly to the entity: required check is not performed=> if no set DB
	// check constraint is raised...
	@JoinColumn(name = "provincia", referencedColumnName = "id", nullable = false, unique = false)
	private Provincia provincia;

	/**
	 * Default constructor
	 */
	public Ciudad() {
	}

	public Boolean getActivo() {
		return activo;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Provincia getProvincia() { //
		return provincia;
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

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

}
