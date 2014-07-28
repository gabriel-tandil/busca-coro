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

/**
 *
 * <p>Title: Tipo</p>
 *
 * <p>Description: Domain Object describing a Tipo entity</p>
 *
 */
@Entity (name="Tipo")
@Table (name="tipo")
@Views({
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @view-base-tipo@// No ending comment snippet from this extension 
	@View(
		name="base",
		members=
        "" 	
        + "id  ; "
        + "nombre  ; "
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
	    + "coroTipoViaTipo { coroTipoViaTipo };" 
	),
	@View(
		name="DEFAULT", 
		extendsView="base",
        members=
          "" 	
	    + "coroTipoViaTipo { coroTipoViaTipo };" 
	),
    @View(name="tipoDEFAULT_VIEW", 
	   members=
          " id ;" 	
        + "nombre  ; "
	),
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @view-reference-tipo@// No ending comment snippet from this extension 
    @View(name="reference", 
       extendsView="tipoDEFAULT_VIEW"
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 
    )
})

@Tabs({
@Tab(
properties=
     " nombre "
)
,
@Tab(
name = "TipoTab",
properties=
     " nombre "
)
,
@Tab(
name = "TipoTabWithRef",
properties=
     " nombre "
)
})
// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-BEGINNING @class-annotation@// No ending comment snippet from this extension 
// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-ENDING @class-annotation@// No ending comment snippet from this extension 
public class Tipo {

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


//children
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @child-coroTipoViaTipo-tipo@// No ending comment snippet from this extension 
    @OneToMany (targetEntity=ar.org.buscacoro.domain.buscacoro.Coro.class, fetch=FetchType.LAZY, mappedBy="tipo", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Coro> coroTipoViaTipo = new HashSet<Coro>(); 
   
// No beginning comment snippet from this extension MP-MANAGED-UPDATABLE-ENDING// No ending comment snippet from this extension 
//m2m
    /**
    * Default constructor
    */
    public Tipo() {
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



    public Set<Coro> getCoroTipoViaTipo() {
        if (coroTipoViaTipo == null){
            coroTipoViaTipo = new HashSet<Coro>();
        }
        return coroTipoViaTipo;
    }

    public void setCoroTipoViaTipo (Set<Coro> coroTipoViaTipo) {
        this.coroTipoViaTipo = coroTipoViaTipo;
    }	
    
    public void addCoroTipoViaTipo (Coro coro) {
    	    getCoroTipoViaTipo().add(coro);
    }
    



// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-BEGINNING @implementation@// No ending comment snippet from this extension 
// No beginning comment snippet from this extension MP-MANAGED-ADDED-AREA-ENDING @implementation@// No ending comment snippet from this extension 

}
