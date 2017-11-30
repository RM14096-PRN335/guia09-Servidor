/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2017.web.controladores;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso.InterfaceFacade;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones.TipoSeccion;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso.TipoSeccionFacadeLocal;

@Named(value = "TipoSeccionBean")
@ViewScoped
public class TipoSeccionBean extends AbstractManagedBean<TipoSeccion> implements Serializable {

    @EJB
    TipoSeccionFacadeLocal TipoSeccionFacade;
    TipoSeccion TipoSeccion= new TipoSeccion();
    boolean activo=false, panel = true;
    
    public TipoSeccionBean() {
    }
   
    /**
     * Este metodo carga la lista inicial de datos a la DataTable al ingresar a
     * la aplicacion
     */
    @PostConstruct
    public void init() {
        super.AbstractManagedBean();
        llenarLista();
        System.out.println("POSTCONSTRUCT");
    }

    /**
     * invoca al metodo create de la clase AbstractFacade y crea un registro en
     * la DB
     */
    @Override
    public void crear() {
        super.AbstractManagedBean();
        super.crear();
        cancelar();
    }

    /**
     * Elimina registros de la DB utilizando el metodo remove de la clase
     * AbstractFacade
     */
    @Override
    public void eliminar() {
        super.AbstractManagedBean();
        super.eliminar();
        cancelar();
    }

    /**
     * Invaco al metodo edit de la clase AbstractFacade para editar un registro
     */
    @Override
    public void editar() {
        super.AbstractManagedBean();
        super.editar();
        cancelar();
    }

    /**
     * si el objeto rol es diferente de nulo asigna una nueva instancia a este
     * para dejarlo vacio, oculta el panel de botones de edicion
     */
    public void cancelar() {
        TipoSeccion=new TipoSeccion();
        System.out.println("LIMPIAR");
        panel = true;
        activo=false;
    }
    

    /**
     * Recice un evente de tipo SelectEvent, asigna los valores del objeto
     * recivido a las propiedades del objeto rol
     *
     * @param event
     */
    public void onRowSelect(SelectEvent event) {
        TipoSeccion = (TipoSeccion) event.getObject();
        panel=false;
        activo=true;
    }


    public TipoSeccion getRol() {
        return TipoSeccion;
    }

    public void setTipoSeccion(TipoSeccion TipoSeccion) {
        this.TipoSeccion = TipoSeccion;
    }

    public  TipoSeccionFacadeLocal getTipoSeccionFacade() {
        return TipoSeccionFacade;
    }

    public void setTipoSeccionFacade(TipoSeccionFacadeLocal TipoSeccionFacade) {
        this.TipoSeccionFacade = TipoSeccionFacade;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean isPanel() {
        return panel;
    }

    public void setPanel(boolean panel) {
        this.panel = panel;
    }

    public List<TipoSeccion> getListaRegistros() {
        return listaRegistros;
    }

    public void setListaRegistros(List<TipoSeccion> listaRegistros) {
        this.listaRegistros = listaRegistros;
    }
    
    @Override
    protected InterfaceFacade<TipoSeccion> getFacadeLocal() {
        return (InterfaceFacade<TipoSeccion>) TipoSeccionFacade;
    }

    @Override
    protected TipoSeccion getEntity() {
        return TipoSeccion;
    }

}
