package controllers;

import com.opensymphony.xwork2.ActionSupport;
import cliente.VoluntarioJerseyClient;
import static com.opensymphony.xwork2.Action.ERROR;

import entidades.Voluntario;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.struts2.interceptor.SessionAware;

public class EliminarVoluntarioAction extends ActionSupport implements SessionAware {

    private String mensaje;
    private String password;
    private Map<String, Object> session;

    @Override
    public String execute() {
        try {
            Integer id = (Integer) session.get("voluntarioId");
            VoluntarioJerseyClient client1=new VoluntarioJerseyClient();
        GenericType<Voluntario> genericType = new GenericType<Voluntario>() {};
        String aux = DigestUtils.sha256Hex(password);
        
         Voluntario vol = client1.find_XML(genericType, id.toString());
             if (id == null) {
               mensaje = "No se ha encontrado la sesion.";
                return ERROR;
            }
            if (vol == null || !vol.getContrasenya().equals(aux)) {
                mensaje = "Contraseña incorrecta.";
                return ERROR;
            }
        

            
            client1.remove(id.toString());
            session.clear();
            return SUCCESS;

        } catch (Exception e) {
            mensaje = "No se ha podido eliminar el usuario.";
            return ERROR;
        }
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getPassword() {
        return password;
    }

    public Map<String, Object> getSession() {
        return session;
    }
    
}
