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

import ar.org.buscacoro.domain.buscacoro.Provincia;

/**
 *
 * <p>Title: Pais</p>
 *
 * <p>Description: Domain Object describing a Pais entity</p>
 *
 */
@Entity (name="Pais")
@Table (name="pais")
@Views({
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @view-base-pais@// No ending comment snippet from this extension 
	@View(
		name="base",
		members=
        "" 	
        + "id  ; "
        + "nombre  ; "
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
	    + "provinciaPaisViaPais { provinciaPaisViaPais };" 
	),
	@View(
		name="DEFAULT", 
		extendsView="base",
        members=
          "" 	
	    + "provinciaPaisViaPais { provinciaPaisViaPais };" 
	),
    @View(name="paisDEFAULT_VIEW", 
	   members=
          " id ;" 	
        + "nombre  ; "
        + "activo  ; "
	),
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @view-reference-pais@// No ending comment snippet from this extension 
    @View(name="reference", 
       extendsView="paisDEFAULT_VIEW"
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
name = "PaisTab",
properties=
     " nombre "
    +",  activo "
)
,
@Tab(
name = "PaisTabWithRef",
properties=
     " nombre "
    +",  activo "
)
})
// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-BEGINNING @class-annotation@// No ending comment snippet from this extension 
// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-ENDING @class-annotation@// No ending comment snippet from this extension 
public class Pais {

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


//children
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @child-provinciaPaisViaPais-pais@// No ending comment snippet from this extension 
    @OneToMany (targetEntity=ar.org.buscacoro.domain.buscacoro.Provincia.class, fetch=FetchType.LAZY, mappedBy="pais", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Provincia> provinciaPaisViaPais = new HashSet<Provincia>(); 
   
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 
//m2m
    /**
    * Default constructor
    */
    public Pais() {
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



    public Set<Provincia> getProvinciaPaisViaPais() {
        if (provinciaPaisViaPais == null){
            provinciaPaisViaPais = new HashSet<Provincia>();
        }
        return provinciaPaisViaPais;
    }

    public void setProvinciaPaisViaPais (Set<Provincia> provinciaPaisViaPais) {
        this.provinciaPaisViaPais = provinciaPaisViaPais;
    }	
    
    public void addProvinciaPaisViaPais (Provincia provincia) {
    	    getProvinciaPaisViaPais().add(provincia);
    }
    

// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-pais@// No ending comment snippet from this extension 
    @javax.persistence.PrePersist
    public void prePersist_ () {
    }
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-pais@// No ending comment snippet from this extension 
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
    }
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-BEGINNING @implementation@// No ending comment snippet from this extension 
// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-ENDING @implementation@// No ending comment snippet from this extension 

}
