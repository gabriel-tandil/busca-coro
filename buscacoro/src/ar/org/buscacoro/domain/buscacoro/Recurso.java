package ar.org.buscacoro.domain.buscacoro;

import javax.persistence.*;

import org.openxava.annotations.*;

/**
 * 
 * <p>
 * Title: Recurso
 * </p>
 * 
 * <p>
 * Description: Domain Object describing a Recurso entity
 * </p>
 * 
 */
@Entity(name = "Recurso")
@Table(name = "recurso")
@Views({
		@View(name = "base", members = "" + "id  ; " + "ciudad  ; "
				+ "nombre  ; " + "detalle  ; " + "web  ; " + "email  ; "
				+ "contacto  ; " + "demo  ; " + "material  ; " + "activo  ; "
				+ "modificacion  ; " + "hasta  ; " + "desde  ; "),

		@View(name = "Create", extendsView = "base"),
		@View(name = "Update", extendsView = "base", members = ""),
		@View(name = "DEFAULT", extendsView = "base", members = ""),
		@View(name = "recursoDEFAULT_VIEW", members = " id ;" + "nombre  ; "
				+ "detalle  ; " + "web  ; " + "email  ; " + "contacto  ; "
				+ "demo  ; " + "material  ; " + "activo  ; "
				+ "modificacion  ; " + "hasta  ; " + "desde  ; "),
		@View(name = "reference", extendsView = "recursoDEFAULT_VIEW"

		) })
@Tabs({
		@Tab(properties = " nombre " + ",  detalle " + ",  web " + ",  email "
				+ ",  contacto " + ",  demo " + ",  material " + ",  activo "
				+ ",  modificacion " + ",  hasta " + ",  desde "),
		@Tab(name = "RecursoTab", properties = " nombre " + ",  detalle "
				+ ",  web " + ",  email " + ",  contacto " + ",  demo "
				+ ",  material " + ",  activo " + ",  modificacion "
				+ ",  hasta " + ",  desde "),
		@Tab(name = "RecursoTabWithRef", properties = " nombre "
				+ ",  detalle " + ",  web " + ",  email " + ",  contacto "
				+ ",  demo " + ",  material " + ",  activo "
				+ ",  modificacion " + ",  hasta " + ",  desde ") })
public class Recurso {

	@Column(name = "activo", nullable = false, unique = false)
	@Required
	private Boolean activo;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	// remove optional=false to aggragate but leads to a side effect when going
	// directly to the entity: required check is not performed=> if no set DB
	// check constraint is raised...
	@JoinColumn(name = "ciudad", referencedColumnName = "id", nullable = false, unique = false)
	private Ciudad ciudad;

	@Column(name = "contacto", length = 100, nullable = false, unique = false)
	@Required
	private String contacto;

	@Column(name = "demo", nullable = false, unique = false)
	@Required
	private Boolean demo;

	@Column(name = "desde", nullable = true, unique = false)
	@Temporal(TemporalType.DATE)
	private java.util.Date desde;

	@Column(name = "detalle", length = 500, nullable = false, unique = false)
	@Required
	private String detalle;

	@Column(name = "email", length = 100, nullable = false, unique = false)
	@Required
	private String email;

	@Column(name = "hasta", nullable = true, unique = false)
	@Temporal(TemporalType.DATE)
	private java.util.Date hasta;

	@Hidden
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "material", nullable = false, unique = false)
	@Required
	private Boolean material;

	@Column(name = "modificacion", nullable = false, unique = false)
	@Required
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date modificacion;

	@Column(name = "nombre", length = 100, nullable = false, unique = false)
	@Required
	private String nombre;

	@Column(name = "web", length = 250, nullable = false, unique = false)
	@Required
	private String web;

	// children
	// m2m
	/**
	 * Default constructor
	 */
	public Recurso() {
	}

	public Boolean getActivo() {
		return activo;
	}

	public Ciudad getCiudad() { //
		return ciudad;
	}

	public String getContacto() {
		return contacto;
	}

	public Boolean getDemo() {
		return demo;
	}

	public java.util.Date getDesde() {
		return desde;
	}

	public String getDetalle() {
		return detalle;
	}

	public String getEmail() {
		return email;
	}

	public java.util.Date getHasta() {
		return hasta;
	}

	public int getId() {
		return id;
	}

	public Boolean getMaterial() {
		return material;
	}

	public java.util.Date getModificacion() {
		return modificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public String getWeb() {
		return web;
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

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;// this.ciudad = ciudad;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public void setDemo(Boolean demo) {
		this.demo = demo;
	}

	public void setDesde(java.util.Date desde) {
		this.desde = desde;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setHasta(java.util.Date hasta) {
		this.hasta = hasta;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMaterial(Boolean material) {
		this.material = material;
	}

	public void setModificacion(java.util.Date modificacion) {
		this.modificacion = modificacion;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setWeb(String web) {
		this.web = web;
	}

}
