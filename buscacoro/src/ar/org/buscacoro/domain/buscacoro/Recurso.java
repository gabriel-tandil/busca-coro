package ar.org.buscacoro.domain.buscacoro;

// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-BEGINNING @import@// No ending comment snippet from this extension 
// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-ENDING @import@// No ending comment snippet from this extension 
import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

import javax.persistence.*;
import org.openxava.annotations.*;

import ar.org.buscacoro.domain.buscacoro.Ciudad;

/**
 *
 * <p>Title: Recurso</p>
 *
 * <p>Description: Domain Object describing a Recurso entity</p>
 *
 */
@Entity (name="Recurso")
@Table (name="recurso")
@Views({
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @view-base-recurso@// No ending comment snippet from this extension 
	@View(
		name="base",
		members=
        "" 	
        + "id  ; "
        + "ciudad  ; "
        + "nombre  ; "
        + "detalle  ; "
        + "web  ; "
        + "email  ; "
        + "contacto  ; "
        + "demo  ; "
        + "material  ; "
        + "activo  ; "
        + "modificacion  ; "
        + "hasta  ; "
        + "desde  ; "
		),
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 
	@View(
		name="Create", 
		extendsView="base"
	),
	@View(
		name="Update", 
		extendsView="base",
        members=
          "" 	
	),
	@View(
		name="DEFAULT", 
		extendsView="base",
        members=
          "" 	
	),
    @View(name="recursoDEFAULT_VIEW", 
	   members=
          " id ;" 	
        + "nombre  ; "
        + "detalle  ; "
        + "web  ; "
        + "email  ; "
        + "contacto  ; "
        + "demo  ; "
        + "material  ; "
        + "activo  ; "
        + "modificacion  ; "
        + "hasta  ; "
        + "desde  ; "
	),
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @view-reference-recurso@// No ending comment snippet from this extension 
    @View(name="reference", 
       extendsView="recursoDEFAULT_VIEW"
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 
    )
})

@Tabs({
@Tab(
properties=
     " nombre "
    +",  detalle "
    +",  web "
    +",  email "
    +",  contacto "
    +",  demo "
    +",  material "
    +",  activo "
    +",  modificacion "
    +",  hasta "
    +",  desde "
)
,
@Tab(
name = "RecursoTab",
properties=
     " nombre "
    +",  detalle "
    +",  web "
    +",  email "
    +",  contacto "
    +",  demo "
    +",  material "
    +",  activo "
    +",  modificacion "
    +",  hasta "
    +",  desde "
)
,
@Tab(
name = "RecursoTabWithRef",
properties=
     " nombre "
    +",  detalle "
    +",  web "
    +",  email "
    +",  contacto "
    +",  demo "
    +",  material "
    +",  activo "
    +",  modificacion "
    +",  hasta "
    +",  desde "
)
})
// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-BEGINNING @class-annotation@// No ending comment snippet from this extension 
// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-ENDING @class-annotation@// No ending comment snippet from this extension 
public class Recurso {

    @Hidden  @Id @Column(name="id" )
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id; 

// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-BEGINNING @nombre-field-annotation@// No ending comment snippet from this extension 
// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-ENDING @nombre-field-annotation@// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-nombre@// No ending comment snippet from this extension 
    @Column(name="nombre",  length=100, nullable=false,  unique=false)
    @Required
    private String nombre;
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-BEGINNING @detalle-field-annotation@// No ending comment snippet from this extension 
// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-ENDING @detalle-field-annotation@// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-detalle@// No ending comment snippet from this extension 
    @Column(name="detalle",  length=500, nullable=false,  unique=false)
    @Required
    private String detalle;
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-BEGINNING @web-field-annotation@// No ending comment snippet from this extension 
// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-ENDING @web-field-annotation@// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-web@// No ending comment snippet from this extension 
    @Column(name="web",  length=250, nullable=false,  unique=false)
    @Required
    private String web;
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-BEGINNING @email-field-annotation@// No ending comment snippet from this extension 
// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-ENDING @email-field-annotation@// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-email@// No ending comment snippet from this extension 
    @Column(name="email",  length=100, nullable=false,  unique=false)
    @Required
    private String email;
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-BEGINNING @contacto-field-annotation@// No ending comment snippet from this extension 
// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-ENDING @contacto-field-annotation@// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-contacto@// No ending comment snippet from this extension 
    @Column(name="contacto",  length=100, nullable=false,  unique=false)
    @Required
    private String contacto;
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-BEGINNING @demo-field-annotation@// No ending comment snippet from this extension 
// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-ENDING @demo-field-annotation@// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-demo@// No ending comment snippet from this extension 
    @Column(name="demo",   nullable=false,  unique=false)
    @Required
    private Boolean demo;
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-BEGINNING @material-field-annotation@// No ending comment snippet from this extension 
// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-ENDING @material-field-annotation@// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-material@// No ending comment snippet from this extension 
    @Column(name="material",   nullable=false,  unique=false)
    @Required
    private Boolean material;
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-BEGINNING @activo-field-annotation@// No ending comment snippet from this extension 
// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-ENDING @activo-field-annotation@// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-activo@// No ending comment snippet from this extension 
    @Column(name="activo",   nullable=false,  unique=false)
    @Required
    private Boolean activo;
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-BEGINNING @modificacion-field-annotation@// No ending comment snippet from this extension 
// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-ENDING @modificacion-field-annotation@// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-modificacion@// No ending comment snippet from this extension 
    @Column(name="modificacion",   nullable=false,  unique=false)
    @Required
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date modificacion;
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-BEGINNING @hasta-field-annotation@// No ending comment snippet from this extension 
// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-ENDING @hasta-field-annotation@// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-hasta@// No ending comment snippet from this extension 
    @Column(name="hasta",    nullable=true,  unique=false)
    @Temporal(TemporalType.DATE)
    private java.util.Date hasta;
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-BEGINNING @desde-field-annotation@// No ending comment snippet from this extension 
// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-ENDING @desde-field-annotation@// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-desde@// No ending comment snippet from this extension 
    @Column(name="desde",    nullable=true,  unique=false)
    @Temporal(TemporalType.DATE)
    private java.util.Date desde;
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 


// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @parent-Ciudad-recurso@// No ending comment snippet from this extension 
    @ManyToOne (fetch=FetchType.LAZY ,optional=false) //remove optional=false to aggragate but leads to a side effect when going directly to the entity: required check is not performed=> if no set DB check constraint is raised...
    @JoinColumn(name="ciudad", referencedColumnName = "id", nullable=false,  unique=false  )
    @ReferenceView ("reference") 
    private Ciudad ciudad;
    
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 
//children
//m2m
    /**
    * Default constructor
    */
    public Recurso() {
    }


    public Integer getId() {
        return id;
    }
	
    public void setId (Integer id) {
        this.id =  id;
    }
    

// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-nombre@// No ending comment snippet from this extension 
    public String getNombre() {
        return nombre;
    }
	
    public void setNombre (String nombre) {
        this.nombre =  nombre;
    } 
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-detalle@// No ending comment snippet from this extension 
    public String getDetalle() {
        return detalle;
    }
	
    public void setDetalle (String detalle) {
        this.detalle =  detalle;
    } 
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-web@// No ending comment snippet from this extension 
    public String getWeb() {
        return web;
    }
	
    public void setWeb (String web) {
        this.web =  web;
    } 
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-email@// No ending comment snippet from this extension 
    public String getEmail() {
        return email;
    }
	
    public void setEmail (String email) {
        this.email =  email;
    } 
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-contacto@// No ending comment snippet from this extension 
    public String getContacto() {
        return contacto;
    }
	
    public void setContacto (String contacto) {
        this.contacto =  contacto;
    } 
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-demo@// No ending comment snippet from this extension 
    public Boolean getDemo() {
        return demo;
    }
	
    public void setDemo (Boolean demo) {
        this.demo =  demo;
    } 
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-material@// No ending comment snippet from this extension 
    public Boolean getMaterial() {
        return material;
    }
	
    public void setMaterial (Boolean material) {
        this.material =  material;
    } 
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-activo@// No ending comment snippet from this extension 
    public Boolean getActivo() {
        return activo;
    }
	
    public void setActivo (Boolean activo) {
        this.activo =  activo;
    } 
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-modificacion@// No ending comment snippet from this extension 
    public java.util.Date getModificacion() {
        return modificacion;
    }
	
    public void setModificacion (java.util.Date modificacion) {
        this.modificacion =  modificacion;
    } 
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-hasta@// No ending comment snippet from this extension 
    public java.util.Date getHasta() {
        return hasta;
    }
	
    public void setHasta (java.util.Date hasta) {
        this.hasta =  hasta;
    } 
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-desde@// No ending comment snippet from this extension 
    public java.util.Date getDesde() {
        return desde;
    }
	
    public void setDesde (java.util.Date desde) {
        this.desde =  desde;
    } 
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 


    public Ciudad getCiudad () {  //
    	return ciudad;
    }
	
    public void setCiudad (Ciudad ciudad) {
    	this.ciudad = ciudad;//this.ciudad = ciudad;
    }


// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-recurso@// No ending comment snippet from this extension 
    @javax.persistence.PrePersist
    public void prePersist_ () {
    }
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-recurso@// No ending comment snippet from this extension 
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
    }
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-BEGINNING @implementation@// No ending comment snippet from this extension 
// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-ENDING @implementation@// No ending comment snippet from this extension 

}
