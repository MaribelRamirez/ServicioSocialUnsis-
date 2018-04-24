
package com.deporte.controller;

import com.deporte.domain.Jugador;
import com.deporte.service.JugadorService;
import com.deporte.service.JugadorServiceImplements;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;


@ViewScoped
@ManagedBean(name= "jugadorController")
public class JugadorController implements Serializable{
    private List <Jugador> ListaRegistro;

    public List<Jugador> getListaRegistro() {
        return ListaRegistro;
    }

    public void setListaRegistro(List<Jugador> ListaRegistro) {
        this.ListaRegistro = ListaRegistro;
    }
    private Jugador selectedJugador;

    public Jugador getSelectedJugador() {
        return selectedJugador;
    }

    public void setSelectedJugador(Jugador selectedJugador) {
        this.selectedJugador = selectedJugador;
    }
private JugadorService jugadorService;
//inicializar objetos
@PostConstruct
public void init(){
    jugadorService=new JugadorServiceImplements();
    inicializarListaJugador();
}
private void inicializarListaJugador(){
ListaRegistro=new ArrayList<>();
ListaRegistro = jugadorService.obtenerRegistros();
}
//metodo para crear el registro
public void crearRegistro(Jugador jugador){
jugadorService.crearRegistro(jugador);
}

public void actualizarRegistro(Jugador jugador){
jugadorService.actualizarRegistro(jugador);
}

 public void eliminarRegistro(int idJugador){
 jugadorService.eliminarRegistro(idJugador);
 }
 
  public Jugador obtenerRegistro(int idJugador){
 return  jugadorService.obtenerRegistro(idJugador);
        
  }
   public List<Jugador> obtenerRegistros(){
 return  jugadorService.obtenerRegistros();
       
   }
  
   
    public void onRowEdit(RowEditEvent event){
    
    jugadorService.actualizarRegistro(selectedJugador);
    //Jugador jugador=(Jugador)event.getObjectt();
    FacesMessage mensaje;
        mensaje = new  FacesMessage ("jugador actualizado",((Jugador) event.getObject()).getIdJugador().toString());
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
  
    }
    
    public void onRowSelect(SelectEvent event){
        //jugadorService.actualizarRegistro(jugador);
        //  FacesMessage mensaje=new FacesMessage();
        
        FacesMessage mensaje;
        mensaje = new  FacesMessage ("jugador seleccionado",((Jugador) event.getObject()).getIdJugador().toString());
         FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public void onRowEditCancel(RowEditEvent event){}
}
