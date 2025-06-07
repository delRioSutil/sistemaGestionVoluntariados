/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import cliente.EventoClient;
import cliente.InscripcionJerseyClient;
import cliente.VoluntarioJerseyClient;
import entidades.Evento;
import entidades.Inscripcion;
import entidades.Voluntario;
import java.util.Date;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Collection;
import org.apache.struts2.interceptor.SessionAware;

public class InscribirseEventoAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;
    private Integer eventoId; // Recibido del formulario
    private String eventoNombre;
    String mensaje;

    // SETTER obligatorio para Struts
    public void setEventoId(Integer eventoId) {
        this.eventoId = eventoId;
    }

    @Override
    public String execute() throws Exception {
        // Obtener el ID del voluntario desde sesión
        Integer voluntarioId = (Integer) session.get("voluntarioId");

        if (voluntarioId == null || eventoId == null) {
            return ERROR;
        }

        // Crear cliente y obtener entidades necesarias
        EventoClient eventoClient = new EventoClient();
        GenericType<Evento> eventoType = new GenericType<Evento>() {};
        Evento evento = eventoClient.find_XML(eventoType, eventoId.toString());
       

        VoluntarioJerseyClient voluntarioClient = new VoluntarioJerseyClient();
        GenericType<Voluntario> voluntarioType = new GenericType<Voluntario>() {};
        Voluntario voluntario = voluntarioClient.find_XML(voluntarioType, voluntarioId.toString());
        
      System.out.println("Evento recibido: " + evento);                             // Verifica si es null
if (evento == null) {
    mensaje = "No se pudo encontrar el evento con ID " + eventoId;
    return ERROR;
}

 InscripcionJerseyClient inscripcionClient = new InscripcionJerseyClient();
        GenericType<Collection<Inscripcion>> tipoInscripciones = new GenericType<Collection<Inscripcion>>() {};
        Collection<Inscripcion> todasInscripciones = inscripcionClient.findAll_XML(tipoInscripciones);

        for (Inscripcion insc : todasInscripciones) {
            if (insc.getEventoid().getEventoid().equals(eventoId) &&
                insc.getVoluntarioid().getVoluntarioId().equals(voluntarioId)) {
                mensaje = "Ya estás inscrito en este evento.";
                return SUCCESS;
            }
        }


        // Obtener nuevo ID de inscripción
        int nuevoId = Integer.parseInt(inscripcionClient.countREST()) + 1;

        // Crear inscripción
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setInscripcionId(nuevoId);
        inscripcion.setEventoid(evento);
        inscripcion.setVoluntarioid(voluntario);
        inscripcion.setFechainscripcion(new Date());
        inscripcion.setAprobada(false);
        inscripcion.setAsistencia(false);

        // Enviar al servidor
        inscripcionClient.create_XML(inscripcion);

        return SUCCESS;
    }

    public String getEventoNombre() {
        return eventoNombre;
    }

    public void setEventoNombre(String eventoNombre) {
        this.eventoNombre = eventoNombre;
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}