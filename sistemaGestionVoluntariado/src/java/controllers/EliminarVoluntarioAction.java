package controllers;

import com.opensymphony.xwork2.ActionSupport;
import cliente.VoluntarioJerseyClient;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public class EliminarVoluntarioAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;

    @Override
    public String execute() {
        try {
            Integer id = (Integer) session.get("voluntarioId");
            if (id == null) {
                addActionError("No se encontró la sesión del voluntario.");
                return ERROR;
            }

            VoluntarioJerseyClient client = new VoluntarioJerseyClient();
            client.remove(id.toString());
            session.clear();
            return SUCCESS;

        } catch (Exception e) {
            addActionError("Error al eliminar el voluntario: " + e.getMessage());
            return ERROR;
        }
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
