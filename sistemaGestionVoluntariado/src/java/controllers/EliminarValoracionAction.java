package controllers;

import cliente.ValoracionJerseyClient;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class EliminarValoracionAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;

    private int eventoidd;
    private int voluntarioidd;

    @Override
    public String execute() {
        try {
            ValoracionJerseyClient client = new ValoracionJerseyClient();

            // Construimos la URL con matrix parameters como requiere el servicio REST
            String matrixParams = "clave;eventoid=" + eventoidd + ";voluntarioid=" + voluntarioidd;
            
            client.remove(matrixParams);
            client.close();

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public int getEventoidd() {
        return eventoidd;
    }

    public void setEventoidd(int eventoidd) {
        this.eventoidd = eventoidd;
    }

    public int getVoluntarioidd() {
        return voluntarioidd;
    }

    public void setVoluntarioidd(int voluntarioidd) {
        this.voluntarioidd = voluntarioidd;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}