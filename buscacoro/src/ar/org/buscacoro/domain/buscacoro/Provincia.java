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
import ar.org.buscacoro.domain.buscacoro.Pais;

/**
 *
 * <p>Title: Provincia</p>
 *
 * <p>Description: Domain Object describing a Provincia entity</p>
 *
 */
@Entity (name="Provincia")
@Table (name="provincia")
@Views({
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @view-base-provincia@// No ending comment snippet from this extension 
	@View(
		name="base",
		members=
        "" 	
        + "id  ; "
        + "nombre  ; "
        + "pais  ; "
        + "activo  ; "
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
	    + "ciudadProvinciaViaProvincia { ciudadProvinciaViaProvincia };" 
	),
	@View(
		name="DEFAULT", 
		extendsView="base",
        members=
          "" 	
	    + "ciudadProvinciaViaProvincia { ciudadProvinciaViaProvincia };" 
	),
    @View(name="provinciaDEFAULT_VIEW", 
	   members=
          " id ;" 	
        + "nombre  ; "
        + "activo  ; "
	),
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @view-reference-provincia@// No ending comment snippet from this extension 
    @View(name="reference", 
       extendsView="provinciaDEFAULT_VIEW"
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 
    )
})

@Tabs({
@Tab(
properties=
     " nombre "
    +",  activo "
)
,
@Tab(
name = "ProvinciaTab",
properties=
     " nombre "
    +",  activo "
)
,
@Tab(
name = "ProvinciaTabWithRef",
properties=
     " nombre "
    +",  activo "
)
})
// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-BEGINNING @class-annotation@// No ending comment snippet from this extension 
// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-ENDING @class-annotation@// No ending comment snippet from this extension 
public class Provincia {

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

// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-BEGINNING @activo-field-annotation@// No ending comment snippet from this extension 
// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-ENDING @activo-field-annotation@// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-activo@// No ending comment snippet from this extension 
    @Column(name="activo",   nullable=false,  unique=false)
    @Required
    private Boolean activo;
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 


// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @parent-Pais-provincia@// No ending comment snippet from this extension 
    @ManyToOne (fetch=FetchType.LAZY ,optional=false) //remove optional=false to aggragate but leads to a side effect when going directly to the entity: required check is not performed=> if no set DB check constraint is raised...
    @JoinColumn(name="pais", referencedColumnName = "id", nullable=false,  unique=false  )
    @ReferenceView ("reference") 
    private Pais pais;
    
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 
//children
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @child-ciudadProvinciaViaProvincia-provincia@// No ending comment snippet from this extension 
    @OneToMany (targetEntity=ar.org.buscacoro.domain.buscacoro.Ciudad.class, fetch=FetchType.LAZY, mappedBy="provincia", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Ciudad> ciudadProvinciaViaProvincia = new HashSet<Ciudad>(); 
   
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 
//m2m
    /**
    * Default constructor
    */
    public Provincia() {
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

// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-activo@// No ending comment snippet from this extension 
    public Boolean getActivo() {
        return activo;
    }
	
    public void setActivo (Boolean activo) {
        this.activo =  activo;
    } 
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 


    public Pais getPais () {  //
    	return pais;
    }
	
    public void setPais (Pais pais) {
    	this.pais = pais;//this.pais = pais;
    }

    public Set<Ciudad> getCiudadProvinciaViaProvincia() {
        if (ciudadProvinciaViaProvincia == null){
            ciudadProvinciaViaProvincia = new HashSet<Ciudad>();
        }
        return ciudadProvinciaViaProvincia;
    }

    public void setCiudadProvinciaViaProvincia (Set<Ciudad> ciudadProvinciaViaProvincia) {
        this.ciudadProvinciaViaProvincia = ciudadProvinciaViaProvincia;
    }	
    
    public void addCiudadProvinciaViaProvincia (Ciudad ciudad) {
    	    getCiudadProvinciaViaProvincia().add(ciudad);
    }
    

// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-provincia@// No ending comment snippet from this extension 
    @javax.persistence.PrePersist
    public void prePersist_ () {
    }
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-provincia@// No ending comment snippet from this extension 
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
    }
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-BEGINNING @implementation@// No ending comment snippet from this extension 
// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-ENDING @implementation@// No ending comment snippet from this extension 

}
