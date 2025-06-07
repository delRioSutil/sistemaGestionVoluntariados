/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juanr
 */
package controllers;

import com.opensymphony.xwork2.ActionSupport;
import cliente.TareaJerseyClient;
import entidades.Tarea;
import org.apache.struts2.interceptor.SessionAware;

import javax.ws.rs.core.GenericType;
import java.util.*;

import static com.opensymphony.xwork2.Action.SUCCESS;
import static com.opensymphony.xwork2.Action.ERROR;

public class VerDetallesEventoAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;
    private List<Tarea> tareasDelEvento;
    private Integer eventoId;

    public String execute() {
        if (eventoId == null) {
            return ERROR;
        }

        TareaJerseyClient client = new TareaJerseyClient();
        GenericType<List<Tarea>> gt = new GenericType<List<Tarea>>() {};
        List<Tarea> todasLasTareas = client.findAll_XML(gt);

        tareasDelEvento = new ArrayList<>();
        for (Tarea t : todasLasTareas) {
            if (t.getEventoid() != null && t.getEventoid().getEventoid().equals(eventoId)) {
                tareasDelEvento.add(t);
            }
        }

        session.put("tareasDelEvento", tareasDelEvento);
        return SUCCESS;
    }

    public List<Tarea> getTareasDelEvento() {
        return tareasDelEvento;
    }

    public void setTareasDelEvento(List<Tarea> tareasDelEvento) {
        this.tareasDelEvento = tareasDelEvento;
    }

    public void setEventoId(Integer eventoId) {
        this.eventoId = eventoId;
    }

    public Integer getEventoId() {
        return eventoId;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
