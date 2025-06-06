package controllers;

import cliente.ValoracionJerseyClient;
import com.opensymphony.xwork2.ActionSupport;
import entidades.Valoracion;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import org.apache.struts2.interceptor.SessionAware;

public class ListarValoracionesAction extends ActionSupport implements SessionAware {
    private Map<String, Object> session;
    private List<Valoracion> valoraciones;

    @Override
    public String execute() {
        try {
            List<Valoracion> valoracionesFiltradas = new ArrayList<>();
            int voluntarioId = (Integer) session.get("voluntarioId");
            ValoracionJerseyClient client = new ValoracionJerseyClient();

            GenericType<List<Valoracion>> gType = new GenericType<List<Valoracion>>() {};
            List<Valoracion> todas = client.findAll_XML(gType);
            client.close();

            // Filtrar solo las del voluntario actual
            for (Valoracion v : todas) {
    if (v.getValoracionPK().getVoluntarioid() == voluntarioId) {
        valoracionesFiltradas.add(v);
    }
}

this.valoraciones = valoracionesFiltradas;
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public List<Valoracion> getValoraciones() {
        return valoraciones;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}