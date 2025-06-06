package controllers;

import com.opensymphony.xwork2.ActionSupport;
import cliente.InscripcionJerseyClient;
import entidades.Evento;
import entidades.Inscripcion;
import org.apache.struts2.interceptor.SessionAware;

import javax.ws.rs.core.GenericType;
import java.util.*;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;

public class MostrarEventosAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;
    private List<Evento> eventosAsistidos;

    public String execute() {
        Integer voluntarioId = (Integer) session.get("voluntarioId");
        if (voluntarioId == null) {
            return ERROR;
        }

        InscripcionJerseyClient client = new InscripcionJerseyClient();
        GenericType<List<Inscripcion>> gt = new GenericType<List<Inscripcion>>() {};
        List<Inscripcion> inscripciones = client.findAll_XML(gt);

        eventosAsistidos = new ArrayList<>();
        for (Inscripcion ins : inscripciones) {
            if (ins.getVoluntarioid().getVoluntarioId().equals(voluntarioId) && Boolean.TRUE.equals(ins.getAsistencia())) {
                eventosAsistidos.add(ins.getEventoid());
            }
        }
        return SUCCESS;
    }

    public List<Evento> getEventosAsistidos() {
        return eventosAsistidos;
    }

    public void setEventosAsistidos(List<Evento> eventosAsistidos) {
        this.eventosAsistidos = eventosAsistidos;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
