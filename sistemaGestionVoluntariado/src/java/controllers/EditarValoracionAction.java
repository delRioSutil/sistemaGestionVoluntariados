package controllers;

import cliente.ValoracionJerseyClient;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import entidades.Valoracion;
import entidades.ValoracionPK;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public class EditarValoracionAction extends ActionSupport implements SessionAware {
    private Map<String, Object> session;

    private int eventoid;
    private float puntuacion;
    private String comentario;

    @Override
    public String execute() {
        try {
            
            int voluntarioid = (Integer) session.get("voluntarioId");
           
            
        System.out.println("DEBUG >> EVENTO ID RECIBIDO: " + eventoid);
        System.out.println("DEBUG >> VOLUNTARIO ID (de sesión): " + voluntarioid);
            ValoracionJerseyClient client = new ValoracionJerseyClient();
            ValoracionPK pk = new ValoracionPK(eventoid, voluntarioid);

            Valoracion valoracion = new Valoracion(pk);
            valoracion.setPuntuacion(puntuacion);
            valoracion.setComentario(comentario);

            String idCompuesta = eventoid + ";voluntarioid=" + voluntarioid;
            client.edit_XML(valoracion, idCompuesta);
            client.close();

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public int getEventoid() {
        return eventoid;
    }

    public void setEventoid(int eventoid) {
        this.eventoid = eventoid;
    }

    public float getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(float puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public static Logger getLOG() {
        return LOG;
    }

    public static void setLOG(Logger LOG) {
        ActionSupport.LOG = LOG;
    }

   
}