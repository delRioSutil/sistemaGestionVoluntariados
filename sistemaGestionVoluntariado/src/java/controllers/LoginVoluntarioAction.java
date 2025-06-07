package controllers;

import cliente.VoluntarioJerseyClient;
import com.opensymphony.xwork2.ActionSupport;
import entidades.Voluntario;
import java.util.Map;
import org.apache.commons.codec.digest.DigestUtils;
import javax.ws.rs.core.GenericType;
import org.apache.struts2.interceptor.SessionAware;

public class LoginVoluntarioAction extends ActionSupport implements SessionAware {

    private String id;
    private String password;
    private Voluntario voluntario;
    private Map<String, Object> session;

    @Override
    public String execute() throws Exception {
        VoluntarioJerseyClient client = new VoluntarioJerseyClient();
        GenericType<Voluntario> genericType = new GenericType<Voluntario>() {};

        String passHash = DigestUtils.sha256Hex(password);
        try {
            Voluntario vol = client.find_XML(genericType, id);
            if (vol == null || !vol.getContrasenya().equals(passHash)) {
                addActionError("Datos incorrectos.");
                return ERROR;
            }

            session.put("voluntarioId", vol.getVoluntarioId());
            return SUCCESS;

        } catch (Exception e) {
            addActionError("Error al iniciar sesión.");
            e.printStackTrace();
            return ERROR;
        }
    }

    public void validate() {
        if (password == null || password.trim().isEmpty()) {
            addFieldError("password", "Introduzca contraseña");
        }
        if (id == null || id.trim().isEmpty()) {
            addFieldError("id", "Inserte el ID del voluntario");
        }
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Voluntario getVoluntario() { return voluntario; }
    public void setVoluntario(Voluntario voluntario) { this.voluntario = voluntario; }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
