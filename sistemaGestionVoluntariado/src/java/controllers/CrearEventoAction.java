/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cliente.EventoClient;
import com.opensymphony.xwork2.ActionSupport;
import entidades.Evento;
import entidades.Organizacion;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author usuario
 */
public class CrearEventoAction extends ActionSupport implements SessionAware{
    
    private String nombre;
    private String descripcion;
    private String fechainicio;
    private String fechafin;
    private Map<String, Object> session;
    
    
    public CrearEventoAction() {
    }
    
    public String execute() throws Exception {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); // mismo que input type="date"

        Date fechaInicioDate = formato.parse(fechainicio);
        Date fechaFinDate = formato.parse(fechafin);
        
        
        EventoClient client1 = new EventoClient();
        String id = client1.countREST();
        Integer idInt = Integer.valueOf(id);
        Evento evento = new Evento();
        evento.setEventoid(idInt + 1);
        evento.setNombre(nombre);
        evento.setDescripcion(descripcion);
        evento.setFechainicio(fechaInicioDate);
        evento.setFechafin(fechaFinDate);
        evento.setInformeCollection(null);
        evento.setInscripcionCollection(null);
        evento.setTareaCollection(null);
        evento.setValoracionCollection(null);
        evento.setOrganizacionid((Organizacion) session.get("organizacion"));
        client1.create_XML(evento);
        List<Evento> eventos = (List<Evento>) session.get("eventos");
        eventos.add(evento);
        session.put("eventos", eventos);
        return SUCCESS;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }

   

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
    
    
}
