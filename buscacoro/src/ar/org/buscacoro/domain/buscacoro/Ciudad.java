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

import ar.org.buscacoro.domain.buscacoro.Coro;
import ar.org.buscacoro.domain.buscacoro.Recurso;
import ar.org.buscacoro.domain.buscacoro.Provincia;

/**
 *
 * <p>Title: Ciudad</p>
 *
 * <p>Description: Domain Object describing a Ciudad entity</p>
 *
 */
@Entity (name="Ciudad")
@Table (name="ciudad")
@Views({
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @view-base-ciudad@// No ending comment snippet from this extension 
	@View(
		name="base",
		members=
        "" 	
        + "id  ; "
        + "nombre  ; "
        + "provincia  ; "
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
	    + "coroCiudadViaCiudad { coroCiudadViaCiudad };" 
	    + "recursoCiudadViaCiudad { recursoCiudadViaCiudad };" 
	),
	@View(
		name="DEFAULT", 
		extendsView="base",
        members=
          "" 	
	    + "coroCiudadViaCiudad { coroCiudadViaCiudad };" 
	    + "recursoCiudadViaCiudad { recursoCiudadViaCiudad };" 
	),
    @View(name="ciudadDEFAULT_VIEW", 
	   members=
          " id ;" 	
        + "nombre  ; "
        + "activo  ; "
	),
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @view-reference-ciudad@// No ending comment snippet from this extension 
    @View(name="reference", 
       extendsView="ciudadDEFAULT_VIEW"
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
name = "CiudadTab",
properties=
     " nombre "
    +",  activo "
)
,
@Tab(
name = "CiudadTabWithRef",
properties=
     " nombre "
    +",  activo "
)
})
// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-BEGINNING @class-annotation@// No ending comment snippet from this extension 
// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-ENDING @class-annotation@// No ending comment snippet from this extension 
public class Ciudad {

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


// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @parent-Provincia-ciudad@// No ending comment snippet from this extension 
    @ManyToOne (fetch=FetchType.LAZY ,optional=false) //remove optional=false to aggragate but leads to a side effect when going directly to the entity: required check is not performed=> if no set DB check constraint is raised...
    @JoinColumn(name="provincia", referencedColumnName = "id", nullable=false,  unique=false  )
    @ReferenceView ("reference") 
    private Provincia provincia;
    
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 
//children
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @child-coroCiudadViaCiudad-ciudad@// No ending comment snippet from this extension 
    @OneToMany (targetEntity=ar.org.buscacoro.domain.buscacoro.Coro.class, fetch=FetchType.LAZY, mappedBy="ciudad", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Coro> coroCiudadViaCiudad = new HashSet<Coro>(); 
   
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @child-recursoCiudadViaCiudad-ciudad@// No ending comment snippet from this extension 
    @OneToMany (targetEntity=ar.org.buscacoro.domain.buscacoro.Recurso.class, fetch=FetchType.LAZY, mappedBy="ciudad", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Recurso> recursoCiudadViaCiudad = new HashSet<Recurso>(); 
   
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 
//m2m
    /**
    * Default constructor
    */
    public Ciudad() {
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


    public Provincia getProvincia () {  //
    	return provincia;
    }
	
    public void setProvincia (Provincia provincia) {
    	this.provincia = provincia;//this.provincia = provincia;
    }

    public Set<Coro> getCoroCiudadViaCiudad() {
        if (coroCiudadViaCiudad == null){
            coroCiudadViaCiudad = new HashSet<Coro>();
        }
        return coroCiudadViaCiudad;
    }

    public void setCoroCiudadViaCiudad (Set<Coro> coroCiudadViaCiudad) {
        this.coroCiudadViaCiudad = coroCiudadViaCiudad;
    }	
    
    public void addCoroCiudadViaCiudad (Coro coro) {
    	    getCoroCiudadViaCiudad().add(coro);
    }
    
    public Set<Recurso> getRecursoCiudadViaCiudad() {
        if (recursoCiudadViaCiudad == null){
            recursoCiudadViaCiudad = new HashSet<Recurso>();
        }
        return recursoCiudadViaCiudad;
    }

    public void setRecursoCiudadViaCiudad (Set<Recurso> recursoCiudadViaCiudad) {
        this.recursoCiudadViaCiudad = recursoCiudadViaCiudad;
    }	
    
    public void addRecursoCiudadViaCiudad (Recurso recurso) {
    	    getRecursoCiudadViaCiudad().add(recurso);
    }
    

// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-ciudad@// No ending comment snippet from this extension 
    @javax.persistence.PrePersist
    public void prePersist_ () {
    }
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-ciudad@// No ending comment snippet from this extension 
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
    }
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 

// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-BEGINNING @implementation@// No ending comment snippet from this extension 
// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-ENDING @implementation@// No ending comment snippet from this extension 

}
