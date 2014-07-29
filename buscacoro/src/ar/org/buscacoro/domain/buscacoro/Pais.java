package ar.org.buscacoro.domain.buscacoro;

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
public class Pais {

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

	/**
	 * Default constructor
	 */
	public Pais() {
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

}
