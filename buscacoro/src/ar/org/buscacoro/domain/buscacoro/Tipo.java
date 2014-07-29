package ar.org.buscacoro.domain.buscacoro;

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
public class Tipo {

	@Hidden
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "nombre", length = 100, nullable = false, unique = false)
	@Required
	private String nombre;

	// m2m
	/**
	 * Default constructor
	 */
	public Tipo() {
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
