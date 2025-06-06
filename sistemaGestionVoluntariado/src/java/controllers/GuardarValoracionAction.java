package controllers;

import com.opensymphony.xwork2.ActionSupport;
import cliente.ValoracionJerseyClient;
import entidades.Evento;
import entidades.Valoracion;
import entidades.ValoracionPK;
import entidades.Voluntario;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;

public class GuardarValoracionAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;
    private Integer eventoIdSeleccionado;
    private Float puntuacion;
    private String comentario;

    public String execute() {
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

    public void validate() {
        if (puntuacion == null) {
            addFieldError("puntuacion", "Introduzca puntuación");
        } else if (puntuacion < 1 || puntuacion > 5) {
            addFieldError("puntuacion", "La puntuación debe estar entre 1 y 5");
        }

        if (comentario == null || comentario.trim().isEmpty()) {
            addFieldError("comentario", "Introduzca comentario");
        }
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
