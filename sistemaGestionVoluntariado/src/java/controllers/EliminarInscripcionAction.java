/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cliente.InscripcionJerseyClient;
import cliente.EventoClient;
import cliente.VoluntarioJerseyClient;
import entidades.Inscripcion;
import entidades.Evento;
import entidades.Voluntario;

import java.util.Collection;
import java.util.Map;
import javax.ws.rs.core.GenericType;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

public class EliminarInscripcionAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;
    private Integer eventoId;
    private String mensaje;

    public void setEventoId(Integer eventoId) {
        this.eventoId = eventoId;
    }

    public Integer getEventoId() {
        return eventoId;
    }

    public String getMensaje() {
        return mensaje;
    }

    @Override
    public String execute() throws Exception {
        Integer voluntarioId = (Integer) session.get("voluntarioId");

        if (eventoId == null || voluntarioId == null) {
            mensaje = "Error: datos incompletos.";
            return ERROR;
        }

        EventoClient eventoClient = new EventoClient();
        VoluntarioJerseyClient voluntarioClient = new VoluntarioJerseyClient();
        InscripcionJerseyClient inscripcionClient = new InscripcionJerseyClient();

        Evento evento = eventoClient.find_XML(new GenericType<Evento>() {}, eventoId.toString());
        Voluntario voluntario = voluntarioClient.find_XML(new GenericType<Voluntario>() {}, voluntarioId.toString());

        // Buscar inscripción asociada al voluntario y evento
       Collection<Inscripcion> todasLasInscripciones = inscripcionClient.findAll_XML(new GenericType<Collection<Inscripcion>>() {});

for (Inscripcion inscripcion : todasLasInscripciones) {
    if (inscripcion.getEventoid() != null && inscripcion.getVoluntarioid() != null) {
        Integer idEvento = inscripcion.getEventoid().getEventoid();
        Integer idVoluntario = inscripcion.getVoluntarioid().getVoluntarioId();

        if (eventoId.equals(idEvento) && voluntarioId.equals(idVoluntario)) {
            inscripcionClient.remove(inscripcion.getInscripcionId().toString());
            mensaje = "Inscripción eliminada correctamente.";
            return SUCCESS;
        }
    }
}

mensaje = "No se encontró ninguna inscripción que eliminar.";
return ERROR;

      
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
}
