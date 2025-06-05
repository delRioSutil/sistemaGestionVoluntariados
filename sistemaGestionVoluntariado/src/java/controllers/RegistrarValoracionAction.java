/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.opensymphony.xwork2.ActionSupport;
import entidades.Evento;
import entidades.Inscripcion;
import entidades.Valoracion;
import entidades.Voluntario;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import org.apache.struts2.interceptor.SessionAware;
import cliente.InscripcionJerseyClient;
import cliente.ValoracionJerseyClient;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import entidades.ValoracionPK;

public class RegistrarValoracionAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;
    private List<Evento> eventosAsistidos;
    private Integer eventoIdSeleccionado;
    private Float puntuacion;
    private String comentario;

    public String mostrarEventos() {
        Integer voluntarioId = (Integer) session.get("voluntarioId");
        if (voluntarioId == null) {
            return ERROR;
        }

        InscripcionJerseyClient client = new InscripcionJerseyClient();
        GenericType<List<Inscripcion>> gt = new GenericType<List<Inscripcion>>() {
        };
        List<Inscripcion> inscripciones = client.findAll_XML(gt);

        eventosAsistidos = new ArrayList<>();
        for (Inscripcion ins : inscripciones) {
            if (ins.getVoluntarioid().getVoluntarioId().equals(voluntarioId) && Boolean.TRUE.equals(ins.getAsistencia())) {
                eventosAsistidos.add(ins.getEventoid());
            }
        }
        return SUCCESS;
    }

    public String registrarValoracion() {
        return SUCCESS;
    }

    public String guardarValoracion() {
        Integer voluntarioId = (Integer) session.get("voluntarioId");
        if (voluntarioId == null) {
            return ERROR;
        }
           ValoracionPK pk = new ValoracionPK(eventoIdSeleccionado, voluntarioId);

    Valoracion valoracion = new Valoracion();
    valoracion.setValoracionPK(pk);

       
        valoracion.setComentario(comentario);
        valoracion.setPuntuacion(puntuacion);

        Evento evento = new Evento();
        evento.setEventoid(eventoIdSeleccionado);
        Voluntario voluntario = new Voluntario();
        voluntario.setVoluntarioId(voluntarioId);
        
        
        valoracion.setEvento(evento);
        valoracion.setVoluntario(voluntario);

        ValoracionJerseyClient client = new ValoracionJerseyClient();
        client.create_XML(valoracion);

        return SUCCESS;
    }

    // Getters y Setters
    public List<Evento> getEventosAsistidos() {
        return eventosAsistidos;
    }

    public void setEventosAsistidos(List<Evento> eventosAsistidos) {
        this.eventosAsistidos = eventosAsistidos;
    }

    public Integer getEventoIdSeleccionado() {
        return eventoIdSeleccionado;
    }

    public void setEventoIdSeleccionado(Integer eventoIdSeleccionado) {
        this.eventoIdSeleccionado = eventoIdSeleccionado;
    }

    public Float getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Float puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
