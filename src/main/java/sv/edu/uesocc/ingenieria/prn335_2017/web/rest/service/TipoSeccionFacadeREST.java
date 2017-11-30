/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2017.web.rest.service;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso.TipoSeccionFacadeLocal;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones.TipoSeccion;

/**
 *
 * @author 
 */
@Stateless
@Path("tipoSeccion")
public class TipoSeccionFacadeREST extends AbstractFacade<TipoSeccion> implements Serializable{
    
    @EJB
     TipoSeccionFacadeLocal  TipoSeccionFacade;
    

    @PersistenceContext(unitName = "sv.edu.uesocc.ingenieria.prn335_2017_guia09Servidor_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public TipoSeccionFacadeREST() {
        super(TipoSeccion.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(TipoSeccion entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, TipoSeccion entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TipoSeccion> findAll( ) {
      
        try {
            if (TipoSeccionFacade != null) {
                return TipoSeccionFacade.findAll( );
            } 
        } catch (Exception e) {
             Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return Collections.EMPTY_LIST;
    }

    @GET
    @Path("{inicio}/{tamanio}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TipoSeccion> findRange(
            @PathParam("inicio") @DefaultValue("0") int first,
            @PathParam("tamanio") @DefaultValue("10") int size) {
        try {
            if (TipoSeccionFacade != null) {
                return TipoSeccionFacade.findRange(first, size);
            }
        } catch (Exception e) {
            System.out.println("ex: " + e);
        }
        return Collections.EMPTY_LIST;
    }

    @GET
    @Path("{idtipoSeccion}")
    @Produces(MediaType.APPLICATION_JSON)
    public TipoSeccion findById(
            @PathParam("idtipoSeccion") Integer id,
            @PathParam("n") Integer n){
        try {
            if (TipoSeccionFacade != null && id != null) {
                System.out.println(n);
                return TipoSeccionFacade.find(id);
                
            } else {
                
            }
        } catch (Exception e) {
             Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        
      return new TipoSeccion();
   }
    
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
