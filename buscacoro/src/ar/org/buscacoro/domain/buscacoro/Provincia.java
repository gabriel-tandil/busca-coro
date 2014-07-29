package ar.org.buscacoro.domain.buscacoro;

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
public class Provincia {

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
	@JoinColumn(name = "pais", referencedColumnName = "id", nullable = false, unique = false)
	private Pais pais;

	// m2m
	/**
	 * Default constructor
	 */
	public Provincia() {
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

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPais(Pais pais) {
		this.pais = pais;// this.pais = pais;
	}

}
